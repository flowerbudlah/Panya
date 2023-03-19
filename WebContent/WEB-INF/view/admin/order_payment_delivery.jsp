<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="root" value="${pageContext.request.contextPath }/" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<style>
table{border: 1px solid gray; }
th{color: white; background-color: #df4759; text-align:center; border: 1px solid gray;}
td{text-align:center; border: 1px solid gray;}
</style>
</head>
<body>
<c:import url="/WEB-INF/view/include/head_meta.jsp" />
<c:import url="/WEB-INF/view/include/top_menu.jsp" />
<div class="container" style="margin:50px;">
<h5>${loginMemberDTO.member_name } 페이지 (The Page for the Administrator only)</h5>
<p>주문·결제·배송 현황</p>
<table style="width: 1250px; margin: auto; ">
		<thead>
			<tr>
				<th style="text-align: center;">주문번호</th>
				<th style="text-align: center;">주문인(ID)</th>
				<th style="text-align: center;">주문내역</th>
				<th style="text-align: center;">물품가격합계</th>
				<th style="text-align: center;">배송비</th>
				<th style="text-align: center;">결제금액</th>
				<th style="text-align: center;">결제 년월일시</th>
				<th style="text-align: center;">결제정보</th>
				<th style="text-align: center;">배송상황</th>
				
				
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${allPaymentList }" var="allPaymentList">
			<tr>
				<td style="text-align: center;">${allPaymentList.order_idx }</td>
				<td style="text-align: center;">${allPaymentList.member_id }</td>
				<td style="text-align: center;">
					<a href="${root }mypage/order/orderInfo_Details?order_idx=${allPaymentList.order_idx}">자세히 보기</a>
				</td>
				<td style="text-align: center;">
					<fmt:formatNumber pattern="###,###,###" value="${allPaymentList.paymentprice-3000}"/>원
				</td>
				<td style="text-align: center;">3,000원</td>
				<td style="text-align: center;">
					<fmt:formatNumber pattern="###,###,###" value="${allPaymentList.paymentprice}"/>원
				</td>
				<td style="text-align: center;">
					<fmt:formatDate pattern="yyyy-MM-dd(E) HH:mm:ss" value="${allPaymentList.order_date}" />
				</td>
				<td style="text-align: center;">${allPaymentList.payment_method }</td>
				<td style="text-align: center;">
				<form action='${root }admin/change' method='post' modelAttribute="changeDeliveryOrderDTO">
				<input type="hidden" name="order_idx" value="${allPaymentList.order_idx}"/>
					<select name="circumstance">
						<option value="${allPaymentList.circumstance }">${allPaymentList.circumstance }</option>
						<option value="결제완료(배송준비 전)">결제완료(배송준비 전)</option>
    					<option value="배송준비중">배송준비중</option>
    					<option value="배송중">배송중</option>
    					<option value="배송완료">배송완료</option>
					</select>
					<button type="submit" class="btn btn-link btn-sm">저장</button>
					
		</form>	
				</td>
			</tr>
		</c:forEach>
		</tbody>
</table> 

</div>
<c:import url="/WEB-INF/view/include/bottom_info.jsp" />
</body>
</html>