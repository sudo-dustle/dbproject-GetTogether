<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>teamRecommend</title>
<%@ include file="/WEB-INF/components/nav.jsp" %>
<link rel=stylesheet href="<c:url value='/css/teamrecommend.css' />" type="text/css">
</head>
<body>
	<div class="searchForm">
		<form method="GET" action="<c:url value='/project/search'/>">
			<select class="select" name="projectSearch">
					<option value="pjName">제목</option>
					<option value="writer">작성자</option>
			</select>
			<input type="text" class="srhInput" name="srhTxt">
			<input type="submit" class="srhButton" value="검색">
		</form>
	</div>
	<div class="parent">
	<button type="button" class="left-arrow" id="left-arrow">
	</button>
		<div class="container" >
		   <c:forEach var="recommendTeam" items="${teamRecommendList}" >
					<div class="team-box" style = "cursor:pointer;" onClick= "location.href = '<c:url value= '/project/detail?pid=${recommendTeam.pid}'/>';">
						<h2>${recommendTeam.title}</h2>
						<br>
						<h3>${recommendTeam.subtitle}</h3>
						${recommendTeam.lookupcnt}<br>
					</div>
			</c:forEach>
		</div>
		<button type="button" class="right-arrow" id="right-arrow">
		</button>
	</div>
</body>

</html>