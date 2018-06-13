<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="ebore.dao.ConnectSql"%>
<%@page import="ebore.dao.OrderDAO"%>
<%@page import=" java.util.Map"%>
<%@page import="ebore.model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
	Map<String, Order> mapListOrder = OrderDAO.mapOrder;
%>

<html>



<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ADMIN | EBORE</title>
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
												aria-label="idOrther: activate to sort column descending"
												style="width: 96px;">ID Orther</th>
											<th class="sorting" tabindex="0"
												aria-controls="dataTables-example" rowspan="1" colspan="1"
												aria-label="idStory: activate to sort column ascending"
												style="width: 150px;">ID Story</th>
											<th class="sorting" tabindex="0"
												aria-controls="dataTables-example" rowspan="1" colspan="1"
												aria-label="idUser: activate to sort column ascending"
												style="width: 277px;">ID User</th>
											<th class="sorting" tabindex="0"
												aria-controls="dataTables-example" rowspan="1" colspan="1"
												aria-label="Date: activate to sort column ascending"
												style="width: 156px;">Date</th>
											<th class="sorting" tabindex="0"
												aria-controls="dataTables-example" rowspan="1" colspan="1"
												aria-label="delete: activate to sort column ascending"
												style="width: 141px;">Delete</th>
											<th class="sorting" tabindex="0"
												aria-controls="dataTables-example" rowspan="1" colspan="1"
												aria-label="edit: activate to sort column ascending"
												style="width: 141px;">Edit</th>
										</tr>
									</thead>
									<tbody>
								<%
								List<Order> list = OrderList.getAllOrder();
								for(Order order : list){
								%>
										<tr>
											<td><%=order.getIdOrder().trim()%></td>
											<td><%=order.getIdStory().trim()%></td>
											<td><%=order.getIdUser().trim()%></td>
											<td><%=order.getDate()%></td>

<!--											<td><a href="DeleteOrder">
													<button type="button" class="btn btn-sm btn-danger" id=""
														aria-label="Right Align">
														<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
													</button>
											</a></td>
-->	
											
											<td>
												<form action="DeleteOrder" method="post">
													<p data-placement="top" data-toggle="tooltip"
														title="Delete">
														<input type="hidden" name="orderId"
															value="<%=order.getIdOrder()%>">
														<button class="btn btn-danger btn-xs" data-title="Delete"
															data-toggle="modal" data-target="#delete">
															<span class="glyphicon glyphicon-trash"></span>
														</button>
													</p>
												</form>
											</td>
											
											
											
											<td><a href=#><button type="button"
														class="btn  btn-sm btn-warning" aria-label="Right Align">
														<span class="glyphicon glyphicon-edit"></span>
													</button></a></td>
										</tr>

										<%
											}
										%>

									</tbody>
								</table>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6">
								<div class="dataTables_info" id="dataTables-example_info"
									role="status" aria-live="polite">Showing 1 to 10 of 60
									entries</div>
							</div>
							<div class="col-sm-6">
								<div class="dataTables_paginate paging_simple_numbers"
									id="dataTables-example_paginate">
									<ul class="pagination">
										<li class="paginate_button previous disabled"
											aria-controls="dataTables-example" tabindex="0"
											id="dataTables-example_previous"><a href="#">Previous</a>
										</li>
										<li class="paginate_button active"
											aria-controls="dataTables-example" tabindex="0"><a
											href="#">1</a></li>
										<li class="paginate_button "
											aria-controls="dataTables-example" tabindex="0"><a
											href="#">2</a></li>
										<li class="paginate_button "
											aria-controls="dataTables-example" tabindex="0"><a
											href="#">3</a></li>
										<li class="paginate_button next"
											aria-controls="dataTables-example" tabindex="0"
											id="dataTables-example_next"><a href="#">Next</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- COPY -->

			</div>

			<!-- database -->

			<div class="intro"></div>

		</div>
	</div>
	</main>
</body>
</html>