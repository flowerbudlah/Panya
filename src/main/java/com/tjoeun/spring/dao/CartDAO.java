package com.tjoeun.spring.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tjoeun.spring.dto.CartDTO;
import com.tjoeun.spring.dto.OrderDTO;
import com.tjoeun.spring.dto.OrderDetailDTO;
import com.tjoeun.spring.dto.OrderListDTO;

@Repository
public class CartDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public boolean findCartGoods(CartDTO cartDTO) {
		String result = sqlSessionTemplate.selectOne("cart.findCartGoods", cartDTO);
		return Boolean.parseBoolean(result);
	}

	//?¥ë°”êµ¬?‹ˆ?— ?„£ê¸? 
	public void addGoodsInCart(CartDTO cartDTO) {
		sqlSessionTemplate.insert("cart.addGoodsInCart", cartDTO);
	}

	//?¥ë°”êµ¬?‹ˆ ëª©ë¡ 
	public List<CartDTO> getMyCart(String member_id) {	
		return sqlSessionTemplate.selectList("cart.getMyCart", member_id);
	}


	//?¥ë°”êµ¬?‹ˆ ?¸?±?Š¤ ?•˜?‚˜ ?‚­? œ
	public void delete(int cart_idx) {
		sqlSessionTemplate.delete("cart.delete", cart_idx);
	}
	
	//?¥ë°”êµ¬?‹ˆ ?•©ê³?
	public int sum(String member_id) {
		return sqlSessionTemplate.selectOne("cart.sum", member_id);
	}
	
	//?¥ë°”êµ¬?‹ˆ?•ˆ?—?ˆ?Š” ë¬¼ê±´?˜ ?ˆ˜?Ÿ‰ë³?ê²? 
	public void updateAmount(CartDTO updateAmountCartDTO) {
		sqlSessionTemplate.update("cart.updateAmount", updateAmountCartDTO); 
	}
	
	
	
	
	//1. ê²°ì œ
	
	//1) ì£¼ë¬¸??˜ ? •ë³?, ?ˆ˜?‹ ?¸ ? •ë³´ì…? ¥
	public void orderInfo(OrderDTO newOrderDTO) {
		sqlSessionTemplate.insert("cart.orderInfo", newOrderDTO);
	}
	//2) ì£¼ë¬¸ ?ƒ?„¸? •ë³?(ì£¼ë¬¸ë²ˆí˜¸, ?•´?‹¹ë¬¼í’ˆ, ?ˆ˜?Ÿ‰, )
	public void orderInfoDetail(OrderDetailDTO newOrderDetailDTO) {
		sqlSessionTemplate.insert("cart.orderInfo_Details", newOrderDetailDTO); 
	}
	//3) ì¹´íŠ¸ë¹„ìš°ê¸?
	public void emptyMyCart(String member_id) {
		sqlSessionTemplate.delete("cart.emptyMyCart", member_id); 
	}
	//4) ?Š¹? •?šŒ?›?˜ ê²°ì œ?™„ë£? ë¦¬ìŠ¤?Š¸
	public List<OrderDTO> orderPaymentList(String member_id) {
		return sqlSessionTemplate.selectList("cart.orderPaymentList", member_id);
	}
	
	public List<OrderListDTO> allInformationAboutOrder(OrderDTO idAndOrderIdxOrderDTO) {
		return sqlSessionTemplate.selectList("cart.allInformationAboutOrder",idAndOrderIdxOrderDTO);
	}
	
	
	
	
	
	

}
