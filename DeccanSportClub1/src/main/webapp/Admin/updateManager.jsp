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

Hello  , <a href="<%=request.getContextPath()%>/logout.jsp">Logout</a><br>
update manager
<form method="post" action="<%=request.getContextPath()%>/AdminServlet/updateManager" readonly>
		Username: <input type="text" name="username" value="${manager.username}"> <br>
		Password: <input type="text" name="password" value="${manager.password}"> <br>
		Role: <input type="text" name="role" value="${manager.role}"> <br>
		Address: <input type="text" name="address" value="${manager.address}"> <br> 
		Phone: <input type="text" name="phone" value="${manager.phone}"> <br> 
		Email: <input type="text" name="email" value="${manager.email}"> <br> 
		
		 <input	type="submit" value="Update Manager">
	</form>
</body>
</html>