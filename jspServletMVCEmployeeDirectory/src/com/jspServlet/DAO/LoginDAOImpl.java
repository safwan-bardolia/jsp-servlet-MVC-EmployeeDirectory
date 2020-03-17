package com.jspServlet.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jspServlet.Helper.DBConnectionUtil;
import com.jspServlet.entity.Login;

public class LoginDAOImpl implements LoginDAO {

	@Override
	public String authentiacte(Login login) {
		try {
			
			String sql="SELECT * FROM TBL_LOGIN WHERE EMAIL=? AND PASSWORD=?";		//email & pass from  "form"
			Connection connection=DBConnectionUtil.openConnection();
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,login.getEmail());
			preparedStatement.setString(2,login.getPassword());
			
			
			ResultSet resultSet=preparedStatement.executeQuery();
		
			
			if(resultSet.next()) {			//if resultSet Contain any record with given email & pass
				return "true";
			}
			else {
				return "false";
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "error";			//if above if else not execute then
	}

}
