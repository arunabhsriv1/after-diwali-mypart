<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Welcome,   <a href="<%=request.getContextPath()%>/logout.jsp">Logout</a><br>
<form method="post" action="<%=request.getContextPath()%>/AdminServlet/addManager">
		Username: <input type="text" name="username"> <br>
		Password: <input type="password" name="password"> <br>
		Role: <input type="text" name="role" value="manager" readonly="readonly"> <br> 
		Address: <input type="text" name="address"> <br> 
		Phone: <input type="text" name="phone"> <br> 
		Email: <input type="email" name="email"> <br> 
		
		
		<input type="submit" value="Add Manager">
	</form>
</body>
</html>