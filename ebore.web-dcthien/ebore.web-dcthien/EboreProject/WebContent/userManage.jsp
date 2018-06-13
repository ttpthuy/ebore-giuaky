<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="ebore.dao.UserDAO" %>
    <%@ page import="ebore.model.User" %>
    <%@ page import="java.util.*" %>
    <%@ page import="java.util.Map" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <link type="text/css" rel="stylesheet" href="css/style.css"> -->
<link type="text/css" rel="stylesheet" href="css/admintest.css">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>User Management</title>
</head>
<body>
	<header> <jsp:include page="menuAdmin.jsp" /> </header>
	<main>
	<div class="wrapper">
		<div class="grid">
			<div class="mana">

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
											
										</tr>
									</thead>
									
										<%
										Collection list = UserDAO.mapUser.values();
										Iterator<User> itr = list.iterator();
										while (itr.hasNext()) {
											
											User p = itr.next();
									%>
									
									<tbody>
										<tr>
										<td> <%=p.getUsername().trim() %></td>
										<td> <%=p.getPass().trim() %></td>
										<td>
											<form action="deleteUser" method="post">
											<input type="hidden" name="customerID"
											value=<%=p.getUsername().trim()%>>
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
	</div>
	</div>
	</div>
	</main>
										
	
</body>
</html>