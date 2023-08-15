<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Edit User</title>
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

	<div id="editUserModal" class="modal">
		<div class="modal-content">
			<h2>Edit User</h2>
			<form id="editUserForm"
				action=<%=request.getContextPath() + "/admin/edituser"%>
				method="post">
				<input type="text" id="id" name="id" value="${editUser.id}" hidden><br>
				<div class="form-group">
					<label for="username">Username</label> <input type="text"
						id="username" class="form-control" name="username"
						value="${editUser.username}" readonly required>
				</div>
				<input type="password" id="password" name="password"
					value="${editUser.password}" hidden><br>

				<div class="form-group">
					<label for="email">Email</label> <input type="email" id="email"
						class="form-control" name="email" value="${editUser.email}"
						required>
				</div>
				<div class="form-group">
					<label for="role">Role</label> <select id="role"
						class="form-control" name="role" required>
						<c:if test="${editUser.roleId == 1}">
							<option value="Admin" id="role-admin" selected>Admin</option>
							<option value="User" id="role-user">User</option>
						</c:if>
						<c:if test="${editUser.roleId != 1}">
							<option value="Admin" id="role-admin">Admin</option>
							<option value="User" id="role-user" selected>User</option>
						</c:if>
					</select>
				</div>
				<div class="d-flex justify-content-center">
					<button type="submit" class="btn btn-primary mr-2">Update</button>
				</div>
			</form>
		</div>
	</div>
	<section class="overlay"></section>
	<script
		src="${pageContext.request.contextPath}/view/admin/static/js/scripts.js"></script>
	<script>
		var modal = document.getElementById("editUserModal");
		modal.style.display = "block";
	</script>
</body>
</html>