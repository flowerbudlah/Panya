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
th{color: white; background-color: salmon; text-align: center; width: 250px;  }
tr{border: 1px solid lightgray; }
td{background-color: whitesmoke; text-align: left; }

h4:hover{color: salmon;}
h4:active{color: gray;}
.attention{color:red; }
</style>
</head>
<body>
<!--상단메뉴 -->
<c:import url="/WEB-INF/view/include/head_meta.jsp" />
<c:import url="/WEB-INF/view/include/top_menu.jsp" />
<div class="container text-center" style="margin-top:100px; margin-bottom:100px">
<!-- 내용 -->
<h4>${loginMemberDTO.member_name } 고객님의 <strong>주문·결제·배송 정보</strong>입니다. </h4>
<c:choose>
	<c:when test="${orderPaymentList != null}">
		<c:forEach items="${orderPaymentList}" var="orderPaymentList">
		<table style="border: 1px solid lightgray; width:100%;" >
			<tr>
				<th>주문번호</th>
 				<td>
 				<a href="${root }mypage/order/orderInfo_Details?order_idx=${orderPaymentList.order_idx}">
 				${orderPaymentList.order_idx}
 				</a>
 				</td>
			</tr>
			<tr>
				<th>결제일시</th>
 				<td><fmt:formatDate pattern="yyyy-MM-dd(E) hh:mm:ss" value="${orderPaymentList.order_date}" /></td>
			</tr>
			<tr>
				<th>발송인의 이름<br>발송인의 연락처<br>발송인의 주소</th>
 				<td>${orderPaymentList.sender_name}<br>${orderPaymentList.sender_tel}
 				<br>${orderPaymentList.sender_address}&nbsp;&nbsp;&nbsp;&nbsp;(우편번호: ${orderPaymentList.sender_postcode})</td>
			</tr>
			<tr>
				<th>수령인의 이름<br>수령인의 연락처<br>수령인의 주소</th>
 				<td>${orderPaymentList.recipient_name}<br>${orderPaymentList.recipient_tel}
 				<br>${orderPaymentList.recipient_address}&nbsp;&nbsp;&nbsp;&nbsp;
 				(우편번호: ${orderPaymentList.recipient_postcode})</td>
			</tr>
			<tr>
				<th>메모(남기는 말씀)</th>
 				<td>${orderPaymentList.memo}</td>
			</tr>	
			<tr>
				<th>결제금액</th>
 				<td>
 					<strong>총 <fmt:formatNumber pattern="###,###,###" value="${orderPaymentList.paymentprice }" />원</strong>
 					(물품금액의 합계<fmt:formatNumber pattern="###,###,###" value="${orderPaymentList.paymentprice-3000 }" /> 원
 					+ 배송비 3,000 원)
 				</td>
			</tr>
			<tr>
				<th>결제수단</th>
 				<td>${orderPaymentList.payment_method}</td>
			</tr>
			<tr>
				<th>배송상황</th>
 				<td><strong>${orderPaymentList.circumstance}</strong>
 					<p class="attention">※결제가 완료된 후 배송준비 전일경우 100%환불이 가능하며, 배송준비후에는 반품접수가 이루어집니다. 
 					<br>환불이나 반품을 원하실 경우, 신속하게 유선(Tel. 02-313-1132, 010-5824-9508)으로 연락바랍니다. </p>
 				</td> 
			</tr>
		</table><br>
		</c:forEach>
	</c:when>
	<c:otherwise>
		<p>${loginMemberDTO.member_name } 고객님께서는 아직 주문·결제를 완료하신 상품내역이 없습니다.</p>
	</c:otherwise>
</c:choose>
<!-- 하단정보 -->
</div>
<c:import url="/WEB-INF/view/include/bottom_info.jsp" />
</body>
</html>