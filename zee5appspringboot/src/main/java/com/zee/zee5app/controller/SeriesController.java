package com.zee.zee5app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.naming.NameNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.payload.response.MessageResponse;
import com.zee.zee5app.service.SeriesService;

@RestController
@RequestMapping("/api/series")
public class SeriesController {

	@Autowired
	SeriesService seriesService;
	
	@PostMapping("/addSeries")
	@PreAuthorize("hasRole('ADMIN')")
	//used ? so we can return any type
	public ResponseEntity<?> addSeries(@Valid @RequestBody Series series) {
		
		Series result = seriesService.addSeries(series);
		return ResponseEntity.status(201).body(result);
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<?> getSeriesById(@PathVariable("id") String id) throws NameNotFoundException, IdNotFoundException, InvalidIdLengthException {
		Series result = seriesService.getSeriesById(id);
		return ResponseEntity.ok(result);	
		
	}
	
	@GetMapping("/all")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<?> getAllSeriesDetails() throws NameNotFoundException, InvalidIdLengthException{
		Optional<List<Series>> optional = seriesService.getAllSeries();
		if(optional.isEmpty()) {
			Map<String, String> map = new HashMap<>();
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new MessageResponse("no record found"));
		}
		return ResponseEntity.ok(optional.get());	
		
	}
	
	
}
