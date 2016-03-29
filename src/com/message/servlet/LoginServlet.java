package com.message.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.message.dao.DaoFactory;
import com.message.entity.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession s;
    
    public LoginServlet() {
        super();
        
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		s=request.getSession();
		s.setAttribute("incorectInput","");
		if(s.getAttribute("username")==null)
			request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
		else
			response.sendRedirect(request.getContextPath()+"/auth/home");
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//check if the user exist in the data base and if the input password is his or hers
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		s=request.getSession();
		
		if (DaoFactory.getUserDao().isAuthenticated(username, password)) {
			//redirect to the home page	
		
			s.setAttribute("username", username);
		
			response.sendRedirect(request.getContextPath()+"/auth/home");
		}
		else {
			 s=request.getSession();
			s.setAttribute("incorectInput","incorrect login or password.please try again");
			
			request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
			
		}
	}

}
