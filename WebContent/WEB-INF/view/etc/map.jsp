<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath }/" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>팡야팡야</title>
<link rel="icon" type="image/x-icon" href="${root}image/favicon.png">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">

</head>
<body>
<!--상단메뉴 -->
<c:import url="/WEB-INF/view/include/head_meta.jsp" />
<c:import url="/WEB-INF/view/include/top_menu.jsp" />
<!-- 본문내용 -->
<div class="container text-center" style="margin-top:30px; margin-bottom:50px" >

<!-- 내용 -->
<div id="map" style="width:950px;height:400px;" class="container"></div>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=8249c8270d72004ec9d600652f7fc667"></script>
	<script>
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    	mapOption = { 
        	center: new kakao.maps.LatLng(37.55637314315518, 126.93904707152713), // 지도의 중심좌표
        	level: 3 // 지도의 확대 레벨
    				};
			var map = new kakao.maps.Map(mapContainer, mapOption); 
			var markerPosition  = new kakao.maps.LatLng(37.55637314315518, 126.93904707152713); 
			
			var marker = new kakao.maps.Marker({	position: markerPosition	});
		marker.setMap(map);
	</script>
	
<div class="address" style="margin-top:20px;">
<p>서울특별시 서대문구 신촌로 119, 2~3층(창천동) 신촌역 4번출구 80m</p>

<p><strong>Tel. (+82)02-313-1132<br>Fax.(+82)070-8622-5523</strong></p>

</div>
</div>
<c:import url="/WEB-INF/view/include/bottom_info.jsp" />
</body>
</html>