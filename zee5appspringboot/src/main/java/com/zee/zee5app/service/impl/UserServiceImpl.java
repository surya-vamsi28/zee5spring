package com.zee.zee5app.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.UserRepository;

import com.zee.zee5app.service.UserService;

@Component



public class UserServiceImpl implements UserService {
	
	
	
	
	
	@Autowired
	private UserRepository userRepository;
	
	private UserServiceImpl() throws IOException{
		
	}

	@Override
	public String addUser(Register register) {
		Register register2 =  userRepository.save(register);
		
		if(register2!=null) {
			return "add Success";
		}
		else {
			return "fail";
		}
		                   
	}

	@Override
	public String updateUser(String id, Register register) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Register> getUserById(String id) throws IdNotFoundException, InvalidPasswordException,
			InvalidIdLengthException, InvalidNameException, InvalidEmailException {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
		
	}

	@Override
	public Register[] getAllUsers()
			throws InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException {
		// TODO Auto-generated method stub
		
		List<Register> register1 = userRepository.findAll();
		Register[] array = new Register[register1.size()];
		return register1.toArray(array);
		
	}

	@Override
	public String deleteUserById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		try {
			Optional<Register> optional = this.getUserById(id);
			if(optional.isEmpty()) {
				throw new IdNotFoundException("record not found");
			}
			else {
				userRepository.deleteById(id);
				return "Success";
			}
		} catch (IdNotFoundException | InvalidPasswordException | InvalidIdLengthException | InvalidNameException
				| InvalidEmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
	}

	@Override
	public Optional<List<Register>> getAllUserDetails()
			throws InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(userRepository.findAll());
	}

	
}
