<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath }/" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>팡야팡야</title>
<link rel="icon" type="image/x-icon" href="${root }image/favicon.png">


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
</head>
<body>
<!-- 상단메뉴 -->
<c:import url="/WEB-INF/view/include/head_meta.jsp" />
<c:import url="/WEB-INF/view/include/top_menu.jsp"/>
<!-- 본문내용 -->
<div class="container" style="margin-top:100px; margin-bottom:100px">
<div class="text-center">
<p>해당하는 글이 삭제됬습니다. </p>
<p><a href="${root }board/main?board_idx=${board_idx}">돌아가기</a></p>
</div>
</div>
<!-- 하단정보 -->
<c:import url="/WEB-INF/view/include/bottom_info.jsp"/>
</body>
</html>



