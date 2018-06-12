<%@page import="dao.DAOProduct"%>
<%@page import="dao.CustomerDAO"%>
    <%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add new order here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>
  <script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
  </script>
</head>
<body>
<jsp:include page="menu/menu.jsp"></jsp:include>
	<div class="container">
<h2> Add Order</h2>
  <form action="addOrder" method="post" id="formDemo">
    <div class="form-group">
      <label>Order ID :</label>
      <input type="text" class="form-control"   name="addOID">
    </div>
   <!--  <div class="form-group">
      <label>Order Customer ID: </label>
      <input type="text" class="form-control"  name="addOCID" >
    </div>
     -->
    <div class="form-group">
      <label>Customer ID: </label>
      <select class="form-control"   name="addOCID">
      <% ArrayList<String> list = CustomerDAO.getCustomerID(); 
      	for(int i = 0; i < list.size(); i++){
      %>
      	<option> <%=list.get(i) %></option> 
     <%} %>
      </select>
    </div>
    
    <div class="form-group">
      <label>Product ID: </label>
      <select class="form-control"   name="addOPID">
      <% ArrayList<String> listProduct = DAOProduct.getProductID(); 
      	for(int i = 0; i < listProduct.size(); i++){
      %>
      	<option> <%=listProduct.get(i) %></option> 
     <%} %>
      </select>
    </div>
    
    
   <!--    <div class="form-group">
      <label>Product ID : </label>
      <input type="text" class="form-control"  name="addOPID" >
    </div> -->
    
    
     <div class="form-group">
      <label>Quantity: </label>
      <input type="text" class="form-control"   name="addOQ" >
    </div>
    <div class="form-group">  <p>Date: </p><input type="text" id="datepicker" name= "addOD"> </div>
    <input type="submit" class="btn btn-default" value="Add"> 
  </form>
</div>

 <script type="text/javascript">
 $(document).ready(function() {
 
        //Khi bàn phím được nhấn và thả ra thì sẽ chạy phương thức này
        $("#formDemo").validate({
            rules: {
            	addOID: "required",
            	addOCID: "required",
            	addOPID: "required",
            	addOD: "required",
            	addOQ: {
                    required: true,
                    digits: true
                }
            },
            messages: {
            	addOID: "Order ID is required ",
            	addOCID: "Customer Id is required",
            	addOPID: "Product  is required",
            	addOD: "Order day is required",
            	addOQ: {
                    required: "Order quantity is required and must be a number",
                }
            }
        });
    });
 </script>
</body>
</html>