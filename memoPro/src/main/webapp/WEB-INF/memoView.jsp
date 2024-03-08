<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1-Day Memo</title>
</head>
<body>
	<h1>Memo</h1>
	<form action="write.do">
		<div>
			<textarea name="content" rows="2" cols="30">
				${modReq.content}
			</textarea>
		</div>
		<div><input type="submit" value="save"></div>
	</form>
</body>
</html>