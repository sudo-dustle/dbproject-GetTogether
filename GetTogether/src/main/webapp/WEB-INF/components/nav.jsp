<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel=stylesheet href="<c:url value='/css/common.css'/>" type="text/css">
<header><h1> <a href="<c:url value='/'/>">모여봐요</a></h1></header>
	<div>
	<%-- 로그인 안되어 있을경우 따로 처리가 필요합니다. --%>
	<ul>
		<li class="header-item">
			<a href="<c:url value='/user/login'/>">로그인</a>
		</li>
		<li class="header-item">|</li>
		<li class="header-item">
			<a href="<c:url value='/user/register'/>">회원가입</a>
		</li>
		</ul>
	</div>
<nav>
	<ul class="nav-container">
		<li class="nav-item">
			<a href="<c:url value='/project/list'/>">프로젝트 목록</a>
		</li>
		<li >|</li>
		<li class="nav-item">
			<a href="<c:url value='/project/manage'/>">프로젝트 관리</a>
		</li>
		<li>|</li>
		<li class="nav-item">
			<a href="<c:url value='/user/recommend'/>">팀원 추천</a>
		</li>
	</ul>
</nav>