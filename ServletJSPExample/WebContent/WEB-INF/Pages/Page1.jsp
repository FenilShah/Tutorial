<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="././JS/jquery-1.11.0.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	//alert("page1");
	<%
	ResultSet rs = (ResultSet) request.getAttribute("resultSet");
	if(rs != null){
	while(rs.next()){
	%>
	
		alert("<%= rs.getLong(1) %>");
		$('#UserId').val("<%= rs.getLong(1) %>");
		$('#DisplayName').val("<%= rs.getString(2) %>");
		$('#EmailId').val("<%= rs.getString(3) %>");
		$('#Password').val("<%= rs.getString(4) %>");
		
	<%
	}}
	%>	
});
</script>
</head>
<body>
<h1>Page 1</h1>
<div align="right">
<a href="Login.htm?action=LogOut">Log out</a>
</div>
<form name="userForm" action="UserController.htm?action=SaveUser" method="post">
<table>
<tr>
<td>Display Name:</td>
<td>
<input type="hidden" name="UserId" id="UserId">
<input type="text" name="DisplayName" id="DisplayName"/></td>
</tr>
<tr>
<td>Email Id:</td>
<td><input type="text" name="EmailId" id="EmailId"/></td>
</tr>
<tr>
<td>Password:</td>
<td><input type="password" name="Password" id="Password"/></td>
</tr>
<tr>
<td colspan="2" align="center">
<input type="submit"/>
</td>
</tr>
</table>
</form>
</body>
</html>