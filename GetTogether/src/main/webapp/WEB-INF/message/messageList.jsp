<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
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
	
	const receivedList = () => {
		location.href="/GetTogether/message/list/received";
	}
	const sentList = () => {
		location.href="/GetTogether/message/list/sent";
	}
	
	
	const createMessage = () => {
		location.href="/GetTogether/message/create/form";
	}
	
	const deleteMessage = () => {
		//checkbox가 배열 형태로 넘어간다. (value는 msg.id)
		if ($('input:checkbox[name="select"]:checked').length <= 0){
			alert("선택된 메세지가 없습니다.");
			return ;
		}
		form.submit();
	}
</script>
</head>
<body>
	<div class="message-table-box">
			<div>
				<h2>쪽지함</h2>
			</div>
			<div class="message-type">
				<button type="button" onclick="receivedList();">받은 쪽지</button>
				<button type="button" onclick="sentList();">보낸 쪽지</button>
			</div>
			
			<form name="form" method="POST" action="<c:url value='/message/delete' />">
				<div>
				<table>
				<thead>
					<tr>
						<th class="checkbox">
							<input type="checkbox" onclick="selectAll(this)">
						</th>
						<th width="90px">보낸 사람</th>
						<th width="90px">받은 사람</th>
						<th>제목</th>
						<th width="150px">보낸 날짜</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="msg" items="${messageList}">
					<tr>
						<td class="checkbox">
							<input type="checkbox" name="select" value='${msg.id}'>
						</td>
						<td>${msg.sender.mname}</td>
						<td>${msg.receiver.mname}</td>
						<td>
							<a class="message-title" href="<c:url value='/message/detail'>
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
						<button type="button" onclick="createMessage();">쪽지 쓰기</button>
						<button type="button" onclick="deleteMessage();">쪽지 삭제</button>
					</div>
					</div>
				</form>
		</div>
		
</body>

</html>