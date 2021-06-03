<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%
	ArrayList<List> list = (ArrayList<List>)request.getAttribute("list");
	request.setAttribute("list", list);  
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main</title>
	<style>
	body {
		margin: 2% 5%;
		padding: 3%;
		border: solid 3px green;
	}
	header  {
		1padding: 3%;
		text-align: center;
	}
	section {
		padding: 30px;
	}
	footer {
		padding: 30px;
	}
	table {
		border: solid 1px blue;
	}
	th {
		width: 25%;
		1height: 20%;
		height: 90px;
		border: solid 1px red;
	}
	td {
		width: 25%;
		1height: 5%;
		height: 80px;
		border: solid 1px yellow;
	}
	</style>

</head>
<body>
<header>
	<button style="float: right;" class="hover" type="button" onClick="location.href='todoForm'">새로운 todo 등록</button>
	<br>
</header>
<section>
<form action="/todo/todoType" method="get">
<table>
	<thead>
		<tr>
			<th>TODO</th>
			<th>DOING</th>
			<th>DONE</th>
		</tr>
	</thead>
	</tbody>
		<c:forEach items="${list }" var = "item">
		<tr>
			<td>
				<input type="hidden" name="id" value="${item.id }" >
				<input type="hidden" name="type" value="${item.type }" >
			<!--  -<c:set value="${item.id }" var="id" scope="request" />
				<c:set value ="${item.type }" var="type" scope="request" />-->	
				<h3>${item.title}</h3><br>
				등록날짜 : ${item.regdate}, 
				${item.name}, 
				우선순위 : ${item.sequence}, 
				<input type="submit" value="->">
				<br>
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>	
</form>	
</section>
	
<%-- JSTL 
	<c:forEach items="${list }" var = "item">
		${item } 
		<br>
	</c:forEach>
--%>

<%-- EL  
	${list[0]}
--%>
 
<%-- JAVA
	<%
		ArrayList<List> list = (ArrayList<List>)request.getAttribute("list");
		
		if(list != null) {
			for(int i=0; i<list.size(); i++) {
				
				out.println(list.get(i));
	%>
		<br>		
	<%
			}
		}
	%>
 --%>

</body>
</html>