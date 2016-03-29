<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<title>Register</title>
		<link href="jsp/register.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<fieldset>
			<legend>Register</legend>
			<%=session.getAttribute("registerErrorMessage") %>
			<form method="post"">
			<table>
				<tr>
					<td><label for="username">Username</label></td>
					<td><input type="text" id="username" name="username" required></td>
				</tr>
				<tr>
					<td><label for="password">Password</label></td>
					<td><input type="password" id="password" name="password" required></td>
				</tr>
				<tr>
					<td><label for="password">confirm Password</label></td>
					<td><input type="password" id="password" name="passwordConfirm" required></td>
				</tr>
				
				<tr>
					<td><label for="password">Firstname</label></td>
					<td><input type="text" id="firstname" name="firstname" required></td>
				</tr>
				<tr>
					<td><label for="password">Lastname</label></td>
					<td><input type="text" id="lastname" name="lastname" required></td>
				</tr>
				<tr>
					<td><label for="password">E-mail</label></td>
					<td><input type="text" id="email" name="email" required></td>
				</tr>
				
				<tr>
				</tr>
			</table>
			<input type="submit" value="Submit" onClick="">
			<a href="index.jsp">cancel</a>
			</form>
		</fieldset>	
	</body>
</html>>