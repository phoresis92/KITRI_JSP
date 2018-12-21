<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멤버 가입</title>

<script type="text/javascript">

	function menu(type){
		
		var el = document.goto;
		if(type == "showAll"){
			el.mem_code.value = "show_all";
		}else if(type == "search"){
			el.mem_code.value = "search";
		}
		
		el.submit();
		
	}
	
</script>

</head>
<body>
	<form action="reg.do" method="post">
		<label>이름 : </label><input name="p_name" type="text" value="<%= session.getAttribute("ID") %>"><br>
		<label>이메일 : </label><input name="p_email" type="text" value="<%= session.getId() %>"><br>
		<input type="submit" value="가입하기">
	</form>
	
	<form action="mem.do" method="post" name="goto">
		<input type="button" onclick="menu('showAll')" value="전체 회원 보기">
		<input type="button" onclick="menu('search')" value="회원 검색">
		<input type="hidden" name="mem_code" value="">
	</form>
</body>
</html>