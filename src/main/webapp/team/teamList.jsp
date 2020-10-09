<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Team List</title>
</head>
<body>
	<h1> All teams</h1>
	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Leader</th>
		</tr>
		<c:forEach var="cur" items="${teams}">
			<tr>
				<td>${cur.id}</td>
				<td>${cur.name}</td>
				<td>${cur.leader.firstName} ${cur.leader.lastName}</td>	
			</tr>
		</c:forEach>
	</table>
	<p> Back <a href="/simple/">Home</a></p>  
</body>
</html>