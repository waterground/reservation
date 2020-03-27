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
<title>상세보기</title>
<link rel="stylesheet" href="${cp}/resources/css/style.css" />
<link rel="stylesheet" href="${cp}/resources/css/info_style.css" />
<link rel="stylesheet"
	href="//unpkg.com/bootstrap@4/dist/css/bootstrap.min.css">
<script src='//unpkg.com/jquery@3/dist/jquery.min.js'></script>
<script src='//unpkg.com/popper.js@1/dist/umd/popper.min.js'></script>
<script src='//unpkg.com/bootstrap@4/dist/js/bootstrap.min.js'></script>
<script src="${cp}/resources/javascript/myCarousel.js"></script>
</head>
<body>
	<div class="background">
		<jsp:include page="../header.jsp" flush="false" />
		<!-- img box -->
		<div id="promotion" class="carousel slide" data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#carouselIndicators" data-slide-to="0"
					class="active" onclick="indexEvent(0)"></li>
				<c:forEach items="${product.imgList}" var="img" varStatus="status">
					<c:if test="${status.index ne 0}">
						<li data-target="#carouselIndicators"
							data-slide-to="${status.index}"
							onclick="indexEvent(${status.index})"></li>
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
			<a class="carousel-control-prev" role="button" data-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"
				onclick="prevEvent()"></span>
			</a> <a class="carousel-control-next" role="button" data-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"
				onclick="nextEvent()"></span>
			</a>
		</div>
		<!-- info box -->
		<div id="detail">
			<h4>${product.name}</h4>
			<div class="info">전화번호 ${product.tel}</div>
			<div class="info">주소 ${product.address}</div>
			<div class="info">운영 시간 ${product.openingHours}</div>
			<div class="info">홈페이지 ${product.homepage}</div>
		</div>
		<!-- 예약하기 버튼 box -->
		<div id="btnContainer">
			<div><a href="${cp}/reservation/${product.id}">예약하기</a></div>
		</div>
		<!-- avg score box -->
		<div id="score"></div>
		<!-- comment box -->
		<div id="commentList"></div>
		<div class="toTop">
			<div><a href="#main_header">Top</a></div>
		</div>
		<input type="hidden" id="productId" value="${product.id}"/>
		<jsp:include page="../footer.jsp" flush="false" />
	</div>
	<script>
	$(".carousel").carousel({
		interval : 2000
	});
	var bId, mIdVal;
	$(document).ready(function(){
		
		// 댓글 목록 함수 호출
			
		fn_getList();
	});

	//댓글 등록
	$("#writeBtn").on("click", function() {
		var rContent = $("#rContent");
		var rContentVal = rContent.val();
		var rNameVal = $("#rName").val();
		
		$.ajax({
			type : "post",
			url : "${cp}/comment/write",
			headers : {
				"Content-type" : "application/json",
				"X-HTTP-Method-Override" : "POST"
			},
			dataType : "text",
			data : JSON.stringify({
				"memberId" : bId,
				"rContent" : rContentVal,
				"rName" : rNameVal,
				"mId" : mIdVal
			}),
			success : function(result) {
				if (result == "register Success") {
					alert("댓글이 등록 되었습니다");
					fn_getList(pageNum);
					rContent.val(""); // 댓글 내용 초기화
				}
			},
			error: function(request, status, error) {
				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			}
		});
	});

	//댓글 삭제
	function fn_remove(rId) {
		$.ajax({
			type : "post",
			url : "${cp}/comment/remove",
			headers : {
				"Content-type" : "application/json",
				"X-HTTP-Method-Override" : "POST"
			},
			dataType : "text",
			data : JSON.stringify({
				"id" : id
			}),
			success : function(result) {
				if (result == "remove Success") {
					alert("댓글이 삭제 되었습니다");
				}
				fn_getList();
			},
			error: function(request, status, error) {
				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			}
		});	
	}

	// 후기 목록 함수
	function fn_getList(){
		$.ajax({
			type: "post",
			url: "${cp}/comment/list?productId=" + $("#productId").val(),
			dataType : "json",
			success: function(res){
				var html = "";
				
				if(res.length < 1){
					html += "<div class='commentContainer' style='text-align:center; margin: 10px'>";
					html += "<br>등록된 후기가 없습니다<br><br>";
					html += "</div>";
				}else{
					$(res).each(function(){
						var date = new Date(this.date);
						html += "<br/>";
						html += "<div class='commentContainer'><h6><strong>"+ this.memberId +"</strong>&nbsp;";
						html += "<small>" + dateToStr(date) +"</small>&nbsp;";
						if(mIdVal == this.memberId){
							html += "<span id='" + this.rId+ "buttons'>";
							html += "<a href='#' onClick='fn_updateForm("+ this.rId + ")'>수정</a>&nbsp;"
							html += "<a href='#' onClick='fn_remove(" + this.rId+ ")'>삭제</a>";
						}
						html += "</span></h6>";
						html += "<div id='"+this.id+"content'>"+this.content + "</div>";
						html += "<hr></div>";
					});
				}
				$("#commentList").html(html);
			}
		});
	}

	// 댓글 날짜 출력
	function dateToStr(format){
	    var year = format.getFullYear();
	    var month = format.getMonth() + 1;
	    if(month<10) month = '0' + month;
	    var date = format.getDate();
	    if(date < 10) date = '0' + date;
	    var hour = format.getHours();
	    if(hour < 10) hour = '0' + hour;
	    var min = format.getMinutes();
	    if(min < 10) min = '0' + min;
	    var sec = format.getSeconds();
	    if(sec < 10) sec = '0' + sec;

	    return year + "-" + month + "-" + date + " " + hour + ":" + min + ":" + sec;
	}
	</script>
</body>
</html>
