<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로젝트 상세 페이지(팀장)</title>
<link rel=stylesheet href="<c:url value='/css/common.css'/>" type="text/css">
<link rel=stylesheet href="<c:url value='/css/project.css'/>" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<%@ include file="/WEB-INF/components/nav.jsp" %>
</head>
<script type="text/javascript">
const goProjectList = () => {
    location.href="/GetTogether/";
}
function doUpdate(value){
	if(value==1)
	    location.href="/GetTogether/project/update?pid=${project.pid}";
	else if(value==0)
		location.href="/GetTogether/project/delete?pid=${project.pid}"
}

function checkMnum(){
	if(<%=session.getAttribute("mnum") %> == "${project.mnum}"){
		return (1);
	}
	return 0;
}

$(document).ready(() => {
	if(!checkMnum())
	{
		$(".submit").hide();
	}
});


</script>
<style>
div {
	margin-right: 20px;
}
</style>
<body>
<form method="GET" > 
	<div>
		<table style="margin-top: 2%;">
			<tr>
				<th>프로젝트 상세</th>
				<th></th>
			</tr>
			<tr>
				<td id="element">프로젝트 제목</td>
				<td id="content">${project.title}</td>
			</tr>
			<tr>
				<td id="element">부제목</td>
				<td id="content">${project.subtitle}</td>
			</tr>
			<tr>
				<td id="element">수행기간</td>
				<td id="content"><fmt:formatDate value="${project.executionStart}" pattern="yyyy-MM-dd hh:mm" />~<fmt:formatDate value="${project.executionEnd}" pattern="yyyy-MM-dd hh:mm" />
				</td>
			</tr>
			<tr>
				<td id="element">모집기간</td>
				<td id="content"><fmt:formatDate value="${project.applicationStart}" pattern="yyyy-MM-dd hh:mm" />~<fmt:formatDate value="${project.applicationEnd}" pattern="yyyy-MM-dd hh:mm" />
				</td>
			</tr>
			<tr>
				<td id="element">모집인원</td>
				<td id="content">${project.numOfMembers}/${project.applicationNum}</td>
			</tr>
			<tr>
				<td id="element">기술 분야</td>
				<td id="content">${project.field}</td>
			</tr>
			<tr>
				<td id="element">목표</td>
				<td id="content">${project.goal}</td>
			</tr>
			<tr>
				<td id="element" style="height: 100px;">프로젝트 개요</td>
				<td>${project.description}</td>
			</tr>
			<tr>
				<td id="element" style="height: 70px;">필요 기술</td>
				<td id="content">${project.language}</td>
			</tr>
			<tr>
				<td id="btn" style="background-color: #F6F8ED;"></td>
				<td  id="content" style="text-align: right; border: 0;background-color: #F6F8ED;">
					<input class="submit" value="수정" name="update" onClick="doUpdate(1);">
					<input class="submit" name="delete" value="삭제" onClick="doUpdate(0);">
					<input class="reset" name="cancel" value="목록으로" onClick="goProjectList();">
					</tr>
		</table>
		</form>
	</div>
	
</body>
</html>