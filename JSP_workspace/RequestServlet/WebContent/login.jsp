<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 하기</title>
</head>
<body>
	<h1>로그인</h1>
	<form action="login.do" method="post">
		<label>이름 : </label><input name="p_name" type="text"><br> 
		<input name="log_code" type="hidden" value="login">
		<input type="submit" value="로그인">
		<a href="reg.do">회원가입</a>
	</form>
</body>
</html>