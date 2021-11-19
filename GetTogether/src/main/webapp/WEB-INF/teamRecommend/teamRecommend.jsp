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
	            	<c:forEach var="recommendTeam" items="${teamRecommendList}">
	                <div id="box1"><h2>${recommendTeam.title}</h2> </br><h3>${recommendTeam.subtitle}</h3>${recommendTeam.lookupcnt}</br></div>
	                <div id="box2"><h2>프로젝트3</h2> </br><h3>사용기술 : a,b,c</h3>작성자2 </br></div>
	                <div id="box3"><h2>프로젝트2</h2> </br><h3>사용기술 : a,b,c</h3>작성자3 </br></div>
	                <div id="box4"><h2>프로젝트6</h2> </br><h3>사용기술 : a,b,c</h3>작성자4 </br></div>
	                <div id="box5"><h2>프로젝트4</h2> </br><h3>사용기술 : a,b,c</h3>작성자5 </br></div>
	                <div id="box6"><h2>프로젝트5</h2> </br><h3>사용기술 : a,b,c</h3>작성자6</br></div>
	                </c:forEach>	
	            </div>
            <div class="arrow-right"></div>
        </div>
</body>
</html>