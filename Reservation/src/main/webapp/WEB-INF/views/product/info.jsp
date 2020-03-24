<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
<link rel="stylesheet" href="${cp}/resources/css/style.css" />
<link rel="stylesheet" href="${cp}/resources/css/info_style.css" />
<link rel="stylesheet"
	href="//unpkg.com/bootstrap@4/dist/css/bootstrap.min.css">
<script src='//unpkg.com/jquery@3/dist/jquery.min.js'></script>
<script src='//unpkg.com/popper.js@1/dist/umd/popper.min.js'></script>
<script src='//unpkg.com/bootstrap@4/dist/js/bootstrap.min.js'></script>
<script src="${cp}/resources/javascript/carousel.js"></script>
</head>
<body>
	<div class="background">
		<jsp:include page="../header.jsp" flush="false" />
		<!-- img box -->
		<div id="promotion" class="carousel slide" data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#carouselIndicators" data-slide-to="0"
					class="active"></li>
				<c:forEach items="${product.imgList}" var="img" varStatus="status">
					<c:if test="${status.index ne 0}">
						<li data-target="#carouselIndicators"
							data-slide-to="${status.index}"></li>
					</c:if>
				</c:forEach>
			</ol>
			<div class="carousel-inner">
				<c:forEach items="${product.imgList}" var="img" varStatus="status">
					<c:choose>
						<c:when test="${status.index eq 0}">
							<div class="carousel-item active">
								<img class="d-block w-100"
									src="${cp}/resources/img/img/${img.name}.${img.type}">
							</div>
						</c:when>
						<c:otherwise>
							<div class="carousel-item">
								<img class="d-block w-100"
									src="${cp}/resources/img/img/${img.name}.${img.type}">
							</div>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</div>
			<a class="carousel-control-prev"
				role="button" data-slide="prev"> <span
				class="carousel-control-prev-icon" aria-hidden="true"></span>
			</a> <a class="carousel-control-next"
				role="button" data-slide="next"> <span
				class="carousel-control-next-icon" aria-hidden="true"></span>
			</a>
		</div>
		<!-- info box -->
		<div id="detail">
			<h4>${product.name}</h4><span></span>
			<div>
				<span class="">전화번호   ${product.tel} </span>
				<span class="info">주소   ${product.address}</span>
				<span class="idx">운영 시간  ${product.openingHours}</span>
				<span class="idx">홈페이지   ${product.homepage}</span>
			</div>
		</div>
		<!-- 예약하기 버튼 box -->
		<div id="btnContainer">
			<a href="${cp}/reservation?id=${product.id}">예약하기</a>
		</div>
		<!-- avg score box -->
		<div id="score"></div>
		<!-- comment box -->
		<div id="commentList"></div>
		<div class="toTop">
			<div>
				<a href="#main_header">Top</a>
			</div>
		</div>
		<jsp:include page="../footer.jsp" flush="false" />
	</div>
	<script>
	</script>
</body>
</html>
