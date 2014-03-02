<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.sql.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Page 2</h1>

<table>
	<tr>
	<th>UserId</th>
	<th>Display Name</th>
	<th>Email</th>
	<th>Password</th>
	</tr>


<%
ResultSet rs = (ResultSet) request.getAttribute("resultSet");
while(rs.next()){
%>

	<tr>
	<td><a href="UserController.htm?action=userAddEdit&userId=<%= rs.getLong(1) %>"><%= rs.getLong(1) %></a></td>
	<td><%= rs.getString(2) %></td>
	<td><%= rs.getString(3) %></td>
	<td><%= rs.getString(4) %></td>
	</tr>
	
<%
}
%>	
</table>
</body>
</html>