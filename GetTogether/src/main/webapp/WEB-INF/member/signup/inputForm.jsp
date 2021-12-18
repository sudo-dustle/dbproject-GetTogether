<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../../../../WEB-INF/components/nav.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>회원가입</title>
<link rel = stylesheet href= "<c:url value='/css/signup.css' />" type="text/css">
<script>
	function checkemailaddy() {
		if (form.email_select.value == '1') {
			form.email2.readOnly = false;
			form.email2.value = '';
			form.email2.focus();
		} else {
			form.email2.readOnly = true;
			form.email2.value = form.email_select.value;
		}
	}
	function duplicateCheck() {
		alert("onclick check");
		form.action = '/GetTogether/member/duplicate';
		
		<%if (request.getAttribute("memberId") != "") {%>
			alert("이미 존재하는 사용자입니다.");
		<%} else {%>
			alert("사용 가능한 아이디입니다.");
			<%}%>
	}

	function selectAll1(selectAll) {
		const checkboxes = document.getElementsByName('field');
		
		checkboxes.forEach((checkbox) => {
			checkbox.checked = selectAll.checked;
		})
	}

	function selectAll2(selectAll) {
		const checkboxes = document.getElementsByName('lan');
		
		checkboxes.forEach((checkbox) => {
			checkbox.checked = selectAll.checked;
		})
	}
</script>

</head>

<body>
	<div class="main" align=center>
		<form method="post" action="<c:url value='/member/signup' />">
			<table style="border-collapse: collapse;">
				<tr>
					<th colspan="2" class="name">회원가입(* 표시 기입 필수)</th>
				</tr>
				<tr>
					<th class="name">아이디*</th>
					<td class="contents">
					<input type="text" name="mid" size="16" minlength="8" maxlength="16" required> 
					<input type="submit" class="checkButton" value="중복확인" onClick="duplicateCheck()">
					</td>
				</tr>
				<tr>
					<th class="name">비밀번호*</th>
					<td id="contents">
					<input type="password" name="passwd" size="16" required>
					</td>
				</tr>
				<tr>
					<th class="name">비밀번호 확인*</th>
					<td id="contents">
						<input type="password" size="16" minlength="8" maxlength="20" required>
					</td>
				</tr>
				<tr>
					<th class="name">이름*</th>
					<td class="contents">
						<input type="text" name="mname" size="16" required>
					</td>
				</tr>
				<tr>
					<th class="name">생년월일*</th>
					<td id="contents">
						<input type="date" name="date" size="17">
					</td>
				</tr>
				<tr>
					<th class="name">휴대폰*</th>
					<td id="contents"><select name="phone">
							<option value="010" selected>010</option>
							<option value="011">011</option>
							<option value="017">017</option>
							<option value="070">070</option>
							<option value="080">080</option>
					</select> - <input type="text" name="phone1" size="4" maxlength="4"> - <input
						type="text" name="phone2" size="4" maxlength="4"></td>
				</tr>
				<tr>
					<th class="name">이메일*</th>
					<td id="contents">
					<input name="email1" type="text" class="box" id="email1" size="15" required> @ 
					<input name="email2" type="text" class="box" id="email2" size="10s">
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
						<input type="text" name="school" size="20">
				</tr>
				<tr>
					<th class="name">학과</th>
					<td id="contents"><input type="text" name="major" size="30"></td>
				</tr>

				<tr>
					<th class="name">관심 프로젝트</th>
					<td id="contents">
						<input type="checkbox" name="field" value="ALL" onClick = "selectAll1(this)">ALL 
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
					<input type="checkbox" name="lan" value="ALL" onClick = "selectAll2(this)">ALL 
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
					<td id="contents"><textarea rows="5" cols="70" name="experience" cols="50px">간단하게 프로젝트 경험에 대해 서술해주세요.</textarea>
				</tr>
				<tr>
					<th colspan="2" class="title">
						<input type="submit" class="button" onClick="inputCheck()" value="가입하기"> 
						<input type="reset" class="button" value="다시작성"></th>
				</tr>

			</table>
		</form>
	</div>

</body>
</html>