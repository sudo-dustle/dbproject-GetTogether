<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="../../../../WEB-INF/components/nav.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel = stylesheet href= "<c:url value='/css/findId.css' />" type="text/css">
</head>
<body>
<div class="box">
		<h2>비밀번호 찾기 결과입니다.</h2>
		<br>
		<c:set var="string" value="${memberInfo.passwd }" />
		비밀번호: ${fn:substring(string, 0, 3)}
		<c:forEach var="i" begin="4" end="${fn:length(string)}" >
			<c:out value="*"/>
		</c:forEach>
</div>

</body>
</html>