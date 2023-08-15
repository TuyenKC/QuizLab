<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>QUIZLAB - Register</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/view/client/static/css/styles.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>

<body>

	<div id="registerModal" class="modal">
		<div class="modal-content">
			<h2>Register</h2>
			<form id="RegisterForm" action="register" method="post">
				<div class="form-group">
					<label for="username">Username</label> <input type="text"
						id="username" name="username" class="form-control" required>
				</div>
				<div class="form-group">
					<label for="password">Password</label> <input type="password"
						id="password" name="password" class="form-control" required>
				</div>
				<div class="form-group">
					<label for="confirm-password">Confirm password</label> <input
						type="password" id="confirm-password" name="confirm-password"
						class="form-control" required>
				</div>
				<div class="form-group">
					<label for="email">Email</label> <input type="text" id="email"
						class="form-control" name="email" required>
				</div>
				<div class="d-flex justify-content-center">
					<button type="submit" class="btn btn-success mr-2">Register</button>
				</div>
				<c:if test="${not empty alert}">
					<p>${alert}</p>
				</c:if>
			</form>
		</div>
	</div>

	<script>
		var modal = document.getElementById('registerModal');
		modal.style.display = "block";
	</script>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.7/dist/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>
