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
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
$(document).ready(function() {
    var checkedValues = ${memberInfo.field};
    
    console.log("log test");
    
    $('input:checkbox[name="checkbox"]').each( function() {
        if ( checkedValues.indexOf( $(this).attr("value") )  != -1) {
            $(this).attr("checked", "checked");
            console.log("test check");
        }
    });
    
    $("#email_select").change(function(){
    	console.log("test: "+$(this).val());
    	$("#email_select").val($(this).val());
    });
    
});
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
					<input name="email2" type="text" class="box" id="email2" size="10s" value="${fn:split(memberInfo.email, '@')[1]}" required>
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
						<p style="color: #9DB589;"> 기존 정보: ${memberInfo.field } </p>
						<input type="checkbox" name="field" value="ALL" onClick = "selectAll1(this)">ALL 
						<input type="checkbox" name="field" value="IoT">IoT 
						<input type="checkbox" name="field" value="모바일">모바일
						<input type="checkbox" name="field" value="데스크톱 SW">데스크톱 SW 
						<p></p> 
						<input type="checkbox" name="field" value="인공지능">인공지능 
						<input type="checkbox" name="field" value="보안">보안
						<input type="checkbox" name="field" value="가상현실">가상현실 
						<input type="checkbox" name="field" value="빅데이터">빅데이터
						<p></p> 
						<input type="checkbox" name="field" value="자동제어기술">자동제어기술
						<input type="checkbox" name="field" value="블록체인">블록체인
						<input type="checkbox" name="field" value="형상처리">형상처리
						<input type="checkbox" name="field" value="웹">웹 
						<input type="checkbox" name="field" value="기타">기타
				</tr>
				<tr>
					<th class="name">사용가능한 언어</th>
					<td id="contents">
					<p style="color: #9DB589;"> 기존 정보: ${memberInfo.language } </p>
					<input type="checkbox" name="lan" value="0" onClick = "selectAll2(this)">ALL 
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