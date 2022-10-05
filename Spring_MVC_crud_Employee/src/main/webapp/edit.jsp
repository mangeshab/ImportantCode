<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>com.editpage</title>
<h1 align="center">EDIT DATA</h1>
</head>
<body>
	<form action="update">
	<style>
	h1{color : Red}
	th{color : blue}
	input{color : green}
	</style>
	<center>
	<table border="2">
		<tr>
			<th colspan="2"><marquee><h1>Welcome to Info update</h1></marquee></th>
		</tr>	
		<tr>
			<th>Eid</th>
			<td><input type="hidden" name="eid" value="${data.eid}"></td>	
		</tr>
		<tr>
			<th>Name</th>
			<td><input type="text" name="name" value="${data.name}"></td>
		</tr>
		<tr>
			<th>Username</th>
			<td><input type="text" name="username" value="${data.username}"></td>
		</tr>
		<tr>
			<th>Password</th>
			<td><input type="password" name="password" value="${data.password}"></td>
		</tr>
		<tr>
			<th>BirthDate</th>
			<td><input type="date" name="birthdate" value="${data.birthdate}"></td>
		</tr>
		<tr>
			<th>Address</th>
			<td><input type="textarea" name="address" value="${data.address}"></td>
		</tr>
		<tr>
			<th colspan="2"><input type="submit" value="Update"></th>
		</tr>	
		
		
	</table>
	</center>
	</form>
	
</body>
</html>