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
</head>
<body>

	<button class="hover" type="button" onClick="location.href='todoForm'">새로운 todo 등록</button>
	<br>
	<table>
		<thead>
		<tr>
			<th>TODO</th>
			<th>DOING</th>
			<th>DONE</th>
		</tr>
		</thead>
		</tbody>
		<tr>
			<td>
			</td>
		</tr>
		</tbody>
	</table>		


<button class="hover" type="button" onClick="location.href='todoTypeServlet.java'"> -> </button>


<%-- JSTL --%>
<c:forEach items="${list }" var = "item">
	${item } <br>
</c:forEach>


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