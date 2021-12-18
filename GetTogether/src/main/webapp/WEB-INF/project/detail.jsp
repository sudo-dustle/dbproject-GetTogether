<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로젝트 상세 페이지(팀장)</title>
<link rel=stylesheet href="<c:url value='/css/common.css'/>" type="text/css">
<link rel=stylesheet href="<c:url value='/css/project.css'/>" type="text/css">
<%@ include file="/WEB-INF/components/nav.jsp" %>
</head>
<script type="text/javascript">
function doUpdate(value){
	if(value==1)
	    location.href="/GetTogether/project/update?pid=${project.pid}";
	else if(value==0)
	{
		if (confirm("정말 삭제하시겠습니까?"))
			location.href="/GetTogether/project/delete?pid=${project.pid}"
	}
}
</script>
<body>
<form method="GET" > 
	<div>
		<table style="margin-top: 2%;">
			<tr>
				<th>프로젝트 상세</th>
				<th></th>
			</tr>
			<tr>
				<td id="element">프로젝트 제목</td>
				<td id="content">${project.title}</td>
			</tr>
			<tr>
				<td id="element">부제목</td>
				<td id="content">${project.subtitle}</td>
			</tr>
			<tr>
				<td id="element">수행기간</td>
				<td id="content"><fmt:formatDate value="${project.executionStart}" pattern="yyyy-MM-dd hh:mm" />~<fmt:formatDate value="${project.executionEnd}" pattern="yyyy-MM-dd hh:mm" />
				</td>
			</tr>
			<tr>
				<td id="element">모집기간</td>
				<td id="content"><fmt:formatDate value="${project.applicationStart}" pattern="yyyy-MM-dd hh:mm" />~<fmt:formatDate value="${project.applicationEnd}" pattern="yyyy-MM-dd hh:mm" />
				</td>
			</tr>
			<tr>
				<td id="element">모집인원</td>
				<td id="content">${project.numOfMembers}/${project.applicationNum}</td>
			</tr>
			<tr>
				<td id="element">기술 분야</td>
				<td id="content">${project.field}</td>
			</tr>
			<tr>
				<td id="element">목표</td>
				<td id="content">${project.goal}</td>
			</tr>
			<tr>
				<td id="element" style="height: 100px;">프로젝트 개요</td>
				<td>${project.description}</td>
			</tr>
			<tr>
				<td id="element" style="height: 70px;">필요 기술</td>
				<td id="content">${project.language}</td>
			</tr>
			<tr>
				<td id="content" style="text-align: right; border: 0; background-color: #F6F8ED;" colspan="2">
				<%--	<c:if test="${MemberSessionUtils.getLoginMembreId() != null }">
						<c:if test="${MemberSessionUtils.getLoginMemberId() == project.mnum}"> --%>
							<input class="submit" style = "cursor:pointer" type="button" value="수정" name="update" onClick="doUpdate(1);">
							<input class="submit" style = "cursor:pointer" type="button" value="삭제" onClick="doUpdate(0);">
						<%-- </c:if>
						</c:if> --%>
				</td>
			</tr>	

		</table>
		</form>
	</div>
		<table>
			<tr>
				<th>프로젝트 신청 현황</th>
				<th></th>
				<th></th>
				<th></th>
			</tr>
			<tr>
				<td class="application" width="130px">신청자명</td>
				<td class="application">내용</td>
				<td class="application" width="150px">신청일</td>
				<td class="application" width="50px">상태</td>
			</tr>
			<tr>
			<%
				if (request.getAttribute("commentList") == null){
			%>
				<td colspan="4"><p style="text-align: center;border: 0;color:#adadad;">지금은 비어있습니다.</p></td>
			<%
				} else {
			%>
				<c:forEach var="comment" items="${commentList}"></c:forEach>
					<td>${comment.applicant.mname}</td>
			<%
				}
			%>
			</tr>
		</table>
		<br>
	<form method="POST" action="<c:url value='/applicationComment/create' />">
		<table>
			<tr>
				<th text-align="left" padding-left="20px">프로젝트 신청 댓글 작성 </th>
				<th></th>
			</tr>
			<tr>
				<td id="element">내용</td>
				<td><textarea name="content" rows="4" style="width: 99%;" maxlength="200"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" id="btn" style="text-align: right; border: 0; background-color: #F6F8ED;">
					<input class="submit" type="submit" style = "cursor:pointer" type="button" value="신청" name="update">
				</td>
			</tr>
		</table>
					<input type="hidden" name="pid" value="${project.pid}" />
		</form>
	</div>
	
</body>
</html>