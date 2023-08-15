<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>QUIZLAB - Login</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/view/client/static/css/styles.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>

<body>

	<div id="loginModal" class="modal">
		<div class="modal-content">
			<h2>Login</h2>
			<form id="loginForm" action="login" method="post">
				<div class="form-group">
					<label for="username">Username</label> <input type="text"
						id="username" name="username" class="form-control" required>
				</div>
				<div class="form-group">
					<label for="password">Password</label> <input type="password"
						id="password" name="password" class="form-control" required>
				</div>
				<c:if test="${not empty alert}">
					<p>${alert}</p>
				</c:if>
				<div class="d-flex justify-content-center">
					<button type="submit" class="btn btn-success mr-2">Login</button>
					<button type="button" class="btn btn-primary mr-2"
						onclick="window.location.href='register'">Register</button>
				</div>
			</form>
		</div>
	</div>

	<script>
		var modal = document.getElementById('loginModal');
		modal.style.display = "block";
	</script>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.7/dist/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>
