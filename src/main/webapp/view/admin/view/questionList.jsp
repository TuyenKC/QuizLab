<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Question Management</title>
<!-- CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/view/admin/static/css/styles.css" />
<!-- Boxicons CSS -->
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
			<h5 class="text-center">Title: ${quiz.title}</h5>
			<h5 class="text-center">Total Score: ${quiz.totalScore}</h5>
			<h5 class="text-center">Total Question: ${quiz.totalQuestion}</h5>
			<hr>
			<div class="container text-left">
				<c:url var="addQuestionUrl" value="/admin/addquestion">
					<c:param name="quiz_id" value="${quiz.id}" />
				</c:url>
				<a href="${addQuestionUrl}" class="btn btn-success">Add New
					Question</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>No.</th>
						<th>Content</th>
						<th>Option A</th>
						<th>Option B</th>
						<th>Option C</th>
						<th>Option D</th>
						<th>Correct Option</th>
						<th>Score</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${questionList}" var="question"
						varStatus="status">
						<tr>
							<td>${status.index + 1}</td>
							<td>${question.content}</td>
							<td>${question.optionA}</td>
							<td>${question.optionB}</td>
							<td>${question.optionC}</td>
							<td>${question.optionD}</td>
							<td>${question.correctOption}</td>
							<td>${question.score}</td>
							<td><c:url var="editUrl" value="/admin/editquestion">
									<c:param name="quiz_id" value="${quiz.id}" />
									<c:param name="question_id" value="${question.questionId}" />

								</c:url> <a href="${editUrl}">Edit</a> &nbsp;&nbsp; <a href="#"
								onclick="showDeletePopup(${question.questionId})">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<div id="deleteQuestionModal" class="modal">
		<div class="modal-content">
			<span class="close" onclick="closeModal('deleteQuestionModal')">&times;</span>
			<h2>Delete Question</h2>
			<p>Are you sure you want to delete this Question?</p>
			<form id="deleteForm"
				action=<%=request.getContextPath() + "/admin/deletequestion"%>
				method="post">
				<input type="hidden" name="question_id" id="deleteQuestionId">
				<input type="hidden" name="quiz_id" id="quiz_id" value="${quiz.id}">
				<div class="d-flex justify-content-center">
					<button class="btn btn-danger mr-2" onclick="deleteQuestion()">Delete</button>
					<button class="btn btn-secondary"
						onclick="closeModal('deleteQuestionModal')">Cancel</button>
				</div>
			</form>
		</div>
	</div>

	<section class="overlay"></section>
	<script>
		function showDeletePopup(questionId) {
			openModal('deleteQuestionModal');
			document.getElementById("deleteQuestionId").value = questionId;
		}
	</script>
	<script
		src="${pageContext.request.contextPath}/view/admin/static/js/scripts.js"></script>
</body>
</html>