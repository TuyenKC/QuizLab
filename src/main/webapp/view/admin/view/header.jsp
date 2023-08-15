
<nav>
	<div class="logo">
		<i class="bx bx-menu menu-icon"></i> <span class="logo-name">QuizLab</span>
	</div>
	<div class="sidebar">
		<div class="logo">
			<i class="bx bx-menu menu-icon"></i> <span class="logo-name">QuizLab</span>
		</div>

		<div class="sidebar-content">
			<ul class="lists">
				<li class="list"><a href="dashboard" class="nav-link"> <i
						class="bx bx-home-alt icon"></i> <span class="link">Dashboard</span>
				</a></li>
				<li class="list"><a href="userlist" class="nav-link"> <i
						class='bx bx-user icon'></i> <span class="link">User
							Management</span>
				</a></li>
				<li class="list"><a href="categorylist" class="nav-link"> <i
						class='bx bx-category icon'></i> <span class="link">Category
							Management</span>
				</a></li>
				<li class="list"><a href="quizlist" class="nav-link"> <i
						class="bx bx-file icon"></i> <span class="link">Quiz
							Management</span>
				</a></li>
				<div class="bottom-cotent">
					<li class="list"><a href="#" class="nav-link"> <i
							class="bx bx-cog icon"></i> <span class="link">Settings</span>
					</a></li>
					<li class="list"><a
						href=<%=request.getContextPath() + "/logout"%> class="nav-link">
							<i class="bx bx-log-out icon"></i> <span class="link">Logout</span>
					</a></li>
				</div>
		</div>
	</div>
</nav>