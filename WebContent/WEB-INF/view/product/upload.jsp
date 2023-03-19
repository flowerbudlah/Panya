<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var='root' value="${pageContext.request.contextPath }/"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>상품등록(관리자 권한)</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Single+Day&display=swap" rel="stylesheet">
</head>
<style>
.entire{border: 1px solid lightgray; font-family: 'Single Day', cursive; font-size: 25px; }
</style>
<body>
<c:import url="/WEB-INF/view/include/head_meta.jsp" />
<c:import url="/WEB-INF/view/include/top_menu.jsp"/>
<!-- 본문내용 -->
<div class="container" style="margin: 100px;">
	<div class="row">
		<div class="col-sm-3"></div>
			<div class="col-sm-7">
			
			
			
<form:form action="${root }product/upload_proc" method="post" modelAttribute="newProductDTO" enctype="multipart/form-data">
	<div class="form-group">
		<form:label path="category_idx">1차 분류:&nbsp;&nbsp;&nbsp;</form:label>
		<form:select path="category_idx">
				<form:option value="1">빵, 샌드위치</form:option>
				<form:option value="2">케이크</form:option>
				<form:option value="3">기타</form:option>
		</form:select>
	</div>
	<div class="form-group">
		<form:label path="product_name">상품명: </form:label>
		<form:input path="product_name" class="form-control" />
		 <form:errors path="product_name" style="color:red;"/>
	</div>
	<div class="form-group">
		<form:label path="product_price">단가: </form:label>
		<form:input path="product_price" class="form-control"/>
		<form:errors path="product_price" style="color:red;"/>
	</div>
	<div class="form-group">
		<form:label path="storage_method">보관방법: </form:label>
		<form:input path="storage_method" class="form-control"/>
		 <form:errors path="storage_method" style="color:red;"/>
	</div>
	<div class="form-group">
		<form:label path="expiration_date">유통기한: </form:label>
		<form:input path="expiration_date" class="form-control"/>
		<form:errors path="expiration_date" style="color:red;"/>
	</div>
	<div class="form-group">
		<form:label path ="product_image_file">첨부 이미지</form:label>
		<form:input type="file" path="product_image_file" class="form-control" accept="image/*"/>
		 <form:errors path="product_image_file" style="color:red;"/>
	</div>
	<div class="form-group">
		<div class="text-right">
			<form:button class="btn btn-danger">상품등록완료</form:button>
		</div>
	</div>
</form:form>

		</div>
	</div>
</div>
<!-- 하단정보 -->
<c:import url="/WEB-INF/view/include/bottom_info.jsp" />
</body>
</html>
