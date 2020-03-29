<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코멘트 작성</title>
<link rel="stylesheet" href="${cp}/resources/css/style.css" />
<link rel="stylesheet"
	href="//unpkg.com/bootstrap@4/dist/css/bootstrap.min.css">
<script src='//unpkg.com/jquery@3/dist/jquery.min.js'></script>
<script src='//unpkg.com/popper.js@1/dist/umd/popper.min.js'></script>
<script src='//unpkg.com/bootstrap@4/dist/js/bootstrap.min.js'></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.css">
<!-- Latest compiled and minified JavaScript -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.js"></script>
</head>
<body>
	<div class="background">
		<jsp:include page="../header.jsp" flush="false" />
		<div class="form_container">
			<br>
			<h3>리뷰 작성</h3>
			<br>
			<form:form action="${cp}/comment/" method="post"
				commandName="comment">
				<form:hidden path="reservationId" value="${reservationId}" />
				<form:hidden path="memberId" value="${member.id}" />

				<div class="form-group">
					<label for="content"> 내용 </label>
					<form:textarea path="content" class="form-control" rows="10"></form:textarea>
				</div>
				<!-- 평점 선택창 -->
				<div class="form-group my-ratings">
					<form:label path="rating">평점: </form:label>
					<form:hidden path="rating" id="rating" value="0" />
					<div class="rating"></div>
				</div>
				<button class="btn btn-primary float-right">등록</button>
				<a href="#" class="btn btn-primary float-right"
					onClick="history.back()">취소</a>
			</form:form>
		</div>
		<jsp:include page="../footer.jsp" flush="false" />
	</div>
	<script>
		$(".rating").rateYo({
			rating: 2.5,
			starWidth: "20px",
			normalFill: "#A0A0A0",
			halfStar: true,
			onSet: function (rating, rateYoInstance) {
				$("#rating").val(rating);
		    }
		});
	</script>
</body>
</html>