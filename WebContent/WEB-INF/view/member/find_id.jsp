<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }/" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>팡야팡야</title>
<link rel="icon" type="image/x-icon" href="image/favicon.png">>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
	$(function(){
		$("#loginBtn").click(function(){
			location.href='../member/login';
		})
	})
</script>
<style>

</style>
</head>
<body>
<c:import url="/WEB-INF/view/include/head_meta.jsp" />
<c:import url="/WEB-INF/view/include/top_menu.jsp" />
<!-- 내용 -->
<div class="container" style="margin-top:100px; margin-bottom:100px;">
<div class="text-center">
<h5>아이디 찾기 검색결과</h5>
	<div>
		<h5>${id }</h5>
		<p>
			<button type="button" id=loginBtn class="btn btn-danger">로그인</button>
			<button type="button" onclick="history.go(-1);" class="btn btn-warning">이전 페이지로 돌아가기</button>
		</p>
	</div>

</div>
</div>
<!-- 하단 -->
<c:import url="/WEB-INF/view/include/bottom_info.jsp" />
</body>
</html>