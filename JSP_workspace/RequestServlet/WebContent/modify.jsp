<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정 페이지</title>
</head>
<body>
	<form action="mem.do" method="post">
		수정할 이름 : <input type="text" name="mod_name" value="${MEMBER.name}"> <br>
		수정할 이메일 : <input type="text" name="mod_email" value="${MEMBER.email}"> <br>
		<input type="hidden" name="mem_code" value="modify_ok">
		<input type="hidden" name="origin" value="${MEMBER.name }">
		<input type="submit" value="수정반영하기">
	</form>
</body>
</html>