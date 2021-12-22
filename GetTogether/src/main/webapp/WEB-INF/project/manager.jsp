<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
	<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<meta charset="UTF-8">
		<title>프로젝트 관리</title>
		<link rel=stylesheet href="<c:url value='/css/common.css'/>" type="text/css">
		<%@ include file="/WEB-INF/components/nav.jsp" %>
		<link rel=stylesheet href="<c:url value='/css/teamrecommend.css' />" type="text/css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<style>
			.project-add-box {
			 width: 100px;
				border: dashed 2px #DCDCDC;
				text-align:center;
				vertical-align: middle;
				float: left;
				padding: 30px 15px;
				flex-basis: 300px;
				margin: 10px;
				display: table;

			}
			p {
				color: #DCDCDC;
				font-size: 60px;
				text-align:center;
				vertical-align: middle;
			}
		</style>
		
	</head>
	<body>
	<br>
		<div align="center">
		<h2>내 프로젝트 관리</h2>
		</div>	
		<div class="parent">
		<div align="center">
		</div>
		<div class="member-container">
		
		<div class="container" >
		<%int i = 0;%>
		   <c:forEach var="project" items="${projectList}" >
					<div id="id" class="team-box" style = "cursor:pointer;" onClick= "location.href = '<c:url value= '/project/detail?pid=${project.pid}'/>';">
						<h3>${project.title}</h3>
						<ul>
							<li>${project.subtitle}</li>
							<li>팀원 ${project.numOfMembers}/${project.applicationNum}명</li>
						</ul>
						<div class="nav-item-right"></div>
					</div>
				<%
					i++;%>
			</c:forEach>
			<div class="project-add-box" style = "cursor:pointer;" onClick= "location.href = '<c:url value= '/project/new/form'/>';">
				<p>+</p>
			</div>
		</div>
		<div align="center">
		</div>
		
			<!-- <!-- <div class="member-box project-box">
				<h3>프로젝트명 1</h3>
				<ul>
					<li>프로젝트의 주제</li>
					<li>팀원 n/m명</li>
					<li>대기 중인 팀원 n명</li>
				</ul>
				<div class="nav-item-right"></div>
			</div>
			<div class="member-box project-box">
				<h3>프로젝트명 2</h3>
				<ul>
					<li>프로젝트의 주제</li>
					<li>팀원 n/m명</li>
					<li>대기 중인 팀원 n명</li>
				</ul>
			</div>
			<div class="member-box project-box">
				<h3>프로젝트명 3</h3>
				<ul>
					<li>프로젝트의 주제</li>
					<li>팀원 n/m명</li>
					<li>대기 중인 팀원 n명</li>
				</ul>
			</div>
			<div class="project-add-box">
				<p>+</p>
			</div> -->
		</div>
		</div>
	</body>
</html>