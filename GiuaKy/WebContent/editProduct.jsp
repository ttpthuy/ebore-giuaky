<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.Product" %>
    <%@ page import="dao.DAOProduct" %>
    <%@ page import="java.util.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Edit Product Here</title>
</head>
<body>
<jsp:include page="menu/menu.jsp"></jsp:include>
	<% 
	Product product = (Product) request.getAttribute("product");
	
	%>
	<div class="container">
<h2> Edit Product</h2>
  <form action="editProduct" method="post">
  <input type="hidden" name="productCode" value="<%= product.getProductCode()%>">
    <div class="form-group">
      <label>Product ID :</label>
      <input type="text" class="form-control"  value="<%=product.getProductCode() %>" name="editPID">
    </div>
    <div class="form-group">
      <label>Product Name: </label>
      <input type="text" class="form-control"  value="<%=product.getProductName() %>" name="editPN" >
    </div>
     <div class="form-group">
      <label>Product Price: </label>
      <input type="text" class="form-control" value="<%=product.getProductPrice() %>" name="editPP" >
    </div>
   <!--   <div class="form-group">
      <label>Producer ID: </label>
      <input type="text" class="form-control"  value="<%=product.getProducerID() %>" name="editProducer" >
    </div>-->
    
    <div class="form-group">
      <label>Producer ID: </label>
      <select class="form-control"   name="editOCID">
      <% ArrayList<String> list = DAOProduct.getProducer(); 
      	for(int i = 0; i < list.size(); i++){
      %>
      	<option> <%=list.get(i) %></option> 
     <%} %>
      </select>
    </div>
    <input type="submit" class="btn btn-default" value="Edit">
  </form>
</div>
	
	
	
</body>
</html>