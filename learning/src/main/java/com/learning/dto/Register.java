package com.learning.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
@Data
@Entity 
@Table(name = "register")
public class Register {
	@Id //Id must be auto generated
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Size(max=50)
	@NotBlank
	private String name;
	@Email
	private String email;
	@Size(max=100)
	@NotBlank
	private String password;
	@Size(max = 100)
	private String address;
	
	
}
