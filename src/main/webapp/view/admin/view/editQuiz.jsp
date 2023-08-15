<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Edit Quiz</title>
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

	<div id="editQuizModal" class="modal">
		<div class="modal-content">
			<h2>Edit Quiz</h2>
			<form id="editQuizForm"
				action=<%=request.getContextPath() + "/admin/editquiz"%>
				method="post">
				<input type="text" id="quiz_id" name="quiz_id"
					value="${editQuiz.id}" hidden><br> <label
					for="category">Category</label> <select id="category_id"
					class="form-control" name="category_id" required>
					<c:forEach items="${categoryList}" var="category">
						<option value="${category.id}"
							<c:if test="${category.id == editQuiz.categoryId}">selected</c:if>>${category.title}</option>
					</c:forEach>
				</select>
				<div class="form-group">
					<label for="title">Title</label> <input type="text" id="title"
						name="title" class="form-control" value="${editQuiz.title}"
						required>
				</div>
				<div class="form-group">
					<label for="total_time">Time</label> <input type="number"
						id="total_time" class="form-control" name="total_time"
						value="${editQuiz.totalTime}" required>
				</div>
				<div class="d-flex justify-content-center">
					<button type="submit" class="btn btn-primary mr-2">Edit
						Quiz</button>
				</div>
			</form>
		</div>
	</div>

	<section class="overlay"></section>
	<script>
		var editModal = document.getElementById("editQuizModal");
		editModal.style.display = "block";
	</script>
	<script
		src="${pageContext.request.contextPath}/view/admin/static/js/scripts.js"></script>
</body>
</html>