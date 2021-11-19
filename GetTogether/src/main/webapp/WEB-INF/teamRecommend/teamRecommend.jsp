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
            <div class="arrow-left"></div>
	            <div id = "wrap">

	            <% int i = 1; %>
	            	<c:forEach var="recommendTeam" items="${teamRecommendList}">
					<% out.print("<div id='box" + i++ + "'>");%>
	            	<h2>${recommendTeam.title}</h2> <br><h3>${recommendTeam.subtitle}</h3>${recommendTeam.lookupcnt}<br>
	                
	                </c:forEach>	
	            </div>
            <div class="arrow-right"></div>
        </div>
</body>

</html>

