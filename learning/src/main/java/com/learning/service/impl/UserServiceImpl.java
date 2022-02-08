package com.learning.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.dto.Register;
import com.learning.exception.AlreadyExistsException;
import com.learning.exception.IdNotFoundException;
import com.learning.repository.UserRepository;
import com.learning.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserServiceImpl() {
		// TODO Auto-generated constructor stub
	
		
	}
	
	@Autowired
	UserRepository repo;
	@Override
	public Register addregister(Register register) throws AlreadyExistsException {
		// TODO Auto-generated method stub
		if(repo.existsByEmail(register.getEmail())== true) {
			throw new AlreadyExistsException("this record already exists");
		}
		Register register2 = repo.save(register);
		if (register2 == null) {
			return null;
			
		}
		return register2;
	}

	@Override
	public String updateregister(Integer id, Register register){
		// TODO Auto-generated method stub
		if(this.repo.existsById(id)==false) {
			return "fail";
		}
		return (this.repo.save(register)!=null)?"success":"fail";

	}

	@Override
	public Register getregisterById(Integer id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<Register> optional =  repo.findById(id);
		if(optional.isEmpty()) {
			throw new IdNotFoundException("id not found");
		}
		else {
			return optional.get();
		}
	}

	@Override
	public Optional<List<Register>> getAllUserDetails() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(repo.findAll());
	}

	@Override
	public String deleteUserById(Integer id) {
		// TODO Auto-generated method stub
		try {
			Register optional = this.getregisterById(id);
			if(optional == null) {
				throw new IdNotFoundException("record not found");
			}
			else {
				repo.deleteById(id);
				return "Success";
			}
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "fail";

	}

	@Override
	public String authenticate(String email, String password) {
		// TODO Auto-generated method stub
		if(repo.existsByEmailAndPassword(email, password)) {
			return "success";
		}
		return "fail";
	}

}
