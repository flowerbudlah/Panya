<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath }/" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>팡야팡야</title>
<link rel="icon" type="image/x-icon" href="image/favicon.png">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<script type="text/javascript">
	$(document).ready(function(){// 취소
		$(".cencle").on("click", function(){
			location.href = "${root}main";
		})
		
		
		$("#submit").on("click", function(){
			
			if($("#member_pw").val()==""){
				alert("회원님의 비밀번호를 입력해주세요.");
					$("member_pw").focus();
					return false;
			} 
		});
	})
</script>
<body>
<!-- 상단메뉴 -->
<c:import url="/WEB-INF/view/include/head_meta.jsp" />
<c:import url="/WEB-INF/view/include/top_menu.jsp"/>
<!-- 본문내용 -->
<div class="container" style="margin-top:100px; margin-bottom:100px">
<div class="text-center">
<p>회원탈퇴를 원하세요? </p>
<p>탈퇴 전 정보 확인을 위해서 회원님의 <strong>비밀번호</strong>를 입력해주세요. </p>
<p>그 동안 팡야팡야를 이용해 주셔서 감사합니다.</p>
<p>안녕히 가세요! </p>
<form action="${root }member/delete_proc" method="post">
	<input type="hidden" id="member_id" name="member_id" value="${loginMemberDTO.member_id}"/>
	
	<div class="form-group">
		<input type="password" id="member_pw" name="member_pw" size="30" />
	</div>
				
	<div class="form-group">
		<button class="btn btn-success" type="submit" id="submit">회원탈퇴</button>
		<button class="cencle btn btn-danger" type="button">회원탈퇴 취소</button>
	</div>
</form>
	<div>
		<c:if test="${msg == false}">비밀번호가 정확하지 않아요.</c:if>
	</div>
	
</div>
</div>
<!-- 하단정보 -->
<c:import url="/WEB-INF/view/include/bottom_info.jsp"/>
</body>
</html>

