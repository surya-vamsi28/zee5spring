package com.zee.zee5app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@Entity 
@Table(name = "Episodes")
public class Episodes {
	
	@Id 
	@Column(name = "id")
	private String id;
	@Size(max=50)
	@NotBlank
	private String name;
	private String Trailer;
	@Min(value=0)
	private int length;
	@NotBlank
	private String location;
	
	@ManyToOne
	@JoinColumn(name="seriesid") // for foreign key
	private Series series; // series id and act as fk
}
