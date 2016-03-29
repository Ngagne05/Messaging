<%@page import="java.util.List"%>
<%@page import="com.message.entity.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>

<head>
	<meta charset="UTF-8">
<link href="../jsp/searchContact.css" type="text/css" rel="stylesheet" />
<title>Search Contact</title>
</head>

<body>
	<div id="header">
		<div id="menu">
		<a href="../logout">LogOut</a>  <a href="profile"><%=session.getAttribute("username") %></a>  <a href="contact.html">Contact</a> <a href="home">Home</a>
		</div>
	</div>
	<div id="body">
	<p>you must type correctly the user's username you want to add.<br>
	pay attention about  capital letters and the lower letters.<p>
	<div id="search"> 
	
		<form method="post">
		<tr>
			<td><p>Search Contact</p></td>
			
			<td> <input type="text" name="searchedContact" required/> </td><br>
			<td><td align="right"><input type="submit" value="Go" /></td>
		</tr>
		</form>
	</div>
	<div id="tab">
		<tr>		
			<%List<User> listContact=((User)session.getAttribute("user")).getContacts();
			boolean alreadyAdded=false;
			if(listContact!=null)
			for(User c:listContact)			
				if(c.getUsername().equals(session.getAttribute("contactName")))
					alreadyAdded=true;
			if(alreadyAdded)
			{%>
				<td><%=session.getAttribute("contactName") %><td>
				<td>already added</td>
			<% }
			else{%>
				<form action="addContact" method="post">
					<td><label> <%=session.getAttribute("contactName") %></label></td>
					<td><input  type="submit" value="Add"/></td>
				</form>
		<%}%>
		</tr>
		

	</div>

</div> <!--fin body-->
<div id="right" >
            <p> Copyright © 2014 All Rights Reserved.</p>
        </div>
</body>

</html>