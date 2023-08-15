<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>User Management</title>
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

	<div class="row mt-70s">
		<div class="container">
			<h3 class="text-center">List of Users</h3>
			<hr>
			<div class="container text-left">
				<a href="adduser" class="btn btn-success">Add New User</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>No.</th>
						<th>Name</th>
						<th>Email</th>
						<th>Role</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${userList}" var="user" varStatus="status">
						<tr>
							<td>${status.index + 1}</td>
							<td>${user.username}</td>
							<td>${user.email}</td>

							<c:if test="${user.roleId == 1}">
								<td>Admin</td>
							</c:if>
							<c:if test="${user.roleId != 1}">
								<td>User</td>
							</c:if>
							<td><c:url var="editUrl" value="/admin/edituser">
									<c:param name="id" value="${user.id}" />
								</c:url> <a href="${editUrl}">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a
								href="#" onclick="showDeletePopup(${user.id})">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<div id="deleteUserModal" class="modal">
		<div class="modal-content">
			<span class="close" onclick="closeModal('deleteUserModal')">&times;</span>
			<h2>Delete User</h2>
			<p>Are you sure you want to delete this user?</p>
			<form id="deleteForm"
				action=<%=request.getContextPath() + "/admin/deleteuser"%>
				method="post">
				<input type="hidden" name="id" id="deleteUserId">
				<div class="d-flex justify-content-center">
					<button type="submit" class="btn btn-danger mr-2">Delete</button>
					<button type="button" class="btn btn-secondary"
						onclick="closeModal('deleteUserModal')">Cancel</button>
				</div>
			</form>

		</div>
	</div>

	<section class="overlay"></section>
	<script
		src="${pageContext.request.contextPath}/view/admin/static/js/scripts.js"></script>
	<script>
		function showDeletePopup(userId) {
			openModal('deleteUserModal');
			document.getElementById("deleteUserId").value = userId;
		}
	</script>
</body>
</html>