<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
												style="width: 96px;">STT</th>
											<th class="sorting" tabindex="0"
												aria-controls="dataTables-example" rowspan="1" colspan="1"
												aria-label="Mã sách: activate to sort column ascending"
												style="width: 150px;">Mã sách</th>
											<th class="sorting" tabindex="0"
												aria-controls="dataTables-example" rowspan="1" colspan="1"
												aria-label="Tên sách: activate to sort column ascending"
												style="width: 277px;">Tên sách</th>
											<th class="sorting" tabindex="0"
												aria-controls="dataTables-example" rowspan="1" colspan="1"
												aria-label="Giá sách: activate to sort column ascending"
												style="width: 156px;">Giá sách</th>
											<th class="sorting" tabindex="0"
												aria-controls="dataTables-example" rowspan="1" colspan="1"
												aria-label="Tác Giả: activate to sort column ascending"
												style="width: 141px;">Tác Giả</th>
										</tr>
									</thead>
									<tbody>

										<tr class="gradeX odd" role="row">
											<td class="sorting_1">1</td>
											<td>s1</td>
											<td>Tuổi trẻ đáng giá bao</td>
											<td class="center">70000</td>
											<td class="center">B</td>
										</tr>
										<tr class="gradeA even" role="row">
											<td class="sorting_1">2</td>
											<td>s3</td>
											<td>Trở về nơi hoang dã</td>
											<td class="center">60000</td>
											<td class="center">A</td>
										</tr>
										<tr class="gradeA odd" role="row">
											<td class="sorting_1">3</td>
											<td>s4</td>
											<td>Có phải anh</td>
											<td class="center">60000</td>
											<td class="center">A</td>
										</tr>
										<tr class="gradeC even" role="row">
											<td class="sorting_1">4</td>
											<td>s2</td>
											<td>Đời mưa gió</td>
											<td class="center">40000</td>
											<td class="center">C</td>
										</tr>
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
</body>
</html>