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
 <a href="<%=request.getContextPath()%>/logout.jsp">Logout</a><br>
manager list
${deletemsg}
	<a href="<%=request.getContextPath()%>/Admin/addManager.jsp">add Manager</a> <br>
	
	<table border="1">
		<tr>
			<th>userId</th>
			<th>Username</th>
			<th>password</th>
			<th>role</th>
			<th>address</th>
			<th>phone</th>
			<th>email</th>
			
		</tr>
		<c:forEach var="manager" items="${manager}">
			<tr>
			<!-- user.getUsername(); user.getUserrole() -->
			<td><c:out value="${manager.userId}"></c:out></td> 
			<td><c:out value="${manager.username}"></c:out></td>  
			<td><c:out value="${manager.password}"></c:out></td>
			<td><c:out value="${manager.role}"></c:out></td>
			<td><c:out value="${manager.address}"></c:out></td>
			<td><c:out value="${manager.phone}"></c:out></td>
			<td><c:out value="${manager.email}"></c:out></td>
			
			<td>
			<a href="<%=request.getContextPath()%>/AdminServlet/deleteManager?username=${manager.username}">delete</a>
			</td>
			<td>
			<a href="<%=request.getContextPath()%>/AdminServlet/editManager?username=${manager.username}">update</a>
			</td>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>