<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <a href="<%=request.getContextPath()%>/logout.jsp">Logout</a><br>
<form method="post" action="<%=request.getContextPath()%>/AdminServlet/addSport">
	Enter sport name : <input type="text" name="sportName"> <br>
		
		
		
		<input type="submit" value="Add Sport">
	</form>
</body>
</html>