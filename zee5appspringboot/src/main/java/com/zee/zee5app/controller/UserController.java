package com.zee.zee5app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.service.UserService;


//Rest api RESPONSE  wherever we have to share the response that method must be marked with @responsebody
//1000 methods ---> @Responsebody ---> 1000times
//
@RestController
@RequestMapping("/users") //jacksonapi main behind converting json to java
public class UserController {
	//adding info to the table
	//info will be shared by client in terms of JSON Object
	// we need to read that json object
	//where is the json available in request === > requestBody
	//we need to read that requestbody 
	// we need to transform json object to java object || takencare by @Requestbody
	
	
	@Autowired
	UserService userservice;
	
	//we need to inform when the method should be called
	@PostMapping("/addUser")
	public ResponseEntity<?> addUser(@Valid @RequestBody Register register) throws AlreadyExistsException {
		Register result = userservice.addUser(register);
			System.out.println(result);
			return ResponseEntity.status(201).body(result);
			// TODO Auto-generated catch block
			//return a json object with message: record already exists
			// status : problem
	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getUserById(@PathVariable("id") String id) throws IdNotFoundException{
		Register result = userservice.getUserById(id);
		return ResponseEntity.status(201).body(result);
	}
	@GetMapping("/all")
	public ResponseEntity<?> getAllUserDetails(){
		Optional<List<Register>> optional = userservice.getAllUserDetails();
		if(optional.isEmpty()) {
			Map<String,String> map = new HashMap<String, String>();
			map.put("message","no record found");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(map);
		}
		return ResponseEntity.of(optional);
	}
}
