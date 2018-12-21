<%@ page import="com.young.dto.MDto" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 수정 완료</title>
<script type="text/javascript">

	function rtbase(){
		location.href="SignUP.do"
	}
	
	function memdo(type){
		
		var el = document.member;
		if(type == 'mod'){
			el.action = "Modify.do";
						
		}else if(type == 'del'){
			el.action = "Delete.do";
			alert(el.action);
		}
		
		el.submit();
		
	}
	
</script>
</head>
<body>

	<%
	
	MDto dto = (MDto)request.getAttribute("MEMBER");
	
	%>


	<h1>회원 수정완료</h1>
	
	<label>이름 : </label><%= dto.getName() %><br/>
	<label>생년월일 : </label><%= dto.getBirth() %><br/>
	<label>성별 : </label><%= dto.getGender() %><br/>
	<label>전화번호 : </label><%= dto.getPhone() %><br/>

	<form action="" name="member" method="post">
		<input type="button" value="수정하기" onclick="memdo('mod')">
		<input type="button" value="삭제하기" onclick="memdo('del')">
		<input type="hidden" value="<%= dto.getPhone() %>" name="PHONE">
	</form>
	<input type="button" value="돌아가기" onclick="rtbase()">
	
</body>
</html>