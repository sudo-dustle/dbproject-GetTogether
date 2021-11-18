<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>프로젝트 등록</title>
<link rel=stylesheet href="<c:url value='/css/common.css'/>" type="text/css">
<%@ include file="../components/nav.jsp" %>
</head>
<body>

<div>
		<table style="margin-top: 2%;">
			<tr><th>프로젝트 등록</th><th></th></tr>
			<tr>
				<td id="element">프로젝트 제목</td>
				<td id="content"><input type="text" name ="title"></td>
			</tr>
			<tr>
				<td id="element">부제목</td>
				<td id="content"><input type="text" name = "subtitle"></td>
			</tr>
			<tr>
				<td id="element">수행기간</td>
				<td id="content">
				<input type="date"> ~ <input type="date" name = >
				</td>
			</tr>
			<tr>
				<td id="element">모집기간</td>
				<td id="content">
				<input type="date"> ~ <input type="date">
				</td>
			</tr>
			<tr>
				<td id="element">모집인원</td>
				<td id="content"><input type="text" style="width: 30px;"> 명
				<select name="count">
						<option value="one">1</option>
						<option value="two">2</option>
						<option value="three">3</option>
						<option value="four">4</option>
				</select></td>
			</tr>
			<tr>
				<td id="element">기술 분야</td>
				<td id="content"><select name="job">
						<option value="">분야 선택</option>
						<option value="iot">IoT</option>
						<option value="mobile">모바일</option>
						<option value="desktop">데스크톱 SW</option>
						<option value="ai">인공지능</option>
						<option value="">보안</option>
						<option value="기타">가상현실</option>
						<option value="기타">빅데이터</option>
						<option value="기타">자동제어기술</option>
						<option value="기타">블록체인</option>
						<option value="기타">영상처리</option>
				</select></td>
			</tr>
			<tr>
				<td id="element">목표</td>
				<td id="content"><input type="text"></td>
			</tr>
			<tr>
				<td id="element" style="height: 100px;">프로젝트 개요</td>
				<td><textarea rows="10" style="width: 99%;"></textarea></td>
			</tr>
			<tr>
				<td id="element" style="height: 70px;">필요 기술</td>
				<td id="content">
					<input type="checkbox" value="css"> C
					<input type="checkbox" value="css"> C++
					<input type="checkbox" value="css"> C#
					<input type="checkbox" value="css"> Java
					<input type="checkbox" value="css"> JavaScript
					<input type="checkbox" value="css"> Python
					<input type="checkbox" value="css"> Visual Basic
					<input type="checkbox" value="css"> PHP
					<!-- <br /> -->
					<input type="checkbox" value="css"> SQL
					<input type="checkbox" value="css"> CSS
					<input type="checkbox" value="css"> HTML
					<input type="checkbox" value="css"> R
				</td>
			</tr>
			<tr>
				<td id="btn" style="background-color: #F6F8ED;"></td>
				<td  id="content" style="text-align: right; border: 0;background-color: #F6F8ED;">
					<button>등록</button>
					<button>취소</button></td>
			</tr>
		</table>
	</div>
</body>
</html>