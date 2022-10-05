<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>com.loginpage</title>
</head>
<body>
	<form action="login">
	<center>
	<style>
	h1{color : red}
	th{color : green}
	input{color : blue}
	</style>
		<table border="1">
			<tr>
				<th colspan="2"><marquee><h1>Welcome to Login</h1></marquee></th>
			</tr>
			<tr>
				<th>Username</th>
				<td><input type="text" name="un" placeholder="Username"></td>
			</tr>
			<tr>
				<th>Password</th>
				<td><input type="password" name="ps" placeholder="Password"></td>
			</tr>
			<tr>
			<center><th colspan="2"><input type="submit" value="login"><a href="registration">New User?Click Here</a></th></center>	
			</tr>			
		</table>
		</center>
	</form>
</body>
</html>