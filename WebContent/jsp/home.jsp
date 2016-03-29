<%@page import="java.util.Collection"%>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.util.List"%>
<%@page import="com.message.entity.Message"%>
<%@page import="com.message.entity.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
<head>
	<title>User's home page</title>
	<link rel="stylesheet" type="text/css" href="../jsp/home.css">
	<meta charset="UTF-8">
</head>
<body>
<div id="body">
	<div id="header">
		<a href="../logout">LogOut</a>
		<a href="profile"><%=session.getAttribute("username") %></a>
		<a href="../contact">Contact</a>
		
		</br>
	</div>

	<div>
		<a href="chat">Send New message</a>
		<a href="searchContact">search contact</a>
	</div>
	 <div class="historyMessage">
	<table>
			<%User u=(User)session.getAttribute("user"); %>
		  <tr>
		    <th>Date</th>
		    <th>Username</th>
		    <th >Message</th>
		  </tr>
		  
		  <%List<Message> m=u.getReceivedMessages();%>
		 
		
			<%  SimpleDateFormat dateStandard = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss"); 
			if(m!=null)
			for(int i=m.size()-1;i>=0;i--){ 
				User sender=m.get(i).getSender();%>
					  	
						<tr>
						    <td><%=dateStandard.format(m.get(i).getDate()) %></td>
						    <td>
							  	<% if(sender!=null){%>
							    	<a href="chat?selectedContact=<%=sender.getUsername() %>" class="listLient"><%=sender.getUsername() %></a>
							    <%}
								  else{%>
								  		anonymous
								  <%} %>
						    </td>
						 <td> <%=m.get(i).getTexte() %></td> 
					    </tr>
				 	
			  <%} %>
			  
	</table>
	</div>
	
</div>
</body>
<div id="right" >

<p> Copyright © 2014 All Rights Reserved.</p>
</div>
</html>