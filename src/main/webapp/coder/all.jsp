<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All coders</title>
</head>
<body>
	<h1> All coders</h1>
	<table>
		<tr>
			<th>Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Hire Date</th>
			<th>Salary</th>
		</tr>
		<c:forEach var="cur" items="${coders}">
			<tr>
				<td>${cur.id}</td>
				<td>${cur.firstName}</td>
				<td>${cur.lastName}</td>
				<td>${cur.hireDate}</td>
				<td>${cur.salary}</td>
			</tr>
		</c:forEach>
	</table>
	<p> Back <a href="/simple/">Home</a></p>  
</body>
</html>