<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="main_header">
	<div class="first">
		<a href="${cp}/main"><img src="${cp}/resources/img/logo.png" /></a>
	</div>
	<div class="second">
		<c:choose>
			<c:when test="${not empty member && member.id ne null}">
				<div class="dropdown">
					<button class="btn dropdown-toggle" type="button"
						id="dropdownMenuButton" data-toggle="dropdown"
						style="color: white">${member.getId()}</button>
					<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
						<a class="dropdown-item" href="#">Action</a> <a
							class="dropdown-item" href="${cp}/member/remove">회원 탈퇴</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="${cp}/member/logout">로그아웃</a>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<a href="${cp}/member/login">예약하기</a>
			</c:otherwise>
		</c:choose>
	</div>
</div>