<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">>
<html>
<head>
<meta charset="ISO-8859-1">
<title>com.displayData</title>
<script type="text/javascript">
	function addUser()
	{
		document.fn.action="registration";
		document.fn.submit();
	}
	function editUser()
	{
		document.fn.action="edit";
		document.fn.submit();
	}
	function deleteUser()
	{
		document.fn.action="delete";
		document.fn.submit();
	}
</script>
</head>
<body>
	<form name="fn">
	<style>
	h1{color:red}
	th{color:blue}
	td{color:green}
	</style>
	<center>
	<table border="2">
	<tr>
		<th colspan="7"><h1>All Information</h1></th>
	</tr>
	<tr>	
		<th>Sr No</th>
		<th>Eid</th>
		<th>Name</th>
		<th>Username</th>
		<th>Password</th>
		<th>Birthdate</th>
		<th>Address</th>
		</tr>
		<tr>
			<c:forEach items="${data}" var="user">
			<td><input type="radio" name="eid" value="${user.eid}"></td>
			<td>${user.eid}</td>
			<td>${user.name}</td>
			<td>${user.username}</td>
			<td>${user.password}</td>
			<td>${user.birthdate}</td>
			<td>${user.address}</td>
			</tr>
			</c:forEach>
		
	</table>
	</center>
	<table border="2" align="center">
		<tr>
			<th><input type="button"  value="EDIT" onclick="editUser()"></th>
			<th><input type="button"  value="ADD" onclick="addUser()"></th>
			<th><input type="button"  value="DELETE" onclick="deleteUser()"></th>
	</table>
	</form>
</body>
</html>