package com.zee.zee5app.repository.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.ROLE;
import com.zee.zee5app.repository.LoginRepository;
import com.zee.zee5app.utils.DBUtils;
@Component
public class LoginRepositoryImpl implements LoginRepository {
	
	
	public LoginRepositoryImpl() throws IOException{
	
	}
	@Autowired
	DataSource dataSource;
	
	
	

	
	@Override
	public String addCredentials(Login login) {
		// TODO Auto-generated method stub
		Connection connection = null;
		String insertQuery = "insert into login (username, password, regId , role)" + "values(?,?,?,?)";
		try {
			connection = dataSource.getConnection();
			PreparedStatement prepStatement = connection.prepareStatement(insertQuery);
			prepStatement.setString(1, login.getUserName());
			prepStatement.setString(2, login.getPassword());
			prepStatement.setString(3, login.getReg_id());
			prepStatement.setString(4, login.getRole().toString());
			
			int result = prepStatement.executeUpdate();
			
			if (result > 0) {
//				connection.commit();
				return "success";
			} else {
				connection.rollback();
				return "fail";
			}

		} catch (SQLException e) {
		e.printStackTrace();
		} 
		return "fail";
	}

	@Override
	public String deleteCredentials(String userName) {
		// TODO Auto-generated method stub
		Connection connection = null;
		ResultSet resultset = null;
		
		
		String deleteStatement = "delete from register where username = ?";
		
		PreparedStatement preparedStatement = null;
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(deleteStatement);
			preparedStatement.setString(1, userName);
			int result = preparedStatement.executeUpdate();
			if(result > 0 ) {
				
				return "success";
				
			}
			else {
				return "fail";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return "fail";
	}

	@Override
	public String changePassword(String userName, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String changeRole(String username, ROLE role) {
		// TODO Auto-generated method stub
		String updatestatement = "UPDATE login SET role = ? WHERE username = ?";
		Connection connection = null;
		ResultSet resultset = null;
		
		
		PreparedStatement preparedStatement = null;
		try {
			connection = dataSource.getConnection();
		
			preparedStatement = connection.prepareStatement(updatestatement);
			preparedStatement.setString(1, role.toString());
			preparedStatement.setString(2, username);
			int result = preparedStatement.executeUpdate();
			if(result > 0 ) {
				connection.commit();
				return "success";
				
			}
			else {
				connection.rollback();
				return "fail";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		
		return "fail";
	}

}
}
	
