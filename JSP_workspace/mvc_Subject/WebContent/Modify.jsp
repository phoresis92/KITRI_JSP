<%@ page import="com.young.dto.MDto" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
</head>
<body>

	<%
	MDto dto = (MDto)request.getAttribute("MDTO");
	%>

	<form action="ModOK.do" method="post">
		<label for="name">이름 : </label><input type="text" name="name" value=" <%= dto.getName() %> "> <br/>
		<label for="birth">생년월일 : </label><input type="date" name="birth" value="<%= dto.getBirth() %>"> <br/>
		<label for="gender">성별 : </label>남<input type="radio" name="gender" value="M" checked="checked">여<input type="radio" name="gender" value="F"> <br/>
		<label for="phone">전화번호 : </label>
		<select name="front_num">
			<option value="010" selected="selected">010</option>
			<option value="011">011</option>
			<option value="016">016</option>
		</select>
		-<input type="text" name="mid_num" maxlength="4" value="<%= dto.getMid_num() %>">-<input type="text" name="last_num" maxlength="4" value="<%= dto.getLast_num() %>"> <br/>
		<input type="hidden" name="origin_num" value="<%= dto.getPhone() %>">
		<input type="submit" value="수정완료">
	</form>
</body>
</html>