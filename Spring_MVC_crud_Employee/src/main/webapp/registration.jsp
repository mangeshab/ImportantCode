<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>com.registrationpage</title>
</head>
<body>
	<form action="reg">
	<center>
	<style>
	h1{color : Red}
	th{color : blue}
	input{color : green}
	</style>
	<table border="2" >
		<tr>
			<th colspan="2" ><marquee><h1>Welcome to Registration</h1></marquee></th>
		</tr>	
		<tr>
			<th>Eid</th>
			<td><input type="number" name="eid" placeholder="Eid" ></td>	
		</tr>
		<tr>
			<th>Name</th>
			<td><input type="text" name="name" placeholder="Name" ></td>
		</tr>
		<tr>
			<th>Username</th>
			<td><input type="text" name="username" placeholder="Username"></td>
		</tr>
		<tr>
			<th>Password</th>
			<td><input type="password" name="password" placeholder="Passsword"></td>
		</tr>
		<tr>
			<th>BirthDate</th>
			<td><input type="date" name="birthdate" placeholder="Birthdate"></td>
		</tr>
		<tr>
			<th>Mobile No</th>
			<td><input type="number" name="mobileno" placeholder="Mobile No"></td>
		</tr>
		<tr>
			<th>Address</th>
			<td><input type="textarea" name="address" placeholder="Address"></td>
		</tr>
		<tr>
			<th colspan="2"><input type="submit" value="Register" style="color : orange;"></th>
		</tr>	
		
		
	</table>
	</center>
	</form>
</body>
</html>