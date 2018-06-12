<%@page import="dao.DAOProduct"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="dao.OrderDAO" %>
    <%@ page import="java.util.*" %>
    <%@ page import="model.Order" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Bills</title>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/buttons/1.5.1/css/buttons.dataTables.min.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.16/datatables.min.css"/>
 
<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.16/datatables.min.js"></script>
</head>
<body>
<jsp:include page="/menu/menu.jsp"></jsp:include>

<div class="container">
	<table id="example" class="display nowrap" style="width:100%">
	<thead>
	<tr>
		<th> Order Id </th>
		<th>  Order Customer </th>
		<th> Order Product Id </th>
		<th> Quantity </th>
		<th> Total </th>
		<th> Date </th>
		<th> Edit </th>
		<th> Delete </th>
	</tr>
	</thead>
		<%
		List<Order> list = OrderDAO.mapOrder;
		Iterator<Order> itr = list.iterator();
		while (itr.hasNext()) {
			Order o = itr.next();
		%>
		<tbody>
	<tr>
			<td> <%= o.getId() %></td>
			<td> <%= o.getCusid() %></td>
			<td> <%= o.getProid() %></td>
			<td> <%= o.getQuantity() %></td>
		 	<td> <%= DAOProduct.lookUp(o.getProid()).getProductPrice() * o.getQuantity() %></td> 
			<td> <%= o.getDate() %></td>
			<td>
				<form action="editOrder" method="get">
					<input type="hidden" name="orderID"	value=<%=o.getId()%>>
					<input type="hidden" name="orderPID"	value=<%=o.getProid()%>>
			 	 	<input type="submit" class ="btn btn-primary"  value="Edit">   
				</form>
		
			</td>
			<td>
			<form action="deleteOrder" method="post">
					<input type="hidden" name="orderID" value=<%=o.getId()%>>
					<input type="hidden" name="orderPID"	value=<%=o.getProid()%>>
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
	<a href="addOrder.jsp" type="button" class="btn btn-success"> Add More Bill</a>
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