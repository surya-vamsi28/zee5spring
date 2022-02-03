package com.zee.zee5app.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

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
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "name")})

public class Series {
	@Id 
	@Column(name = "Id")
	@Length(min = 6 )
	private String id;
	@NotBlank
	private String name;
	@NotBlank
	private String genre;
	@NotBlank
	private String release_date;
	//@NotBlank
	private String trailer;
	@Min(value=1)
	private int numberepisodes;
	@NotBlank
	private String language;
	@NotBlank
	private String cast;
	@Max(value = 70)
	private int agelimit;
		
	@OneToMany(mappedBy = "series", cascade = CascadeType.ALL)
	private List<Episodes> episodes = new ArrayList<>();
	
	
	
	

	

}
