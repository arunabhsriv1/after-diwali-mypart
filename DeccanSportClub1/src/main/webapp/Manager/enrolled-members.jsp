<%@page import="com.cybage.pojos.AllBatchInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- logic for rendering list...  -->
	
	<table border="1">
		<tr>
			<th>BatchId</th>
			<th>Start Date</th>
			<th>End Date</th>
			<th>Batch Size</th>
			<th>Sport Name</th>		
			<th>planName</th>
			<th>Fees</th>
			<th>Duration</th>
			<th>EnrollId</th>
			<th>Username</th>
			<th>Status</th>
			
			
			
		</tr>
		<c:forEach var="members" items="${enrolledbatches }">
			<tr>
			<!-- user.getUsername(); user.getUserrole() -->
			<td><c:out value="${members.batchId}"></c:out></td>  
			<td><c:out value="${members.startDate}"></c:out></td>
			<td><c:out value="${members.endDate}"></c:out></td>  
			<td><c:out value="${members.batchSize}"></c:out></td>
			<td><c:out value="${members.sportName}"></c:out></td>
			<td><c:out value="${members.planName}"></c:out></td>  
			<td><c:out value="${members.fees}"></c:out></td>
			<td><c:out value="${members.duration}"></c:out></td>
			<td><c:out value="${members.enrollId}"></c:out></td>
			<td><c:out value="${members.username}"></c:out></td>
			<td><c:out value="${members.mStatus}"></c:out></td>
			
			
			<td>
			<a href="<%=request.getContextPath()%>/ManagerServlet/approvemember?enrollId=${members.enrollId}&amp;batchSize=${members.batchSize}">Approve</a>
			</td>
			<td>
			<a href="<%=request.getContextPath()%>/ManagerServlet/rejectmember?enrollId=${members.enrollId}">Reject</a>
			</td>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>