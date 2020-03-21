<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="main_header">
	<div class="first">
		<a href="${cp}/main"><img src="${cp}/resources/img/logo.png" /></a>
	</div>
	<div class="second">
		<c:choose>
			<c:when test="${not empty member && member.mId != null}">
				<span>${member.getmName()} </span>
			</c:when>
			<c:otherwise>
				<a href="${cp}/member/loginForm">예약하기</a>
			</c:otherwise>
		</c:choose>
	</div>
</div>