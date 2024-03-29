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
	
	//??? ?(??κ²μ? λ©μΈ)
	public List<ProductDTO> getProductListByCategory(int category_idx){
		List<ProductDTO> productListByCategory = sqlSessionTemplate.selectList("product.getProductListByCategory", category_idx);
			return productListByCategory ;
	}
	
	//????Έλ³΄κΈ°(??κ²μ? κΈ??½κΈ?)
	public ProductDTO getProductDetail(int product_idx){
		ProductDTO productDetail = sqlSessionTemplate.selectOne("product.getProductDetail", product_idx);
			return productDetail ;
	}
	
	//???±λ‘?(??κ²μ? κΈ??½κΈ?)
	public void addProduct(ProductDTO newProductDTO) {
		sqlSessionTemplate.insert("product.addProduct", newProductDTO);
	}

	//???­? 
	public void delete(int product_idx) {
		sqlSessionTemplate.delete("product.delete", product_idx); 
	}
	
	
	//???? 
	public void modify(ProductDTO modifyProductDTO) {
		sqlSessionTemplate.update("product.modify", modifyProductDTO);
	}

	//???κΈ? ??±
	public void write(ProductReplyDTO writeProductReplyDTO) {
		sqlSessionTemplate.insert("product.replyWrite", writeProductReplyDTO); 
	}

	//?΄ ??? ?΄?Ή?? ?κΈ? λͺ©λ‘ κ°?? Έ?€κΈ?
	public List<ProductReplyDTO> replyList(int product_idx) {
		  return sqlSessionTemplate.selectList("product.replyList", product_idx);
	}

	//?? ?κΈ? ?­? 
	public int deleteProductReply(int product_reply_idx) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.delete("product.deleteProductReply", product_reply_idx); 
	}
	
	//μ’μ?
	public int like(int product_idx) {
		return sqlSessionTemplate.update("product.like", product_idx);
	}
	
	
	

}
