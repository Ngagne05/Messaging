package com.message.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.message.dao.DaoFactory;
import com.message.entity.User;


@WebServlet("/auth/profile")
public class profileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public profileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("../jsp/profile.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u=new User();
		HttpSession s=request.getSession();
		u=(User)s.getAttribute("user");
		PrintWriter out=response.getWriter();
		out.print(u.getId()+"    "+u.getUsername());
		u.setPassword(request.getParameter("password"));
		u.setFamilyName(request.getParameter("lastname"));
		u.setGivenName(request.getParameter("firstname"));
		u.setEmail(request.getParameter("email"));
		DaoFactory.getUserDao().updateUser(u);
		response.sendRedirect(request.getContextPath()+"/auth/home");
	}

}
