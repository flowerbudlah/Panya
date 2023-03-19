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
<link rel="icon" type="image/x-icon" href="${root }image/favicon.png">
<!-- Bootstrap CDN -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">
//이메일 중복체크하는 제이쿼리와 아작스
function checkEmailInModify(){
	
	const member_email = $("#member_email").val()
	if(member_email.length == 0){
		alert('가입하실 Email를 입력해주세요!');
		return; 
	}
    
    $.ajax({
      url: '${root}member/checkEmailInModify/'+member_email, 
      type: 'get',
      dataType: 'text',
      success: 
    	function(result){
        	if(result.trim() == 'true'){
          		alert('사용하실 수 있습니다. ');
          		$('#inputMemberEmail').val('true');
        	}else{ //result.trim() == 'false'
        		alert('다른 Email을 이용해주세요.');  
              	$('#inputMemberEmail').val('false');
        	}
          } //function 끝
      	})//아작스끝
    }//펑션 끝
function resetInputMemberEmail(){
	$("#inputMemberEmail").val('false'); //이런경우(false)는 회원가입 안된다. BindingResult의 오류로  
}
</script>
</head>
<body>
<!-- 상단 -->
<c:import url="/WEB-INF/view/include/head_meta.jsp" />
<c:import url="/WEB-INF/view/include/top_menu.jsp"/>
<!-- 본문 -->
<div class="container" style="margin-top:50px; margin-bottom:50px;">
	<div class="row">
		<div class="col-sm-3"></div>
		<div class="col-sm-7">
			<div class="card shadow-none">
				<div class="card-body">
				<form:form action='${root }member/modify_proc' method='post' modelAttribute="modifyMemberDTO">
				<form:hidden path="inputMemberEmail" />
					<div class="form-group">
						<form:label path="member_name">이름</form:label>
						<form:input path="member_name" class='form-control' />
					</div>
					<div class="form-group">
						<form:label path="member_id">아이디</form:label>
						<form:input path="member_id" class='form-control' readonly="true"/>
					</div>
					<div class="form-group">
						<form:label path="member_pw">비밀번호</form:label>
						<form:password path="member_pw" value="${modifyMemberDTO.member_pw }" class='form-control'/>
						<form:errors path='member_pw' style='color:red'/>
					</div>
					<div class="form-group">
						<form:label path="member_pw2">↑↑↑위 비밀번호 확인</form:label>
						<form:password path="member_pw2" value="${modifyMemberDTO.member_pw }" class='form-control'/>
						<form:errors path='member_pw2' style='color:red'/>
					</div>
					<%--이메일 --%>
					<div class="form-group">
						<form:label path="member_email">E-mail</form:label> 
							<div class="input-group">
								<form:input path="member_email" class="form-control" onkeypress="resetInputMemberEmail()"/>
								<div class="input-group-append">
									<button type="button" class="btn btn-warning" onClick="checkEmailInModify();">이메일 중복확인</button>
								</div>
							</div>
						<form:errors path="member_email" style="color:red;" />
					</div>
					<%--이메일 끝 --%>
					<div class="form-group">
						<form:label path="member_tel">연락처</form:label>
						<form:input path="member_tel" class='form-control'/>
					</div>
					<div class="form-group">
						<form:label path="member_address">주소</form:label>
						<div class="input-group-append">
							<form:input path="postcode" class='form-control'/>&nbsp;
							<input type="button" class="btn btn-danger btn-sm" id="searchAdd" value="우편번호 찾기" >
						</div>
						<form:input path="member_address" class='form-control' id="roadAddress"/>
					</div>
					<div class="form-group">
						<form:label path="question">아이디 또는 비밀번호 분실시 질문</form:label>&nbsp;&nbsp;
						<form:select path="question" class="form-control">
							<form:option value="아버지의 이름은 무엇인가요? ">아버지의 이름은 무엇인가요?</form:option>
    						<form:option value="어머니의 이름은 무엇인가요?">어머니의 이름은 무엇인가요?</form:option>
    						<form:option value="고향은 어디인가요?">고향은 어디인가요?</form:option>
    						<form:option value="별명은 무엇인가요?">별명은 무엇인가요?</form:option>
    						<form:option value="감명깊게 본 책은 무엇인가요?">감명깊게 본 책은 무엇인가요?</form:option>
						</form:select>
					</div>
					<div class="form-group">
						<form:label path="answer">↑↑↑위 질문에 대한 답</form:label>
						<form:input path="answer" class='form-control'/>
					</div>
					<div class="form-group">
						<div class="text-right" style="margin-top:100px">
							<form:button class='btn btn-danger'>정보수정 완료</form:button>
						</div>
					</div>
					</form:form>
				</div>
			</div>
		</div>
	<div class="col-sm-3"></div>
</div>
</div>
<!--하단정보-->
<c:import url="/WEB-INF/view/include/bottom_info.jsp"/>
<%--주소 api --%>
<script>
function postcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            var roadAddr = data.roadAddress; // 도로명 주소 변수
            var extraRoadAddr = ''; // 참고 항목 변수

            // 법정동명이 있을 경우 추가한다. (법정리는 제외) 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                extraRoadAddr += data.bname;
            }
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if(data.buildingName !== '' && data.apartment === 'Y'){
               extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }
            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if(extraRoadAddr !== ''){
                extraRoadAddr = ' (' + extraRoadAddr + ')';
            }
            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('postcode').value = data.zonecode;
            document.getElementById("roadAddress").value = roadAddr;
           }
	}).open();
}
$("#searchAdd").click(function(event) {
	event.preventDefault();
	postcode();

});
</script>

</body>
</html>
    