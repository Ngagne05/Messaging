package com.message.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.message.dao.DaoFactory;
import com.message.entity.User;


@WebServlet("/auth/searchContact")
public class searchContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public searchContactServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s=request.getSession();
		s.setAttribute("contact", "");
		request.getRequestDispatcher("../jsp/searchContact.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchedContact=request.getParameter("searchedContact");
		User contact=DaoFactory.getUserDao().retrieveUser(searchedContact);
		HttpSession s=request.getSession();
		if(contact==null)
		{
			s.setAttribute("contactName",null);;
			request.getRequestDispatcher("../jsp/searchContact.jsp").forward(request, response);
		}
		else
		{
			s.setAttribute("contact", contact);
			s.setAttribute("contactName", contact.getUsername());			
			request.getRequestDispatcher("../jsp/searchContact.jsp").forward(request, response);
		}
	}

}
