<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
.sub-register-form {
	float: left;
	width: 40%;
	padding: 10px;
}

.sub-user-list {
	float: left;
	width: 60%;
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
	<h1>Register</h1>



	<div class="body">
		<div class="sub-register-form">
			<form action="register" method="post">
				<input type="hidden" name="command" value="ADD" /> <label
					for="userName">First name:</label> <input type="text" id="userName"
					name="userName"> <br> <label for="password">Password:</label>
				<input type="text" id="password" name="password"> <br>

				<label for="email">Email:</label> <input type="email" id="email"
					name="email"> <br>

				<input type="submit" value="Submit">

			</form>
			<p>
				<a href="home">Back to Home Page</a>
			</p>

		</div>

	</div>


</body>
</html>