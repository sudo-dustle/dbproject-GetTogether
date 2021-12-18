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
<%@ include file="/WEB-INF/components/nav.jsp" %>
</head>
<script type="text/javascript">
function doUpdate(value){
	if(value==1)
	    location.href="/GetTogether/project/update?pid=${project.pid}";
	else if(value==0)
		location.href="/GetTogether/project/delete?pid=${project.pid}"
}
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
			<td  id="content" style="text-align: right; border: 0;background-color: #F6F8ED;">
			<%--	<c:if test="${MemberSessionUtils.getLoginMembreId() != null }">
					<c:if test="${MemberSessionUtils.getLoginMemberId() == project.mnum}"> --%>
						<input class="submit" type="" value="수정" name="update" onClick="doUpdate(1);">
						<input class="submit" name="delete" value="삭제" onClick="doUpdate(0);">
					<%-- </c:if>
					</c:if> --%>
			</td>
					
		</table>
		</form> 
		<%-- 
		<hr style="width: 60%; margin-top: 2%;">
		<table>
			<tr>
				<th>프로젝트 신청 현황</th>
				<th></th>
				<th></th>
				<th></th>
			</tr>
			<tr>
				<td id="element">제목</td>
				<td id="element">신청자명</td>
				<td id="element">신청일</td>
				<td id="element">상태</td>
			</tr>
			<tr>
				<td colspan="4"><p style="text-align: center;border: 0;color:#adadad;">지금은 비어있습니다.</p></td>
			</tr>
		</table>
		<hr style="width: 60%; margin-top: 2%;">
		<table>
			<tr>
				<th>프로젝트 신청하기</th>
				<th></th>
			</tr>
			<tr>
				<td id="element">제목</td>
				<td style="padding-left: 15px;"><input type="text"></td>
			</tr>
			<tr>
				<td id="element">신청자 이름</td>
				<td style="padding-left: 15px;"><input type="text"></td>
			</tr>
			<tr>
				<td id="element" >개발 역량</td>
				<td><input type="checkbox" value="css"> C
					<input type="checkbox" value="css"> C++
					<input type="checkbox" value="css"> C#
					<input type="checkbox" value="css"> Java
					<input type="checkbox" value="css"> JavaScript
					<input type="checkbox" value="css"> Python
					<input type="checkbox" value="css"> Visual Basic
					<input type="checkbox" value="css"> PHP
					<input type="checkbox" value="css"> SQL
					<input type="checkbox" value="css"> CSS
					<input type="checkbox" value="css"> HTML
					<input type="checkbox" value="css"> R</td>
			</tr>
			<tr>
				<td id="element">자기 소개</td>
				<td><textarea rows="10" style="width: 99%;"></textarea></td>
			</tr>
			<tr>
				<td id="btn" style="background-color: #F6F8ED;"></td>
				<td id="content" style="text-align: right; border: 0;background-color: #F6F8ED;">
					<button>신청</button>
				</td>
			</tr>
		</table>
--%>
	</div>
	
</body>
</html>