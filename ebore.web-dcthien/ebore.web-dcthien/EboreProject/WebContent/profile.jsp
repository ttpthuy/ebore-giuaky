<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Profile</title>
<link type="text/css" rel="stylesheet" href="css/profile.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
	<%
		String newName = (String) session.getAttribute("name");
		if (newName == null)
			newName = "null";
	%>
	<main>
	<div class="wrapper">
		<div class="grid">
			<div class="cover">
				<div class="avatar">
					<img class="ava" src="css/img/profile/avatar3.jpg">
				</div>
				<div class="pseudonym">
					<h2><%=newName %></h2>
				</div>
			</div>
			<div class="infor">
				<h2>general information</h2>
				<div class="tabl">
					<table>
						<tr>
							<td>Fullname</td>
							<td><%=newName %></td>
						</tr>
						<tr>
							<td>Living</td>
							<td>Toronto</td>
						</tr>
						<tr>
							<td>Email</td>
							<td>example@gmail.com</td>
						</tr>
					</table>
				</div>
			</div>
			<div class="descript">
				<h2>describe yourself</h2>
				<p>
					&nbsp;&nbsp;Lorem ipsum dolor sit amet, consectetur adipiscing
					elit, sed do eiusmod tempor incididunt ut labore et dolore magna
					aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco
					laboris nisi ut aliquip ex ea commodo consequat.<br>
					<br> &nbsp;&nbsp;Duis aute irure dolor in reprehenderit in
					voluptate velit esse cillum dolore eu fugiat nulla pariatur.
					Excepteur sint occaecat cupidatat non proident, sunt in culpa qui
					officia deserunt mollit anim id est laborum.
				</p>
			</div>
			<div class="file">
				<h3>Your works</h3>
				<div class="work">
					<h3>12</h3>
				</div>
				<h3>Your read list</h3>
				<div class="read">
					<h3>45</h3>
				</div>
				<h3>Folowing</h3>
				<div class="folow">
					<h3>2049</h3>
				</div>
			</div>
		</div>
	</div>
	</main>
</body>
</html>