package com.zee.zee5app.repository.impl;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Component;

import com.zee.zee5app.config.Config;
import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.ROLE;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.LoginRepository;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.service.LoginService;
import com.zee.zee5app.service.impl.LoginServiceImpl;
import com.zee.zee5app.utils.DBUtils;
import com.zee.zee5app.utils.PasswordUtils;
@Component
public class UserRepositoryImpl implements UserRepository {
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	LoginRepository loginService;
	
	@Autowired
	PasswordUtils PasswordUtils;
	
	
	
	
	
	public UserRepositoryImpl() throws IOException{
	
	
	}
	

	@Override
	public String addUser(Register register) 
	{
		Connection connection = null;
	try {

		connection = dataSource.getConnection();
	String insertQuery = "insert into register" + "(regId, firstname, lastname, email, contactnumber, password)"
			+ "values(?,?,?,?,?,?)";
		PreparedStatement prepStatement = connection.prepareStatement(insertQuery);
		prepStatement.setString(1, register.getId());
		prepStatement.setString(2, register.getFirstName());
		prepStatement.setString(3, register.getLastName());
		prepStatement.setString(4, register.getEmail());
		prepStatement.setBigDecimal(5, register.getContactNumber());
		String encryptPassword = PasswordUtils.generateSecurePassword(register.getPassword(),
				PasswordUtils.getSalt(30));
		prepStatement.setString(6, encryptPassword);
		int result = prepStatement.executeUpdate();
		if (result > 0) {
			
			Login login = new Login();
			login.setUserName(register.getEmail());
			login.setPassword(encryptPassword);
			login.setReg_id(register.getId());
			login.setRole(ROLE.ROLE_USER);
			String status = loginService.addCredentials(login);
			if (status.equals("success")) {
				
				return "success";
			} else {
				connection.rollback();
				return "fail";
			}
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
	public String updateUser(String id, Register register) throws IdNotFoundException {
		
			Connection connection;
			
			String updateQuery = "UPDATE register SET firstname=?, lastname=?, email=?, contactnumber=?, password=? WHERE regid=?";
			try {
				connection = dataSource.getConnection();
				PreparedStatement prepStatement = connection.prepareStatement(updateQuery);
				prepStatement.setString(6, register.getId());
				prepStatement.setString(1, register.getFirstName());
				prepStatement.setString(2, register.getLastName());
				prepStatement.setString(3, register.getEmail());
				prepStatement.setBigDecimal(4, register.getContactNumber());
				String encryptPassword = PasswordUtils.generateSecurePassword(register.getPassword(),
						PasswordUtils.getSalt(30));
				prepStatement.setString(5, encryptPassword);
				int result = prepStatement.executeUpdate();
				if (result > 0) {
					Login login = new Login();
					login.setUserName(register.getEmail());
					login.setPassword(encryptPassword);
					login.setReg_id(register.getId());
					login.setRole(ROLE.ROLE_USER);
					String status = loginService.addCredentials(login);
					if (status.equals("success")) {
						connection.commit();
						return "success";
					} else {
						connection.rollback();
						return "fail";
					}

				} else {
					connection.rollback();
					return "fail";
				}

			} catch (SQLException e) {
				try {
					connection = dataSource.getConnection();
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			} 			return "fail";
		
	}
	
	
	
	
	@Override
	public Optional<Register> getUserById(String id) throws IdNotFoundException, InvalidPasswordException, InvalidIdLengthException, InvalidNameException, InvalidEmailException {
		// TODO Auto-generated method stub
		Connection connection = null;
		ResultSet resultset = null;
		String selectStatement = "select * from register where regId=?";
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			PreparedStatement preparedStatement = null;
			preparedStatement = connection.prepareStatement(selectStatement);
			preparedStatement.setString(1, id);
			resultset = preparedStatement.executeQuery();
			if(resultset.next()) {
				Register register = new Register();
				register.setId(resultset.getString("regId"));
				register.setFirstName(resultset.getString("firstname"));
				register.setLastName(resultset.getString("lastname"));
				register.setEmail(resultset.getString("email"));
				register.setPassword(resultset.getString("password"));
				register.setContactNumber(resultset.getBigDecimal("contactnumber"));
				return Optional.of(register);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
	}
	
	
	
	
	@Override
	public Register[] getAllUsers() throws InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException {
		// TODO Auto-generated method stub
		Optional<List<Register>> optional = getAllUserDetails();
		
		if(optional.isEmpty()) {
			return null;
		}
		else {
			List<Register> list = optional.get();
			Register[] register = new Register[list.size()];
			return list.toArray(register);
		}
		
	}
	
	
	
	
	
	@Override
	public Optional<List<Register>> getAllUserDetails() throws InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException {
		// TODO Auto-generated method stub
		Connection connection = null;
		ResultSet resultset = null;
		String selectStatement = "select * from register";
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<Register> arraylist = new ArrayList<>(); 
		
		try {
			PreparedStatement preparedStatement = null;
			preparedStatement = connection.prepareStatement(selectStatement);
			resultset = preparedStatement.executeQuery();
			while(resultset.next()) {
				Register register = new Register();
				register.setId(resultset.getString("regId"));
				register.setFirstName(resultset.getString("firstname"));
				register.setLastName(resultset.getString("lastname"));
				register.setEmail(resultset.getString("email"));
				register.setPassword(resultset.getString("password"));
				register.setContactNumber(resultset.getBigDecimal("contactnumber"));
				arraylist.add(register);
			}
			return Optional.ofNullable(arraylist);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Optional.empty();
		
	}
	
	
	
	
	
	
	
	@Override
	public String deleteUserById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Connection connection = null;
		ResultSet resultset = null;
		
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String deleteStatement = "delete from register where regId = ?";
		
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(deleteStatement);
			preparedStatement.setString(1, id);
			int result = preparedStatement.executeUpdate();
			if(result > 0 ) {
				//delete his credentials
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
		}
		
		
		
		
		
		return "fail";
	}
	


}
