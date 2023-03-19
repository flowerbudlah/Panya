<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="root" value="${pageContext.request.contextPath }/" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>팡야팡야</title>
<link rel="icon" type="image/x-icon" href="${root }image/favicon.png">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<script>
//자바스크립트 또는 아작스 들어갈곳 
</script>
<style>
ul{list-style:none;}
.reply{ font-size: 12px;  }
.reply_writer{ text-align:left; position: absolute; }
.reply_date{ text-align:right;  position: relative; }
</style>
</head>
<body>
<!-- 상단 메뉴 부분 -->
<c:import url="/WEB-INF/view/include/head_meta.jsp" />
<c:import url="/WEB-INF/view/include/top_menu.jsp" />
<!-- 본문내용 -->
<div class="container" style="margin-top:50px; margin-bottom:50px">
  <div class="row">
    <div class="col-sm-3"></div>
    <div class="col-sm-7">
      <div class="card shadow-none">
        <div class="card-body">
        <div class="form-group">
            <label for="post_idx">글번호</label>
            <input type="text" id="post_idx" name="post_idx" class="form-control" value="${readPostDTO.post_idx}" disabled="disabled"/>
		</div>
          <div class="form-group">
            <label for="post_writer_name">작성자</label>
            <input type="text" id="post_writer_name" name="post_writer_name" class="form-control" value="${readPostDTO.post_writer_name}" disabled="disabled"/>
          </div>
          <div class="form-group">
            <label for="post_date">작성날짜</label>
            <input type="text" id="post_date" name="post_date" class="form-control" value="${readPostDTO.post_date }" disabled="disabled"/>
          </div>
          <div class="form-group">
            <label for="post_subject">제목</label>
            <input type="text" id="post_subject" name="post_subject" class="form-control" value="${readPostDTO.post_subject }" disabled="disabled"/>
          </div>      
          <div class="form-group">
            <label for="post_content">내용</label>
            <textarea id="post_content" name="post_content" class="form-control" rows="20" style="resize:none" disabled="disabled">${readPostDTO.post_text }</textarea>
          </div>
          
         <!-- 업로드한 파일이 있는 경우에만 실행하도록 함 -->
		<c:if test="${readPostDTO.post_file != null }">
          	<div class="form-group">
          		<label for="board_file" style="font-size:13px;">첨부 이미지</label>
          		<img src="${root }upload/${readPostDTO.post_file}" width=100%; height=350px;/>            
          	</div>
		</c:if>
<hr/>
<!-- 댓글시작 -->
<!--댓글 목록불러오기 -->
<div class="reply">
	<ul>
	<c:forEach var="reply" items="${reply}" >
		<li>

			<div class="reply_writer">작성자: ${reply.replyer_name}</div>
			<div class="reply_date">댓글작성일시: <fmt:formatDate value="${reply.regdate}" pattern="yyyy-MM-dd hh:mm:ss" />
			<!-- 댓글삭제버튼은 댓글작성자와 관리자만 볼 수 있게 처리 -->
			<c:if test="${(loginMemberDTO.member_id eq reply.replyer_id) || (loginMemberDTO.member_id eq 'admin')}">
			<a href="${root }board/reply/delete?board_idx=${board_idx }&post_idx=${post_idx }&reply_idx=${reply.reply_idx}" class="badge badge-pill badge-light" style="font-size:13px;">X</a>
			</c:if>
			</div>
			<textarea id="reply_content" name="reply_content" class="form-control" rows="3" style="resize:none" disabled="disabled">${reply.reply_content }</textarea>
		</li><br>
	</c:forEach>
	</ul>
</div>

<!-- 로그인 한 회원에게만 댓글 작성폼이 보이게 처리 -->
<c:if test="${loginMemberDTO.memberLogin == true }">    
<div>
	<form method="post" action="${root}board/reply/write">
		<input type="hidden" id="board_idx" name="board_idx" value="${board_idx }">
		<input type="hidden" id="post_idx" name="post_idx" value="${readPostDTO.post_idx}">
		<input type="hidden" id="relyer_id" name="replyer_id" value="${loginMemberDTO.member_id }">
		<textarea name="reply_content" id="reply_content" class="form-control" rows="3" style="resize:none" placeholder="댓글을 입력해주세요! 고운말을 써주세요!"></textarea>
		<div class="text-right">
		<button type="submit" class="btn btn-success btn-sm" style="text-align:right;">댓글 작성</button>
		</div>
	</form>
</div>
</c:if><br>
<!-- 댓글 끝 -->
<div class="form-group">
	<div class="text-right">
		<a href="${root }board/main?board_idx=${board_idx}&page=${page}" class="btn btn-primary">목록보기</a>      
		<!--글쓴이와 관리자만 이버튼 쓸수있게 한다.-->
			<c:if test="${(loginMemberDTO.member_idx == readPostDTO.post_writer_idx) || (loginMemberDTO.member_id eq 'admin')}">
				<a href="${root }board/modify?board_idx=${board_idx}&post_idx=${post_idx}&page=${page}" class="btn btn-info">수정하기</a>
				<a href="${root }board/delete?board_idx=${board_idx}&post_idx=${post_idx}" class="btn btn-danger">삭제</a>
			</c:if>    	
	</div>
</div>



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


