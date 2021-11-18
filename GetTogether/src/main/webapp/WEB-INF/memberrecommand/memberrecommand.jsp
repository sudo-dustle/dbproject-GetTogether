<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
<meta charset="UTF-8">
<head>
<title>memberRecommand</title>
<style>
			.member-container {
				display: flex;
				flex-wrap: wrap;
			}
			.page-layout {
				margin: 10px 30px;
			}
			.input-search {
				border: none;
				font-size: 20px;
				border-radius: 3px;
				width: 80%;
				border: solid 1px #DCDCDC;
			}
			.search-box{
				margin: 10px 0;
				width: 100%;
			}
			.member-option-list{
				margin: 10px 0 auto auto;
			}

			.member-box li{
				margin-top: 2px;
			}

		</style>
		<link rel="stylesheet" href="general.css">
	</head>
	<body>
		<div class="header">
			<h1>모여봐요</h1>
		</div>
		<p></p>
		<div class="log">로그인 | 회원가입</div>
		<div class="banner">
			프로젝트 목록 &nbsp;&nbsp;&nbsp;&nbsp; | &nbsp;&nbsp;&nbsp;&nbsp; 프로젝트 관리 &nbsp;&nbsp;&nbsp;&nbsp; | &nbsp;&nbsp;&nbsp;&nbsp; 팀원 추천
		</div>

		<div class="header">
			<h1>프로젝트 구성 시스템</h1>
		</div>
		<nav>
			<ul>
				<li class="nav-item">
					<a href="#">프로젝트 목록</a>
				</li>
				<li class="nav-item">
					<a href="#">프로젝트 관리</a>
				</li>
				<li class="nav-item">
					<a href="#">팀원 추천</a>
				</li>
				<li class="nav-item-right">
					<a href="#">로그인</a>
				</li>
				<li class="nav-item-right">
					<a href="#">회원가입</a>
				</li>
			</ul>
		</nav>
			<div class="page-layout">
			<div class="subtitle">
				<h2>팀원 추천</h2>
				<div class="search-box">
					<input class="input-search" type="text" placeholder="검색하기">
					<button class="option-button">search</button>
				</div>
			</div>
			<div class="member-container">
			<c:forEach var="recommandMember" items="${recommandMemberList}">
					<div class="member-box">
						<ul>
							<li>김*가</li>
							<div class="member-option-list">
								<button class="option-button">${recommandMember.name}</button>
								<button class="option-button">${recommandMember.language}</button>
								<button class="option-button">${recommandMember.language}</button>
							</div>
						</ul>
					</div>
					<div class="member-box">
						<ul>
							<li>이*나</li>
							<div class="member-option-list">
								<button class="option-button">C</button>
								<button class="option-button">C++</button>
							</div>
						</ul>
					</div>
					<div class="member-box">
						<ul>
							<li>박*다</li>
							<div class="member-option-list"></div>
								<button class="option-button">웹개발</button>
								<button class="option-button">Java</button>
								<button class="option-button">Javascript</button>
						</div>
					</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</body>
</html>
