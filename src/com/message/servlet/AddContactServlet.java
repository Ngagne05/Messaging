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


@WebServlet("/auth/addContact")
public class AddContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AddContactServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s=request.getSession();
	    User u=(User)s.getAttribute("user");
	    User c=null;
	    try {
	    	 c=(User)s.getAttribute("contact");
		} catch (Exception e) {
			
		}	    
	   if(c!=null){
	    	DaoFactory.getUserDao().addContact(u,c);	    
		   request.getRequestDispatcher("/auth/home").forward(request, response);
	   } 
	   else{
		   request.getRequestDispatcher("/auth/searchContact").forward(request, response);

	   }
	}

}
