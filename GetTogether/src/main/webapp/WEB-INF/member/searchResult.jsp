<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../../../../WEB-INF/components/nav.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색결과</title>
<link rel=stylesheet href="<c:url value='/css/common.css'/>" type="text/css">
</head>
<body>
	<div class="page-layout">
		<div class="subtitle">
			<h2>검색 결과</h2>
		</div>
			<div class="member-container">
			<%
				if(request.getAttribute("memberList") == null) {
					out.println("검색결과가 없습니다.");
				}
				else {
			%>
				<c:forEach var="member" items="${memberList}">
					<div class="member-box">
						<ul>
							<li>${member.mname}</li>
							<li>
							<div class="member-option-list">
								<button class="option-button">${member.language}</button>
							</div>
							</li>
						</ul>
					</div>
				</c:forEach>
				<% } %>
			</div>
	</div>
</body>
</html>
