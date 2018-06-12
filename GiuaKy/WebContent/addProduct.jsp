<%@page import="dao.DAOProduct"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="dao.DatabaseConnection"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>
	 <script type="text/javascript">
 $(document).ready(function() {
 
        //Khi bàn phím được nhấn và thả ra thì sẽ chạy phương thức này
        $("#formDemo").validate({
            rules: {
                addPID: "required",
                addPN: "required",
                addPP: "required",
                addProducer: {
                    required: true
                }
            },
            messages: {
                addPID: "Product ID is required ",
                addPN: "Product name is required",
                addPP: "Product price is required",
                addProducer: {
                    required: "Producer  is required"
                }
            }
        });
    });
 </script>
</head>
<body>
<jsp:include page="menu/menu.jsp"></jsp:include>
	<div class="container">
<h2> Add Product</h2>
 <form action="addProduct" method="post" id="formDemo">
    <div class="form-group">
      <label>Product ID :</label>
      <input type="text" class="form-control"   name="addPID" >
    </div>
    <div class="form-group">
      <label>Product Name: </label>
      <input type="text" class="form-control"  name="addPN" >
    </div>
     <div class="form-group">
      <label>Product Price: </label>
      <input type="text" class="form-control"  name="addPP" >
    </div>
     <div class="form-group">
      
      <label>Producer ID: </label>
      <select class="form-control"   name="addProducer">
      <% ArrayList<String> list = DAOProduct.getProducer(); 
      	for(int i = 0; i < list.size(); i++){
      %>
      	<option> <%=list.get(i) %></option> 
     <%} %>
      </select>
      
    </div>
    
    <input type="submit" class="btn btn-default" value="Add"> 
  </form>
</div>

   
</body>
</html>