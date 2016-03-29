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


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;      
   
    public RegisterServlet() {
        super();
        
    }
  
    public void init() throws ServletException {
    	DaoFactory.getUserDao();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("jsp/register.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u=new User();
		String inputUsername=request.getParameter("username");
		String password=request.getParameter("password");
		HttpSession s=request.getSession();
		
		if(!password.equals(request.getParameter("passwordConfirm")))
		{
			s.setAttribute("registerErrorMessage", "put the same password please");
			request.getRequestDispatcher("jsp/register.jsp").forward(request, response);
			
		}		
		else if(!DaoFactory.getUserDao().existe(inputUsername))
		{
			u.setUsername(inputUsername);
			u.setPassword(password);
			u.setFamilyName(request.getParameter("lastname"));
			u.setGivenName(request.getParameter("firstname"));
			u.setEmail(request.getParameter("email"));
			DaoFactory.getUserDao().storeUser(u);
		
			s.setAttribute("username", inputUsername);
		
			response.sendRedirect(request.getContextPath()+"/auth/home");
			
		}
		else {			
			s.setAttribute("registerErrorMessage", "this username is already taken");
			request.getRequestDispatcher("jsp/register.jsp").forward(request, response);
			
		}		
		
	}

}
