<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
	<form action="login">
	<style>
	h1{color:red}
	td{color:blue}
	input{color:green}
	</style>
		<table border="1" align="center">
		<tr>
		<th colspan="2"><marquee><h1>Welcome to Login</h1></marquee></th>
		</tr>
			<tr>
				<td>USERNAME:</td>
				<td><input type="text" id="" name="uname" placeholder="USERNAME"></td>
			</tr>
			<tr>
				<td>PASSWORD:</td>
				<td><input type="password" name="password" placeholder="PASSWORD"></td>
			</tr>
			<tr>
				<th colspan="2"><input type="submit" value="Login"><a href="registration">New User</a></th>
			</tr>
		</table>


	</form>
</body>
</html>