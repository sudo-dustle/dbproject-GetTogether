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
	<div class="parent">
	<button type="button" class="left-arrow" id="left-arrow">
	</button>
		<div class="container">
		   <c:forEach var="recommendTeam" items="${teamRecommendList}" >
			<div class="team-box" onClick= "location.href = '<c:url value= '/member/detail?mnum=${recommendMember.mnum}'/>';">
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