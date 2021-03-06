<%@ page import="dto.Product"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">

	table tr:nth-child(2n){
	background-color: #e6e6e6
	}
	table tr:hover{font-weight: bold;}

</style>

</head>
<body>

	<%-- 	<%
		ArrayList<Product> list = (ArrayList<Product>) request.getAttribute("PROD");
		Product p1 = list.get(0);
		Product p2 = list.get(1);
		Product p3 = list.get(2);
	%>

	<table style="border: 1px solid gray;">
		<tr>
			<th>번호</th>
			<th>도서명</th>
			<th>카테고리</th>
			<th>가격</th>
		</tr>
		<%
			for (Product p : list) {
		%>
		<tr>
			<td><%=p.getProd_no()%></td>
			<td><%=p.getProd_name()%></td>
			<td><%=p.getProd_cate()%></td>
			<td><%=p.getProd_price()%></td>
		</tr>
		<%
			}
		%>

	</table> --%>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript">
		/* $(document).ready(function(){}); */
		/* $(function(){}); */
		function init(){
			$("div>form>button").click(function(){
				console.log("clicked!");
				console.log($("div>form>select").val());
				console.log($("div>form>input[type=search]").val());
				var url ="product.do";
				$("div>form").attr("action",url);
				$("div>form").attr("method","post");
				$("div>form").submit();
				return false;
			});
			/* $("div>form").submit(function(){
				console.log("submited!");
				return false;
			}) */
		}
		$(init);
	</script>
	
	<div>
		<form>
		<c:set var="item" value="${param.selectItem }"/>
		<c:if test="${empty item }">
			<c:set var="item" value="name"/>
		</c:if>
		<select name="selectItem">
			<option >검색조건</option>
			<option value="no" ${item == 'no'? "selected" : "" }>번호로 검색</option>
			<option value="name" ${item == "name"? "selected" : "" } >도서명으로 검색</option>
		</select>
		<input type="search" placeholder="값을 입력하세요" name="selectValue"/>
		<button>검색</button>
		</form>
	</div>
	<c:set var="list" value="${ requestScope.PROD }" />
	<table style="border: 1px solid gray;">
		<tr>
			<th>번호</th>
			<th>도서명</th>
			<th>카테고리</th>
			<th>가격</th>
		</tr>

		<c:forEach items="${ list }" var="prod" varStatus="status">
			<tr>
				<td>${prod.prod_no}</td>
				<td>${prod.prod_name}</td>
				<td>${prod.prod_cate.cate_name}</td>
				<td>&#65510;<fmt:formatNumber pattern="0,000" value="${prod.prod_price}"/><%-- ${prod.prod_price} --%></td>
			</tr>
		</c:forEach>

	</table>


</body>
</html>