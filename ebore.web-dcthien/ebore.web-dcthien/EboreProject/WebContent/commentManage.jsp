<%@page import="java.text.DateFormat"%>
<%@page import="ebore.model.CommentList"%>
<%@page import="ebore.model.Comment"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADMIN | EBORE</title>
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
				<div class="dataTable_wrapper">
					<div id="dataTables-example_wrapper"
						class="dataTables_wrapper form-inline dt-bootstrap no-footer">
						<div class="row">
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
												style="width: 42px;">COMMENT ID</th>
											<th class="sorting" tabindex="0"
												aria-controls="dataTables-example" rowspan="1" colspan="1"
												aria-label="Mã sách: activate to sort column ascending"
												style="width: 96px;">USERNAME</th>
											<th class="sorting" tabindex="0"
												aria-controls="dataTables-example" rowspan="1" colspan="1"
												aria-label="Tên sách: activate to sort column ascending"
												style="width: 452px;">CONTENT</th>
											<th class="sorting" tabindex="0"
												aria-controls="dataTables-example" rowspan="1" colspan="1"
												aria-label="Giá sách: activate to sort column ascending"
												style="width: 96px;">POSTDATE</th>
											<th class="sorting" tabindex="0"
												aria-controls="dataTables-example" rowspan="1" colspan="1"
												aria-label="Tác Giả: activate to sort column ascending"
												style="width: 21px;">DELETE</th>
										</tr>
									</thead>
									<tbody>
										<%
											List<Comment> list = CommentList.getAllComment();
											DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, request.getLocale());
											for (Comment comment : list) {
										%>
										<tr class="gradeX odd" role="row">
											<td class="sorting_1">
												<a href="CommentDetail.jsp?commentID=<%=comment.getCommentID() %>">
													<%=comment.getCommentID()%>
												</a>
											</td>
											<td><%=comment.getUsername().trim()%></td>
											<td style="word-wrap: break-word; height: 90px"><%=comment.getContent().trim()%></td>
											<td class="center"><%=dateFormat.format(comment.getPostDate())%></td>
											<td class="center">
												<form action="DeleteCommentController" method="post">
													<p data-placement="top" data-toggle="tooltip"
														title="Delete">
														<input type="hidden" name="commentId"
															value="<%=comment.getCommentID()%>">
														<button class="btn btn-danger btn-xs" data-title="Delete"
															data-toggle="modal" data-target="#delete">
															<span class="glyphicon glyphicon-trash"></span>
														</button>
													</p>
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
					</div>
				</div>
			</div>
		</div>
	</div>
	</main>
</body>
</html>