<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="ebore.dao.UserDAO" %>
    <%@ page import="ebore.model.User" %>
    <%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/buttons/1.5.1/css/buttons.dataTables.min.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.16/datatables.min.css"/>
 
<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.16/datatables.min.js"></script>
<title>User Management</title>
</head>
<body>
	
	<!-- MENU  -->
	<div class="wrapper">
		<div class="grid">
			<div class="dashboard">
				<div class="ava">
					<img src="css/img/profile/avatar3.jpg">
					<h3>Username Admin</h3>
				</div>
				<div class="overview">
					<h4>Overview</h4>
				</div>
				<div class="userMag">
					<h4>User management</h4>
				</div>
				<div class="authorMag">
					<h4>Author management</h4>
				</div>
				<div class="novelMag">
					<h4>Novel management</h4>
				</div>
			</div>
			<div class="header">
				<ul>
					<li class="dn">Dashname</li>
					<li class="btn">LOGOUT</li>
				</ul>
			</div>
			<div class="tool">
				<ul>
					<li>Button1</li>
					<li>Button2</li>
				</ul>
			</div>
			</div>
			</div>
			
			
	<!-- COPY -->
				<div class="dataTable_wrapper">
					<div id="dataTables-example_wrapper"
						class="dataTables_wrapper form-inline dt-bootstrap no-footer">
						<div class="row">
							<div class="col-sm-6">
								<div class="dataTables_length" id="dataTables-example_length">
									<label>Show <select name="dataTables-example_length"
										aria-controls="dataTables-example"
										class="form-control input-sm">
											<option value="10">10</option>
											<option value="25">25</option>
											<option value="50">50</option>
											<option value="100">100</option>
									</select> entries
									</label>
								</div>
							</div>
							<div class="col-sm-6">
								<div id="dataTables-example_filter" class="dataTables_filter">
									<label>Search: <input type="search"
										class="form-control input-sm" placeholder=""
										aria-controls="dataTables-example">
									</label>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12">
								<table
									class="table table-striped table-bordered table-hover dataTable no-footer"
									id="dataTables-example" role="grid"
									aria-describedby="dataTables-example_info">
									<thead>
										<tr role="row">
											<th class="sorting_asc" tabindex="0"
												aria-controls="dataTables-example" rowspan="1" colspan="1"
												aria-sort="ascending"
												aria-label="STT: activate to sort column descending"
												style="width: 96px;">username</th>
											<th class="sorting" tabindex="0"
												aria-controls="dataTables-example" rowspan="1" colspan="1"
												aria-label="Mã sách: activate to sort column ascending"
												style="width: 150px;">pass</th>
											<th class="sorting" tabindex="0"
												aria-controls="dataTables-example" rowspan="1" colspan="1"
												aria-label="Mã sách: activate to sort column ascending"
												style="width: 150px;">pass</th>
											<th class="sorting" tabindex="0"
												aria-controls="dataTables-example" rowspan="1" colspan="1"
												aria-label="Mã sách: activate to sort column ascending"
												style="width: 150px;">pass</th>
											
										</tr>
									</thead>
									<%
										List<User> list = UserDAO.list;
									for(int i = 0; i < list.size(); i++){
									
									%>
									<tbody>
										<tr>
										<td> <%=list.get(i).getUsername() %></td>
										<td> <%=list.get(i).getPass() %></td>
										
										<td>
				<form action="editUser" method="get">
					<input type="hidden" name="customerID"	value=<%=list.get(i).getUsername()%>>
			 	 	<input type="submit" class ="btn btn-primary"  value="Edit">   
			 	<!--  	<a href="/products" class="btn btn-primary" type="submit">Edit </a>-->
				</form>
		
			</td>
			<td>
			<form action="deleteUser" method="post">
					<input type="hidden" name="customerID"
						value=<%=list.get(i).getUsername()%>>
					<input type="submit" class ="btn btn-danger"  value="Delete">   
				</form>
			</td>
									
									</tr>	
									<%} %>
									
									
									</tbody>
									</table>
									</div>
									</div>
									</div>
									</div>
									
			
	
</body>
</html>