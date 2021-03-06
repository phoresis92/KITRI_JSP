<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.young.dto.MDto" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 완료!!!</title>

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

	<c:set var="mem" value="${ MEMBER }"/>

	<h1>회원가입 완료 되었습니다.</h1>
	
	<label>이름 : </label>${ mem.name }<br/>
	<label>생년월일 : </label>${ mem.birth }<br/>
	<label>성별 : </label>${ mem.gender }<br/>
	<label>전화번호 : </label>${ mem.phone }<br/>

	<form action="" name="member" method="post">
		<input type="button" value="수정하기" onclick="memdo('mod')">
		<input type="button" value="삭제하기" onclick="memdo('del')">
		<input type="hidden" value="${ mem.phone }" name="PHONE">
	</form>
	<input type="button" value="돌아가기" onclick="rtbase()">
	
	
	
</body>
</html>