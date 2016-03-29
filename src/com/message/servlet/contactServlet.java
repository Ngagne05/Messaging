package com.message.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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

/**
 * Servlet implementation class contactServlet
 */
@WebServlet("/contact")
public class contactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public contactServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath()+"/contact.html");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Message m= new Message();
		HttpSession s=request.getSession();
		User contact=DaoFactory.getUserDao().retrieveUser("admin");
		if(contact==null)											//pour que le programme ne crash pas si on change de base de donneées ou qu'on la vide		
		{
			User c=new User();
			c.setUsername("admin");
			c.setPassword("admin");									//l'admin pourra mosifier son mot de pass s'il veut
			DaoFactory.getUserDao().storeUser(c);
			contact=DaoFactory.getUserDao().retrieveUser("admin");
		}
		m.setTexte(request.getParameter("message"));	
		
			m.setReceiver(contact);	
		
			 // Récupére la date du jour
				Calendar calendrier = Calendar.getInstance();
				java.util.Date date = calendrier.getTime();					
			m.setDate(date);
			
			DaoFactory.getMessageDao().storeMessage(m);					
		
			PrintWriter out=response.getWriter();
			out.println(contact.getUsername());
			out.print(contact.getId());
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		
	}

}
