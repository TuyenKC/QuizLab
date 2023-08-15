<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Add User</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/view/admin/static/css/styles.css" />
<link href="https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<%@ include file="header.jsp"%>

	<div id="addUserModal" class="modal">
		<div class="modal-content">
			<h2>Add New User</h2>
			<form id="addUserForm"
				action=<%=request.getContextPath() + "/admin/adduser"%>
				method="post">
				<div class="form-group">
					<label for="username">Username</label> <input type="text"
						id="username" class="form-control" name="username" required>
				</div>
				<div class="form-group">
					<label for="password">Password</label> <input type="password"
						id="password" class="form-control" name="password" required>
				</div>
				<div class="form-group">
					<label for="email">Email</label> <input type="email" id="email"
						class="form-control" name="email" required>
				</div>
				<div class="form-group">
					<label for="role">Role</label> <select id="role"
						class="form-control" name="role" required>
						<option value="Admin">Admin</option>
						<option value="User">User</option>
					</select>
				</div>
				<div class="d-flex justify-content-center">
					<button type="submit" class="btn btn-primary mr-2">Add
						User</button>
				</div>
			</form>
		</div>
	</div>

	<section class="overlay"></section>
	<script
		src="${pageContext.request.contextPath}/view/admin/static/js/scripts.js"></script>
	<script>
		var modal = document.getElementById("addUserModal");
		modal.style.display = "block";
	</script>
</body>
</html>