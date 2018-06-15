<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="ebore.model.NovelList"%>
<%@page import="java.util.List"%>
<%@page import="ebore.model.Novel"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="ebore.dao.NovelDao"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>ADMIN | EBORE</title>
<!-- <link type="text/css" rel="stylesheet" href="css/style.css"> -->
<link type="text/css" rel="stylesheet" href="css/admin.css">
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
				<!-- E  D  I  T  
				     H  E  R  E -->

				<div class="dataTable_wrapper">
					<div id="dataTables-example_wrapper"
						class="dataTables_wrapper form-inline dt-bootstrap no-footer">
						<div class="row">
							<div class="col-sm-3">
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
							<div class="col-sm-3">
								<div id="dataTables-example_filter" class="dataTables_filter">
									<button>
										<a href="addNovel.jsp">THÊM SÁCH</a>
									</button>
								</div>
							</div>

							<div class="col-sm-3">
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

											<th class="sorting" tabindex="0"
												aria-controls="dataTables-example" rowspan="1" colspan="1"
												aria-label="Mã sách: activate to sort column ascending"
												style="width: 150px;">ID STORY</th>
											<th class="sorting" tabindex="0"
												aria-controls="dataTables-example" rowspan="1" colspan="1"
												aria-label="Tên sách: activate to sort column ascending"
												style="width: 277px;">TITLE</th>
											<th class="sorting" tabindex="0"
												aria-controls="dataTables-example" rowspan="1" colspan="1"
												aria-label="Giá sách: activate to sort column ascending"
												style="width: 156px;">PRICE</th>
											<th class="sorting" tabindex="0"
												aria-controls="dataTables-example" rowspan="1" colspan="1"
												aria-label="Tác Giả: activate to sort column ascending"
												style="width: 141px;">TYPE</th>
											<th class="sorting" tabindex="0"
												aria-controls="dataTables-example" rowspan="1" colspan="1"
												aria-label="Tác Giả: activate to sort column ascending"
												style="width: 141px;">AUTHOR</th>
											<th class="sorting" tabindex="0"
												aria-controls="dataTables-example" rowspan="1" colspan="1"
												aria-label="Tác Giả: activate to sort column ascending"
												style="width: 141px;">LANGUAGE</th>
											<th class="sorting" tabindex="0"
												aria-controls="dataTables-example" rowspan="1" colspan="1"
												aria-label="Tác Giả: activate to sort column ascending"
												style="width: 141px;">DESCRIPTION</th>
											<th class="sorting" tabindex="0"
												aria-controls="dataTables-example" rowspan="1" colspan="1"
												aria-label="Tác Giả: activate to sort column ascending"
												style="width: 141px;">SCONTENT</th>
											<!-- 											<th class="sorting" tabindex="0" -->
											<!-- 												aria-controls="dataTables-example" rowspan="1" colspan="1" -->
											<!-- 												aria-label="Tác Giả: activate to sort column ascending" -->
											<!-- 												style="width: 141px;">Sửa</th> -->
											<!-- 											<th class="sorting" tabindex="0" -->
											<!-- 												aria-controls="dataTables-example" rowspan="1" colspan="1" -->
											<!-- 												aria-label="Tác Giả: activate to sort column ascending" -->
											<!-- 												style="width: 141px;">Xóa</th> -->
										</tr>
									</thead>
									<tbody>
										<%
											List<Novel> list = NovelList.getAllNovel();
											for (Novel n : list) {
										%>

										<tr class="gradeX odd" role="row">
											<td><%=n.getNovelCode()%></td>
											<td><%=n.getNovelName()%></td>
											<td><%=n.getNovelPrice()%></td>
											<td><%=n.getNovelType()%></td>
											<td><%=n.getNovelAuthor()%></td>
											<td><%=n.getNovelLanguage()%></td>
											<td><%=n.getNovelDescription()%></td>
											<td><%=n.getNovelScontent()%></td>

											<!-- 											<td class="center"> -->
											<!-- 												<div id="dataTables-example_filter" -->
											<!-- 													class="dataTables_filter"> -->
											<!-- 													<button> -->
											<!-- 														<a href="editNovel.jsp">SỬA</a> -->
											<!-- 													</button> -->
											<!-- 												</div> -->
											<!-- 											</td> -->
											<td class="center">
												<form action="DeleteNovel" method="post">
													<input type="hidden" name="novelCode"
														value=<%=n.getNovelCode()%>> <input type="submit"
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