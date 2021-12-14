<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, model.Member.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../../../../WEB-INF/components/nav.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MY PAGE</title>
<link rel = stylesheet href= "<c:url value='/css/mypage.css' />" type="text/css">
<script>
function updateMember() {
	form.submit();	
}
function deleteMember(targetUri) {
	form.action = targetUri;
	form.submit();
}
</script>
</head>
<body>
	<div class="main" align=center>
		<form method="post">
			<table style="border-collapse: collapse;">
				<tr>
					<th colspan="2" class="name">회원 정보 수정</th>
				</tr>
				<tr>
					<th class="name">아이디</th>
					<td class="contents">
					${memberInfo.mid}
					</td>
				</tr>
				<tr>
					<th class="name">이름</th>
					<td class="contents">
					${memberInfo.mname}
					</td>
				</tr>
				<tr>
					<th class="name">생년월일</th>
					<td class="contents">
					${memberInfo.date}
					</td>
				</tr>
				<tr>
					<th class="name">휴대폰</th>
					<td class="contents">
					${memberInfo.phonenum}
					</td>
				</tr>
				<tr>
					<th class="name">이메일</th>
					<td class="contents">
					${memberInfo.email}
					</td>
				</tr>
				<tr>
					<th class="name">재학중인 학교</th>
					<td class="contents">
					${memberInfo.school}
					</td>
				</tr>
				<tr>
					<th class="name">학과</th>
					<td class="contents">
					${memberInfo.major}
					</td>
				</tr>
				<tr>
					<th class="name">관심 프로젝트</th>
					<td class="contents">
					${memberInfo.field}
					</td>
				</tr>
				<tr>
					<th class="name">사용가능한 언어</th>
					<td class="contents">
					${memberInfo.language}
					</td>
				</tr>
				<tr>
					<th class="name">프로젝트 경험</th>
					<td class="contents">
					${memberInfo.experience}
					</td>
				</tr>
				<tr>
					<th colspan="2" class="title">
						<input type="submit" class="button" value="수정하기" onClick="javascript: form.action='/GetTogether/member/detail/update';"> 
					</th>
				</tr>

			</table>

			<hr>
			<table class="delete">
				<tr>
					<td class="delete_td1">회원 탈퇴</td>
				</tr>
				<tr>
					<td class="delete_td2">
					정말로 탈퇴하시겠습니까?
					<input type="submit" class="button" value="탈퇴하기" onClick="javascript: form.action='/GetTogether/member/delete';" >
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>