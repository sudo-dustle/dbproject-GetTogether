<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, model.Member.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../../../../WEB-INF/components/nav.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Team member detail</title>
<link rel=stylesheet href="<c:url value='/css/teammemberpage.css' />" type="text/css">
</head>
<body>
	<div class="main" align=center>
		<table style="border-collapse: collapse;">
			<tr>
				<th colspan="2" class="name">팀원 상세 정보</th>
			</tr>
			<tr>
				<th class="name">아이디</th>
				<td class="contents">${memberInfo.mid}</td>
			</tr>
			<tr>
				<th class="name">이름</th>
				<td class="contents">${memberInfo.mname}</td>
			</tr>
			<tr>
				<th class="name">생년월일</th>
				<td class="contents">${memberInfo.date}</td>
			</tr>
			<tr>
				<th class="name">휴대폰</th>
				<td class="contents">${memberInfo.phonenum}</td>
			</tr>
			<tr>
				<th class="name">이메일</th>
				<td class="contents">${memberInfo.email}</td>
			</tr>
			<tr>
				<th class="name">재학중인 학교</th>
				<td class="contents">${memberInfo.school}</td>
			</tr>
			<tr>
				<th class="name">학과</th>
				<td class="contents">${memberInfo.major}</td>
			</tr>
			<tr>
				<th class="name">관심 프로젝트</th>
				<td class="contents">${memberInfo.field}</td>
			</tr>
			<tr>
				<th class="name">사용가능한 언어</th>
				<td class="contents">${memberInfo.language}</td>
			</tr>
			<tr>
				<th class="name">프로젝트 경험</th>
				<td class="contents">${memberInfo.experience}</td>
			</tr>
		</table>
	</div>
</body>
</html>