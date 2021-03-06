<%@ page import="kr.co.young.model.MemberBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script type="text/javascript">

function memdo(type){
	
		var el = document.member;
	if(type == "del"){
		//삭제 서블릿 실행 mem_code > delete
		
		el.mem_code.value = "delete";
		
		
	}else if(type == "mod"){
		//수정 서블릿 실행 mem_code > modify
		
		el.mem_code.value = "modify";
		//el.method = "get";
		//el.action = "/other.do";
		
	}else if(type == "logout"){
		
		el.log_code.value = "logout";
		el.action = "login.do";
	}
	
	el.submit();
	
}

</script>

<title>회원 정보 보기</title>
</head>
<body>
	<%-- 입력한 이름 : <%= request.getParameter("mb_name") %>
	입력한 이메일 : <%= request.getParameter("mb_email") %> --%>
	<!-- <h1>회원가입 완료 되었습니다</h1> -->
<%-- 	<% 
		MemberBean mb = (MemberBean)request.getAttribute("MEMBER");
	%> --%>
	<%-- <!-- 스크립트릿을 통한 출력 방법 -->
	입력한 이름 : <%= mb.getName() %> <br>
	입력한 이메일 : <%= mb.getEmail() %> <br>
	
	<!-- EL을 통한 출력방법 -->
	입력한 이름 : ${ MEMBER.name } <br>
	입력한 이메일 : ${ MEMBER.email } <br> --%>
	---------------------------------------------------- <br>
	
	
	<%-- <c:set var="al" value="${ requestScope.MEMBER }"/> --%>
	
	
	${ MEMBER[0].name } 님 환영합니다 <br>
	<c:if test="${MEMBER[0].name  == 'Peter'}">
		Peter(관리자) 님 로그인 성공 <br>
	</c:if>
	<c:set var="mem" value="${MEMBER[0] }"/>
	<c:choose>
		<c:when test="${mem.name == 'Sundar' }">살인마 <br></c:when>
		<c:when test="${mem.name == 'Mozhe' }">선지자 <br></c:when>
		<c:when test="${mem.name == 'David' }">축구선수 <br></c:when>
		<c:when test="${mem.name == 'Hermann' }">작가 <br></c:when>
		<c:when test="${mem.name == 'Shelli' }">영화감독 <br></c:when>
		<c:otherwise>백수 <br></c:otherwise>
	</c:choose>
	
		
	<c:forEach items="${ MEMBER }" var="mem">
		회원 이름 : ${ mem.name }<br>
		회원 이메일 : ${ mem.email }<br>
	</c:forEach>

	<form action="mem.do" method="post" name="member">
		<input name="h_name" type="hidden" value="${ requestScope.MEMBER[0].name }">
		<input name="h_email" type="hidden" value="${ requestScope.MEMBER[0].email }">
		<input name="mem_code" type="hidden" value="">
		<input name="log_code" type="hidden" value="">
		<input type="button" value="수정하기" onclick="memdo('mod');">	
		<input type="button" value="삭제하기" onclick="memdo('del');">	
		<input type="button" value="로그아웃" onclick="memdo('logout')">
	</form>
	
	
</body>
</html>