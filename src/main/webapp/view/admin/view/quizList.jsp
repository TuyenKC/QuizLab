<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Quiz Management</title>
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
	<div class="row mt-70">
		<div class="container">
			<h3 class="text-center">List of Quiz</h3>
			<hr>
			<div class="container text-left">

				<a href="addquiz" class="btn btn-success">Add New Quiz</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>No.</th>
						<th>Title</th>
						<th>Category</th>
						<th>Time (minutes)</th>
						<th>Max Score</th>
						<th>Number of Question</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${quizList}" var="quiz" varStatus="status">
						<tr>
							<td>${status.index + 1}</td>
							<td>${quiz.title}</td>
							<td>${categoryMap[quiz.categoryId]}</td>
							<td>${quiz.totalTime}</td>
							<td>${quiz.totalScore}</td>
							<td>${quiz.totalQuestion}</td>
							<td><c:url var="editUrl" value="/admin/editquiz">
									<c:param name="id" value="${quiz.id}" />
								</c:url> <a href="${editUrl}">Edit</a> &nbsp;&nbsp; <a href="#"
								onclick="showDeletePopup(${quiz.id})">Delete</a>&nbsp;&nbsp; <c:url
									var="viewDetailUrl" value="/admin/questionlist">
									<c:param name="quiz_id" value="${quiz.id}" />
								</c:url> <a href="${viewDetailUrl}">View Details</a></td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
	</div>

	<div id="deleteQuizModal" class="modal">
		<div class="modal-content">
			<span class="close" onclick="closeModal('deleteQuizModal')">&times;</span>
			<h2>Delete Quiz</h2>
			<p>Are you sure you want to delete this Quiz?</p>
			<form id="deleteForm"
				action=<%=request.getContextPath() + "/admin/deletequiz"%>
				method="post">
				<input type="hidden" name="id" id="deleteId">
				<div class="d-flex justify-content-center">
					<button type="submit" class="btn btn-danger mr-2">Delete</button>
					<button type="button" class="btn btn-secondary"
						onclick="closeModal('deleteQuizModal')">Cancel</button>
				</div>
			</form>
		</div>
	</div>
	<section class="overlay"></section>
	<script>
		function showDeletePopup(deleteId) {
			openModal('deleteQuizModal');
			document.getElementById("deleteId").value = deleteId;
		}
	</script>
	<script
		src="${pageContext.request.contextPath}/view/admin/static/js/scripts.js"></script>
</body>
</html>