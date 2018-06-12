<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="dao.CustomerDAO" %>
    <%@ page import="java.util.*" %>
    <%@ page import="model.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer</title>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/buttons/1.5.1/css/buttons.dataTables.min.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.16/datatables.min.css"/>
 
<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.16/datatables.min.js"></script>
</head>
</head>
<body>
<jsp:include page="menu/menu.jsp"></jsp:include>
	<div class="container">
	<table id="example" class="display nowrap" style="width:100%">
	<thead>
	<tr>
		<th> Customer Name </th>
		<th>  Customer Acc </th>
		<th> Tel </th>
		<th> Edit </th>
		<th> Delete </th>
	</tr>
	</thead>
		<%
		Collection list = CustomerDAO.mapCustomer.values();
		Iterator<User> itr = list.iterator();
		while (itr.hasNext()) {
			User u = itr.next();
		%>
		
	<tbody>
	<tr>
			<td> <%= u.getCusName() %></td>
			<td> <%= u.getCusAcc() %></td>
			<td> <%= u.getCusTel() %></td>
			<td>
				<form action="editCustomer" method="get">
					<input type="hidden" name="customerID"	value=<%=u.getCusId()%>>
			 	 	<input type="submit" class ="btn btn-primary"  value="Edit">   
			 	<!--  	<a href="/products" class="btn btn-primary" type="submit">Edit </a>-->
				</form>
		
			</td>
			<td>
			<form action="deleteCustomer" method="post">
					<input type="hidden" name="customerID"
						value=<%=u.getCusId()%>>
					<input type="submit" class ="btn btn-danger"  value="Delete">   
				</form>
			</td>
	</tr>
		<%} %>
		</tbody>
	</table>
		
	</div>
<center>
<div>
	<a href="addCustomer.jsp" type="button" class="btn btn-success"> Add More Customer</a>
	</div>
	<div>
	<form action="deleteAllProduct">
	<input type="hidden" name="action" value="deleteAll">
	<a href="" type="button" class="btn btn-success"> Delete All</a>
	</form>
	</div>
	</center>
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.5.1/js/dataTables.buttons.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.5.1/js/buttons.flash.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.32/pdfmake.min.js"></script>

<script type="text/javascript">
    
 $(document).ready(function() {
    $("#example").DataTable();
} );


</script>
</body>
</html>