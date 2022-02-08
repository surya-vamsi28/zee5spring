package com.learning.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.learning.dto.Register;
import com.learning.exception.AlreadyExistsException;
import com.learning.exception.IdNotFoundException;
@Component
public interface UserService {
	public Register addregister(Register register) throws AlreadyExistsException;
	public String updateregister(Integer id, Register register);
	public Register getregisterById(Integer id) throws IdNotFoundException;
	public Optional<List<Register>> getAllUserDetails() ;
	public String deleteUserById(Integer id);
	public String authenticate(String email,String password);
	
}
