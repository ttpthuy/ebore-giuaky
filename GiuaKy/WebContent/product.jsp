<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="dao.DAOProduct"%>
<%@ page import="java.util.*"%>
<%@ page import="model.Product"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="menu/menu.jsp"></jsp:include> 
<div class="container">
  <input class="form-control" id="myInput" type="text" placeholder="Search..">
  <br>
  <table class="table table-bordered table-striped">
   <thead>
				<tr>
					<th>Product Name</th>
					<th>Product Price</th>
					<th>Producer</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>
			<%
				Collection list = DAOProduct.mapProduct.values();
				Iterator<Product> itr = list.iterator();
				while (itr.hasNext()) {
					Product p = itr.next();
			%>
			<tbody id="myTable">
				<tr>
					<td><%=p.getProductName()%></td>
					<td><%=p.getProductPrice()%></td>
					<td><%=p.getProducerID()%></td>
					<td>
						<form action="editProduct" method="get">
							<input type="hidden" name="productCode"
								value=<%=p.getProductCode()%>> <input type="submit"
								class="btn btn-primary" value="Edit">
							<!--  	<a href="/products" class="btn btn-primary" type="submit">Edit </a>-->
						</form>

					</td>
					<td>
						<form action="deleteProduct" method="post">
							<input type="hidden" name="productCode"
								value=<%=p.getProductCode()%>> <input type="submit"
								class="btn btn-danger" value="Delete">
						</form>
					</td>
				</tr>
			<%
				}
			%>
			
			</tbody>
  </table>
  
</div>
		<div>
			<a href="addProduct.jsp" type="button" class="btn btn-success">
				Add Product</a>
		</div>
		<div>
			<form action="deleteAllProduct">
				<input type="hidden" name="action" value="deleteAll"> <a
					href="" type="button" class="btn btn-success"> Delete All</a>
			</form>
		</div>

<script>
$(document).ready(function(){
  $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#myTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});
</script>

</body>
</html>