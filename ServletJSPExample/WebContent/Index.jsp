<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
<script type="text/javascript" src="JS/jquery-1.11.0.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	//alert("Jquery Configured");
});
function callme(){
	//alert("Hello");
	window.location.href = "Login.htm";
}
</script>
</head>
<body>
<h1>Welcome</h1>
<form name="loginForm" method="post" action="Login.htm">
<table>
<tr><td>Please enter username:</td>
	<td><input type="text" name="userId"/></td>
</tr>
<tr><td>Please enter password:</td>
<td><input type="password" name="password"/></td>
</tr>
<tr><td colspan="2">
<input type="submit" value="Click to Login Page"/>
</td>
</tr>
</table>
</form>
</body>
</html>