<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.Cart" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Your Cart</title>
</head>
<body>
<table>
	<th>Quantity</th>
	<th>Name</th>
	<th>Price</th>
	<th> </th>
	<% Cart cart = (Cart) session.getAttribute("cart");
		for(int i = 0; i < cart.getItems().size(); i ++ ) {%>	
		<tr>
		<td> 
			<form action="update" method="post">
				<input type="hidden" name = "productCode" value = <%=cart.getItems().get(i).getProduct().getProductCode() %>>
				<input type="text" name = "updatequantity" value=<%=cart.getItems().get(i).getQuantity() %>>
				<input type="submit" value="Update">
			</form>
		</td>
		
		<td> <%= cart.getItems().get(i).getProduct().getProductName() %></td>
		<td> <%= cart.getItems().get(i).getProduct().getProductPrice() %></td>
		<td>
			<form action="RemoveItem" method="post">
				<input type="hidden" name = "productCode" value = <%=cart.getItems().get(i).getProduct().getProductCode() %>>
				<input type="hidden" name = "quantity" value = <%=cart.getItems().get(i).getQuantity() %>>
				<input type="submit" value="Remove Item">
				</form>
		</td>
		<%} %>
		</tr>
		<td>
		<form action="products.jsp"  method="post">
		<input type="hidden" name ="action" value="shop">
		<input type="submit" value = "Continue Shoping">	
		</form>
		</td>
		<td>		
		<form action="checkout" method="post">
		<input type="hidden" name ="action" value="checkout">
		<input type="submit" value = "Check Out">	
		
		</form>
		</td>
		</table>
</body>
</html>