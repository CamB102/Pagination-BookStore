<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Cart List</h1>

	<c:if test="${not empty cart}">
		<c:forEach var="item" items="${cart}" varStatus="status">
		${status.count}: ${item.value.name} 
			<br>
		</c:forEach>
	</c:if>

	<c:if test="${empty cart}">
		<h2>Empty Cart</h2>
	</c:if>
	<br><br>
	<a href="home">Back to Home Page</a>
</body>
</html>