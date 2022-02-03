package com.zee.zee5app.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zee.zee5app.dto.Role;
import com.zee.zee5app.repository.RoleRepository;
import com.zee.zee5app.service.RoleService;
@Component
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	RoleRepository rolerepository;
	
	
	@Override
	@org.springframework.transaction.annotation.Transactional(rollbackFor = Exception.class)
	public String addRole(Role role) {
		// TODO Auto-generated method stub
		Role role2 = rolerepository.save(role);
		
		if(role !=null) {
			return"success";
		}
		else {
			return"fail";
		}
		
	}

	@Override
	public void deleteRole(int roleId) {
		// TODO Auto-generated method stub

	}

}
