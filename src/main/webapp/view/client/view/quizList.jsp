<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>QUIZLAB - Quiz List</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/view/client/static/css/styles.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>

<body>
	<%@ include file="header.jsp"%>
	<div class="container mt-4">
		<h2>List Quiz</h2>
		<form id="filterQuizForm"
			action=<%=request.getContextPath() + "/quizlist"%> method="get">
			<label for="category">Select Category</label> <select
				id="category_id" class="form-control" name="category_id" required>
				<option value="all"
					<c:if test="${categoryId == null}">selected</c:if>>All</option>
				<c:forEach items="${categoryList}" var="category">
					<option value="${category.id}"
						<c:if test="${category.id == categoryId}">selected</c:if>>${category.title}</option>
				</c:forEach>
			</select> <br>
			<button type="submit" class="btn btn-primary mr-2">Filter
				Quiz</button>
		</form>
		<div class="row">
			<c:forEach items="${quizList}" var="quiz">

				<div class="col-md-4 mb-4">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">${quiz.title}</h5>
							<p class="card-text">Total Question: ${quiz.totalQuestion}</p>
							<p class="card-text">Total Time: ${quiz.totalTime} minutes</p>
							<p class="card-text">Total Score: ${quiz.totalScore}</p>
							<c:url var="doQuizUrl" value="/doquiz">
								<c:param name="quiz_id" value="${quiz.id}" />
							</c:url>
							<a href="${doQuizUrl}" class="btn btn-primary">Start</a>
						</div>
					</div>
				</div>
			</c:forEach>
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
