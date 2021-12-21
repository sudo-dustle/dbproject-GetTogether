<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../../WEB-INF/components/nav.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<link rel = stylesheet href= "<c:url value='/css/findId.css' />" type="text/css">
</head>
<body>
<div class="box">
		<h2>비밀번호 찾기</h2>
		<form method="post" action="<c:url value='/member/findPwById' />">
		<table>
			<tr class="title">
				<th><a href="/GetTogether/member/findId">아이디 찾기</a></th>
				<th>비밀번호 찾기</th>
			</tr>
			<tr>
				<td colspan="2" style="height: 70px;">
				&nbsp;&nbsp;&nbsp;아이디: <input type="text" name="memberId">
				</td>
				<td></td>
			</tr>
			<tr>
				<td colspan="2" class="context2"><input type="submit" class="button" value="비밀번호 찾기"></td>
				<td></td>
			</tr>
		</table>
		</form>
</div>
</body>
</html>