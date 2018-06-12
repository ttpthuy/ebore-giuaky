<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.Order" %>
    <%@ page import="dao.OrderDAO" %>
    <%@ page import="dao.DAOProduct" %>
    <%@ page import="dao.CustomerDAO" %>
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
  </script>
</head>
<body>
<jsp:include page="menu/menu.jsp"></jsp:include>
	

      
<% 
	Order order = (Order) request.getAttribute("order");
	%>
	<div class="container">
<h2> Edit Order</h2>
  <form action="editOrder" method="post">
  <input type="hidden" name="orderID" value="<%= order.getId()%>">
  <input type="hidden" name="orderPID" value="<%= order.getProid()%>">
    <div class="form-group">
      <label>Order ID :</label>
      <input type="text" class="form-control"  value="<%=order.getId() %>" name="editOID">
    </div>
 <!--    <div class="form-group">
      <label>Customer Id: </label>
      <input type="text" class="form-control"  value="<%=order.getCusid() %>" name="editOCID" >
    </div>
     <div class="form-group">
      <label>ProductID: </label>
      <input type="text" class="form-control" value="<%=order.getProid() %>" name="editOPID" >
    </div> -->
      <div class="form-group">
      <label>Customer ID: </label>
      <select class="form-control"   name="editOCID">
      <% ArrayList<String> list = CustomerDAO.getCustomerID(); 
      	for(int i = 0; i < list.size(); i++){
      %>
      	<option> <%=list.get(i) %></option> 
     <%} %>
      </select>
    </div>
    
    <div class="form-group">
      <label>Product ID: </label>
      <select class="form-control"   name="editOPID">
      <% ArrayList<String> listProduct = DAOProduct.getProductID(); 
      	for(int i = 0; i < listProduct.size(); i++){
      %>
      	<option> <%=listProduct.get(i) %></option> 
     <%} %>
      </select>
    </div>
     <div class="form-group">
      <label>Quantity: </label>
      <input type="text" class="form-control"  value="<%=order.getQuantity() %>" name="editOQ" >
    </div>
    <p>Date: <input type="text" id="datepicker" name= "editOD"></p>
    <input type="submit" class="btn btn-default" value="Edit">
  </form>
</div>

</body>
</html>