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
<script>
function loginCheck(){
	<%
		if(request.getAttribute("loginFailed") == ""){
	%>
			alert("아이디와 비밀번호를 입려하세요.");
	<%
		}
	%>
}

</script>
</head>
<body>
	<div class="box">
		<div class="form">
			<form name="loginForm" method="post" action="<c:url value='/member/login' />">
				<input type="text" id="inputbox" placeholder="아이디" name="memberId" /><br>
				<input type="password" id="inputbox" placeholder="비밀번호" name="passwd" /><br> 
				<input type="submit" id="loginbutton" onClick='loginCheck()' value="로그인" /> <br>
				<br> <a href="">아이디/비밀번호 찾기</a> | <a href="/member/signup/input">회원가입</a>
			</form>
		</div>
	</div>
</body>
</html>