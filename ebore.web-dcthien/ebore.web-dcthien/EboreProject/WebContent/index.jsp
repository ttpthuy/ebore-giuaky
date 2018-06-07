<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>EBORE | TTNT</title>
	<link type="text/css" rel="stylesheet" href="css/index.css">
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
<main>
            <div class="wrapper">
                <div class="grid">
                    <div class="menuIndex">
                        <nav class="menu">
                            <ul>
                                <li class="logo">
                                    <a href="#">
                                        EBORE
                                    </a>
                                </li>
                                <li class="about">
                                    <a href="#">
                                        ABOUT ME
                                    </a>
                                </li>
                            </ul>
                        </nav>
                    </div>
                    <div class="decorIndex">
                        <div class="title">
                            <h3>EBORE</h3>
                            <h2>...Let the imagination<br> fly away...</h2>
                        </div>
                    </div>
                    <div class="loginIndex">
                        <div class="form">
                            <h2>LOGIN</h2>
                            <form action="LoginHandling" method="POST" class="loginForm">
                                <div class="form-content">
                                <%
                                	String error = (String) request.getAttribute("errorMessage");
                                	if (error == null) error = "";
                                %>
                                    <p style="color: red"><i><%=error %></i></p>
                                    <input type="text" name="username" placeholder="Username">
                                    <input type="password" name="password" placeholder="Password">
                                    <p class="fpw">
                                        <a href="#">Forgot password</a>
                                    </p>
                                    <p class="newacc">
                                        <a href="#">Haven't, new account ?!</a>
                                    </p>
                                </div>
                                <div class="form-submit">  
                                    <button type="submit">LOGIN</button>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="blank">

                    </div>
                </div>
            </div>
        </main>
</body>
</html>