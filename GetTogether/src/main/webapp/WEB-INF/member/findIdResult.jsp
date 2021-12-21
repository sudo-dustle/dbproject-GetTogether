<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, model.Member.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../../../../WEB-INF/components/nav.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>find id</title>
<link rel = stylesheet href= "<c:url value='/css/findId.css' />" type="text/css">
</head>
<body>
<div class="box">
		<h2>아이디 찾기 결과입니다.</h2>
		<br>
		아이디: ${memberInfo.mid }
</div>
</body>
</html>