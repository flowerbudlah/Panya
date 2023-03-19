package com.tjoeun.spring.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tjoeun.spring.dao.ProductDAO;
import com.tjoeun.spring.dto.ProductDTO;
import com.tjoeun.spring.dto.ProductReplyDTO;

@Service
@PropertySource("/WEB-INF/properties/option.properties")
public class ProductService {

	@Autowired
	private ProductDAO productDAO;
	
	@Value("${item.path.load}")
	private String item_path_load;
  
	//?��?��리스?��
	public List<ProductDTO> getProductListByCategory(int category_idx){
		List<ProductDTO> productListByCategory = productDAO.getProductListByCategory(category_idx); 
			return productListByCategory; 
	}
	
	//?��?��?��?��보기(게시�? ?��?�� ?���?)
	public ProductDTO getProductDetail(int product_idx){
		ProductDTO productDetail = productDAO.getProductDetail(product_idx);
			return productDetail;
	}
	
	//?��미�? ?��?�� 첨�?
	private String saveUploadFile(MultipartFile product_image_file) {
		
		String file_name = product_image_file.getOriginalFilename();
		
		try { product_image_file.transferTo(new File(item_path_load + "/" + file_name));
		} catch (IllegalStateException e) { e.printStackTrace();
		} catch (IOException e) { e.printStackTrace();
		}
			return file_name;
	}
	
	//?��?��?���?
	public void addProduct(ProductDTO newProductDTO) {
		//?��?��?�� ?��록하�? ?��?�� ?��경우?�� 반드?�� ?��미�? ?��?��?�� ?��로드 ?���? ?���?
		MultipartFile product_image_file = newProductDTO.getProduct_image_file(); 
		
		String file_name = saveUploadFile(product_image_file);
		
		newProductDTO.setProduct_img(file_name);
	
		productDAO.addProduct(newProductDTO);
	}
	
	//?��?��?��?��
	public void delete(int product_idx) {
		productDAO.delete(product_idx);
	}
	
	
	//?��?��?��보수?��
	public void modify(ProductDTO modifyProductDTO) {
		
		MultipartFile product_image_file = modifyProductDTO.getProduct_image_file(); 
		
		if(product_image_file.getSize() > 0) {
			String file_name = saveUploadFile(product_image_file);
			modifyProductDTO.setProduct_img(file_name);
		}
			productDAO.modify(modifyProductDTO);
	}

	//?��?�� ?���? ?��?��
	public void write(ProductReplyDTO writeProductReplyDTO) {
		productDAO.write(writeProductReplyDTO);
	}

	//?�� ?��?�� ?��?��?�� ?��?��?��?�� ?���? 목록 �??��?���?
	public List<ProductReplyDTO> replyList(int product_idx) {
		return productDAO.replyList(product_idx);
	}

	//?��?�� ?���? ?��?��(Ajax ?��?��)
	public ProductReplyDTO deleteProductReply(int product_reply_idx) {
		
		ProductReplyDTO productReplyDTO = new ProductReplyDTO();
 
        int deleteCnt = productDAO.deleteProductReply(product_reply_idx); 
        if (deleteCnt > 0) {
        	productReplyDTO.setResult("SUCCESS");
        } else {
        	productReplyDTO.setResult("FAIL");
        }
        return productReplyDTO;
	}
	
	
	
	//7. 좋아?�� 공감버튼 
	public ProductDTO like(int product_idx) throws Exception {
				
		ProductDTO likeProductDTO = new ProductDTO();
				
		int like = productDAO.like(product_idx);
				
		if (like > 0) {
			likeProductDTO.setResult("SUCCESS");
		}else{
			likeProductDTO.setResult("FAIL");
		}
		
		return likeProductDTO;
	}
		
		
	
	
	
	
	

	}
