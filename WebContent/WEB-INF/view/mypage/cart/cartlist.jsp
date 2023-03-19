<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<style>
table{border: 1px solid lightgray; }
th{color: white; background-color: #df4759; text-align:center; }
.sender{  }
.recipient{ background-color: whitesmoke; }
.title{ }
h5:hover{color: #df4759;}
h5:active{color: gray;}
</style>
</head>
<body>
<!--상단메뉴 -->
<c:import url="/WEB-INF/view/include/head_meta.jsp" />
<c:import url="/WEB-INF/view/include/top_menu.jsp" />
<div class="container" style="margin-top: 50px; margin-bottom:50px;" align="center">
<!--본문내용-->
<c:set value="${cartMap.cartList}" var="cartList"/>
	<h5><strong>${loginMemberDTO.member_name }님의 장바구니 </strong></h5> 
	<table class="table table-hover" style="width: 100%; margin: auto; border-bottom: 1px solid #D5D5D5;">
		<thead>
			<tr>
				<th style="text-align: center;"></th>
				<th colspan="2" style="text-align: center;">상품명</th>
				<th style="text-align: center;">단가</th>
				<th style="text-align: center;">수량</th>
				<th style="text-align: center;">총 금액</th>
				<th style="text-align: center;"></th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${cartList != null}">
					<c:forEach items="${cartList}" var="vo" varStatus="status">
						<tr>
							<td>${vo.cart_idx }</td>
							<td>
								<a href="${root }product/product_detail?product_idx=${vo.product_idx}">
									<img src="${root }image/product/${vo.product_img}" width="80px" height="80px" alt="${vo.product_name}">
								</a>
							</td>
							<td>
								<a href="${root }product/product_detail?product_idx=${vo.product_idx}">
									${vo.product_name}
								</a>
							</td>
							<td style="text-align: center;">
								<fmt:formatNumber value="${vo.price }" pattern="###,###,###"/>원
							</td>
							<td style="text-align: center;">
							<%--수량과 수량변경에 대한 --%>
							<form action='${root }mypage/cart/cartlist/updateAmount' method='post' modelAttribute="updateAmountCartDTO">
								<input type="hidden" name="cart_idx" value="${vo.cart_idx }"/>
								<input type="number" name="amount" value="${vo.amount }" min="1" max="999"/>개
							<button type="submit" class="btn btn-link" >수량변경</button>
							</form>
							<%--수량변경 관련 끝 --%>
							</td>
							<td style="text-align: center;">
								<fmt:formatNumber value="${vo.price*vo.amount }" pattern="###,###,###"/>원
							</td>
							<td style="text-align: center;">
								<a href="${root }mypage/cart/cartlist/delete?cart_idx=${vo.cart_idx}">삭제하기</a>
							</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise><tr><td colspan="7"><p>장바구니에 내역이 없습니다.</p></td></tr></c:otherwise>
			</c:choose>
		</tbody>
	</table>
<%--주문정보입력 테이블 --%>
<table class="table table-hover" style="width: 100%; margin: auto; border-bottom: 1px solid #D5D5D5;">
<thead>
	<tr>
		<th style="text-align: center;" colspan="7">
			<div class="text-right">
			총 합계: <fmt:formatNumber value="${paymentMoney }" pattern="###,###,###"/> 원<br>
			배송비: 
			<c:choose>
				<c:when test="${cartList != null}"><%--장바구니에 물건이 들어있다. --%>3,000 </c:when>
				<c:otherwise>0</c:otherwise>
			</c:choose>원<br>
			결제금액: 
			<c:choose>
				<c:when test="${cartList != null}"><%--장바구니에 물건이 들어있다. --%>	
					<fmt:formatNumber value="${paymentMoney+3000}" pattern="###,###,###"/>
				</c:when>
				<c:otherwise>0</c:otherwise>
			</c:choose>원
			</div>
		</th>
	 </tr>
</thead>
<form action='${root }mypage/order' method='post' autocomplete="off">
<input type="hidden" name="circumstance" value="결제완료(배송준비 전)" />
<input type="hidden" name="member_id" value="${loginMemberDTO.member_id }"/>
<tbody>
	<tr class="sender">
		<td colspan="2">
		
		
			<input type="hidden" name="paymentprice" value="${paymentMoney+3000}"/><%--배송비 포함한 결제금액 --%>
		</td>
		<td colspan="2">발송인의 이름: </td>
		<td colspan="3">
			<input type="text" style="width:150px;" name="sender_name" id="sender_name" required="required"/>
		</td>
	</tr>
	<tr class="sender">
		<td colspan="2"></td>
		<td colspan="2">발송인의 연락처(Tel): </td>
		<td colspan="3">
			<input type="tel" style="width:150px;"  name="sender_tel" id="sender_tel" required="required"/>
		</td>
	</tr>
	<tr class="sender">
		<td colspan="2"></td>
		<td colspan="2">발송인의 주소: </td>
		<td colspan="3">
			<input type="text" name="sender_postcode" id="postcode" placeholder="우편번호" style="width:150px;">
			<input type="button" class="btn btn-primary btn-sm" id="searchAdd" value="우편번호 찾기" ><br>
			<input type="text" name="sender_address" placeholder="상세주소" id="roadAddress" style="width:600px;"/>
		</td>
	</tr>
	<tr class="recipient">
		<td colspan="2" ></td>
		<td colspan="2">수령인의 이름: </td>
		<td colspan="3">
			<input type="text" style="width:150px;" name="recipient_name" required="required"/>
		</td>
	</tr>
	<tr class="recipient">
		<td colspan="2"></td>
		<td colspan="2">수령인의 연락처(Tel): </td>
		<td colspan="3">
			<input type="tel" style="width:150px;"  name="recipient_tel" id="recipient_tel" required="required"/>
		</td>
	</tr>
	<tr class="recipient">
		<td colspan="2"></td>
		<td colspan="2">수령인의 주소: </td>
		<td colspan="3">
			<input type="text" name="recipient_postcode" id="postcode2" placeholder="우편번호" style="width:150px;">
			<input type="button" id="searchAdd2" value="우편번호 찾기"  class="btn btn-info btn-sm"><br>
			<input type="text" name="recipient_address" placeholder="상세주소" id="roadAddress2" style="width:600px;"/>
		</td>
	</tr>
	<tr>
		<td colspan="2"></td>
		<td colspan="2">메모: </td>
		<td colspan="3">
			<textarea style="width:600px; resize: none;" name="memo" placeholder="주문결제 또는 배송관련하여 남기실 말씀이 있으시면 여기에 남겨주세요!"></textarea>
		</td>
	</tr>
	<tr>
		<td colspan="2"></td>
		<td colspan="2">결제방법</td>
		<td colspan="3">
			<input type="radio" name="payment_method" value="신용카드">신용카드<br>
			<input type="radio" name="payment_method" value="계좌이체">계좌이체
		</td>
	</tr>

</tbody>
</table><br>
	<c:choose>
		<c:when test="${cartList != null}"><%--장바구니에 물건이 들어있다. --%>
			<button type="submit" class="btn btn-danger">주문결제 하기</button>
		</c:when>
		<c:otherwise></c:otherwise>
	</c:choose>
</form>
</div>
<!-- 하단정보 -->
<c:import url="/WEB-INF/view/include/bottom_info.jsp" />
<%--발송인의 우편번호 API--%>
<script>
function postcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            var roadAddr = data.roadAddress; // 도로명 주소 변수
            var extraRoadAddr = ''; // 참고 항목 변수

            // 법정동명이 있을 경우 추가한다. (법정리는 제외) 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                extraRoadAddr += data.bname;
            }
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if(data.buildingName !== '' && data.apartment === 'Y'){
               extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }
            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if(extraRoadAddr !== ''){
                extraRoadAddr = ' (' + extraRoadAddr + ')';
            }
            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('postcode').value = data.zonecode;
            document.getElementById("roadAddress").value = roadAddr;
           }
	}).open();
}
$("#searchAdd").click(function(event) {
	event.preventDefault();
	postcode();
});
<%--수신인의 우편번호 API --%>
function postcode2() {
    new daum.Postcode({
        oncomplete: function(data) {
            var roadAddr = data.roadAddress;
            var extraRoadAddr = ''; 

      		if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                extraRoadAddr += data.bname;
            }
         
            if(data.buildingName !== '' && data.apartment === 'Y'){
               extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }
           
            if(extraRoadAddr !== ''){
                extraRoadAddr = ' (' + extraRoadAddr + ')';
            }

            document.getElementById('postcode2').value = data.zonecode;
            document.getElementById("roadAddress2").value = roadAddr;
           }
	}).open();
}
$("#searchAdd2").click(function(event) {
	event.preventDefault();
	postcode2();
});
</script>
</body>
</html>

