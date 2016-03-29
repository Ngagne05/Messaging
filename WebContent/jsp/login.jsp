<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html dir="ltr" lang="en-US">
	<head>
		<title>Login</title>
		<link rel="stylesheet" href="jsp/login.css" type="text/css" />
	</head>
	<body>
		<div id="formback">
			
			<form  method="post">
			<%=session.getAttribute("incorectInput") %>
				<div class="login">LOGIN</div>
				<div class="username-text">Username:</div>
				<div class="password-text">Password:</div>
				<div class="username-field">
					<input type="text" name="username" required />
				</div>
				<div class="password-field">
					<input type="password" name="password" required/>
				</div>
				<div class="register"><a href="register">Register</a></div>
				<a href="index.jsp">cancel</a>
				<input type="submit" name="submit" value="GO" />
			</form>
		</div>
</body>
</html>