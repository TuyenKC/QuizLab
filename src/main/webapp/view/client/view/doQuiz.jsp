<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>QUIZLAB - Do Quiz</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/view/client/static/css/profile.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>

<body>
	<%@ include file="header.jsp"%>
	<div class="container mt-4">
		<form id="quizForm" action=<%=request.getContextPath() + "/doquiz"%>
			method="post">
			<div class="row">
				<div class="col-md-12">
					<div class="timer">
						<h4>Time left</h4>
						<p id="countdown"></p>
						<p id="totalTime" hidden>${totalTime}</p>
					</div>
				</div>
			</div>
			<input type="text" id="quiz_id" name="quiz_id" value="${quizId}" hidden><br>
			<div class="question-container">
				<c:forEach items="${questionList}" var="question" varStatus="status">

					<h3>Question ${status.index+1}: ${question.content}</h3>
					<div class="options">
						<label><input type="radio" name="${question.questionId}"
							value="A"> ${question.optionA}</label><br> <label><input
							type="radio" name="${question.questionId}" value="B">
							${question.optionB}</label><br> <label><input type="radio"
							name="${question.questionId}" value="C">
							${question.optionC}</label><br> <label><input type="radio"
							name="${question.questionId}" value="D">
							${question.optionD}</label><br>
					</div>
				</c:forEach>
			</div>
			<button type="submit" class="btn btn-primary mt-3" id="submit-button">End Quiz</button>
		</form>
	</div>
	<div id="submitModal" class="modal">
		<div class="modal-content">
			<span class="close" onclick="closeModal('submitModal')">&times;</span>
			<h2>Confirm</h2>
			<p>Are you sure you want to submit test?</p>
			<div class="d-flex justify-content-center">
				<button type="button" class="btn btn-primary mr-2"
					onclick="closeModal('submitModal');openModal('submittedModal')">Submit</button>
				<button type="button" class="btn btn-secondary"
					onclick="closeModal('submitModal')">Cancel</button>
			</div>
		</div>
	</div>
	<div id="submittedModal" class="modal">
		<div class="modal-content">
			<h2>Status</h2>
			<p>Submitted</p>
			<button type="submit" class="btn btn-primary mr-2" onclick="result()">View
				Result</button>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.7/dist/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script>
		function openModal(modalId) {
			var modal = document.getElementById(modalId);
			modal.style.display = "block";
		}
		function closeModal(modalId) {
			var modal = document.getElementById(modalId);
			modal.style.display = "none";
		}
		function startQuiz(durationInSeconds) {
			const countdownDisplay = document.getElementById('countdown');
			let timer = durationInSeconds, minutes, seconds;
			let submitButton = document.getElementById('submit-button');
			setInterval(function() {
				minutes = parseInt(timer / 60, 10);
				seconds = parseInt(timer % 60, 10);

				minutes = minutes < 10 ? '0' + minutes : minutes;
				seconds = seconds < 10 ? '0' + seconds : seconds;

				countdownDisplay.textContent = minutes + ':' + seconds;

				if (timer <= 0) {
					submitButton.click();
				} else {
					--timer;
				}
			}, 1000);
		}
		var totalTime = document.getElementById('totalTime').textContent;
		startQuiz(totalTime * 60);
	</script>
</body>

</html>
