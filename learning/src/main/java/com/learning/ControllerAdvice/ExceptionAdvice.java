package com.learning.ControllerAdvice;

import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.learning.exception.AlreadyExistsException;


@ControllerAdvice
public class ExceptionAdvice {
//this class should be used when any userdefined exception is called through out all the controller
	@ExceptionHandler(AlreadyExistsException.class)
	public ResponseEntity<?> alreadyRecordExistsExceptionHandler(){
		
		HashMap<String, String> hashmap = new HashMap<>();
		hashmap.put("message","Record already Exists");
		return ResponseEntity.badRequest().body(hashmap);
		
		
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> ExceptionHandler(Exception e){
		
		HashMap<String, String> hashmap = new HashMap<>();
		hashmap.put("message","Unknown Exception - " + e.getMessage());
		return ResponseEntity.badRequest().body(hashmap);
		
		
	}
}
