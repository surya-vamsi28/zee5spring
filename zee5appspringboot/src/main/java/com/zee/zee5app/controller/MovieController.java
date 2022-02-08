package com.zee.zee5app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {

	
	@Autowired
	MovieService service;
	
	
	@PostMapping("/addMovie")
	public ResponseEntity<?> addMovie(@RequestBody Movie movie) {
		
		
			Movie result;
			try {
				result = service.addMovie(movie);
				System.out.println(result);
				return ResponseEntity.status(201).body(result);
			} catch (AlreadyExistsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
			// TODO Auto-generated catch block
			//return a json object with message: record already exists
			// status : problem
			Map<String,String> hashmap = new HashMap<>();
			hashmap.put("message","recod already exists");
			return ResponseEntity.badRequest().body(hashmap);
			
		

	}
	}
