<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var='root' value="${pageContext.request.contextPath }/"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>팡야팡야</title>
<link rel="icon" type="image/x-icon" href="image/favicon.png">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>
<c:import url="/WEB-INF/view/include/head_meta.jsp" />
<c:import url="/WEB-INF/view/include/top_menu.jsp"/>
<!-- 본문 -->
<div class="container" style="margin-top:50px; margin-bottom:50px;">
	<div class="row">
		<div class="col-sm-3"></div>
		<div class="col-sm-7">
			<div class="card shadow-none">
				<div class="card-body">
					<form:form action='${root }product/modify_proc' method='post' modelAttribute="modifyProductDTO" enctype="multipart/form-data">
						<div class="form-group">
							<form:label path="category_idx">1차 분류:&nbsp;&nbsp;</form:label>
							<form:select path="category_idx">
								<form:option value="1">빵, 샌드위치</form:option>
								<form:option value="2">케이크</form:option>
								<form:option value="3">기타</form:option>
							</form:select>
						</div>
						<div class="form-group">
							<form:label path="product_idx">상품일련번호</form:label>
							<form:input path="product_idx" class='form-control' readonly="true"/>
						</div>
					
						<div class="form-group">
							<form:label path="product_name">상품명</form:label>
							<form:input path="product_name" class='form-control' />
							<form:errors path="product_name" style='color:red'/>
						</div>
						<div class="form-group">
							<form:label path="product_price">가격</form:label>
							<form:input path="product_price" class='form-control'/>
							<form:errors path="product_price" style='color:red'/>
						</div>
						<div class="form-group">
							<form:label path="storage_method">보관방법</form:label>
							<form:input path="storage_method" class='form-control'/>
							<form:errors path='storage_method' style='color:red'/>
						</div>
						<div class="form-group">
							<form:label path="expiration_date">유통기간</form:label>
							<form:input path="expiration_date" class='form-control'/>
							<form:errors path='expiration_date' style='color:red'/>
						</div>
						
						
						<div class="form-group">
    						<label for="product_img">첨부 이미지</label>
                            <c:if test="${modifyProductDTO.product_img != null }" > 
								<img src="${root }image/product/${modifyProductDTO.product_img}" width="100%"/>
							<form:hidden path="product_img"/>
                            </c:if>  
							<form:input path="product_image_file" type="file" class="form-control" accept="image/*"/>					
						</div>
						
						
						<div class="form-group">
							<div class="text-right">
								<form:button class='btn btn-danger'>상품정보 수정완료</form:button>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
		<div class="col-sm-3"></div>
	</div>
</div>
<!-- 하단정보 -->
<c:import url="/WEB-INF/view/include/bottom_info.jsp"/>
</body>
</html>