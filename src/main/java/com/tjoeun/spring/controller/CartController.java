package com.tjoeun.spring.controller;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tjoeun.spring.dto.CartDTO;
import com.tjoeun.spring.dto.MemberDTO;
import com.tjoeun.spring.dto.OrderDTO;
import com.tjoeun.spring.dto.OrderDetailDTO;
import com.tjoeun.spring.dto.OrderListDTO;
import com.tjoeun.spring.service.CartService;

@Controller
@RequestMapping("/mypage")
public class CartController {
	
	@Autowired
	private CartService cartService;

	//?û•Î∞îÍµ¨?ãà?óê ?Ñ£?äîÍ±?
	@ResponseBody
	@PostMapping("/cart/")
	public String addGoodsInCart(CartDTO cartDTO, HttpSession session) {
	
		MemberDTO loginMemberDTO = (MemberDTO) session.getAttribute("loginMemberDTO");
		cartDTO.setMember_id(loginMemberDTO.getMember_id()); 
	
		boolean istAlreadyExisted = cartService.findCartGoods(cartDTO);
		System.out.println("istAlreadyExisted : " + istAlreadyExisted);
		
		if (istAlreadyExisted) {   
			return "already_existed";
         } else {
            cartService.addGoodsInCart(cartDTO);
			return "add_success";
		}
	}
	
	
	//?û•Î∞îÍµ¨?ãà Î™©Î°ù
	@RequestMapping(value = "/cart/cartlist/{member_id}", method = {RequestMethod.GET, RequestMethod.POST})
	public String myCart(@PathVariable("member_id") String member_id, Model model) {
		
		Map<String, List> cartMap = cartService.getMyCart(member_id);
		model.addAttribute("cartMap", cartMap);
		
		//Î∞∞ÏÜ°Îπ? ?†ú?ô∏?ïú Í≤∞Ï†úÍ∏àÏï°
		int paymentMoney = cartService.sum(member_id); 
		model.addAttribute("paymentMoney", paymentMoney); 
		
		return "mypage/cart/cartlist";
	}
	
	
	//?û•Î∞îÍµ¨?ãà ?ïà?óê?ûà?äî Í∑? Î¨ºÍ±¥ Ïß??ö∞Í∏?
	@GetMapping("/cart/cartlist/delete")
	public String delete(@RequestParam("cart_idx") int cart_idx, HttpSession session) {
		cartService.delete(cart_idx); 
		
		MemberDTO loginMemberDTO = (MemberDTO) session.getAttribute("loginMemberDTO");
		
		return "redirect:/mypage/cart/cartlist/"+loginMemberDTO.getMember_id();
	}
	
	
	//?û•Î∞îÍµ¨?ãà ?ïà?óê?ûà?äî Í∑? Î¨ºÍ±¥?ùò ?àò?üâ?ùÑ Î≥?Í≤ΩÌïú?ã§. 
	@PostMapping("/cart/cartlist/updateAmount")
	public String updateAmount(@ModelAttribute("updateAmountCartDTO") CartDTO updateAmountCartDTO, HttpSession session) {
		
		cartService.updateAmount(updateAmountCartDTO); 
		MemberDTO loginMemberDTO = (MemberDTO) session.getAttribute("loginMemberDTO");
		return "redirect:/mypage/cart/cartlist/"+loginMemberDTO.getMember_id();
	}

	
	
	//Ï£ºÎ¨∏Í≤∞Ï†ú
	@PostMapping("/order")
	public String order(HttpSession session, OrderDTO newOrderDTO, OrderDetailDTO newOrderDetailDTO){
		MemberDTO loginMemberDTO = (MemberDTO) session.getAttribute("loginMemberDTO");
		String member_id = loginMemberDTO.getMember_id(); 
		
		//Í≥†Ïú†?ùò Ï£ºÎ¨∏Î≤àÌò∏(order_idx)Î•? ?èÖ?äπ?ïòÍ≤? ÎßåÎì§Í∏?
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		String ymd = ym + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		String subNum = "";
		for(int i = 1; i <= 6; i ++) {	subNum += (int)(Math.random()*10);	}
		String order_idx = ymd+"_"+subNum;
		
		newOrderDTO.setOrder_idx(order_idx); 
		newOrderDTO.setMember_id(member_id); 
		cartService.orderInfo(newOrderDTO); 
		
		newOrderDetailDTO.setOrder_idx(order_idx); 
		newOrderDetailDTO.setMember_id(member_id); 
		cartService.orderInfoDetail(newOrderDetailDTO);
		
		//ÎßàÏ?ÎßâÏúºÎ°? Í≤∞Ï†ú?ôÑÎ£åÌñà?úº?ãà Í∑? Í≤∞Ï†ú?êú Î¨ºÍ±¥?? ?û•Î∞îÍµ¨?ãà?óê?Ñú ?óÜ?ï§?ã§.(?û•Î∞îÍµ¨?ãà ÎπÑÏö∞Í∏?)
		cartService.emptyMyCart(member_id); 
		return "redirect:/mypage/order/orderInfo"; 
	}
	
	
	//?äπ?†ï?ù∏?ùò Í≤∞Ï†ú?ôÑÎ£åÎêú Ï£ºÎ¨∏Î™©Î°ù 
	@GetMapping("/order/orderInfo")
	public String orderPaymentList(HttpSession session, Model model){
		
		MemberDTO loginMemberDTO = (MemberDTO)session.getAttribute("loginMemberDTO");
		String member_id = loginMemberDTO.getMember_id(); 
		
		List<OrderDTO> orderPaymentList = cartService.orderPaymentList(member_id); 
		model.addAttribute("orderPaymentList", orderPaymentList);
		
		return "mypage/order/orderInfo";
	}
	
	

	//Í≤∞Ï†úÍ∞? ?ôÑÎ£åÍ? ?êúÍ≤ΩÏö∞, ?ÉÅ?íà?óê Í¥??ïú ?ÉÅ?Ñ∏?†ïÎ≥¥ÎèÑ ?ïå?àò?ûà?äî 
	@GetMapping("/order/orderInfo_Details")
	public String getOrderList(HttpSession session, 
		@RequestParam("order_idx") String order_idx, OrderDTO idAndOrderIdxOrderDTO, Model model){
	
		MemberDTO loginMemberDTO = (MemberDTO)session.getAttribute("loginMemberDTO");
		String member_id = loginMemberDTO.getMember_id(); 
		
		idAndOrderIdxOrderDTO.setMember_id(member_id); 
		idAndOrderIdxOrderDTO.setOrder_idx(order_idx); 
	 
		List<OrderListDTO> allInformationAboutOrder = cartService.allInformationAboutOrder(idAndOrderIdxOrderDTO); 
	 
		model.addAttribute("allInformationAboutOrder", allInformationAboutOrder);
		
		return "mypage/order/orderInfo_Details";
		
		
	}
	
	
	
	
}


