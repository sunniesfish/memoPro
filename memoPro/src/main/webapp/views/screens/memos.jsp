<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>
<%@ page import="vo.Memo" %>
<%@ page import="vo.Line" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>memos</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
		<link rel="stylesheet" href="../../resources/css/style.css"/>
	</head>
	<body class="memos_body">
		<header class="memos_header">
			<div class="memos_logout">
				<a href="logout.do"><i class="fa-regular fa-circle-xmark"></i></a>
			</div>
			<div class="memos_memo-title">
				<h1>
					Memos
				</h1>
			</div>
		</header>
		<!-- 새 메모의 memoid는 어떻게 생성? -->
		<div class="memos_contents">
			<a href="tosession.do?memoid=" >
				<div class="memos_contetns_newmemo">New Memo</div>
			</a>
			<c:forEach var="memoid" items="${memolist}">
				<c:if test="${memoid ne '1'}">
					<a href="tosession.do?memoid=${memoid}"  >
						<div class="memos_contetns_line">${memoid}</div>
					</a>
				</c:if>
			</c:forEach>
		</div>
		<script src="https://kit.fontawesome.com/9e2cfcdf3a.js" crossorigin="anonymous"></script>
	</body>
</html>