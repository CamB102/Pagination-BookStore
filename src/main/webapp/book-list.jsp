
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
	Welcome to Book List
	<hr>
	<ul>
		<c:forEach var="book" items="${booklist}">
			<li>${book.name} - ${book.id} - ${book.categoryId} - ${book.price}</li>
		</c:forEach>
	</ul>
</body>
</html>