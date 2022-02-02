package com.zee.zee5app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.zee.zee5app.exception.LocationNotFoundException;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@Data
@Entity 
@Table(name = "Movie")


public class Movie {
	@Id 
	@Column(name = "movie_Id")
	private String movie_id;
	@NotBlank
	private String movie_name;
	@NotBlank
	private String movie_cast;
	@Min(value=2)
	private int movie_length;
	@NotNull
	private String movie_Release_Date;
	@NotBlank
	private String movie_trailer;
	@NotBlank
	private String movie_language;
	@Max(value=70)
	private int movie_agelimit;
	@NotBlank
	private String movie_genre;
	
	
	
	public  Movie() {
		
		
		
	}

	
		
	
}
