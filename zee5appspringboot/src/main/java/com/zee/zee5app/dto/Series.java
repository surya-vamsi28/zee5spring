package com.zee.zee5app.dto;

import com.zee.zee5app.exception.LocationNotFoundException;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data

public class Series {
	private String series_id;
	private String series_name;
	private String series_genre;
	private String series_release_date;
	private String series_trailer;
	private int series_episodes;
	private String series_language;
	private String series_cast;
	private int series_agelimit;
	private int series_length;
	
	
	
	
	

	

}
