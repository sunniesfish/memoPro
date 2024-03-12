<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
		<link rel="stylesheet" href="../../resources/css/style.css">		
		<title>Log In</title>
	</head>
	<body id="login">
		<header class="login-header">
			<h1 class="login-header__title">Log In</h1>
		</header>
		<form id="login-form" action="login.do" method="post" >
			<input name="userid" type="text" placeholder="Name"/>
			<input name="userpwd" type="password" placeholder="Password"/>
			<input name="" type="submit" value="Log In"/>
			<a href="joinForm.jsp">Create an Account</a>
		</form>
		<% %>
	</body>
</html>