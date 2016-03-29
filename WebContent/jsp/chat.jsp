<%@page import="com.message.entity.Message"%>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.util.List"%>
<%@page import="com.message.entity.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
	<title>Chat</title>
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
		
	</div>
	<p><mark>Don't forget to select a contact</mark></p>
	<form method="post">
	<div class="rightChat" style="float: right; margin-right: 73px;">
		<div>
			<h3>Contacts</h3>
			<%List<User> listContact=((User)session.getAttribute("user")).getContacts();
			if(listContact!=null)
			for(User c:listContact)
			  {String select1=new String(),select2=new String();
			  	if(c.getUsername().equals(session.getAttribute("selectedContact")))
			  	{select1="mark";select2="</mark>";}
			  	else
			  	{ select1="nimporteKoi";select2="";}
			  %>
			  		<li>			
								
						<a href="chat?selectedContact=<%=c.getUsername()%>" class="listLient">
							<div class="<%=select1 %>">
								<%=c.getUsername()%>
							</div>
						</a>
						<br>
				
					</li>
			<%	}
					%>			
			
		</div>
		
	</div>
	<div class="left">
		<div id="chatHistory" class="historyMessage">
			<%--<textarea id="history" name="history" style="width: 474px; height: 200px; margin-left: 35px; margin-top: 11px;"></textarea>	--%>
			<% List<Message> list=(List<Message>)session.getAttribute("messageHistory");
			SimpleDateFormat dateStandard = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
			String witch1="",witch2="";
			if(list!=null)
				  for(Message m:list){ 
				 	if(!m.getSender().getUsername().equals((String)session.getAttribute("username"))){
					  witch1="<mark>";witch2="</mark>";
					}
					 else{
						 witch1="";witch2="";
					}
			  %>
			  		<%=witch1 %>
			  		<tr class> 			
						<td><%=dateStandard.format(m.getDate()) %></td>
						<td ><strong><%=m.getSender().getUsername()%></strong></td>
						<td><%=m.getTexte()%></td>
					</tr>
					<%=witch2 %>
					<br><br>
			<%	}
					%>	
		</div>
		<div>
			<h4>message</h4>
			
	  		<textarea id="message" name="message" style="width: 474px; height: 100px; margin-left: 35px; margin-top: 11px;" required></textarea>	
			
			
		</div>
		<input type="submit" value="send" style="width: 100px; height: 50px; margin-left: 35px; margin-top: 11px;">
	</div>
	
	</form>
</div>
</body>
<div id="right" >

<p> Copyright © 2014 All Rights Reserved.</p>
</div>
</html>