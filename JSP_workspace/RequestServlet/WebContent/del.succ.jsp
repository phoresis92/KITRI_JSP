<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

	function delok(){
		var a = <%= request.getAttribute("DELCNT") %>;
		alert(a +"건의 자료가 삭제되었습니다.");
		location.href = "index.do";
	}
</script>

</head>
<body onload="delok()">
	<h1>회원정보 삭제 성공!</h1>
		
	<%= request.getAttribute("DELCNT") %>건이 삭제 되었습니다.
	

	<form action="input.html">
		<input type="submit" value="회원가입 돌아가기">
	</form>
</body>
</html>