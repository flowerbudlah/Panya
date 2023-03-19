<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="root" value="${pageContext.request.contextPath }/" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>팡야팡야</title>
<link rel="icon" type="image/x-icon" href="${root}image/favicon.png">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<style>
.orderInfo { border:5px dotted lightgray; padding:10px 20px; margin:20px 0;}
.orderInfo span { font-size:20px; font-weight:bold; width:200px; }
ul{list-style:none;}
.orderView li { margin-bottom:20px; padding-bottom:20px; border-bottom:2px dotted lightgray; }
.orderView li::after { content:""; display:block; clear:both; }
.thumb { float:left; width:70px; }
.thumb img{ width:70px; height:70px; }
.gdsInfo{float:left;  line-height:2; }
th{width:300px; }
td{width:700px; text-align: left; }
.sender{background-color: lightgray; }
</style>
</head>
<body>
<!--상단메뉴 -->
<c:import url="/WEB-INF/view/include/head_meta.jsp" />
<c:import url="/WEB-INF/view/include/top_menu.jsp" />
<div class="container text-center" style="margin-top:100px; margin-bottom:100px">
<!-- 내용 -->
<div class="orderInfo">
	<c:forEach items="${allInformationAboutOrder}" var="allInformationAboutOrder" varStatus="status">
	<c:if test="${status.first}">
	<table>
		<tr>
			<th><span>주문번호:</span></th>
			<td>${allInformationAboutOrder.order_idx}</td>
		</tr>
		<tr>
			<th><span>주문결제 일시:</span> </th>
			<td><fmt:formatDate pattern="yyyy-MM-dd(E) HH:mm:ss" value="${allInformationAboutOrder.order_date}"/></td>
		</tr>
		<tr>
			<th><span>발송인: </span></th>
			<td>${allInformationAboutOrder.sender_name}
			&nbsp;&nbsp;(연락처: ${allInformationAboutOrder.sender_tel})</td>
		</tr>
		<tr>
    		<th><span>발송지: </span></th>
    		<td>${allInformationAboutOrder.sender_address}
    		&nbsp;&nbsp;(우편번호:${allInformationAboutOrder.sender_postcode} )</td>
    	</tr>
		<tr class="sender">
			<th><span>수령인: </span></th>
			<td>
			<span>
			${allInformationAboutOrder.recipient_name}
			&nbsp;&nbsp;(연락처: ${allInformationAboutOrder.recipient_tel})
			</span>
			</td>
		</tr>
    	<tr class="sender">
    		<th><span>주소(배송지): </span></th>
    		<td>
    		<span>
    			${allInformationAboutOrder.recipient_address}
    			&nbsp;&nbsp;(우편번호:${allInformationAboutOrder.recipient_postcode} )
    		</span>
    		</td>
    	</tr>
    	<tr>
    		<th><span>총 결제금액: </span></th>
    		<td>
    		<span>
    		<fmt:formatNumber pattern="###,###,###" value="${allInformationAboutOrder.paymentprice}"/>원
    		&nbsp;&nbsp;(배송비 3,000원 포함)</span></td>
    	</tr>
    		<tr>
    		<th><span>주문자(${allInformationAboutOrder.member_id})의 메모: </span></th>
    		<td style="color:red;">
    			${allInformationAboutOrder.memo}
    		</td>
    	</tr>
    </table>
    </c:if>
    </c:forEach>
</div>
<br><br>
<!-- 상세상품정보 -->
<ul class="orderView">
<c:forEach items="${allInformationAboutOrder}" var="allInformationAboutOrder">     
	<li>
		<div class="thumb">
			<img src="${root }image/product/${allInformationAboutOrder.product_img}" />
		</div>
		<div class="gdsInfo">
		<table>
			<tr>
				<th>상품명: </th><td>${allInformationAboutOrder.product_name}</td>
			</tr>
			<tr>
				<th>개당 가격: </th><td><fmt:formatNumber pattern="###,###,###" value="${allInformationAboutOrder.product_price}"/>원</td>
			</tr>
			<tr>
				<th>구입 수량: </th><td>${allInformationAboutOrder.amount}개</td>
			</tr>
			<tr>
				<th>최종가격: </th><td><fmt:formatNumber pattern="###,###,###" value="${allInformationAboutOrder.product_price*allInformationAboutOrder.amount}" /> 원 </td>
			</tr>
		</table>
		
		
        
	
	</div>
	</li>     
</c:forEach>
</ul>

<!-- 하단정보 -->
</div>
<c:import url="/WEB-INF/view/include/bottom_info.jsp" />
</body>
</html>