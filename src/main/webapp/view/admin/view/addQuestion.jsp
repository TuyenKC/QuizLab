<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Add Question</title>
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
	<div id="addQuestionModal" class="modal">
		<div class="modal-content">
			<h2>Add New Question</h2>
			<form id="addQuestionForm"
				action=<%=request.getContextPath() + "/admin/addquestion"%>
				method="post">
				<input type="text" id="quiz_id" name="quiz_id" value="${quiz_id}"
					hidden><br>

				<div class="form-group">
					<label for="content">Content</label> <input type="text"
						id="content" class="form-control" name="content" required>
				</div>
				<div class="form-group">
					<label for="answerA">Answer A</label> <input type="text"
						id="answerA" class="form-control" name="option_a" required>
				</div>
				<div class="form-group">
					<label for="answerB">Answer B</label> <input type="text"
						id="answerB" class="form-control" name="option_b" required>
				</div>
				<div class="form-group">
					<label for="answerC">Answer C</label> <input type="text"
						id="answerC" class="form-control" name="option_c" required>
				</div>
				<div class="form-group">
					<label for="answerD">Answer D</label> <input type="text"
						id="answerD" class="form-control" name="option_d" required>
				</div>
				<div class="form-group">
					<label for="correct-option">Correct Option</label> <select
						type="text" id="correct-option" name="correct_option"
						class="form-control">
						<option value="A">A</option>
						<option value="B">B</option>
						<option value="C">C</option>
						<option value="D">D</option>
					</select>
				</div>
				<div class="form-group">
					<label for="score">Score</label> <input type="number" id="score"
						name="score" class="form-control" required>
				</div>
				<div class="d-flex justify-content-center">
					<button type="submit" class="btn btn-primary mr-2">Add
						Question</button>
				</div>
			</form>
		</div>
	</div>

	<section class="overlay"></section>
	<script>
		var editModal = document.getElementById("addQuestionModal");
		editModal.style.display = "block";
	</script>
	<script
		src="${pageContext.request.contextPath}/view/admin/static/js/scripts.js"></script>
</body>
</html>