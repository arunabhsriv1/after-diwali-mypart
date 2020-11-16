<%@page import="com.cybage.pojos.Plans"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@include file="manager-header.jsp" %> 

	<!-- logic for rendering list...  -->
<div class="container m-3">
	<a href="<%=request.getContextPath()%>/Manager/add-plan.jsp" class="btn btn-info m-3" role="button">add
		plan</a>
	<div class="table-responsive">
		<table class="table table-borderless table-striped">
			<thead class="thead-dark">
				<tr>
					<th>Plan Id</th>
					<th>Plan Name</th>
					<th>Fees</th>
					<th>Duration</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="plans" items="${plans}">
					<tr>
						<!-- user.getUsername(); user.getUserrole() -->
						<td><c:out value="${plans.planId}"></c:out></td>
						<td><c:out value="${plans.planName}"></c:out></td>
						<td><c:out value="${plans.fees}"></c:out></td>
						<td><c:out value="${plans.duration}"></c:out></td>



						<td><a
							href="<%=request.getContextPath()%>/ManagerServlet/deleteplan?planId=${plans.planId}" class="btn btn-danger" role="button">delete</a>
						</td>
						<td><a
							href="<%=request.getContextPath()%>/ManagerServlet/editplan?planId=${plans.planId}" class="btn btn-warning" role="button">update</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>	
</body>
</html>

