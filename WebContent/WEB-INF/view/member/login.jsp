<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="root" value="${pageContext.request.contextPath }/" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>팡야팡야</title>
<link rel="icon" type="image/x-icon" href="${root}image/favicon.png">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<style>

</style>
</head>
<body>
<!-- 상단 메뉴 부분 -->
<c:import url="/WEB-INF/view/include/head_meta.jsp" />
<c:import url="/WEB-INF/view/include/top_menu.jsp" />

<!-- 회원가입 폼 -->
<div class="container" style="margin-top:50px; margin-bottom:50px; ">
	<div class="row">
		 <div class="col-lg-4 col-sm-6"></div>
			<div class="card shadow-none">
				<div class="card-body">
                  <c:if test="${failure == true }" >
					<div class="alert alert-danger"><h3>로그인 실패</h3><p>아이디 비밀번호를 확인해주세요</p></div>
                  </c:if>
						<form:form action="${root }member/login_proc" method="post" modelAttribute="tmpLoginMemberDTO" >
						<div class="form-group">
							<form:label path="member_id">아이디</form:label>
							<form:input path="member_id" class="form-control"/>
                            <form:errors path="member_id" style="color: red;"/>
						</div>
						<div class="form-group">
							<form:label path="member_pw">비밀번호</form:label>
							<form:password path="member_pw" class="form-control"/>
                            <form:errors path="member_pw" style="color: red;"/>
						</div>
						<div class="form-group ">
						<div class="text-left">
							<a href="${root }member/find_id_form" style="">아이디</a>또는 <a href="${root }member/find_password_question" style="">비밀번호</a>를 잊으셨습니까? 
						</div>
						<br>
						<div class="text-right">
							<form:button class="btn btn-danger">로그인</form:button>
						</div>
						</div>
						
						
						</form:form>
				</div>
			</div>
		</div>
		</div>
		<div class="col-sm-3"></div>
<!-- 하단 정보 -->  
<c:import url="/WEB-INF/view/include/bottom_info.jsp" />
</body>
</html>