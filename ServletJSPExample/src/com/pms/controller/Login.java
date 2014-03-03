package com.pms.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.StringUtils;
import com.pms.manager.UserManager;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login.htm")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("In Post");
		boolean flag = false;
		String action = request.getParameter("action");
		if("LogOut".equals(action)){
			HttpSession session = request.getSession();
			session.invalidate();
			//response.sendRedirect("Index.jsp");
		}else{
		
			String userId = request.getParameter("userId");
			String password = request.getParameter("password");
			
			if(userId != null && !userId.isEmpty() && password != null && !password.isEmpty())
			{
				UserManager userManager = new UserManager();
				ResultSet rs = userManager.verifyUser(userId,password);
				try {
					if(rs != null && rs.next()){
					
						String userName = rs.getString(1);
						HttpSession session = request.getSession();
						session.setAttribute("user", userName);
						flag= true;
					
					}	
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					 
				
							
			}
		}
		if(flag)
			response.sendRedirect("UserController.htm?action=userAddEdit");
		else
			response.sendRedirect("Index.jsp");

	}

	@Override
	public void init(ServletConfig servletConfig) {
		System.out.println(servletConfig.getServletName());
	}
}
