<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*, model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../../../../WEB-INF/components/nav.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로젝트 검색 결과</title>
<link rel = stylesheet href= "<c:url value='/css/projectResult.css' />" type="text/css">
</head>
<body>
	<div class="searchForm">
		<form method="GET" action="<c:url value='/project/search'/>" >
			<select class="select" name="projectSearch">
					<option value="pjName">제목</option>
					<option value="writer">작성자</option>
			</select>
			<input type="text" class="srhInput" name="srhTxt">
			<input type="submit" class="srhButton" value="검색">
		</form>
	</div>
	<div class="context">
		<%
		if (request.getAttribute("projectList") == null) {
			out.println("검색결과가 없습니다.");
		} else {
		%>
		<p>"<%= request.getParameter("srhTxt") %>"의 검색결과
		<c:forEach var="project" items="${projectList}">
			<div class="team-box" style = "cursor:pointer;" onClick= "location.href = '<c:url value= '/project/detail?pid=${project.pid}'/>';">
						<h2>${project.title}</h2>
						<br>
						<h3>${project.subtitle}</h3>
					</div>
		</c:forEach>
		<%} %>
	</div>
</body>
</html>