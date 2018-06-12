<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Giua Ky</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li><a href="#">ABOUT</a></li>
        <li><a href="<%=request.getContextPath()%>/customer.jsp">CUSTOMER</a></li>
        <li><a href="<%=request.getContextPath()%>/product.jsp">PRODUCTS</a></li>
        <li><a href="<%=request.getContextPath()%>/bills.jsp">ORDERS</a></li>
    </ul>
    <a type="button" href="<%=request.getContextPath()%>/giuaky/DatHang.jsp" class="btn btn-danger navbar-btn" > Online Order</a>
    <a type="button" href="<%=request.getContextPath()%>/giuaky/MoTaChucNang.jsp" class="btn btn-info navbar-btn" > Description</a>
  </div>
</nav>


</body>
</html>
