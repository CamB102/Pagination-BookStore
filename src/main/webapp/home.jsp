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
.left {
	float: left;
	width: 30%;
	padding: 10px;
}

.right {
	float: left;
	width: 70%;
	padding: 10px;
}

.right-search {
	float: left;
	width: 70%;
	padding: 10px;
	display: grid;
	grid-auto-flow: column;
	place-items: center;
}

/* Clear floats after the columns */
.row:after {
	content: "";
	display: table;
	clear: both;
}

.header {
	display: flex;
}

.right .h4 {
	display: inline-block;
}

.pagination {
	display: inline-block;
}

.pagination a {
	color: black;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
}

.pagination a.active {
	background-color: #4CAF50;
	color: white;
	border-radius: 5px;
}

.pagination a:hover:not(.active) {
	background-color: #ddd;
	border-radius: 5px;
}
</style>
</head>
<body>
	<div class="header">
		<div class="left">
			<h3>Tiem sach cu</h3>
		</div>

		<div class="right-search">
			<form action="home" name="search">
				<input type="text" name="searchBookInput" value="${searchKey}">
				<input type="submit" value="Search">
			</form>

			<c:if test="${sessionScope.name == null}">
				<a href="login">Login here</a>
			</c:if>
			<c:if test="${sessionScope.name != null}">
				<h4>Hi! ${sessionScope.name}</h4>
				<br>
			</c:if>

			<a href="cart?command=VIEW_CART">Cart(${empty sessionScope.cart ? 0 : sessionScope.cart.size()})</a>
		</div>
	</div>
	<hr>
	<div class="body">
		<div class="left">
			<ul>
				<c:forEach var="category" items="${categoryList}">
					<a href="home?categoryId=${category.id}">
						<li>${category.name}</li>
					</a>
				</c:forEach>
			</ul>
		</div>
		<div class="right">
			<c:if test="${hideBookList}">
				<style>
.book-list {
	display: none;
}
</style>
			</c:if>
			<div class="book-list">
				<c:if test="${empty bookListInAPage}">
					No Book
				</c:if>
				<c:if test="${not empty bookListInAPage }">
					<ul>
						<c:forEach var="book" items="${bookListInAPage}">
							<a href="book?bookId=${book.id}">
								<li>${book.name}</li>
							</a>
						</c:forEach>
						<br>
						<br>
						<div class="pagination">
							<c:forEach var="pageNumber" begin="1" end="${totalPages}">
								<a href="home?page=${pageNumber}"
									class="${pageNumber == currentPage ? 'active' : ''}">${pageNumber}</a>
							</c:forEach>
						</div>
					</ul>
				</c:if>
			</div>
			<div class="book-list-by-search">
				<ul>
					<c:forEach var="book" items="${bookListBySearch}">
						<a href="book?bookId=${book.id}">
							<li>${book.name}</li>
						</a>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
	<hr>
	<div class="footer">This is coding mentor website for be4</div>
</body>
</html>
