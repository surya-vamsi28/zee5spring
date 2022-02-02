package com.zee.zee5app.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidTypeException;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
@Entity 
@Table(name = "Subscription")

public class Subscription {
	@Id 
	@Column(name = "sub_Id")
	private String sub_id;
	@NotBlank
	private String sub_type;
	@NotNull
	private Date sub_dop;
	@NotBlank
	private String sub_pack_country;
	@NotBlank
	private String Sub_payment_mode;
	@NotBlank
	private String sub_autorenewal;
	@NotNull
	private Date sub_doe;
	@NotBlank
	private String Sub_status;
	@NotNull
	private int Sub_amount;
	@NotBlank
	private String Sub_contactnumber;
	@NotBlank
	private String reg_id;
	
	
	
	
	
}