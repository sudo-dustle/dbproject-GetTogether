<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../../../../WEB-INF/components/nav.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원 로그인</title>
<link rel = stylesheet href= "<c:url value='/css/login.css' />" type="text/css">
</head>
<body>
	<div class="box">
		<div class="form">
			<form name="loginForm" method="post" action="<c:url value='/member/login' />">
				<input type="text" id="inputbox" placeholder="아이디" name="memberId" /><br>
				<input type="password" id="inputbox" placeholder="비밀번호" name="passwd" /><br> 
				<input type="submit" id="loginbutton" value="로그인" /> <br>
				<br> <a href="/GetTogether/member/findId">아이디/비밀번호 찾기</a> | <a href="/GetTogether/member/signup/form">회원가입</a>
			</form>
		</div>
	</div>
</body>
</html>