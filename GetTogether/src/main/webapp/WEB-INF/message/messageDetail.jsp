<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쪽지</title>
<link rel=stylesheet href="<c:url value='/css/message.css?adsd' />" type="text/css">

</head>
<script>
const goMessageList = () => {
	location.href="/GetTogether/message/list/received";
}

const deleteMessage = () => {
	 if (confirm("정말 삭제하시겠습니까?") == true){
		 location.href="/GetTogether/message/delete?id=${message.id}";
	 }
}

const goMessageForm = () => {
	location.href="/GetTogether/message/create/form?memid=${message.sender.mid}";
}

</script>

<body>
	<div class="message-table-box message-detail-box">
			<div>
				<h2>메세지 상세정보</h2>
			</div>
	<div class="message-table">
		<table>
			<tr>
				<th>제목</th>
				<td>${message.title}</td>
			</tr>
			<tr>
				<th>보낸 사람</th>
				<td>${message.sender.mname}</td>
			</tr>
			<tr>
				<th>받은 사람</th>
				<td>${message.receiver.mname}</td>
			</tr>
			<tr>
				<th>보낸 시각</th>
				<td><fmt:formatDate value="${message.sendDate}" pattern="yyyy-MM-dd hh:mm" /></td>
			</tr>		
			<tr>
				<td class="message-content" colspan="2">
				<div class="message-content">${message.content}</div></td>
			</tr>
		</table>
			<div id="message-type" class="message-type">
			<button type="button" style="cursor:pointer" onclick="goMessageList();">목록</button>
			<button type="button" style="cursor:pointer" onclick="deleteMessage();">삭제</button>
			<button type="button" style="cursor:pointer" onclick="goMessageForm();">답장</button>
		</div>
	</div>
	</div>
</body>
</html>