package com.zee.zee5app.dto;

import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidTypeException;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data

public class Subscription {
	@Setter(value = AccessLevel.NONE)
	private String sub_id;
	@Setter(value = AccessLevel.NONE)
	private String sub_type;
	@Setter(value = AccessLevel.NONE)
	private String sub_dop;
	@Setter(value = AccessLevel.NONE)
	private String sub_pack_country;
	@Setter(value = AccessLevel.NONE)
	private String Sub_payment_mode;
	@Setter(value = AccessLevel.NONE)
	private String sub_autorenewal;
	@Setter(value = AccessLevel.NONE)
	private String sub_expiry;
	@Setter(value = AccessLevel.NONE)
	private String Sub_status;
	@Setter(value = AccessLevel.NONE)
	private int Sub_amount;
	private String Sub_contactnumber;
	private String reg_id;
	
	
	public Subscription() {
		System.out.println("done");
	
		
	
	}


	public void setSub_id(String sub_id) throws InvalidIdLengthException {
		if(sub_id.length()<6) {
			// it should raise the InvalidIdLengthException.
			
			throw new InvalidIdLengthException( "id is less than or equal to 6");
			//
		}
		this.sub_id = sub_id;
	}


	public void setSub_type(String sub_type) throws InvalidTypeException {
		if(sub_type.length()<5) {
			throw new InvalidTypeException("type is invalid");
		}
		this.sub_type = sub_type;
	}


	public void setSub_dop(String sub_dop) {
		this.sub_dop = sub_dop;
	}


	public void setSub_pack_country(String sub_pack_country) {
		this.sub_pack_country = sub_pack_country;
	}

                      
	public void setSub_payment_mode(String sub_payment_mode) {
		Sub_payment_mode = sub_payment_mode;
	}


	public void setSub_autorenewal(String sub_autorenewal) {
		this.sub_autorenewal = sub_autorenewal;
	}


	public void setSub_expiry(String sub_expiry) {
		this.sub_expiry = sub_expiry;
	}


	public void setStatus(String status) {
		this.Sub_status = status;
	}


	public void setSub_amount(int sub_amount) throws InvalidAmountException {
		if(Sub_amount  < 0) {
			throw new InvalidAmountException("Amount is not enough");
		}
		Sub_amount = sub_amount;
	}
	
	
}