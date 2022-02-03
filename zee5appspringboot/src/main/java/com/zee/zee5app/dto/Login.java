package com.zee.zee5app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity 
@Table(name = "Login")
public class Login {
	@Id 
	@Column(name = "username")
	@Email
	private String userName;
	@Size(max=50)
	@NotBlank
	private String password;
	@Size(max=50)
	@NotBlank
	private String reg_id;
	
	
}
