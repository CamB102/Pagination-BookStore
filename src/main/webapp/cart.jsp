<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cart List</title>
</head>
<body>
<div style="display: flex; padding: 20">
	<div style="width: 50%">
	<h3 onclick="window.location.href='home'">Tiem sach cu</h3>
	</div>
	<div style="width: 50%; text-align: right;">
		<c:if test="${sessionScope.name != null }">
			Hi ${sessionScope.name}
			<br>
			<a href="logout">Logout</a>
		</c:if>
		<c:if test="${sessionScope.name == null}">
			<a href="login.jsp">login</a>
		</c:if>
		<a href="home?command=VIEWCART">Cart(${empty sessionScope.cart? 0 : sessionScope.cart.size()})</a>
	</div>
</div>
<h1>Cart List</h1>


<c:if test="${not empty cart}">
    <c:forEach var="item" items="${cart}" varStatus="status">
        ${status.count} - ${item.value.name} - $${item.value.price} - <a href="cart?command=REMOVE&bookId=${item.key}">Remove</a>
        <br>
    </c:forEach>
    <br><br>
    <h4>Total Price: ${totalPrice}</h4>
    <hr>
    <input type="button" value="Submit Cart" onclick="window.location.href='cart?command=SUBMIT_CART'" />
</c:if>

<c:if test="${empty cart}">
    <h2>Empty Cart</h2>
</c:if>
<br><br>

<a href="home">Back to Home Page</a>
</body>
</html>
