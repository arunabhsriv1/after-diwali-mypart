<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@include file="manager-header.jsp" %> 
<div class="container m-3">
	<h1>Updating Plan</h1>
	<form method="post"
		action="<%=request.getContextPath()%>/ManagerServlet/updateplan">
		<div class="form-group">
			<label for="planId">Plan Id:</label>
			 <input type="number" class="form-control" name="planId" readonly="readonly" value="${plans.planId}">
		</div>
		<div class="form-group">
			<label for="planName">Plan Name:</label>
			 <input type="text" class="form-control" name="planName" value="${plans.planName}" required>
		</div>
		<div class="form-group">
			<label for="fees">Fees:</label>
			 <input type="number" class="form-control" name="fees" value="${plans.fees}" required min="1000" max="50000">
		</div>
		<div class="form-group">
			<label for="duration">Duration:</label>
			 <input type="number" class="form-control" name="duration" value="${plans.duration}" required min="1" max="12">
		</div>		
		<button type="submit" class="btn btn-info">Update</button>
	</form>
</div>		
</body>
</html>


