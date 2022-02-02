package com.zee.zee5app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity 
@Table(name = "Login")
public class Episodes {
	private static final int vvalue = 0;
	@Id 
	@Column(name = "username")
	private String epi_id;
	@Size(max=50)
	@NotBlank
	private String epi_name;
	@Size(max=50)
	@NotBlank
	private String ser_id;
	@Min(value=0)
	private int epi_length;
	@NotBlank
	private String epi_location;
}
