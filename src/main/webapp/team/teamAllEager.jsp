<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Teams (Eager)</title>
</head>
<body>
	<h1>All teams</h1>
	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Leader</th>
			<th>Coders</th>
		</tr>
		<c:forEach var="cur" items="${teamListEager}">
			<tr>
				<td>${cur.id}</td>
				<td style="color:${cur.name}">${cur.name}</td>
				<td>${cur.leader.firstName} ${cur.leader.lastName}</td>

				<td><c:forEach var="coder" items="${cur.coders}">
						<ul>
							<li>Id: ${coder.id}, Name: ${coder.firstName}
								${coder.lastName}, Hire Date: ${coder.hireDate}, Salary:
								${coder.salary}
							</li>
						</ul>
					</c:forEach></td>
			</tr>
		</c:forEach>
	</table>
	<p>
		Back <a href="/simple/">Home</a>
	</p>
</body>
</html>