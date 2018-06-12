<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mo ta bai toan</title>
  <script src="https://cdn.ckeditor.com/4.9.2/standard/ckeditor.js"></script>
</head>
<body>
	<jsp:include page="../menu/menu.jsp"></jsp:include>
	
	<div>
	<textarea name="editor1"></textarea>
		<script>
			CKEDITOR.replace( 'editor1' );
		</script>
</div>


</body>
</html>