<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }/" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>팡야팡야</title>
<link rel="icon" type="image/x-icon" href="image/favicon.png">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
</head>
<body>
<c:import url="/WEB-INF/view/include/head_meta.jsp" />
<c:import url="/WEB-INF/view/include/top_menu.jsp" />
<div class="container" style="margin-top:100px; margin-bottom:100px;">
<div class="text-center">
<!-- 내용 -->
<p>아래는 회원님께서 회원가입시 입력하신 질문입니다. <br>이 <strong>질문에 대한 답</strong>을 입력하시면 회원님의 <strong>비밀번호</strong>를 알 수가 있습니다. </p><br>
<p>${memberDTO.question}</p>
<form action="find_password" method="post">
	<div class="form-group">
	<center>
		<input type="text" id="answer" name="answer" class="form-control" style="width:300px;"/>
	</center>
		<input type="hidden" id="member_id" name="member_id" value="${memberDTO.member_id}"/>
	</div>
	<div class="form-group">
		<input  type="submit" class="btn btn-danger" value="다음단계로">
		<button type="button" onclick="history.go(-1);" class="btn btn-warning">이전 단계로 돌아가기</button>
	</div>
	
	<c:if test="${check == 1}">
		<label>일치하는 정보가 존재하지 않습니다.</label>
	</c:if>
	<c:if test="${check == 0 }">
		<label>회원님의 비밀번호는 ${password} 입니다.</label>
	</c:if>
	
</form>
<!-- 하단 -->
</div>
</div>
<c:import url="/WEB-INF/view/include/bottom_info.jsp" />
</body>
</html>