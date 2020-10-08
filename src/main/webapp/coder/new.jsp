<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Team</title>
</head>
<body>
	<h1>New Team</h1>
	<p>team:  ${requestScope.team} </p>
	<p>team:  ${param.name} </p>
	<p>team:  ${param.id} </p>
	<c:choose>
		<c:when test="${fail == true}">
			<h3 style="color: red">Team not created</h3>
		</c:when>
		<c:otherwise>
    	<h3> Team created with id ${team.id} and name ${team.name}!! </h3>
  </c:otherwise>
	</c:choose>
	
		<p> Back <a href="/simple/">Home</a></p>  
</body>
</html>