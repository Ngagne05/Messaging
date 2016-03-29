<%@page import="com.message.dao.DaoFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>

<head>
	<meta charset="UTF-8">
<link href="css/style.css" type="text/css" rel="stylesheet" />
<title>Anonymous Homepage</title>
</head>

<body>
	<%if(session.getAttribute("username")!=null) 
		response.sendRedirect(request.getContextPath()+"/auth/home");
	%>
	<div id="header">
		<div id="menu">
		<a href="login">Login</a>  <a href="register">Register</a>  <a href="contact.html">Contact</a> 
		</div>
	</div>
	<div id="body">
		
		<p>SupMessaging is  the best messaging application its fast, easy to use and secure it responds to all your messaging needs.</p>
		<p>nomber of user:<%=DaoFactory.getUserDao().numberOfUser() %><br>
			number of message sent:<%=DaoFactory.getMessageDao().numberOfMessage() %>
		</p>
		
	<div id="right" >
            <p> Copyright © 2014 All Rights Reserved.</p>
       </div>
</body>


</html>