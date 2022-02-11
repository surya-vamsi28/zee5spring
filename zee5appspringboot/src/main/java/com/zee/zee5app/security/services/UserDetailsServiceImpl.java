package com.zee.zee5app.security.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.zee.zee5app.dto.User;
import com.zee.zee5app.exception.IdNotValidException;
import com.zee.zee5app.repository.UserRepository;
@Component
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("user not found with username " + username));
		
		return UserDetailsImpl.build(user);
	}

}
