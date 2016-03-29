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

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/auth/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
           
    public HomeServlet() {
        super();
        
    }	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("../jsp/home.jsp").forward(request, response);
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession s=request.getSession();
		User u=DaoFactory.getUserDao().retrieveUser((String) s.getAttribute("username"));
		s.setAttribute("user",u);
		
		request.getRequestDispatcher("../jsp/home.jsp").forward(request, response);
	}

}
