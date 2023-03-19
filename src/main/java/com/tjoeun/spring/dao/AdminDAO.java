package com.tjoeun.spring.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tjoeun.spring.dto.MemberDTO;
import com.tjoeun.spring.dto.OrderDTO;

@Repository
public class AdminDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<MemberDTO> getAllMember(){
		List<MemberDTO> allMemberList = sqlSessionTemplate.selectList("admin.getAllMember"); 
			return allMemberList ;
	}
	
	
	public List<OrderDTO> getAllPayment(){
		List<OrderDTO> allPaymentList = sqlSessionTemplate.selectList("admin.getAllPayment"); 
			return allPaymentList ;
	}
	
	//배송�?�? �? 배송?���? �?�?
	public void changeDeliveryCircumstance(OrderDTO changeDeliveryOrderDTO) {
		sqlSessionTemplate.update("admin.changeDeliveryCircumstance", changeDeliveryOrderDTO); 
	}
	
	
	//?��?���??�� ?��
	public int numberOfResultSearchingMember(MemberDTO searchResultMemberDTO) {
		int search_result_count = sqlSessionTemplate.selectOne("admin.numberOfResultSearchingMember", searchResultMemberDTO); 
		return search_result_count; 
	}
	//�??�� 결과 ?��?��
	public List<MemberDTO> resultSearchingMember(MemberDTO searchResultMemberDTO){
		return sqlSessionTemplate.selectList("admin.resultSearchingMember", searchResultMemberDTO);
	}
	

}
