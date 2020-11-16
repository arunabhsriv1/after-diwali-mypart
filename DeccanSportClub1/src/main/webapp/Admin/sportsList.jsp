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
	<a href="<%=request.getContextPath()%>/Admin/addSport.jsp">add Sports</a> <br>
	
	<table border="1">
		<tr>
			<th>sportId</th>
			<th>sportName</th>
			
			
		</tr>
		<c:forEach var="sports" items="${sports}">
			<tr>
			<!-- user.getUsername(); user.getUserrole() -->
			<td><c:out value="${sports.sportId}"></c:out></td> 
			<td><c:out value="${sports.sportName}"></c:out></td>  
			
			
			<td>
			<a href="<%=request.getContextPath()%>/AdminServlet/deleteSport?sportName=${sports.sportName}">delete</a>
			</td>

			</tr>
		</c:forEach>
		
	</table>
</body>
</html>