     package com.zee.zee5app.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.repository.impl.UserRepositoryImpl;
import com.zee.zee5app.service.UserService;

@Component

public class UserServiceImpl implements UserService {
	
	
	private static UserService service;
	
	private UserRepository userRepository;
	
	private UserServiceImpl() throws IOException{
		
	}

	@Override
	public String addUser(Register register) {
		// TODO Auto-generated method stub
		return userRepository.addUser(register);
	}

	@Override
	public String updateUser(String id, Register register) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return userRepository.updateUser(id, register);
	}

	@Override
	public Optional<Register> getUserById(String id) throws IdNotFoundException, InvalidPasswordException, InvalidIdLengthException, InvalidNameException, InvalidEmailException {
		// TODO Auto-generated method stub
		return userRepository.getUserById(id);
	}

	@Override
	public Register[]  getAllUsers() throws InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException {
		return userRepository.getAllUsers();
	}

	@Override
	public String deleteUserById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return userRepository.deleteUserById(id);
	}

	@Override
	public Optional<List<Register>> getAllUserDetails() throws InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException {
		// TODO Auto-generated method stub
		return userRepository.getAllUserDetails();
	}

}
