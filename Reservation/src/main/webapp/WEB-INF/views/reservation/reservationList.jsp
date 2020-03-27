<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약목록 확인</title>
<link rel="stylesheet" href="${cp}/resources/css/style.css" />
<link rel="stylesheet"
	href="//unpkg.com/bootstrap@4/dist/css/bootstrap.min.css">
<script src='//unpkg.com/jquery@3/dist/jquery.min.js'></script>
<script src='//unpkg.com/popper.js@1/dist/umd/popper.min.js'></script>
<script src='//unpkg.com/bootstrap@4/dist/js/bootstrap.min.js'></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body>
	<div class="background">
		<jsp:include page="../header.jsp" flush="false" />
		<div class="list">
			<br>
			<h3>나의 예약 목록</h3>
			<br>
			<div id="reservationList">
				<c:forEach items="${list}" var="reservation">
					<div class="card">
						<div class="row no-gutters">
							<div class="col-auto">
								<img
									src="${cp}/resources/img/img/${reservation.img.name}.${reservation.img.type}"
									class="img-fluid" alt="${reservation.productName}" />
							</div>
							<div class="col">
								<div class="card-block px-2">
									<h4 class="card-title">${reservation.productName}</h4>
									<p class="card-text">예약 날짜: ${reservation.date}</p>
									<p class="card-text">예약 인원: ${reservation.people}</p>
									<a href="#" class="btn btn-primary">코멘트</a>
									<a href="${cp}/reservation/remove/${reservation.id}" class="btn btn-danger">예약취소</a>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="toTop">
			<div>
				<a href="#main_header">Top</a>
			</div>
		</div>
		<jsp:include page="../footer.jsp" flush="false" />
		<!-- 코멘트 작성 -->
		<div class="modal" id="modifyTodo" tabindex="-1" role="dialog">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title">바꿀 내용을 입력하세요</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">×</span>
						</button>
					</div>
					<div class="modal-body">
						<form>
							<div class="form-group">
								<label for="uTitle"> 할 일 </label> <input type="text" id="uTitle"
									name="uTitle" class="form-control">
							</div>
							<div class="form-group">
								<label for="uName"> 이름 </label> <input type="text" id="uName"
									name="uName" class="form-control">
							</div>
							<div class="form-group">
								<label for="uPriority"> 중요도 </label><br> <label
									class="radio-inline">상</label> <input type="radio"
									name="uPriority" value="상"> <label class="radio-inline">중</label>
								<input type="radio" name="uPriority" value="중"> <label
									class="radio-inline">하</label> <input type="radio"
									name="uPriority" value="하">
							</div>
							<div class="form-group">
								<label for="uGoalDate"> 목표 날짜 </label> <input type="text"
									id="datepicker" name="uGoalDate" class="form-control">
							</div>
							<button class="btn btn-primary float-right" onclick="modify();">수정</button>
						</form>
					</div>
				</div>
			</div>
		</div>
</body>
</html>