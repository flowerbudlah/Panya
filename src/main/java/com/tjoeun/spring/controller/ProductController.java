package com.tjoeun.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.tjoeun.spring.dto.ProductDTO;
import com.tjoeun.spring.dto.ProductReplyDTO;

import com.tjoeun.spring.service.ProductService;


//?ÉÅ?íàÍ≤åÏãú?åê ?ó≠?ï† 
@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	//1. ?†ÑÏ≤? ?ÉÅ?íà Î¶¨Ïä§?ä∏ 
	@GetMapping("/product_by_category")
	public String product_by_category(@RequestParam("category_idx") int category_idx, Model model) {
		model.addAttribute("category_idx", category_idx); 
		
		List<ProductDTO> productListByCategory = productService.getProductListByCategory(category_idx);
		model.addAttribute("productListByCategory", productListByCategory);	
		
		return "product/product_by_category";
	}
	
	//2. ?ÉÅ?íà?ùÑ ?ÉÅ?Ñ∏?ûà Î≥¥Í∏∞(Í≤åÏãúÍ∏? ?ùΩÍ∏?)
	@GetMapping("/product_detail")
	public String product_detail(@RequestParam("product_idx") int product_idx, Model model) {
		
		model.addAttribute("product_idx", product_idx); 
		
		ProductDTO productDetail = productService.getProductDetail(product_idx);
		model.addAttribute("productDetail", productDetail);	
		
		//1). ?ï¥?ãπ ?ÉÅ?íà?óê ?ì±Î°ùÎêú ?åìÍ∏? Ï∂úÎ†•
		List<ProductReplyDTO> productReply = productService.replyList(product_idx);
		model.addAttribute("productReply", productReply);
		
		return "product/product_detail";
	}
	
	//3. ?ÉÅ?íà?Ç≠?†ú
	@GetMapping("/delete")
	public String delete(int product_idx, @RequestParam("category_idx") int category_idx, Model model) {
		
		model.addAttribute("category_idx",category_idx);
		productService.delete(product_idx);
		return "redirect:/product/product_by_category?category_idx={category_idx}";
	}
	
	//4-1. ?ÉÅ?íà?ùÑ ?ì±Î°ùÌïò?äî Í∑? ?éò?ù¥Ïß?Î°? Í∞?Í∏?(Í∏??ì∞Í∏? ?éò?ù¥Ïß? Create)
	@GetMapping("/upload")
	public String upload(
	@ModelAttribute("newProductDTO") ProductDTO newProductDTO) {
		
		return "product/upload"; 
	}
	
	//4-2. ?ÉÅ?íà ?ã§?†ú ?ì±Î°?(?Ç¨ÏßÑÎèÑ ?ì±Î°ùÌïòÍ∏?)
	@PostMapping("/upload_proc")
	public String addProduct(@Valid @ModelAttribute("newProductDTO") ProductDTO newProductDTO, BindingResult result, MultipartFile product_image_file){
		
		if(result.hasErrors()) {
			return "product/upload";  
		}
		productService.addProduct(newProductDTO); 	
		
		return "redirect:/product/product_by_category?category_idx="+newProductDTO.getCategory_idx(); 
	}
	
	//5-1. ?àò?†ï?ïòÍ∏?
	@GetMapping("/modify")
	public String modify(@RequestParam("category_idx") int category_idx, @RequestParam("product_idx") int product_idx, @ModelAttribute("modifyProductDTO") ProductDTO modifyProductDTO, Model model) {
		
		model.addAttribute("category_idx", category_idx);
		model.addAttribute("product_idx", product_idx);

		ProductDTO fromDBProductDTO = productService.getProductDetail(product_idx); //?àò?†ï?ïò?†§?äî ?ÉÅ?íà?†ïÎ≥?
		
		//?àò?†ï?ïò?äî Í∑? Í≥ºÏ†ï
		modifyProductDTO.setProduct_name(fromDBProductDTO.getProduct_name()); 
		modifyProductDTO.setProduct_price(fromDBProductDTO.getProduct_price());
		modifyProductDTO.setStorage_method(fromDBProductDTO.getStorage_method());
		modifyProductDTO.setExpiration_date(fromDBProductDTO.getExpiration_date());
		modifyProductDTO.setProduct_img(fromDBProductDTO.getProduct_img());
		modifyProductDTO.setCategory_idx(category_idx);

			return "product/modify";
	}
	
	//5-2. ?àò?†ï?ïòÎ©¥ÏÑú 
	@PostMapping("/modify_proc")
	public String modifyProc
	(@Valid @ModelAttribute("modifyProductDTO") ProductDTO modifyProductDTO, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			return "product/modify";
		}
		productService.modify(modifyProductDTO); 
		
		return "redirect:/product/product_by_category?category_idx="+modifyProductDTO.getCategory_idx();
	}
	
	
	//6. ?ÉÅ?íà?ÉÅ?Ñ∏ ?éò?ù¥Ïß??óê ?ì±Î°ùÌïò?äî ?åìÍ∏?
	
	//1) ?ÉÅ?íà ?åìÍ∏? ?ûë?Ñ± 
	@PostMapping("/product_detail/write")
	public String write(ProductReplyDTO writeProductReplyDTO, @RequestParam("product_idx") int product_idx, Model model) throws Exception {
		
		model.addAttribute("product_idx", product_idx);
		productService.write(writeProductReplyDTO);
									
		return "redirect:/product/product_detail?product_idx="+writeProductReplyDTO.getProduct_idx();
	}

	
	//2) ?ÉÅ?íà ?åìÍ∏? ?Ç≠?†ú(?ïÑ?ûë?ä§ ?ù¥?ö©)
	@RequestMapping("/product_detail/deleteProductReply")
    public @ResponseBody ProductReplyDTO deleteProductReply
    (HttpServletRequest request, HttpServletResponse response, int product_reply_idx) throws Exception{
		
		ProductReplyDTO productReplyDTO = productService.deleteProductReply(product_reply_idx); 
        return productReplyDTO;
    }
	
	
	
	//6. Ï¢ãÏïÑ?öî(Ï∂îÏ≤ú, Í≥µÍ∞ê)
	@RequestMapping("/product_detail/like") 
	public @ResponseBody ProductDTO like(HttpServletRequest request, HttpServletResponse response, int product_idx) throws Exception {
		ProductDTO likeProductDTO = productService.like(product_idx);
		return likeProductDTO;
	}
	
	
	
	

}
