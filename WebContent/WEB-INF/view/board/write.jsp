<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%-- <c:url var="root" value="/" /> --%>
<c:set var="root" value="${pageContext.request.contextPath }/" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>팡야팡야</title>
<link rel="icon" type="image/x-icon" href="image/favicon.png">
<!-- Bootstrap CDN -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>
<!-- 상단 메뉴 부분 -->
<c:import url="/WEB-INF/view/include/head_meta.jsp" />
<c:import url="/WEB-INF/view/include/top_menu.jsp" />
<!-- 입력내용 -->
<div class="container" style="margin-top:100px; margin-bottom:100px;">
	<div class="row">
		<div class="col-sm-3"></div>
			<div class="col-sm-7">
			<div class="card shadow-none">
				<div class="card-body">
                  <form:form action="${root }board/write_proc" method="post" modelAttribute="writePostDTO" enctype="multipart/form-data">
                    <form:hidden path="post_board_idx" /> 
					<div class="form-group">
						<form:label path="post_subject">제목</form:label>
						<form:input path="post_subject" class="form-control"/>
                        <form:errors path="post_subject" style="color:red;"/>
					</div>
					<div class="form-group">
						<form:label path="post_text">내용</form:label>
						<form:textarea path="post_text" class="form-control" rows="15" style="resize:none" />
                        <form:errors path="post_text" style="color:red;"/>
					</div>
					<div class="form-group">
						<form:label path ="upload_file">첨부 이미지</form:label>
						<form:input type="file" path="upload_file" class="form-control" accept="image/*"/>
					</div>
					<div class="form-group">
						<div class="text-right">
							<form:button class="btn btn-danger">작성하기</form:button>
						</div>
					</div>
					
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- 하단 정보 -->  
<c:import url="/WEB-INF/view/include/bottom_info.jsp" />
</body>
</html>
