<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../../../../WEB-INF/components/nav.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<link rel = stylesheet href= "<c:url value='/css/findId.css' />" type="text/css">
</head>
<body>
	<div class="box">
		<h2>아이디 찾기</h2>
		<form method="post" action="<c:url value='/member/findIdByName' />">
		<table>
			<tr class="title">
				<th>아이디 찾기</th>
				<th><a href="/GetTogether/member/findPw">비밀번호 찾기</a></th>
			</tr>
			<tr>
				<td colspan="2" class="context1">
				&nbsp;&nbsp;&nbsp;이름: <input type="text" name="name">
				<br>
				<br>
				&nbsp;&nbsp;&nbsp;전화번호: 
					<select name="phone">
						<option value="010">010</option>
						<option value="011">010</option>
					</select> - <input type="text" name="phone1"> - <input type="text" name="phone2">
				</td>
			</tr>
			<tr>
				<td colspan="2" class="context2"><input type="submit" class="button" value="아이디 찾기"></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>