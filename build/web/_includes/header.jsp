
<!-- Sidebar  -->
<nav id="sidebar">
	<div class="sidebar-header">
		<h3>
			<span>Hi, <%
			if (session.getAttribute("userid") != null) {
				out.println(session.getAttribute("fullname").toString());
			}
			%></span>
		</h3>
	</div>
	<ul class="list-unstyled components">
		<li><a href="./" class="dashboard"><i class="material-icons">dashboard</i><span>Dashboard</span></a></li>
		<li><a href="employee_details.jsp"><i class="material-icons">person</i><span>User
					Detail</span></a></li>
		<li>
		<li><a href="#homeSubmenu" data-toggle="collapse"
			aria-expanded="false" class="dropdown-toggle"><i
				class="material-icons">date_range</i><span>Timesheet</span></a>
			<ul class="collapse list-unstyled" id="homeSubmenu">
				<li><a href="timesheet.jsp">Timesheet Form</a></li>
				<li><a href="timesheet_logs.jsp">Attendance Log</a></li>
			</ul></li>
		<li><a href="timeoff.jsp"><i class="material-icons">apps</i><span>Leave
					Details</span></a></li>
		<li><a href="#"><i class="material-icons">content_copy</i><span>Notice
					Board</span></a></li>
		<li><a href="timeoff.jsp"><i class="material-icons">apps</i><span>Leave
					Application</span></a></li>
		<li class=""><a href="logout.jsp"> <i class="icon-user"></i>
				<span class="title">Log Out</span>
		</a></li>
	</ul>
</nav>


<!-- Page Content  -->
<div id="content">
	<div class="top-navbar">
		<nav class="navbar navbar-expand-lg">
			<div class="container-fluid">
				<button type="button" id="sidebarCollapse"
					class="d-xl-block d-lg-block d-md-mone d-none">
					<span class="fa fa-angle-left fa-2x"></span>
				</button>

				<a class="navbar-brand" href="#"> HRIMS </a>

				<div
					class=" collapse navbar-collapse d-lg-block d-xl-block d-sm-none d-md-none d-none"
					id="navbarSupportedContent">
					<ul class="ml-auto nav navbar-nav">
						<li class="nav-item dropdown"><a id="notifications"
							rel="nofollow" data-target="#" href="#" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="false" class="nav-link">
								<i class="fa fa-bell-o"></i><span
								class="badge bg-red badge-corner notification">12</span>
						</a>
							<ul class="dropdown-menu">
								<li><a href="#">You have 5 new messages</a></li>
								<li><a href="#">You're now friend with Mike</a></li>
								<li><a href="#">Wish Mary on her birthday!</a></li>
								<li><a href="#">5 warnings in Server Console</a></li>
							</ul></li>

						<li class="nav-item"><a class="nav-link" href="#"> <span
								class="fa fa-th"></span>
						</a></li>
						<li class="nav-item"><a class="nav-link" href="#"> <span
								class="fa fa-user fa-1x"></span>
						</a></li>
						<li class="nav-item"><a class="nav-link" href="#"> <span
								class="fa fa-cog fa-1x"></span>
						</a></li>

					</ul>
				</div>
			</div>
		</nav>
	</div>