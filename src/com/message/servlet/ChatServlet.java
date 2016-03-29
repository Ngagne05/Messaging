package com.message.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.message.dao.DaoFactory;
import com.message.entity.Message;
import com.message.entity.User;


@WebServlet("/auth/chat")
public class ChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private User Contact;
    public ChatServlet() {
        super();
        
    }	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contactname=request.getParameter("selectedContact");
		HttpSession s=request.getSession();
		
		if(contactname!=null)
		{
			Contact=DaoFactory.getUserDao().retrieveUser(contactname);
			
			List<Message> messageHistory=DaoFactory.getMessageDao().retrieveHistoryMessage((User) s.getAttribute("user"), Contact);
			s.setAttribute("selectedContact", contactname);
			s.setAttribute("messageHistory", messageHistory);
		}
		else{
			s.removeAttribute("selectedContact");	
			s.removeAttribute("messageHistory");
			
		}
		request.getRequestDispatcher("../jsp/chat.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Message m= new Message();
		HttpSession s=request.getSession();
		String contactname=(String)s.getAttribute("selectedContact");
		m.setTexte(request.getParameter("message"));
		
				
		m.setSender((User) s.getAttribute("user"));
		Contact=DaoFactory.getUserDao().retrieveUser(contactname);
		if(Contact!=null)
		{
			m.setReceiver(Contact);			
			 // Récupére la date du jour
				Calendar calendrier = Calendar.getInstance();
				java.util.Date date = calendrier.getTime();					
			m.setDate(date);
			
			DaoFactory.getMessageDao().storeMessage(m);
						
			List<Message> messageHistory=DaoFactory.getMessageDao().retrieveHistoryMessage((User) s.getAttribute("user"), Contact);
		
			s.setAttribute("messageHistory", messageHistory);
			request.getRequestDispatcher("../jsp/chat.jsp").forward(request, response);
		}
		else{
			request.getRequestDispatcher("../jsp/chat.jsp").forward(request, response);
		}
	}
	
}
