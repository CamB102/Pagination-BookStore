<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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
	<p>Your username or password isn't correct. Please try again</p>
	<form var="user" action = "login" method="get">
		<label>Username: </label> <input type="text" name="username"/>
		<br><br>
		<label>Password: </label> <input type="text" name="password"/>
		<br><br>
		<input type="submit" value="login" />
	</form>

</body>
</html>