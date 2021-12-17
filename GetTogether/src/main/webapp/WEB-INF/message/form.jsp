<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<html>
<head>
<meta charset="UTF-8">
<title>쪽지 쓰기</title>
<link rel=stylesheet href="<c:url value='/css/message.css?adsd' />" type="text/css">

</head>
<script>
const sendMessage = () => {
	if (form.title.value == "") {
		alert("제목을 입력하십시오.");
		form.title.focus();
		return false;
	}
	if (form.receiver.value == "") {
		alert("받는 사람을 입력하십시오.");
		document.form.receiver.focus();
		return false;
	}
	if (form.msgcontent.value == "") {
		alert("내용을 입력하십시오.");
		form.msgcontent.focus();
		return false;
	}
	form.submit();
}

const goMessageList = () => {
	location.href="/GetTogether/message/list/received";
}
</script>

<body>
	<div class="message-table-box message-detail-box">
			<div>
				<h2>쪽지 쓰기</h2>
			</div>
	<div class="message-table"> 
		<form name="form" method="POST" action="<c:url value='/message/create' />">
		<table>
			<tr>
				<th>제목</th>
				<td><input id="title" name="title" maxlength="200"/></td>
			</tr>
			<tr>
				<th>받는 사람(id입력)</th>
				<td><input id="receiver" name="receiver" maxlength="20"/>
				</td>
			</tr>		
			<tr>
				<th>내용</th>
				<td class="message-content">
					<textarea class="message-content" id="msgcontent" name="msgcontent"></textarea>
				</td>
			</tr>
		</table>
			<div id="message-type" class="message-type">
			<button type="button" onclick="sendMessage();">보내기</button>
			<button type="button" onclick="goMessageList();">목록으로</button>
		</div>
		</form>
	</div>
	</div>
</body>
</html>