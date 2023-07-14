<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
id: ${book.id}
<br>
name: ${book.name}
author: ${book.author}
<br>
title: ${book.title}
<br>
stock: ${book.stock}
<br>
price: $${book.price}
<br>
<input type="button" value="Add to Cart" onclick="window.location.href='cart?command=ADD_TO_CART&bookId=${book.id}'"/>
</body>
</html>