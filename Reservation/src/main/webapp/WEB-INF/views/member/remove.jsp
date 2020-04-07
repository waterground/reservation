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
<title>회원 탈퇴</title>
</head>
<body>
	<div class="background">
		<jsp:include page="../header.jsp" flush="false" />
		<div class="form_container">
			<br>
			<h3>회원 탈퇴</h3>
			<br>
			<form:form action="${cp}/member/remove" method="post" commandName="member">
				<div class="form-group">
					<form:label path="id"> 아이디 </form:label><br>
					<form:input path="id" value="${member.id}" readonly="true" class="form-control"/>
				</div>
				<div class="form-group">
					<form:label path="pw"> 비밀번호 </form:label>
					<form:password path="pw" placeholder="비밀번호 " class="form-control" />
				</div>
				<c:if test="${canRemove == false}">
					<small class="form-text" style="color: red;"> 잘못된 비밀번호 입니다
					</small>
				</c:if>
				<br />
				<button class="btn btn-warning float-right">회원 탈퇴</button>
			</form:form>
		</div>
		<jsp:include page="../footer.jsp" flush="false" />
	</div>
</body>
</html>