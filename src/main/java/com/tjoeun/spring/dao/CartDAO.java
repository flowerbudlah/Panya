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

	//?₯λ°κ΅¬?? ?£κΈ? 
	public void addGoodsInCart(CartDTO cartDTO) {
		sqlSessionTemplate.insert("cart.addGoodsInCart", cartDTO);
	}

	//?₯λ°κ΅¬? λͺ©λ‘ 
	public List<CartDTO> getMyCart(String member_id) {	
		return sqlSessionTemplate.selectList("cart.getMyCart", member_id);
	}


	//?₯λ°κ΅¬? ?Έ?±?€ ?? ?­? 
	public void delete(int cart_idx) {
		sqlSessionTemplate.delete("cart.delete", cart_idx);
	}
	
	//?₯λ°κ΅¬? ?©κ³?
	public int sum(String member_id) {
		return sqlSessionTemplate.selectOne("cart.sum", member_id);
	}
	
	//?₯λ°κ΅¬????? λ¬Όκ±΄? ??λ³?κ²? 
	public void updateAmount(CartDTO updateAmountCartDTO) {
		sqlSessionTemplate.update("cart.updateAmount", updateAmountCartDTO); 
	}
	
	
	
	
	//1. κ²°μ 
	
	//1) μ£Όλ¬Έ?? ? λ³?, ?? ?Έ ? λ³΄μ? ₯
	public void orderInfo(OrderDTO newOrderDTO) {
		sqlSessionTemplate.insert("cart.orderInfo", newOrderDTO);
	}
	//2) μ£Όλ¬Έ ??Έ? λ³?(μ£Όλ¬Έλ²νΈ, ?΄?Ήλ¬Όν, ??, )
	public void orderInfoDetail(OrderDetailDTO newOrderDetailDTO) {
		sqlSessionTemplate.insert("cart.orderInfo_Details", newOrderDetailDTO); 
	}
	//3) μΉ΄νΈλΉμ°κΈ?
	public void emptyMyCart(String member_id) {
		sqlSessionTemplate.delete("cart.emptyMyCart", member_id); 
	}
	//4) ?Ή? ??? κ²°μ ?λ£? λ¦¬μ€?Έ
	public List<OrderDTO> orderPaymentList(String member_id) {
		return sqlSessionTemplate.selectList("cart.orderPaymentList", member_id);
	}
	
	public List<OrderListDTO> allInformationAboutOrder(OrderDTO idAndOrderIdxOrderDTO) {
		return sqlSessionTemplate.selectList("cart.allInformationAboutOrder",idAndOrderIdxOrderDTO);
	}
	
	
	
	
	
	

}
