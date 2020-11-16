<%@include file="manager-header.jsp" %> 
<div class="container m-3">
	<h1 class="text-align-center">Adding new Plan</h1>
	<form method="post" action="<%=request.getContextPath()%>/ManagerServlet/addplan">
		<div class="form-group">
			<label for="planName">Plan Name:</label>
			 <input type="text" class="form-control" name="planName" required>
		</div>
		<div class="form-group">
			<label for="fees">Fees:</label>
			 <input type="number" class="form-control" name="fees" required min="1000" max="50000">
		</div>
		<div class="form-group">
			<label for="duration">Duration:</label>
			 <input type="number" class="form-control" name="duration" required min="1" max="12">
		</div>		
		<button type="submit" class="btn btn-info">Add Plan</button>
	</form>
</div>	
</body>
</html>

