package com.pms.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pms.manager.UserManager;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController.htm")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
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
		String action = request.getParameter("action");
		
		if("SaveUser".equals(action))
			saveUser(request, response);
		else if("ListUser".equals(action))
			listUser(request, response);
		else if("userAddEdit".equals(action))
			userAddEdit(request, response);
		
	}

	protected void saveUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String userId = request.getParameter("UserId");
		UserManager userManager = new UserManager();
		if(userId.isEmpty()){
			
			userManager.saveUser(request);
		}else{
			userManager.updateUser(request);
		}
		
		//listUser(request, response);
		response.sendRedirect("UserController.htm?action=ListUser");
	}
	
	protected void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		UserManager userManager = new UserManager();
		ResultSet rs = userManager.listUser();
		request.setAttribute("resultSet", rs);
		
		RequestDispatcher dispatch = request.getRequestDispatcher("WEB-INF/Pages/Page2.jsp");  
		dispatch.forward(request, response);
	}
	
	protected void userAddEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String userId = request.getParameter("userId");
		
		if(userId != null && !userId.isEmpty())
		{
			UserManager userManager = new UserManager();
			ResultSet rs = userManager.findUser(userId);
			request.setAttribute("resultSet", rs);
		}
		RequestDispatcher dispatch = request.getRequestDispatcher("WEB-INF/Pages/Page1.jsp");  
		dispatch.forward(request, response);
	}
}
