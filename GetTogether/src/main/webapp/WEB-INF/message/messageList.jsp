<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
<meta charset="UTF-8">
<title>쪽지함</title>
<link rel=stylesheet href="<c:url value='/css/message.css' />" type="text/css">
<script>
	const checkboxes = document.getElementsByName('select');
	
	const selectAll = (allCheck) => {
		checkboxes.forEach((checkbox) => {
			checkbox.checked = allCheck.checked;
		});
	}
</script>
</head>
<body>
	<div class="message-table-box">
			<div>
				<h2>쪽지함</h2>
			</div>
			<div id="message-type" class="message-type">
				<button type="button">받은 쪽지</button>
				<button type="button">보낸 쪽지</button>
			</div>
			<div id="message-table">
				<table>
				<thead>
					<tr>
						<th>
							<input type="checkbox" onclick="selectAll(this)">
						</th>
						<th width="80px">보낸 사람</th>
						<th width="80px">받은 사람</th>
						<th>제목</th>
						<th width="150px">보낸 날짜</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="msg" items="${messageList}">
					<tr>
						<td>
							<input type="checkbox" name="select" value='${msg.id}'>
						</td>
						<td>${msg.sender.name}</td>
						<td>${msg.receiver.name}</td>
						<td>
							<a class="message-title" href="<c:url value='/detail/'>
							<c:param name='id' value='${msg.id}'/>
							</c:url>
							">${msg.title}</a>
						</td>
						<td>
							<fmt:formatDate value="${msg.sendDate}" pattern="yyyy-MM-dd hh:mm" />
						</td>
					</tr>
					</c:forEach>
				</tbody>
				</table>
				<div id="message-type" class="message-type">
					<button type="button">쪽지 쓰기</button>
					<button type="button">쪽지 삭제</button>
				</div>
			</div>
		</div>
		
</body>

</html>