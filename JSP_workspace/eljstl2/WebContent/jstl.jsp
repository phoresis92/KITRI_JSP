<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="a" value="hello"/>
	<c:set var="b" value="${param.test}"/>
	<c:set var="c" value="${param.a+param.b}"/>
	<c:set var="d" value="${ c+10 }"/>
	<c:set var="d" value="${ d+55 }"/>
	
	${ a } , ${ b } , ${ c } , ${ d }
	<hr><br>
	<c:if test="${ d>10 }">
		d는 10보다 크다
	</c:if>
	<hr><br>
	<c:choose>
		<c:when test="${ d%2 == 0 }">d는 짝수입니다</c:when>
		<c:when test="${ d%5 == 0 }">d는 5의 배수입니다</c:when>
		<c:otherwise>d는 짝수가 아니고, 5의 배수도 아닙니다</c:otherwise>
	</c:choose>
	
	<hr><br>
	<!-- null이거나 ""인 경우 -->
	<c:if test="${empty param.c}">
		요청전달데이터 c를 입력하세요!
	</c:if>
	<hr><br>
	
	<c:forEach begin="1" end="100" step="3" var="i" varStatus="status">
		${status.index} : ${status.count} : ${ i } <br>
	</c:forEach>
	
	
	<hr><br>
	<c:set var="sum" value="0"/>
	<c:forEach begin="1" end="10" step="1" var="i">
		<c:set var="sum" value="${sum+i}"/>
	</c:forEach>
		1~10합 : ${ sum }
		
	<hr><br>
	<%
	//서블릿에서 설정될 내용
	List<String> list = new ArrayList<>();
	list.add("one");
	list.add("two");
	list.add("three");
	request.setAttribute("list", list);
	%>
	<ul>
	<c:forEach items="${requestScope.list }" var="item" varStatus="status">
		<li>${status.index} : ${ item }</li>
	</c:forEach>
	</ul>
</body>
</html>