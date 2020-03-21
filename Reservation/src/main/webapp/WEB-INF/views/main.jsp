<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
<link rel="stylesheet" href="${cp}/resources/css/style.css" />
<link rel="stylesheet"
	href="//unpkg.com/bootstrap@4/dist/css/bootstrap.min.css">
<script src='//unpkg.com/jquery@3/dist/jquery.min.js'></script>
<script src='//unpkg.com/popper.js@1/dist/umd/popper.min.js'></script>
<script src='//unpkg.com/bootstrap@4/dist/js/bootstrap.min.js'></script>
</head>
<body>
	<div class="background">
		<jsp:include page="header.jsp" flush="false" />
		<div id="promotion" class="carousel slide" data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#carouselIndicators" data-slide-to="0"
					class="active"></li>
				<li data-target="#carouselIndicators" data-slide-to="1"></li>
				<li data-target="#carouselIndicators" data-slide-to="2"></li>
			</ol>
			<div class="carousel-inner">
				<c:forEach items="${promotion}" var="promotion">
					<c:choose>
						<c:when test="${promotion.id eq 1}">
							<div class="carousel-item active">
								<img class="d-block w-100"
									src="${cp}/resources/img/img/${promotion.img.name}.${promotion.img.type}">
							</div>
						</c:when>
						<c:otherwise>
							<div class="carousel-item">
								<img class="d-block w-100"
									src="${cp}/resources/img/img/${promotion.img.name}.${promotion.img.type}">
							</div>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</div>
			<a class="carousel-control-prev" href="#carouselIndicators"
				role="button" data-slide="prev"> <span
				class="carousel-control-prev-icon" aria-hidden="true"></span>
			</a> <a class="carousel-control-next" href="#carouselIndicators"
				role="button" data-slide="next"> <span
				class="carousel-control-next-icon" aria-hidden="true"></span> 
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
		<div class="toTop">
			<div>
				<a href="#main_header">Top</a>
			</div>
		</div>
	</div>
	<script>
		// promotion 이벤트
		$(".carousel").carousel({
			interval : 2000
		});

		$(".carousel-control-prev").click(function() {
			$(".carousel").carousel("prev");
		});
		$(".carousel-control-next").click(function() {
			$(".carousel").carousel("next");
		});
		
		$(".carousel-indicators li").click(function(){
			var index = $(".carousel-indicators li").index(this);
			$(".carousel").carousel(index);
		})

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
			$
					.ajax({
						type : "post",
						url : "${cp}/list?categoryName=" + category,
						dataType : "json",
						success : function(res) {
							var html = "";

							if (res.length < 1) {
								html = "진행중인 행사가 없습니다";
							} else {
								$(res)
										.each(
												function() {
													html += '<div class="card">';
													html += '<img class="card-img-top" src="${cp}/resources/img/img/'+this.mainImg.name+'.'+this.mainImg.type+ '">';
													html += '<div class="card-body">';
													html += '<h5 class="card-title">'
															+ this.name
															+ '</h5>';
													html += '<p class="card-text">'
															+ this.description
															+ '</p>';
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