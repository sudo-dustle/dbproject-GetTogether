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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
	<script>
	var conGroup;
	var maxGroup = ${projectList.size()};
	var maxGroupNum = (maxGroup - (maxGroup % 6)) / 6;
	var lookupcnt = 0
	$(document).ready(() => {
		conGroup = 0;
		$(".team-box").hide();
		$(".group" + conGroup).show();
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
	function send(theform){ //form 을 받는다.
		if(theform.srhTxt.value==""){
		alert("검색어를 입력 하세요.");
		theform.search.focus(); //text 창으로 커서
		return false;
		}
		theform.submit();
	}
</script>
	<div>
		<div style="float: right; margin: 25px 15px;">
			<form method="GET" action="<c:url value='/project/search'/>">
				<select name="selectTxt" style="height: 30px; width: 100px;">
					<option value="0">제목</option>
					<option value="1">작성자</option>
				</select>
				<input type="text" class="input-search" name="srhTxt" placeholder="검색하기" value="${srhTxt}" style="width: 300px; height: 31px; vertical-align: middle;"> 
				<input type="button" class="option-button" value="검색" onClick="send(this.form);" style="height: 33px;width: 100px;">
			</form>
		</div>
	</div>
	<div class="parent">
	<button type="button" class="left-arrow" style = "cursor:pointer" id="left-arrow" onclick="previous();">
	</button>
		<div class="container" >
		<%int i = 0;%>
		   <c:forEach var="project" items="${projectList}" >
		   <% String className = "group" + (i / 6); %>
					<div id="id" class="team-box <%=className%>" style = "cursor:pointer;" onClick= "location.href = '<c:url value= '/project/detail?pid=${project.pid}'/>';">
						<h2>${project.title}</h2>
						<br>
						<h3>${project.subtitle}</h3>
						${project.lookupCnt}<br>
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