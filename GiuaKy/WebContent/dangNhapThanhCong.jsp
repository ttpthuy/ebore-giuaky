<%@page import="java.nio.channels.SeekableByteChannel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <% String newName = (String) request.getAttribute("name") ;
	if(newName == null)
		newName= "rong";
%>
	

<h1>Wellcome <%= newName %> to JSP</h1>

<h1>Good bye <%= newName %></h1>
<a href="products.jsp">Our Products </a>
<a href="login.jsp">Log out </a>
</body>
</html>