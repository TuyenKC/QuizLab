<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Edit Question</title>
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

   	<%@ include file="header.jsp" %>
	<div id="editQuestionModal" class="modal">
		<div class="modal-content">
			<h2>Edit Question</h2>
			<form id="editQuestionForm"
				action=<%=request.getContextPath() + "/admin/editquestion"%>
				method="post">
				<input type="text" id="quiz_id" name="quiz_id" value="${editQuestion.quizId}"
					hidden><br>
					 <input type="text" id="question_id"
					name="question_id" value="${editQuestion.questionId}" hidden><br>

				<div class="form-group">
					<label for="content">Content</label> <input type="text"
						id="content" class="form-control" name="content"
						value="${editQuestion.content}" required>
				</div>
				<div class="form-group">
					<label for="optionA">Option A</label> <input type="text"
						id="optionA" class="form-control" name="option_a"
						value="${editQuestion.optionA}" required>
				</div>
				<div class="form-group">
					<label for="optionB">Option B</label> <input type="text"
						id="optionB" class="form-control" name="option_b"
						value="${editQuestion.optionB}" required>
				</div>
				<div class="form-group">
					<label for="optionC">Option C</label> <input type="text"
						id="optionC" class="form-control" name="option_c"
						value="${editQuestion.optionC}" required>
				</div>
				<div class="form-group">
					<label for="optionD">Option D</label> <input type="text"
						id="optionD" class="form-control" name="option_d"
						value="${editQuestion.optionD}" required>
				</div>
				<div class="form-group">
					<label for="correct-option">Correct Option</label> <select
						type="text" id="correct-option" name="correct_option"
						class="form-control">
						<option value="A"
							<c:if test="${editQuestion.correctOption == 'A'}">selected</c:if>>A</option>
						<option value="B"
							<c:if test="${editQuestion.correctOption == 'B'}">selected</c:if>>B</option>
						<option value="C"
							<c:if test="${editQuestion.correctOption == 'C'}">selected</c:if>>C</option>
						<option value="D"
							<c:if test="${editQuestion.correctOption == 'D'}">selected</c:if>>D</option>
					</select>
				</div>
				<div class="form-group">
					<label for="score">Score</label> <input type="number" id="score"
						class="form-control" name="score" value="${editQuestion.score}"
						required>
				</div>
				<div class="d-flex justify-content-center">
					<button type="submit" class="btn btn-primary mr-2">Edit
						Question</button>
				</div>
			</form>
		</div>
	</div>
	<section class="overlay"></section>
	<script>
		var editModal = document.getElementById("editQuestionModal");
		editModal.style.display = "block";
	</script>
	<script
		src="${pageContext.request.contextPath}/view/admin/static/js/scripts.js"></script>
</body>
</html>