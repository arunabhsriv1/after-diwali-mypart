<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<a href="<%=request.getContextPath()%>/AdminServlet/managerList">Manager Operations</a>
<br>
<a href="<%=request.getContextPath()%>/AdminServlet/sportsList">Sports Operations</a>
<br>
<%-- <a href="<%=request.getContextPath()%>/AdminServlet/showLogs">showLogs</a>
<br> --%>
<a href="<%=request.getContextPath()%>/log/mylog.log">showLogs</a>
<br>
<a href="<%=request.getContextPath()%>/logout.jsp">Logout</a>

</body>
</html>