<%@page import="com.message.entity.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>ProfilePage</title>
	<link rel="stylesheet" href="../jsp/profile.css" type="text/css" />
	<link rel="stylesheet" type="text/css" href="../jsp/home.css">
	<meta charset="UTF-8">
</head>
<body>
<div id="body">
	<div id="header">
		<a href="../logout">LogOut</a>
		<a href="profile"><%=session.getAttribute("username") %></a>
		<a href="../contact">Contact</a>
		<a href="home">Home</a>
		
		</br>
	</div>
	<br><br><br>
	<%User u=(User)session.getAttribute("user"); %>
<form class="profile" style="background-color:#1A2223;font-size:14px;font-family:'Open Sans','Helvetica Neue', 'Helvetica', Arial, Verdana, sans-serif;color:#ECECEC;max-width:480px;min-width:150px;" method="post"><div class="title"><h2>Edit profil</h2></div>
	<div class="element-name">
	<label for="firstname">First name:</label><span class="nameFirst"><input type="text" size="8" id="firstname" name="firstname" value="<%=u.getGivenName() %>"/></span>
	<label for="lastname">Last name:</label><span class="nameLast"><input  type="text" size="14" id="lastname" name="lastname" value="<%=u.getFamilyName()%>"/></span>
	</div>
	<div class="element-email"><label class="title"></label>
	<label for="email"> Email:</label><input class="large" type="email" id="email" name="email" value="<%=u.getEmail() %>" placeholder="Email"/></div>
	<div class="element-password"><label class="title"></label>
	<label for="password">password:</label><input class="large" id="password" type="password" name="password"   required/></div>
<div class="submit"><input type="submit" value="Submit"/></div></form>
	</div>

</body>
<div id="right" >

<p> Copyright © 2014 All Rights Reserved.</p>
</div>
</html>