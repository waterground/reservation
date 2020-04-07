<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${cp}/resources/css/style.css" />
<link rel="stylesheet"
	href="//unpkg.com/bootstrap@4/dist/css/bootstrap.min.css">
<script src='//unpkg.com/jquery@3/dist/jquery.min.js'></script>
<script src='//unpkg.com/popper.js@1/dist/umd/popper.min.js'></script>
<script src='//unpkg.com/bootstrap@4/dist/js/bootstrap.min.js'></script>
<!-- font -->
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
<title>회원 가입</title>
</head>
<body>
	<div class="background">
		<jsp:include page="../header.jsp" flush="false" />
		<div class="form_container">
			<br>
			<h3>회원 가입</h3>
			<br>
			<form:form action="${cp}/member/join" method="post"
				commandName="member">
				<div class="form-group">
					<form:label path="id"> 아이디 </form:label>
					<form:input path="id" class="form-control" />
					<c:if test="${possibleId == false}">
						<small class="form-text" style="color: red;"> 7글자 이상의 아이디를 입력해주세요</small>
					</c:if>
				</div>
				<div class="form-group">
					<form:label path="pw"> 비밀번호 </form:label>
					<form:password path="pw" id="pw" class="form-control" />
				</div>
				<div class="form-group">
					<label> 비밀번호 재확인</label>
					<input type="password" id="pwChk" class="form-control" />
					<small class="form-text" style="color: red;" id="pw-wrong">비밀번호가 일치하지 않습니다</small>
					<small class="form-text" style="color: blue;" id="pw-success">비밀번호가 일치합니다</small>
				</div>
				<button class="btn btn-warning float-right">회원 가입</button>
			</form:form>
		</div>
		<jsp:include page="../footer.jsp" flush="false" />
	</div>
	<script>
	$(function(){ 
		$("#pw-wrong").hide();
		$("#pw-success").hide();
		$("input").keyup(function(){ 
			var pw = $("#pw").val(); 
			var pwChk = $("#pwChk").val(); 
			if(pw != "" || pwChk != ""){ 
				if(pw == pwChk){ 
					$("#pw-success").show(); 
					$("#pw-wrong").hide(); 
					$(".btn").removeAttr("disabled"); 
				}else{ 
					$("#pw-success").hide(); 
					$("#pw-wrong").show(); 
					$(".btn").attr("disabled", "disabled"); 
				} 
			} 
		}); 
	});
	</script>
</body>
</html>