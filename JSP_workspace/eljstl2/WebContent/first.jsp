<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>FIRST JSP</h2>
<%-- 	<%
	String loginId =
		(String)request.getAttribute("loginId");
	String loginName = 
		(String)request.getAttribute("loginName");
	%>
	로그인한 아이디 [<%= loginId %>] <br/>
	로그인한 이름 [<%= loginName %>] <br/> --%>
	
	<%-- <jsp:useBean id="loginId" class="java.lang.String" scope="request"/>
	<jsp:getProperty property="" name="loginId"/> --%>
	<!-- 자바빈 타입에 유용하다 따라서 제한적으로 사용 -->
	
	로그인한 ID ${ requestScope.loginId } <br/>
	로그인한 이름 ${ loginName } <br/>
	
	${ requestScope.loginInfo.id }
	${ loginInfo.id }
</body>
</html>