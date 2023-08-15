<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<a class="navbar-brand" href="welcome">QUIZLAB</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNav" aria-controls="navbarNav"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNav">
		<ul class="navbar-nav ml-auto">
			<li class="nav-item"><a class="nav-link" href="quizlist">Quiz
					List</a></li>
			<li class="nav-item"><a class="nav-link" href="#"
				onclick="openModal('contactModal')">Contact</a></li>
			<c:if test="${not empty sessionScope.user}">
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="userDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <img
						src="${pageContext.request.contextPath}/view/client/static/img/langlieu.jpg"
						alt="Avatar" class="avatar">
				</a>
					<div class="dropdown-menu dropdown-menu-right"
						aria-labelledby="userDropdown">
						<a class="dropdown-item" href="profile">Account Profile</a> <a
							class="dropdown-item" href="history">History</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="logout">Logout</a>
					</div></li>
			</c:if>
			<c:if test="${empty sessionScope.user}">
				<li class="nav-item"><a class="nav-link" href="login">Login</a></li>
				<li class="nav-item"><a class="nav-link" href="register">Register</a></li>
			</c:if>
		</ul>
	</div>
</nav>


