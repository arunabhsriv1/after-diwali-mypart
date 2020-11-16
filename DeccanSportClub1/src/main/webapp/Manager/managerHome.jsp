<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
<title>Manager Home</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand"
			href="<%=request.getContextPath()%>/ManagerServlet/managerprofile">welcome
			<%=request.getRemoteUser()%></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link"
					href="<%=request.getContextPath()%>/ManagerServlet/listbatch">Batch
						Management</a></li>
				<li class="nav-item"><a class="nav-link"
					href="<%=request.getContextPath()%>/ManagerServlet/listenrolledmembers">Enroll
						Members</a></li>
				<li class="nav-item"><a class="nav-link"
					href="<%=request.getContextPath()%>/ManagerServlet/listplan">Plan
						Management</a></li>
				<li class="nav-item"><a class="nav-link"
					href="<%=request.getContextPath()%>/logout.jsp">Logout</a></li>
			</ul>


		</div>
	</nav>
			
			<%HttpSession session1 =request.getSession(); session1.setAttribute("username", request.getRemoteUser());%>
	
			<div class="container m-3 d-flex justify-content-center">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-4">
						<div class="card" style="width: 18rem;">
							<img src="batch.png" class="card-img-top" alt="Batch...">
							<div class="card-body">
								<h5 class="card-title">Batch Management</h5>
								<p class="card-text">Access all the batch info and change according to desire.</p>
								<a href="<%=request.getContextPath()%>/ManagerServlet/listbatch" class="btn btn-primary">Go</a>
							</div>
						</div>
					</div>
					<div class="col-sm-12 col-md-12 col-lg-4">
						<div class="card" style="width: 18rem;">
							<img src="approve.png" class="card-img-top" alt="Enroll...">
							<div class="card-body">
								<h5 class="card-title">Enroll Member</h5>
								<p class="card-text">Approve or disapprove user request for membership.</p>
								<a href="<%=request.getContextPath()%>/ManagerServlet/listenrolledmembers" class="btn btn-primary">Go</a>
							</div>
						</div>
					</div>
					<div class="col-sm-12 col-md-12 col-lg-4">
						<div class="card" style="width: 18rem;">
							<img src="plan.png" class="card-img-top" alt="Plan...">
							<div class="card-body">
								<h5 class="card-title">Plan Management</h5>
								<p class="card-text">Access all the available plans and make changes as desired.</p>
								<a href="<%=request.getContextPath()%>/ManagerServlet/listplan" class="btn btn-primary">Go</a>
							</div>
						</div>
					</div>
				</div>
			</div>
</body>

</html>