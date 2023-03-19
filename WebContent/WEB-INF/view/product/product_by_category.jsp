<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="root" value="${pageContext.request.contextPath }/" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>팡야팡야</title>
<link rel="icon" type="image/x-icon" href="${root}image/favicon.png">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Single+Day&display=swap" rel="stylesheet">
<style>
.test li{ position: relative; float: left; list-style: none; }
.test li .test_hover 
{position: absolute; left: 0; right: 20px; top: 0; bottom: 0; background: rgba(0, 0, 0, 0.5);
color: white; text-align: center; padding-top: 70px; opacity: 0; }
.test li:hover .test_hover{ opacity: 1; }
.test li .test_hover a{ color: white; }
table{ margin: 0 auto; width:1200px; position: relative; font-family: 'Single Day', cursive; }
.goods{ width:400px; height:400px; position: relative; }
</style>
</head>
<body>
<c:import url="/WEB-INF/view/include/head_meta.jsp" />
<c:import url="/WEB-INF/view/include/top_menu.jsp" />
<div class="container" style="margin-top:50px; margin-bottom:50px; margin-left:0px;">
<!--상품전시 부분  -->
<ul class="test">
<c:set var="i" value="0" />
<c:set var="j" value="3" />
<table>
<c:forEach items="${productListByCategory }" var="productDTO" > 
<c:if test="${i%j == 0 }">
<tr>
</c:if>
	<td>
        <div class="goods">
        	<li>
				<img src="${root }image/product/${productDTO.product_img}" width="300px" height="300px" alt="${productDTO.product_name}">
        		<div class="test_hover">
    				<h3>${productDTO.product_name}</h3>
    				<h1><fmt:formatNumber value="${productDTO.product_price}" pattern="###,###,###"/> ￦</h1>
    				<h1><a href="${root }product/product_detail?product_idx=${productDTO.product_idx}">사러가기!</a></h1>
				</div>
       		</li>
        </div>
    </td>
<c:if test="${i%j == j-1 }">
</tr>
</c:if>
<c:set var="i" value="${i+1 }" />
</c:forEach>
</table>
</ul>


<div align="right">
<c:choose>
	<c:when test="${loginMemberDTO.member_id eq 'admin'}">
		<div class="col-sm-3">
			<a href="${root }product/upload" class="btn btn-danger btn-block" style="color:white">상품 등록하기</a>
		</div>
	</c:when>
	<c:otherwise>
	</c:otherwise>
</c:choose>
</div>


<!-- 하단 정보부분 -->
</div>
<c:import url="/WEB-INF/view/include/bottom_info.jsp" />
</body>
</html>