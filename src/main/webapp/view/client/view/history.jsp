<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>QUIZLAB - History</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/view/client/static/css/styles.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container">
		<h3 class="text-center">History</h3>
		<hr>
		<br>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>No.</th>
					<th>Title</th>
					<th>Score</th>
					<th>Max Score</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${historyList}" var="history" varStatus="status">
					<tr>
						<td>${status.index+1}</td>
						<td>${historyQuizNameMap[history]}</td>
						<td>${history.score}</td>
						<td>${historyMap[history]}</td>
						<td><a href="viewresult?history_id=${history.historyId}">View
								Details</a> &nbsp;&nbsp;&nbsp;&nbsp;</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
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
