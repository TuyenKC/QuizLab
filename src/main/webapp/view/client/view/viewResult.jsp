<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>QUIZLAB - View Result</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/view/client/static/css/styles.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>

<body>
	<%@ include file="header.jsp"%>
	<div class="container mt-4">
		<div class="row">
			<div class="col-md-12">
				<div class="score">
					<h4>Result</h4>
					<p id="score">${score}/${maxScore}</p>
				</div>
			</div>
		</div>
		<div class="question-container">
			<c:forEach items="${questionList}" var="question" varStatus="status">
				<h3>Question ${status.index+1}: ${question.content}</h3>
				<div class="options">
					<label
						class="answer-option ${question.correctOption == 'A' ? 'correct-answer': (quesAnsMap[question] == 'A' ? 'incorrect-answer' : '') }">
						<input type="radio" name="${question.questionId}" value="A"
						disabled ${quesAnsMap[question]=='A' ? 'checked':''}>
						${question.optionA}
					</label><br> <label
						class="answer-option ${question.correctOption == 'B' ? 'correct-answer': (quesAnsMap[question] == 'B' ? 'incorrect-answer' : '') }">
						<input type="radio" name="${question.questionId}"
						disabled ${quesAnsMap[question]==
						'B' ? 'checked':''}
						value="B"> ${question.optionB}
					</label><br> <label
						class="answer-option ${question.correctOption == 'C' ? 'correct-answer': (quesAnsMap[question] == 'C' ? 'incorrect-answer' : '') }">
						<input type="radio" name="${question.questionId}"
						disabled ${quesAnsMap[question]==
						'C' ? 'checked':''}
						value="C"> ${question.optionC}
					</label><br> <label
						class="answer-option ${question.correctOption == 'D' ? 'correct-answer': (quesAnsMap[question] == 'D' ? 'incorrect-answer' : '') }">
						<input type="radio" name="${question.questionId}"
						disabled ${quesAnsMap[question]==
						'D' ? 'checked':''}
						value="D"> ${question.optionD}
					</label><br>
				</div>

			</c:forEach>
			<button class="btn btn-primary"
				onclick="window.location.href='doquiz?quiz_id=${quizId}'">Do again</button>
		</div>
	</div>

	<div id="contactModal" class="modal">
		<div class="modal-content">
			<span class="close" onclick="closeModal('contactModal')">&times;
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
