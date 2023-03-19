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
<style>

</style>
</head>
<body>
<c:import url="/WEB-INF/view/include/head_meta.jsp" />
<c:import url="/WEB-INF/view/include/top_menu.jsp" />
<div class="container" style="margin-top:100px; margin-bottom:100px;">
<!-- 내용 -->
<div class="text-center">
<form action="${root }member/find_id" method="post">
	<div>
		<p>아래에 회원가입시 입력하신 이메일 주소를 입력해주세요!<br>
			<center>
				<input class="form-control" style="width:300px;" type="text" id="member_email" name="member_email" required>
			</center>
		</p>
		<br>
		<p>
			<button type="submit" id=findBtn class="btn btn-danger">아이디 찾기</button>
			<button type="button" onclick="history.go(-1);" class="btn btn-primary">아이디 찾기 취소</button>
		</p>
	</div>
</form>
			
			

<!-- 하단 -->
</div>
</div>
<c:import url="/WEB-INF/view/include/bottom_info.jsp" />
</body>
</html>
