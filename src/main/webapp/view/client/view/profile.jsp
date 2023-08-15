<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>QUIZLAB - Profile</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/view/client/static/css/profile.css">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>

<body>
	<%@ include file="header.jsp"%>
	<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<div class="profile-card">
					<div class="avatar-container">
						<img
							src="${pageContext.request.contextPath}/view/client/static/img/langlieu.jpg"
							class="avatar" alt="Avatar">
					</div>
					<div class="card-body">
						<h5 class="card-title">Account Profile</h5>
						<p>
							<strong>Username:</strong> ${user.username}
						</p>
						<p>
							<strong>Email:</strong> ${user.email}
						</p>
						<button class="btn btn-primary"
							onclick="window.location.href='editprofile'">Edit
							Profile</button>
						<button class="btn btn-info"
							onclick="window.location.href='changepassword'">Change
							Password</button>
						<button class="btn btn-danger"
							onclick="window.location.href='logout'">Logout</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div id="contactModal" class="modal">
		<div class="modal-content">
			<span class="close" onclick="closeModal('contactModal')">&times;</span>
			<h2>Contact</h2>
			<p>Coming soon</p>
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

</html>
