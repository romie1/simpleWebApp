<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Team</title>
</head>
<body>
	<h1>Delete Team</h1>

	
	<c:if test="${deleted == true}">
		<h3>Team deleted with id ${param.id}!!</h3>
	</c:if>
	<c:if test="${deleted == false}">
		<h3 style="color: red">Team not deleted! Please insert a valid id!</h3>
	</c:if>
	
	<p>
		Back <a href="/simple/">Home</a>
	</p>
</body>
</html>