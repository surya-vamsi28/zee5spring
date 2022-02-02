package com.zee.zee5app.dto;

import com.zee.zee5app.exception.LocationNotFoundException;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@Data


public class Movie {
	private String movie_id;
	private String movie_name;
	private String movie_cast;
	private int movie_length;
	private String movie_Release_Date;
	private String movie_trailer;
	private String movie_language;
	private int movie_agelimit;
	private String movie_genre;
	
	
	
	public  Movie() {
		
		
		
	}

	
		
	
}
