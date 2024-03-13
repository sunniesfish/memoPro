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
			<div class="memos_goList-button">
				<a><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512"><path d="M0 96C0 78.3 14.3 64 32 64H416c17.7 0 32 14.3 32 32s-14.3 32-32 32H32C14.3 128 0 113.7 0 96zM0 256c0-17.7 14.3-32 32-32H416c17.7 0 32 14.3 32 32s-14.3 32-32 32H32c-17.7 0-32-14.3-32-32zM448 416c0 17.7-14.3 32-32 32H32c-17.7 0-32-14.3-32-32s14.3-32 32-32H416c17.7 0 32 14.3 32 32z"/></svg></a>
			</div>
			<div class="memos_memo-title">
				<h1>
					<c:choose>
						<c:when test="${memoid eq 'todaysmemo'}">
							Today's Memo
						</c:when>
						<c:otherwise>
							Memo
						</c:otherwise>
					</c:choose>
				</h1>
			</div>
		</header>
		<div class="memos_contents">
			<c:forEach var="entry" items="${contentsmap}">
				<div class="memos_contents_line">
					<form action="write.do" method="post" name="" >
						<input class="memos_contents_text" name="" type="text" value="${entry.value}"/>
						<input class="memos_contents_save-button" type="submit" value="SAVE">
					</form>
				</div>
			</c:forEach>
		</div>
		<script src="https://kit.fontawesome.com/9e2cfcdf3a.js" crossorigin="anonymous"></script>
	</body>
</html>