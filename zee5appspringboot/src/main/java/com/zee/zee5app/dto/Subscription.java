package com.zee.zee5app.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidTypeException;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
@Entity 
@Table(name = "Subscription")

public class Subscription {
	@Id 
	@Column(name = "Id")
	private String id;
	@NotBlank
	private String type;
	@NotBlank
	private String dop;
	@NotBlank
	private String pack_country;
	@NotBlank
	private String payment_mode;
	@NotBlank
	private String autorenewal;
	@NotBlank
	private String doe;
	@NotBlank
	private String status;
	@NotNull
	private int amount;
	@NotBlank
	private String contactnumber;
//	@NotBlank
//	private String reg_id;
	
	@OneToOne
	@JoinColumn(name="regId") // for foreign key
	private Register register; // series id and act as fk
	
	
	
	
}