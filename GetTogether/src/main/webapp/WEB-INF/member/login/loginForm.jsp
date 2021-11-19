<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../../../../WEB-INF/components/nav.jsp" %>
<%-- <link rel = stylesheet href= "<c:url value='/css/common.css' />" type="text/css"> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원 로그인</title>
<style>
@import url('https://fonts.googleapis.com/css2?family=Jua&display=swap');
*{
	font-family: 'Jua', sans-serif;
}

body {
	font-weight: bold;
	font-size: 12pt;
	color: #2F2F2F;
	background-color: #F6F8ED;
}

div.box {
	margin: 5% auto;
	width: 700px;
	height: 350px;
	background-color: #9DB589;
	text-align: center;
}

div.form {
	margin-top: 45px;
	display: inline-block;
	text-align: center;
}

#inputbox {
	width: 500px;
	height: 70px;
	margin-bottom: 10px;
	padding-left: 10px;
}

#loginbutton {
	width: 506px;
	height: 70px;
	background-color: #2F2F2F;
	color: white;
}
</style>
</head>
<body>
	<div class="box">
		<div class="form">
			<form name="loginForm" method="post"
				action="<c:url value='/member/login' />">
				<input type="text" id="inputbox" placeholder="아이디" name="memberId" /><br>
				<input type="password" id="inputbox" placeholder="비밀번호"
					name="passwd" /><br> <input type="submit" id="loginbutton"
					value="로그인" /> <br>
				<br> <a href="">아이디/비밀번호 찾기</a> | <a href="inputForm.jsp">회원가입</a>
			</form>
		</div>
	</div>
</body>
</html>