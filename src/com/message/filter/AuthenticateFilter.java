package com.message.filter;

import java.io.IOException;










import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.net.httpserver.HttpExchange;

@WebFilter(urlPatterns="/auth/*")
public class AuthenticateFilter implements Filter {
	
	private FilterConfig filterConfig;
	@Override
	public void destroy() {
		
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		String username  = (String) ((HttpServletRequest)request).getSession().getAttribute("username");
		
		if(username!=null)
			chain.doFilter(request, response);
		else
			((HttpServletResponse)response).sendRedirect(((HttpServletRequest)request).getContextPath()+"/index.jsp");
	}

	@Override
	public void init(FilterConfig fc) throws ServletException {
		
		filterConfig = fc;
	}

}
