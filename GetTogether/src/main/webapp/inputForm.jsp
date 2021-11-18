<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<title>회원가입</title>
<style>
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

.button {
	border: solid 1px #9DB589;
	border-radius: 5px;
}

table {
	width: 800px;
	height: 700px;
	color: #2F2F2F;
}

table, td, th {
	border-collapse: collaspe;
	border: solid 1px #2F2F2F;
	background-color: white;
}

th {
	width: 70px;
}

th.title {
	background-color: #9DB589;
	text-align: center;
	font-weight: bold;
	font-size: 15px;
}

th.name {
	background-color: #9DB589;
	table-layout: auto;
	width: 150px;
	text-align: center;
	font-weight: bold;
	font-size: 20px;
}

td.contents {
	font-size: 13px;
}

* {
	font-family: 'Jua', sans-serif;
}
</style>
<script language="JavaScript">
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
</script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap"
	rel="stylesheet">
</head>

<body>
	<h1>
		<div class="main">모여봐요</div>
	</h1>
	<P></P>
	<div class="log">로그인 | 회원가입</div>
	</P>
	<div class="banner">프로젝트 목록 &nbsp;&nbsp;&nbsp;&nbsp; |
		&nbsp;&nbsp;&nbsp;&nbsp; 프로젝트 관리 &nbsp;&nbsp;&nbsp;&nbsp; |
		&nbsp;&nbsp;&nbsp;&nbsp; 팀원 추천</div>
	<p></p>

	<div align=center>
		<form method="post" action="/user/input">
			<table style="border-collapse: collapse;">
				<tr>
					<th colspan="2" class="name">회원가입(* 표시 기입 필수)</th>
				</tr>
				<tr>
					<th class="name">아이디*</th>
					<td class="contents">
					<input type="text" name="mid" size="16" minlength="8" maxlength="16" required> 
					<input type="button" class="button" value="중복확인">
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
							<option value=1 selected>010</option>
							<option value="2">011</option>
							<option value="3">017</option>
							<option value="4">070</option>
							<option value="5">080</option>
					</select> - <input type="text" name="phone1" size="4" maxlength="4"> - <input
						type="text" name="phone2" size="4" maxlength="4"></td>
				</tr>
				<tr>
					<th id class="name">이메일*</th>
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
						<input type="text" size="20" readonly>
						<input type="button" class="button" value="대학교 선택">
				</tr>
				<tr>
					<th id class="name">학과</th>
					<td id="contents"><input type="text" name="major" size="30"></td>
				</tr>

				<tr>
					<th class="name">관심 프로젝트</th>
					<td id="contents">
						<input type="checkbox" name="project" value="0" checked>ALL 
						<input type="checkbox" name="project" value="1">웹 개발 
						<input type="checkbox" name="project" value="2">모바일 웹 개발
						<p></p> 
						<input type="checkbox" name="project" value="3">게임개발 
						<input type="checkbox" name="project" value="4">데이터사이언스 
						<input type="checkbox" name="project" value="5">서버 개발
						<p></p> 
						<input type="checkbox" name="project" value="6">블록체인 개발 
						<input type="checkbox" name="project" value="7"> 데스크톱 앱 개발 
						<input type="checkbox" name="project" value="8">
						<input type="text" size="5" value="기타"></td>
				</tr>
				<tr>
					<th class="name">사용가능한 언어</th>
					<td id="contents">
					<input type="checkbox" name="lan" value="0"
						checked>ALL 
						<input type="checkbox" name="lan" value="1">C
						<input type="checkbox" name="lan" value="2">Python 
						<input type="checkbox" name="lan" value="3">Java 
						<input type="checkbox" name="lan" value="4">C++
						<p></p> 
						<input type="checkbox" name="lan" value="5">C# 
						<input type="checkbox" name="lan" value="6">Visual Basic 
						<input type="checkbox" name="lan" value="7">JavaScript 
						<input type="checkbox" name="lan" value="8">PHP 
						<input type="checkbox" name="lan" value="9">R
						<p></p> 
						<input type="checkbox" name="lan" value="10">SQL 
						<input type="checkbox" name="lan" value="11">Groovy 
						<input type="checkbox" name="lan" value="12">Perl 
						<input type="checkbox" name="lan" value="13">Go 
						<input type="checkbox" name="lan" value="14">Swift
						<p></p> 
						<input type="checkbox" name="lan" value="15">Ruby
						<input type="checkbox" name="lan" value="15">
						<input type="text" size="5" value="기타">
						</td>
				</tr>
				<tr>
					<th class="name">프로젝트 경험</th>
					<td id="contents"><textarea rows="5px" name="experience" cols="50px">간단하게 프로젝트 경험에 대해 서술해주세요.</textarea>
				</tr>
				<tr>
					<th colspan="2" class="title">
						<input type="submit" class="button" value="가입하기"> 
						<input type="reset" class="button" value="다시작성"></th>
				</tr>


			</table>
		</form>
	</div>


</body>
</html>