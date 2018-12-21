
<%@ page import="kr.co.young.model.MemberBean" %>
<%@ page import="java.util.ArrayList" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	ArrayList<MemberBean> list = (ArrayList<MemberBean>)request.getAttribute("MEMBERS");
	%>	
	
	<form action="mem.do" method="post">
	
	<%
	for(int i = 0 ; i < list.size() ; i++){
	%>
		입력한 이름 : <%= list.get(i).getName() %> <br>
		입력한 이메일 : <%= list.get(i).getEmail() %> <br>
	<%
/* 		out.println(list.get(i));
		out.println("<br>"); */
	}
	
	%>

		<input name="h_name" type="hidden" value="<%= list.get(0).getName() %>">
		<input name="h_email" type="hidden" value="<%= list.get(0).getEmail() %>">
		<input name="mem_code" type="hidden" value="modify">
		<input type="submit" value="수정하기">	
	</form>
	
</body>
</html>