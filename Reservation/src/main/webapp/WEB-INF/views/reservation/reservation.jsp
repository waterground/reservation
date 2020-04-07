<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약하기</title>
<link rel="stylesheet" href="${cp}/resources/css/style.css" />
<link rel="stylesheet" href="//unpkg.com/bootstrap@4/dist/css/bootstrap.min.css">
<script src='//unpkg.com/jquery@3/dist/jquery.min.js'></script>
<script src='//unpkg.com/popper.js@1/dist/umd/popper.min.js'></script>
<script src='//unpkg.com/bootstrap@4/dist/js/bootstrap.min.js'></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<!-- font -->
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
</head>
<body>
	<div class="background">
		<jsp:include page="../header.jsp" flush="false" />
		<div class="form_container">
			<br>
			<h3>예약하기</h3>
			<br>
			<form:form action="${cp}/reservation/reservation" method="post"
				commandName="reservation">
				<form:hidden path="memberId" value="${member.id}" />
				<form:hidden path="productId" value="${productId}"/>
				<div class="form-group">
					<form:label path="date"> 날짜 </form:label>
					<form:input id="datepicker" path="date" />
				</div>
				<div class="form-group">
					<form:label path="people"> 인원수 </form:label>
					<form:input path="people" class="form-control" />
				</div>
				<button class="btn btn-warning float-right">예약하기</button>
				<a href="#" class="btn btn-primary float-right" onClick="history.back()">취소</a>
			</form:form>
		</div>
		<jsp:include page="../footer.jsp" flush="false" />
	</div>
		
	<script>
	$(function(){
		var today = new Date();
		
		$("#datepicker").datepicker({
			dateFormat: 'yy-mm-dd' //Input Display Format 변경
			,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 Tooltip 텍스트
            ,dayNamesMin: ['일','월','화','수','목','금','토'] //달력의 요일 부분 텍스트
            ,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'] //달력의 요일 부분 Tooltip 텍스트
            ,minDate: new Date(today.setDate(today.getDate() + 1)) // 최소 내일이 goalDate가 되도록 설정
		});
		
		//초기값을 오늘 날짜로 설정
        $('#datepicker').datepicker('setDate', 'today');

	});
	</script>
</body>
</html>