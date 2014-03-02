package com.pms.manager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;

import com.pms.LoadConnection;

public class UserManager {
	public void saveUser(HttpServletRequest request) {
		String DisplayName = request.getParameter("DisplayName");
		String EmailId = request.getParameter("EmailId");
		String password = request.getParameter("Password");
		
		String query = "insert into UserTable(DisplayName, EmailId, Password) values('" + 
		DisplayName + "','" + EmailId + "','" + password + "')";
		
		try {
			Statement st = LoadConnection.getConnection().createStatement();
			
			st.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ResultSet listUser(){
		try {
			Statement st  = LoadConnection.getConnection().createStatement();
			
			String query = "Select * FROM usertable";
			//Long id;
			//String name;

			ResultSet rs = st.executeQuery(query);

			/*while (rs.next()) {
			id = rs.getLong(1);	
			name = rs.getString(2);
			System.out.println("Id "+ id + " Name " + name);
			} //end while*/
			
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ResultSet findUser(String userId){
		try {
			Statement st  = LoadConnection.getConnection().createStatement();
			
			String query = "Select * FROM usertable where UserId=" + userId;
			//Long id;
			//String name;

			ResultSet rs = st.executeQuery(query);

			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	
	public void updateUser(HttpServletRequest request) {
		String userId = request.getParameter("UserId");
		String DisplayName = request.getParameter("DisplayName");
		String EmailId = request.getParameter("EmailId");
		String password = request.getParameter("Password");
		
		String query = "update UserTable set DisplayName = '" + DisplayName + "', EmailId = '" + EmailId + "', Password = '" + 
		password+ "' where UserId =" + userId; 
		
		try {
			Statement st = LoadConnection.getConnection().createStatement();
			
			st.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ResultSet verifyUser(String userId, String password){
		try {
			Statement st  = LoadConnection.getConnection().createStatement();
			
			String query = "Select * FROM usertable where UserId=" + userId + " and password = '" + password + "'";
			//Long id;
			//String name;

			ResultSet rs = st.executeQuery(query);

			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
}
