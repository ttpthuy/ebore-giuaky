<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.User" %>
    <%@ page import="dao.CustomerDAO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Customer</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<jsp:include page="menu/menu.jsp"></jsp:include>
<body>
<% 
	User user = (User) request.getAttribute("user");
	
	%>
	<div class="container">
<h2> Edit Product</h2>
  <form action="editCustomer" method="post">
  <input type="hidden" name="customerID" value="<%= user.getCusId()%>" >
    <div class="form-group">
      <label>Customer ID :</label>
      <input type="text" class="form-control"  value="<%=user.getCusId() %>" name="editCID">
    </div>
    <div class="form-group">
      <label>Customer Account: </label>
      <input type="text" class="form-control"  value="<%=user.getCusAcc() %>" name="editCU" >
    </div>
     <div class="form-group">
      <label>Customer Tel: </label>
      <input type="text" class="form-control" value="<%=user.getCusTel() %>" name="editCT" >
    </div>
     <div class="form-group">
      <label>Customer Name: </label>
      <input type="text" class="form-control"  value="<%=user.getCusName() %>" name="editCN" >
    </div>
    <input type="submit" class="btn btn-default" value="Edit">
  </form>
</div>

</body>
</html>