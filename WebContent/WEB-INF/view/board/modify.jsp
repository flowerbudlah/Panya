<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>
<c:url var="root" value="/" />
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
<c:import url="/WEB-INF/view/include/top_menu.jsp" />
<div class="container" style="margin-top:50px; margin-bottom:50px;">
	<div class="row">
		<div class="col-sm-3"></div>
		<div class="col-sm-7">
			<div class="card shadow-none">
				<div class="card-body">
                    <form:form action="${root }board/modify_proc" method="post" modelAttribute="modifyPostDTO" enctype="multipart/form-data">
        			<form:hidden path="post_idx" />    
        			<form:hidden path="post_board_idx" />  
                      <input type="hidden" name="page" value="${page }" > 
					
						<div class="form-group">
							<form:label path="post_writer_name"  >작성자</form:label>
							<form:input path="post_writer_name" class="form-control" readonly="true" />
						</div>
						
						<div class="form-group">
							<form:label path="post_date">작성날짜</form:label>
							<form:input path="post_date" class="form-control" readonly="true" />
						</div>
						<div class="form-group">
							<form:label path="post_subject">제목</form:label>
							<form:input path="post_subject" class="form-control" />
                            <form:errors path="post_subject" style="color:red;"/>
						</div>
						<div class="form-group">
							<form:label path="post_text">내용</form:label>
							<form:textarea path="post_text" class="form-control" rows="10" style="resize:none" />
                            <form:errors path="post_text"  style="color:red;"/>
						</div>
						
						
						<div class="form-group">
    						<label for="post_file">첨부 이미지</label>
                            <c:if test="${modifyPostDTO.post_file != null }" > 
    						  <img src="${root }upload/${modifyPostDTO.post_file}" width="100%"/>
                              <form:hidden path="post_file" />
                            </c:if>  
							<form:input path="upload_file" type="file" class="form-control" accept="image/*"/>					
						</div>
						
						
						<div class="form-group">
							<div class="text-right">
								<form:button class="btn btn-primary">수정완료</form:button>
								<a href="${root }board/read?board_idx=${board_idx}&post_idx=${post_idx}&page=${page}" class="btn btn-info">취소</a>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
		<div class="col-sm-3"></div>
	</div>
</div>

<!-- 하단 정보 -->  
<c:import url="/WEB-INF/view/include/bottom_info.jsp" />


</body>
</html>

