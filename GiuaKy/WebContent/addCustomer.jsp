<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add new Customer here</title>
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
<h2> Add Customer</h2>
  <form action="addCustomer" method="post" id="formDemo">
    <div class="form-group">
      <label>Customer ID :</label>
      <input type="text" class="form-control"   name="addCID">
    </div>
    <div class="form-group">
      <label>Customer Name: </label>
      <input type="text" class="form-control"  name="addCN" >
    </div>
     <div class="form-group">
      <label>Customer Acc: </label>
      <input type="text" class="form-control"  name="addCA" >
    </div>
     <div class="form-group">
      <label>Customer Pass: </label>
      <input type="password" class="form-control"   name="addCPass" >
    </div>
     <div class="form-group">
      <label>Customer Tell: </label>
      <input type="text" class="form-control"   name="addCT" >
    </div>
    <input type="submit" class="btn btn-default" value="Add"> 
  </form>
</div>

 <script type="text/javascript">
 $(document).ready(function() {
 
        //Khi bàn phím được nhấn và thả ra thì sẽ chạy phương thức này
        $("#formDemo").validate({
            rules: {
            	addCID: "required",
            	addCN: "required",
            	addCPass: "required",
            	addCA: "required",
            },
            messages: {
            	addCID: "Customer ID is required ",
            	addCN: "Customer name is required",
            	addCPass: "Customer pass is required",
            	addCA: "Account is required",
            }
        });
    });
 </script>
</body>
</html>