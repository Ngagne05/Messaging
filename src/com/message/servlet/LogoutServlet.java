package com.message.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession s = req.getSession();
		s.removeAttribute("username");
		s.removeAttribute("contact");		
		s.removeAttribute("incorectInput");
		s.removeAttribute("registerErrorMessage");
		s.removeAttribute("user");
		s.removeAttribute("selectedContact");
		resp.sendRedirect(req.getContextPath()+"/index.jsp");
	}
}
