<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코멘트 작성</title>
<link rel="stylesheet" href="${cp}/resources/css/style.css" />
<link rel="stylesheet" href="//unpkg.com/bootstrap@4/dist/css/bootstrap.min.css">
<script src='//unpkg.com/jquery@3/dist/jquery.min.js'></script>
<script src='//unpkg.com/popper.js@1/dist/umd/popper.min.js'></script>
<script src='//unpkg.com/bootstrap@4/dist/js/bootstrap.min.js'></script>
<!-- font -->
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
<!-- star rating(rateyo)-->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.js"></script>
<style>
	.imgContainer img{margin: 2px;}
</style>
</head>
<body>
	<div class="background">
		<jsp:include page="../header.jsp" flush="false" />
		<div class="form_container">
			<br>
			<h3>리뷰 작성</h3>
			<br>
			<form:form action="${cp}/review/" method="post" id="form"
				commandName="review" enctype="multipart/form-data">
				<form:hidden path="reservationId" value="${reservationId}" />
				<form:hidden path="memberId" value="${member.id}" />
				<!-- 평점 선택창 -->
				<div class="form-group my-ratings">
					<form:label path="rating">평점 </form:label>
					<form:hidden path="rating" id="rating" value="0" />
					<div class="rating"></div>
				</div>
				<div class="form-group">
					<label for="content"> 내용 </label>
					<form:textarea path="content" class="form-control" rows="10"></form:textarea>
				</div>
				<!-- review 이미지 입력 -->
				<label id="file">리뷰 이미지</label><br>
				<input multiple="multiple" type="file" id="imgFile" name="file" accept="image/*" maxlength="2"/>
				<div class="imgContainer conatiner p-3 my-3 border" style="height:110px;"></div>
				<button class="btn btn-primary float-right" style="margin-left: 2px">등록</button>
				<a href="#" class="btn btn-primary float-right" onClick="history.back()">취소</a>
			</form:form>
		</div>
		<jsp:include page="../footer.jsp" flush="false" />
	</div>
	<script>
	
	$(document).ready(function(){
		$("#imgFile").on("change", imgUploadEvent);
	});
		$(".rating").rateYo({
			rating: 0,
			starWidth: "20px",
			normalFill: "#A0A0A0",
			halfStar: true,
			onSet: function (rating, rateYoInstance) {
				$("#rating").val(rating);
		    }
		});
		
		var imgFiles = [];
		function imgUploadEvent(e){
			imgFiles = [];
			$(".imgContainer").empty();
			
			var files = e.target.files;
			var filesArr = Array.prototype.slice.call(files);
			
			var index = 0;
			filesArr.forEach(function(f){
				if(!f.type.match("image.*")){
					alert("이미지 파일만 가능합니다");
					return;
				}
				
				imgFiles.push(f);
				
				var reader = new FileReader();
				reader.onload = function(e) { 
					var html = "<a onclick='deleteImg("+index+")' id='img"+index+"' ><img src='"+e.target.result+"' title='클릭 시 삭제' width='120px'/></a>";
					$(".imgContainer").append(html);
					index++;
				}
				reader.readAsDataURL(f);
			})
		}
		
		function deleteImg(index){
			imgFiles.splice(index, 1);
			$("#img"+index).remove();
		}

	</script>
</body>
</html>