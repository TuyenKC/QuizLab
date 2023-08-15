<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>QUIZLAB - Change Password</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/view/client/static/css/profile.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>

<body>
	<%@ include file="header.jsp"%>
	<div id="changePasswordModal" class="modal">
		<div class="modal-content">
			<h2>Change Password</h2>
			<form id="changePasswordForm"
				action=<%=request.getContextPath() + "/changepassword"%>
				method="post">
				<div class="form-group">
					<label for="password">Password</label> <input type="password"
						id="password" class="form-control" name="password" required>
				</div>
				<div class="form-group">
					<label for="confirm-password">Confirm Password</label> <input
						type="password" id="confirm-password" class="form-control"
						name="confirm-password" required>
				</div>
				<div class="d-flex justify-content-center">
					<button type="submit" class="btn btn-primary mr-2">Update</button>
				</div>
			</form>
		</div>
	</div>

	<script
		src="${pageContext.request.contextPath}/view/client/static/js/scripts.js"></script>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.7/dist/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
<script>
	var modal = document.getElementById("changePasswordModal");
	modal.style.display = "block";
</script>
</html>
