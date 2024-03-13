<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="../../resources/css/style.css">
	<title>Join</title>
	</head>
	<body>
		<header class="join-header">
			<h1 class="join-header__title">Join</h1>
		</header>
		<form id="join-form" action="join.do" method="post" >
			<input name="userid" type="text" placeholder="Name"/>
			<input name="userpwd" type="password" placeholder="Password"/>
			<input type="submit" value="Submit"/>
		</form>
		<div id="join_link">
			<a href="loginPage.jsp">Go Back</a>
		</div>
		<div id="join_validation">
			<c:if test="${errors != null}">
				<span>please write  your name and password</span>
			</c:if>
		</div>
	</body>
</html>