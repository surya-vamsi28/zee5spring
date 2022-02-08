package com.learning.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.dto.Register;
import com.learning.exception.AlreadyExistsException;
import com.learning.service.UserService;



@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserService userservice;
	
	@PostMapping("/register")
	public ResponseEntity<?> addUser(@Valid @RequestBody Register register) throws AlreadyExistsException {
		Register result = userservice.addregister(register);
			System.out.println(result);
			return ResponseEntity.status(201).body(result);
}
	@PostMapping("/authenticate")
	public ResponseEntity<?> authenticate(@RequestBody Register register){
		String res = userservice.authenticate(register.getEmail(), register.getPassword());
		System.out.println(res);
		Map<String,String> map = new HashMap<String, String>();
		map.put("message",res);
		return ResponseEntity.status(201).body(map);
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getUserById(@PathVariable("id") Integer id) throws com.learning.exception.IdNotFoundException{
		Register result = userservice.getregisterById(id);
		return ResponseEntity.status(201).body(result);
	}
	
	@GetMapping("/users")
	public ResponseEntity<?> getAllUserDetails(){
		Optional<List<Register>> optional = userservice.getAllUserDetails();
		if(optional.isEmpty()) {
			Map<String,String> map = new HashMap<String, String>();
			map.put("message","no record found");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(map);
		}
		return ResponseEntity.of(optional);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteuserbyid(@PathVariable("id") Integer id){
		String res = userservice.deleteUserById(id);
		System.out.println(res);
		Map<String,String> map = new HashMap<String, String>();
		map.put("message",res);
		return ResponseEntity.status(201).body(map);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateuserbyid(@PathVariable("id") Integer id,@RequestBody Register register){
		String res = userservice.updateregister(id, register);
		Map<String,String> map = new HashMap<String, String>();
		map.put("message",res);
		return ResponseEntity.status(201).body(map);
	}
	
	
}
