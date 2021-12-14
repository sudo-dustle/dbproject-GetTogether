<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, model.Member.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="../../../../WEB-INF/components/nav.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MY PAGE</title>
<link rel = stylesheet href= "<c:url value='/css/signup.css' />" type="text/css">
<script>
function deleteMember() {
	form.action = "/member/delete";
}
</script>
</head>
<body>
	<div class="main" align=center>
		<form method="post" action="<c:url value='/member/update' />">
			<table style="border-collapse: collapse;">
				<tr>
					<th colspan="2" class="name">회원 정보 수정</th>
				</tr>
				<tr>
					<th class="name">아이디</th>
					<td class="contents">
					<input type="text" name="mid" size="16" minlength="8" maxlength="16" value="${memberInfo.mid}" required>
					</td>
				</tr>
				<tr>
					<th class="name">비밀번호</th>
					<td id="contents">
					<input type="password" name="passwd" size="16" value="${memberInfo.passwd}" required>
					</td>
				</tr>
				<tr>
					<th class="name">비밀번호 확인</th>
					<td id="contents">
						<input type="password" size="16" minlength="8" maxlength="20" required>
					</td>
				</tr>
				<tr>
					<th class="name">이름</th>
					<td class="contents">
						<input type="text" name="mname" size="16" value="${memberInfo.mname}" required>
					</td>
				</tr>
				<tr>
					<th class="name">생년월일</th>
					<td id="contents">
						<input type="date" name="date" size="17" value="${memberInfo.date}" required>
					</td>
				</tr>
				<tr>
					<th class="name">휴대폰</th>
					<td id="contents"><select name="phone">
							<option value=1 selected>010</option>
							<option value="2">011</option>
							<option value="3">017</option>
							<option value="4">070</option>
							<option value="5">080</option>
					</select> - <input type="text" name="phone1" size="4" maxlength="4" value="${fn:split(memberInfo.phonenum, '-')[1]}"> - <input
						type="text" name="phone2" size="4" maxlength="4" value="${fn:split(memberInfo.phonenum, '-')[2]}"></td>
				</tr>
				<tr>
					<th class="name">이메일</th>
					<td id="contents">
					<input name="email1" type="text" class="box" id="email1" size="15" value="${fn:split(memberInfo.email, '@')[0]}" required> @ 
					<input name="email2" type="text" class="box" id="email2" size="10s" value="${fn:split(memberInfo.email, '@')[1]}">
					 <select name="email_select" class="box" id="email_select"
						onChange="checkemailaddy();">
							<option value="" selected>선택하세요</option>
							<option value="naver.com">naver.com</option>
							<option value="hotmail.com">hotmail.com</option>
							<option value="hanmail.com">hanmail.com</option>
							<option value="yahoo.co.kr">yahoo.co.kr</option>
							<option value="1">직접입력</option>
					</select></td>
				</tr>
				<tr>
					<th class="name">재학중인 학교</th>
					<td id="contents">
						<input type="text" name="school" size="20" value="${memberInfo.school}">
				</tr>
				<tr>
					<th class="name">학과</th>
					<td id="contents"><input type="text" name="major" size="30" value="${memberInfo.major}"></td>
				</tr>

				<tr>
					<th class="name">관심 프로젝트</th>
					<td id="contents">
						<input type="checkbox" name="field" value="ALL" checked>ALL 
						<input type="checkbox" name="field" value="웹 개발">웹 개발 
						<input type="checkbox" name="field" value="모바일 웹 개발">모바일 웹 개발
						<p></p> 
						<input type="checkbox" name="field" value="게임개발">게임개발 
						<input type="checkbox" name="field" value="데이터사이언스">데이터사이언스 
						<input type="checkbox" name="field" value="서버 개발">서버 개발
						<p></p> 
						<input type="checkbox" name="field" value="블록체인 개발">블록체인 개발 
						<input type="checkbox" name="field" value="데스크톱 앱 개발"> 데스크톱 앱 개발 
						<input type="checkbox" name="field" value="기타">기타
				</tr>
				<tr>
					<th class="name">사용가능한 언어</th>
					<td id="contents">
					<input type="checkbox" name="lan" value="0"
						checked>ALL 
						<input type="checkbox" name="lan" value="C">C
						<input type="checkbox" name="lan" value="Python">Python 
						<input type="checkbox" name="lan" value="Java">Java 
						<input type="checkbox" name="lan" value="C++">C++
						<p></p> 
						<input type="checkbox" name="lan" value="C#">C# 
						<input type="checkbox" name="lan" value="Visual Basic">Visual Basic 
						<input type="checkbox" name="lan" value="JavaScript">JavaScript 
						<input type="checkbox" name="lan" value="PHP">PHP 
						<input type="checkbox" name="lan" value="R">R
						<p></p> 
						<input type="checkbox" name="lan" value="SQL">SQL 
						<input type="checkbox" name="lan" value="Groovy">Groovy 
						<input type="checkbox" name="lan" value="Perl">Perl 
						<input type="checkbox" name="lan" value="Go">Go 
						<input type="checkbox" name="lan" value="Swift">Swift
						<p></p> 
						<input type="checkbox" name="lan" value="Ruby">Ruby
						<input type="checkbox" name="lan" value="기타">기타
						</td>
				</tr>
				<tr>
					<th class="name">프로젝트 경험</th>
					<td id="contents"><textarea rows="5px" name="experience" cols="50px">${memberInfo.experience }</textarea>
				</tr>
				<tr>
					<th colspan="2" class="title">
						<input type="submit" class="button" value="저장하기"> 
						<input type="reset" class="button" value="다시작성"></th>
				</tr>

			</table>
		</form>
	</div>
</body>
</html>