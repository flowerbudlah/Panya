package com.tjoeun.spring.dao;

import java.util.List;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tjoeun.spring.dto.ProductDTO;
import com.tjoeun.spring.dto.ProductReplyDTO;

@Repository
public class ProductDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	//?ƒ?’ˆ? „?‹œ(?ƒ?’ˆê²Œì‹œ?Œ ë©”ì¸)
	public List<ProductDTO> getProductListByCategory(int category_idx){
		List<ProductDTO> productListByCategory = sqlSessionTemplate.selectList("product.getProductListByCategory", category_idx);
			return productListByCategory ;
	}
	
	//?ƒ?’ˆ?ƒ?„¸ë³´ê¸°(?ƒ?’ˆê²Œì‹œ?Œ ê¸??½ê¸?)
	public ProductDTO getProductDetail(int product_idx){
		ProductDTO productDetail = sqlSessionTemplate.selectOne("product.getProductDetail", product_idx);
			return productDetail ;
	}
	
	//?ƒ?’ˆ?“±ë¡?(?ƒ?’ˆê²Œì‹œ?Œ ê¸??½ê¸?)
	public void addProduct(ProductDTO newProductDTO) {
		sqlSessionTemplate.insert("product.addProduct", newProductDTO);
	}

	//?ƒ?’ˆ?‚­? œ
	public void delete(int product_idx) {
		sqlSessionTemplate.delete("product.delete", product_idx); 
	}
	
	
	//?ƒ?’ˆ?ˆ˜? •
	public void modify(ProductDTO modifyProductDTO) {
		sqlSessionTemplate.update("product.modify", modifyProductDTO);
	}

	//?ƒ?’ˆ?Œ“ê¸? ?‘?„±
	public void write(ProductReplyDTO writeProductReplyDTO) {
		sqlSessionTemplate.insert("product.replyWrite", writeProductReplyDTO); 
	}

	//?´ ?ƒ?’ˆ?— ?•´?‹¹?•˜?Š” ?Œ“ê¸? ëª©ë¡ ê°?? ¸?˜¤ê¸?
	public List<ProductReplyDTO> replyList(int product_idx) {
		  return sqlSessionTemplate.selectList("product.replyList", product_idx);
	}

	//?ƒ?’ˆ ?Œ“ê¸? ?‚­? œ
	public int deleteProductReply(int product_reply_idx) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.delete("product.deleteProductReply", product_reply_idx); 
	}
	
	//ì¢‹ì•„?š”
	public int like(int product_idx) {
		return sqlSessionTemplate.update("product.like", product_idx);
	}
	
	
	

}
