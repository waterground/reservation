<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약목록 확인</title>
<link rel="stylesheet" href="${cp}/resources/css/style.css" />
<link rel="stylesheet" href="${cp}/resources/css/reservation_style.css" />
<link rel="stylesheet" href="//unpkg.com/bootstrap@4/dist/css/bootstrap.min.css">
<script src='//unpkg.com/jquery@3/dist/jquery.min.js'></script>
<script src='//unpkg.com/popper.js@1/dist/umd/popper.min.js'></script>
<script src='//unpkg.com/bootstrap@4/dist/js/bootstrap.min.js'></script>
<!-- font -->
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
</head>
<body>
	<div class="background">
		<jsp:include page="../header.jsp" flush="false" />
		<div class="listContainer">
			<br>
			<h3>나의 예약 목록</h3>
			<br>
			<div id="reservationList">
				<c:forEach items="${list}" var="reservation">
					<div class="card">
						<div class="row no-gutters">
							<div class="col-auto">
								<a href="${cp}/product/${reservation.productId}">
									<img
										src="${cp}/file/download/img/${reservation.img.id}"
										class="img-fluid" alt="${reservation.productName}" />
								</a>
							</div>
							<div class="col">
								<div class="card-block px-2">
									<h4 class="card-title">${reservation.productName}</h4>
									<p class="card-text">예약 날짜: ${reservation.date}</p>
									<p class="card-text">예약 인원: ${reservation.people}</p>
									<c:if test="${reservation.hasReview eq false}">
										<a href="${cp}/review/${reservation.id}" class="btn btn-primary">코멘트 작성</a> 
									</c:if>
									<c:if test="${reservation.hasReview eq true}">
										<a href="${cp}/product/${reservation.productId}" class="btn btn-secondary">코멘트 보기</a> 
									</c:if>
									<a href="#" class="btn btn-danger" onclick="del(${reservation.id})">예약취소</a>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<jsp:include page="../footer.jsp" flush="false" />
	</div>
	<script>
		function getContextPath(){
			var hostIndex = location.href.indexOf(location.host) + location.host.length;
			return location.href.substring(hostIndex, location.href.indexOf('/', hostIndex + 1));
		}
		
		function del(id) {
			var chk = confirm("정말 삭제하시겠습니까?");
			if (chk) {
				location.href=getContextPath() + '/reservation/remove/' + id;
			}
		}	

		</script>
</body>
</html>