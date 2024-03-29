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
	
	
	// ?₯λ°κ΅¬?? ?£κΈ? 
	public void addGoodsInCart(CartDTO cartDTO) {
		cartDAO.addGoodsInCart(cartDTO);
	}
	
	
	// ?₯λ°κ΅¬? λͺ©λ‘
	public Map<String, List> getMyCart(String member_id) {
		
		Map<String, List> cartMap = new HashMap<String, List>();
		
		List<CartDTO> cartList = cartDAO.getMyCart(member_id);
		
		if (cartList.size() == 0) {
			return null;
		}
		
		cartMap.put("cartList", cartList);
			return cartMap;
				
	}
	

	//?₯λ°κ΅¬????? κ·? λ¬Όκ±΄ ?? μ§??°κΈ?
	public void delete(int cart_idx) {
		cartDAO.delete(cart_idx);
	}

	//?₯λ°κ΅¬? κΈμ‘?©κ³?
	public int sum(String member_id) {
		return cartDAO.sum(member_id);
	}
	
	//?₯λ°κ΅¬????? λ¬Όκ±΄? ??λ³?κ²? 
	public void updateAmount(CartDTO updateAmountCartDTO) {
		cartDAO.updateAmount(updateAmountCartDTO); 
	}
	
	//1.κ²°μ 
	//1) μ£Όλ¬Έ?? ? λ³?, ?? ?Έ ? λ³΄μ? ₯
	public void orderInfo(OrderDTO newOrderDTO) {
		cartDAO.orderInfo(newOrderDTO);
	}
	
	
	//2) μ£Όλ¬Έ ??Έ? λ³?(μ£Όλ¬Έλ²νΈ, ?΄?Ήλ¬Όν, ??, )
	public void orderInfoDetail(OrderDetailDTO newOrderDetailDTO) {
		cartDAO.orderInfoDetail(newOrderDetailDTO); 
	}
	
	//3) μΉ΄νΈλΉμ°κΈ?
	public void emptyMyCart(String member_id) {
		cartDAO.emptyMyCart(member_id); 
	}
	
	//4) ?Ή? ??? κ²°μ ?λ£? λ¦¬μ€?Έ
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