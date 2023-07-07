<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
    <h1>Login</h1>
    <br>
    <form var="user" action="login" method="get">
        <c:if test="${not empty errorMessage}">
            <p>${errorMessage}</p>
        </c:if>
        <label>Username:</label> <input type="text" name="username" value="${param.username}" /> <br><br>
        <label>Password:</label> <input type="password" name="password" /> <br><br>
        <input type="submit" value="Login" />
    </form>
</body>
</html>
