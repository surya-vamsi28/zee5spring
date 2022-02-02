package com.zee.zee5app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.zee.zee5app.exception.LocationNotFoundException;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@NoArgsConstructor
@Setter
@AllArgsConstructor
@ToString
@Data
@Entity 
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "series_name")})

public class Series {
	@Id 
	@Column(name = "series_Id")
	private String series_id;
	@NotBlank
	private String series_name;
	@NotBlank
	private String series_genre;
	@NotBlank
	private String series_release_date;
	@NotBlank
	private String series_trailer;
	@Min(value=1)
	private int series_episodes;
	@NotBlank
	private String series_language;
	@NotBlank
	private String series_cast;
	@Max(value = 70)
	private int series_agelimit;
		
	
	
	
	

	

}
