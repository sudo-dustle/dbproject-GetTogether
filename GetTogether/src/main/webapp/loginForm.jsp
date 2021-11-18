<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
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

div.main {
	text-align: center;
	padding-top: 15px;
}

div.banner {
	background-color: #9DB589;
	text-align: center;
	padding: 20px;
	font-size: 18pt;
	color: #2F2F2F;
}

div.log {
	text-align: right;
}

div.box {
	border: 1px solid black;
	margin: 10% auto;
	width: 700px;
	height: 350px;
	background-color: #9DB589;
	text-align: center;
}

div.form {
	margin-top: 15px;
	display: inline-block;
	text-align: center;
}

#inputbox {
	width: 500px;
	height: 70px;
	margin-bottom: 10px;
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
	<h1>
		<div class="main">모여봐요</div>
	</h1>
	<P></P>
	<div class="log">로그인 | 회원가입</div>

	<div class="banner">프로젝트 목록 &nbsp;&nbsp;&nbsp;&nbsp; |
		&nbsp;&nbsp;&nbsp;&nbsp; 프로젝트 관리 &nbsp;&nbsp;&nbsp;&nbsp; |
		&nbsp;&nbsp;&nbsp;&nbsp; 팀원 추천</div>
		
	<div class="box">
	<div class="form">
	<form name="loginForm" method="post" action="<c:url value='/user/login' />">
		<input type="text" id="inputbox" placeholder="아이디" name="memberId" /><br>
		<input type="password" id="inputbox" placeholder="비밀번호" name="passwd" /><br>
	
		<input type="submit" id="loginbutton" value="로그인" />
		<br><br><br>
		<a href= "">아이디/비밀번호 찾기</a> | <a href="inputForm.jsp">회원가입</a>
	</form>
	</div>
	</div>
</body>
</html>