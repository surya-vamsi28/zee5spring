package com.zee.zee5app.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.ROLE;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.repository.LoginRepository;
import com.zee.zee5app.service.LoginService;
@Component
public class LoginServiceImpl implements LoginService {
	

	@Autowired
	private LoginRepository loginRepository;
	
	private LoginServiceImpl() {
		
	}

	
	@Override
	public String addCredentials(Login login) {
		// TODO Auto-generated method stub
		Login login2 =  loginRepository.save(login);
		
		if(login2!=null) {
			return "add Success";
		}
		else {
			return "fail";
		}

	}

	@Override
	public String deleteCredentials(String userName) {
		// TODO Auto-generated method stub
//		Optional<Login> optional;
//		
//			optional = this.getLoginById(userName);
//			if(optional.isEmpty()) {
//				throw new IdNotFoundException("record not found");
//			}
//			else {
//				loginRepository.deleteById(userName);
//				return "Success";
//			}
			
			return null;
	}

	@Override
	public String changePassword(String userName, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changeRole(String username, ROLE role) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
