package com.pms.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthorizeFilter
 */
//@WebFilter("/AuthorizeFilter")
public class AuthorizeFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthorizeFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		 // Get the IP address of client machine.   
	      String ipAddress = request.getRemoteAddr();

	      // Log the IP address and current timestamp.
	      System.out.println("IP "+ ipAddress + ", Time "
	                                       + new Date().toString());
	      boolean flag = true;
	      if (request instanceof HttpServletRequest) {
	    	  String url = ((HttpServletRequest)request).getRequestURL().toString();
	    	  //String queryString = ((HttpServletRequest)request).getQueryString();
	    	  
	    	  int i = url.lastIndexOf("/");
	    	  String action = url.substring(i+1,url.length());
	    	  if(!"Login.htm".equals(action) && !"Index.jsp".equals(action)){
	    		  HttpSession session = ((HttpServletRequest) request).getSession();
	    		  Object userName = session.getAttribute("user");
	    		  if(userName == null || userName.toString().isEmpty()){
	    			  flag = false;
	    			
	    		  }
	    	  }
	      }
		
		// pass the request along the filter chain
	    if(!flag){
	    	  HttpServletResponse httpResponse = (HttpServletResponse) response;
			  httpResponse.sendRedirect("Index.jsp");
	    }else
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
