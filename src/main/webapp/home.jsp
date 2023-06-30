
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
* {
  box-sizing: border-box;
}

/* Create two equal columns that floats next to each other */
.sub-body-category {
  float: left;
  width: 20%;
  padding: 10px;
}
.sub-body-product {
  float: left;
  width: 80%;
  padding: 10px;
}


/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}
</style>
</head>
<body>
	<div class="header">
		<form action="home?searchBookInput=${book.name}">
			<input type="text" name="searchBookInput" value="${searchKey}"> 
			<input type="submit" value="Search">
		</form>
	</div>
	<hr>
	<div class="body">
		<div class="sub-body-category">
			<ul>
				<c:forEach var="category" items="${categoryList}">
					<a href="home?categoryId=${category.id}">
						<li>${category.name}</li>
					</a>
				</c:forEach>
			</ul>
		</div>
		<div class="sub-body-product">
		 <c:if test="${hideBookList}">
    		<style>
        		.book-list {
            	display: none;}
    		</style>
		 </c:if>
			<div class="book-list">
				<c:if test="${empty bookList}">
					No Book
				</c:if>
				<c:if test="${not empty bookList }">
					<ul>
					<c:forEach var="book" items="${bookList}">
						<a href="book?bookId=${book.id}">
						<li>${book.name}</li>
						</a>
					</c:forEach>
					</ul>
				</c:if>	
			</div>
			<div class="book-list-by-search">
				<ul>
				<c:forEach var="book" items="${bookListBySearch}">
					<a href="book?bookId = ${book.id}">
						<li>${book.name}</li>
					<a/>
				</c:forEach>
				</ul>
			</div>
		
		</div>
	</div>
	<hr>
	<div class="footer">This is coding mentor website for be4</div>


</body>
</html>