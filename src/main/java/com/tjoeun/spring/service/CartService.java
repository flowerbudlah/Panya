package com.tjoeun.spring.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjoeun.spring.dao.CartDAO;
import com.tjoeun.spring.dto.CartDTO;
import com.tjoeun.spring.dto.OrderDTO;
import com.tjoeun.spring.dto.OrderDetailDTO;
import com.tjoeun.spring.dto.OrderListDTO;



@Service
public class CartService {
	
	@Autowired
	private CartDAO cartDAO;
	
	
	public boolean findCartGoods(CartDTO cartDTO) {
		return cartDAO.findCartGoods(cartDTO);
	}
	
	
	// ?¥ë°”êµ¬?‹ˆ?— ?„£ê¸? 
	public void addGoodsInCart(CartDTO cartDTO) {
		cartDAO.addGoodsInCart(cartDTO);
	}
	
	
	// ?¥ë°”êµ¬?‹ˆ ëª©ë¡
	public Map<String, List> getMyCart(String member_id) {
		
		Map<String, List> cartMap = new HashMap<String, List>();
		
		List<CartDTO> cartList = cartDAO.getMyCart(member_id);
		
		if (cartList.size() == 0) {
			return null;
		}
		
		cartMap.put("cartList", cartList);
			return cartMap;
				
	}
	

	//?¥ë°”êµ¬?‹ˆ?•ˆ?—?ˆ?Š” ê·? ë¬¼ê±´ ?•˜?‚˜ ì§??š°ê¸?
	public void delete(int cart_idx) {
		cartDAO.delete(cart_idx);
	}

	//?¥ë°”êµ¬?‹ˆ ê¸ˆì•¡?•©ê³?
	public int sum(String member_id) {
		return cartDAO.sum(member_id);
	}
	
	//?¥ë°”êµ¬?‹ˆ?•ˆ?—?ˆ?Š” ë¬¼ê±´?˜ ?ˆ˜?Ÿ‰ë³?ê²? 
	public void updateAmount(CartDTO updateAmountCartDTO) {
		cartDAO.updateAmount(updateAmountCartDTO); 
	}
	
	//1.ê²°ì œ
	//1) ì£¼ë¬¸??˜ ? •ë³?, ?ˆ˜?‹ ?¸ ? •ë³´ì…? ¥
	public void orderInfo(OrderDTO newOrderDTO) {
		cartDAO.orderInfo(newOrderDTO);
	}
	
	
	//2) ì£¼ë¬¸ ?ƒ?„¸? •ë³?(ì£¼ë¬¸ë²ˆí˜¸, ?•´?‹¹ë¬¼í’ˆ, ?ˆ˜?Ÿ‰, )
	public void orderInfoDetail(OrderDetailDTO newOrderDetailDTO) {
		cartDAO.orderInfoDetail(newOrderDetailDTO); 
	}
	
	//3) ì¹´íŠ¸ë¹„ìš°ê¸?
	public void emptyMyCart(String member_id) {
		cartDAO.emptyMyCart(member_id); 
	}
	
	//4) ?Š¹? •?šŒ?›?˜ ê²°ì œ?™„ë£? ë¦¬ìŠ¤?Š¸
	public List<OrderDTO> orderPaymentList(String member_id) {
		
		List<OrderDTO> orderPaymentList = cartDAO.orderPaymentList(member_id);
		
		if (orderPaymentList.size() == 0) {
			return null;
		}
			return orderPaymentList; 
	}
	
	
	public List<OrderListDTO> allInformationAboutOrder(OrderDTO idAndOrderIdxOrderDTO) {
		return cartDAO.allInformationAboutOrder(idAndOrderIdxOrderDTO);
	}

	
	
	
	
}