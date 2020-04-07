<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Cache-Control" content="no-cache"/>
<meta http-equiv="Expires" content="0"/>
<meta http-equiv="Pragma" content="no-cache"/>
<title>메인 페이지</title>
<link rel="stylesheet" href="${cp}/resources/css/style.css" />
<link rel="stylesheet" href="//unpkg.com/bootstrap@4/dist/css/bootstrap.min.css">
<script src='//unpkg.com/jquery@3/dist/jquery.min.js'></script>
<script src='//unpkg.com/popper.js@1/dist/umd/popper.min.js'></script>
<script src='//unpkg.com/bootstrap@4/dist/js/bootstrap.min.js'></script>
<script src="${cp}/resources/javascript/myCarousel.js"></script>
<!-- font -->
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700;800&display=swap" rel="stylesheet">
</head>
<body>
	<div class="background">
		<jsp:include page="header.jsp" flush="false" />
		<div id="promotion" class="carousel slide" data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#carouselIndicators" data-slide-to="0"
					class="active" onclick="indexEvent(0)"></li>
				<c:forEach items="${promotion}" var="promotion" varStatus="status">
					<c:if test="${status.index ne 0}">
						<li data-target="#carouselIndicators"
							data-slide-to="${status.index}" onclick="indexEvent(${status.index})"></li>
					</c:if>
				</c:forEach>
			</ol>
			<div class="carousel-inner">
				<c:forEach items="${promotion}" var="promotion">
					<c:choose>
						<c:when test="${promotion.id eq 1}">
							<div class="carousel-item active">
								<a href="${cp}/product/${promotion.productId}"> <img
									class="d-block w-100"
									src="${cp}/file/download/img/${promotion.img.id}">
								</a>
							</div>
						</c:when>
						<c:otherwise>
							<div class="carousel-item">
								<a href="${cp}/product/${promotion.productId}"> <img
									class="d-block w-100"
									src="${cp}/file/download/img/${promotion.img.id}">
								</a>
							</div>
						</c:otherwise>
					</c:choose>

				</c:forEach>
			</div>
			<a class="carousel-control-prev" role="button" data-slide="prev" onclick="prevEvent()">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
			</a> 
			<a class="carousel-control-next" role="button" data-slide="next" onclick="nextEvent()">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
			</a>
		</div>
		<div id="products_tab">
			<nav class="navbar navbar-expand-lg navbar-dark bg-warning">
				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav">
						<li class="nav-item active"><a class="nav-link" href="#"
							onclick="fn_getList('all')">전체 </a></li>
						<li class="nav-item"><a class="nav-link" href="#"
							onclick="fn_getList('공연')">공연</a></li>
						<li class="nav-item"><a class="nav-link" href="#"
							onclick="fn_getList('뮤지컬')">뮤지컬</a></li>
						<li class="nav-item"><a class="nav-link" href="#"
							onclick="fn_getList('콘서트')">콘서트</a></li>
					</ul>
				</div>
			</nav>
		</div>
		<div class="card-columns" id="product_list"></div>
		<jsp:include page="footer.jsp" flush="false" />
	</div>
	<script>
		$(".carousel").carousel({
			interval : 2000
		});
	
		// category 선택에 따른 active 태그 변화
		var listContainer = document.getElementById("products_tab");
		var list = listContainer.getElementsByTagName("a");

		for (var i = 0; i < list.length; i++) {
			list[i].addEventListener("click", function() {
				var current = document
						.getElementsByClassName("nav-item active");
				current[0].className = current[0].className.replace(" active",
						"");
				this.parentNode.className += " active";
			});
		}

		$(document).ready(function() {
			fn_getList("all");
		});

		// product 목록 함수
		function fn_getList(category) {
			$.ajax({
				type : "post",
				url : "${cp}/list?categoryName=" + category,
				dataType : "json",
				success : function(res) {
					var html = "";

					if (res.length < 1) {
						html = "진행중인 행사가 없습니다";
					} else {
						$(res).each(function() {
							html += '<div class="card" onClick="location.href=\'${cp}/product/'+ this.id + '\'">';
							html += '<img class="card-img-top" src="${cp}/file/download/img/'+this.mainImg.id+'">';
							html += '<div class="card-body">';
							html += '<h5 class="card-title">'+ this.name+ '</h5>';
							html += '<p class="card-text">'+ this.description+ '</p>';
							html += '</div></div>';
							});
						}
						$("#product_list").html(html);
					}
				});
		}
	</script>
</body>
</html>