<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Checkout</title>
</head>
<body>
    <h1>Thank You for ordering with us!</h1>

    <h2>Your order details:</h2>
    <c:forEach var="book" items="${booksOrdered}">
        <p> ${book.name} --- Price: ${book.price}</p>
    </c:forEach>
    	<h3> Total: $${totalPrice} </h3>
</body>