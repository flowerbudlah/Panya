<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<c:set var="root" value="${pageContext.request.contextPath }/" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>팡야팡야</title>
<style>   
.logo{text-align: center; margin-top:5px; }
.test a{text-decoration: black; } 
a:visited{ color: black;  }
.test li{list-style: none; float: right;      }
.test li::after{ content: ''; padding-right: 20px; }
.test li:last-child::after{ content: ''; }   
</style>
</head>
<body>
<nav class="bg-light navbar-dark fixed-top">

<div class="logo"><a href="${root }main"><img src="${root}image/banner.png" ></a></div>
<div class="menu">
	<ul class="test">
		<c:choose>
			<c:when test="${loginMemberDTO.memberLogin == true }"><!--로그인 된상태 -->
				<li><a href="${root }member/delete" style="color:black;">회원탈퇴</a></li>
				<li><a href="${root }member/modify" style="color:black;">회원정보수정</a></li>
				<li><a href="${root }member/logout" style="color:black;">로그아웃</a></li>
			</c:when>
        	<c:otherwise><!-- 로그인 안된상태 -->
        		<li><a href="${root }member/join" style="color:black;">회원가입</a></li>
        		<li><a href="${root }member/login" style="color:black;">로그인</a></li>
        	</c:otherwise>    
		</c:choose>
		
	</ul>
</div>

</nav>
</body>
</html>