package com.zee.zee5app.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.zee.zee5app.exception.LocationNotFoundException;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity 
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "name")})


public class Movie {
	@Id 
	private String id;
	@NotBlank
	private String name;
	@NotBlank
	private String cast;
	@Min(value=2)
	private int length;
	@NotNull
	private String release_date;
//	@Lob
//	private byte[] trailer;
	private String Trailer;
	@NotBlank
	private String language;
	@Max(value=70)
	private int agelimit;
	@NotBlank
	private String genre;
	
	
	
	

	
		
	
}
