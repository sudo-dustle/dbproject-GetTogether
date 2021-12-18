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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
<script>
	var conGroup;
	var maxGroup = ${teamRecommendList.size()};
	var maxGroupNum = (maxGroup - (maxGroup % 6)) / 6;
	var lookupcnt = 0
	$(document).ready(() => {
		conGroup = 0;
		$(".team-box").hide();
		$(".group" + conGroup).show();
	});
	
	$(".btn-like").on("click", function(e) {

	    var likeCount = button.find(".like-count")
	    var heartShape = button.find(".heart-shape")
	});
	
	const previous = () => {
		conGroup--;
		if (conGroup < 0)
			conGroup = maxGroupNum;
		$(".team-box").hide();
		$(".group" + conGroup).show();
	}
	
	const next = () => {
		conGroup++;
		if (conGroup > maxGroupNum)
			conGroup = 0;
		$(".team-box").hide();
		$(".group" + conGroup).show();
	
	}
</script>
	<div class="parent">
	<button type="button" class="left-arrow" style = "cursor:pointer" id="left-arrow" onclick="previous();">
	</button>
		<div class="container" >
		<%int i = 0;%>
		   <c:forEach var="recommendTeam" items="${teamRecommendList}" >
		   <% String className = "group" + (i / 6); %>
					<div id="id" class="team-box <%=className%>" style = "cursor:pointer;" onClick= "location.href = '<c:url value= '/project/detail?pid=${recommendTeam.pid}'/>';">
						<h2>${recommendTeam.title}</h2>
						<br>
						<h3>${recommendTeam.subtitle}</h3>
						${recommendTeam.lookupcnt}<br><br><br>
					    <button type="button" class="btn-like" background-color = #DCDCDC>♡${recommendTeam.recommendcnt}</button>
					</div>
				<%
					i++;%>
			</c:forEach>
		</div>
		<button type="button" class="right-arrow" id="right-arrow" style = "cursor:pointer" onclick="next();">
		</button>
	</div>
</body>

</html>