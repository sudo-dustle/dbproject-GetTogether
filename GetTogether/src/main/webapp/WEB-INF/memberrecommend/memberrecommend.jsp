<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/WEB-INF/components/nav.jsp" %>
<html>
<head>
<meta charset="UTF-8">
<head>
<title>memberRecommend</title>
<link rel=stylesheet href="<c:url value='/css/memberrecommend.css' />" type="text/css">
			<div class="page-layout">
			<div class="subtitle">
				<h2>팀원 추천</h2>
				<div class="search-box">
					<input class="input-search" type="text" placeholder="검색하기">
					<button class="option-button">search</button>
				</div>
			</div>
			<div class="member-container">
				<c:forEach var="msg" items="${MemberRecommendList}">
					<div class="member-box">
						<ul>
							<li>>${recommendMember.name}</li>
							<div class="member-option-list">
								<button class="option-button">${recommendMember.language}</button>
								<button class="option-button">${recommendMember.language}</button>
							</div>
						</ul>
					</div>
					<div class="member-box">
						<ul>
							<li>이*나</li>
							<div class="member-option-list">
								<button class="option-button">C</button>
								<button class="option-button">C++</button>
							</div>
						</ul>
					</div>
					<div class="member-box">
						<ul>
							<li>박*다</li>
							<div class="member-option-list"></div>
								<button class="option-button">웹개발</button>
								<button class="option-button">Java</button>
								<button class="option-button">Javascript</button>
					</div>
				</c:forEach>	
			</div>

	</body>
</html>
