<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<h5>${loginMemberDTO.member_name } 전용 페이지 (The Page for the Administrator only)</h5>
<p>회원목록</p>
<P>총 ${search_result_count }명이 검색되었습니다. </P>

<%--회원검색 --%>
<form action="" method="get" class="text-lfet">
	<select name="type">
		<option value="member_id">아이디(ID)</option>
		<option value="member_name">이름</option>
	</select>
	<input type="text" name="keyword" value="" required="required"/>
	<input type="submit" value="회원 검색" class="btn btn-danger btn-sm" /> 
</form>
<!-- 검색기능끝 -->


<table style="width: 1250px; margin: auto;">
		<thead>
			<tr>
				<th style="text-align: center;">번호</th>
				<th style="text-align: center;">아이디(ID)</th>
				<th style="text-align: center;">이름</th>
				<th style="text-align: center;">연락처</th>
				<th style="text-align: center;">주소</th>
				<th style="text-align: center;">이메일</th>
				<th style="text-align: center;">가입일</th>
			</tr>
		</thead>
		<tbody>
		
		
		<c:forEach items="${memberList}" var="memberList">
			<tr>
				<td style="text-align: center;">${memberList.member_idx }</td>
				<td style="text-align: center;">${memberList.member_id }</td>
				<td style="text-align: center;">${memberList.member_name }</td>
				<td style="text-align: center;">${memberList.member_tel }</td>
				<td style="text-align: center;">${memberList.member_address }</td>
				<td style="text-align: center;">${memberList.member_email}</td>
				<td style="text-align: center;">${memberList.registerDate }</td>
			</tr>
		</c:forEach>
		
		
		</tbody>
</table> 

</div>
<c:import url="/WEB-INF/view/include/bottom_info.jsp" />
</body>
</html>