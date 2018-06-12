
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>Join our email list</h2>
	<label><i>${message}</i></label>
	<form  action="TestSer" method="get" >
	<input type="hidden" name="action" value="add">
	<label>Email: </label>
	<input type = "text" name="email" value="${user.email}">
	<br>
	
	<label>First Name: </label>
	<input type = "text" name="fN" value="${user.fN }">
	<br>
	
	<label>Last Name: </label>
	<input type = "text" name="lN" value="${user.lN }">
	<br>
	
	<label>Quantity: </label>
	<input type = "text" name="quantity" value ="${user.quantity }">
	<br>
	<input type = "submit" value = "Submit">
	</form>
</body>
</html>