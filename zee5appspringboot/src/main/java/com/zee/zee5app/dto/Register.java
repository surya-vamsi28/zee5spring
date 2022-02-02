package com.zee.zee5app.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;


@Setter
@Getter

//@EqualsAndHashCode
//@NoArgsConstructor
//@AllArgsConstructor
@ToString



public class Register implements Comparable<Register>
{
	
	public Register(String id,String firstName,String lastName, String email, String password, BigDecimal contactNumber) throws InvalidNameException, InvalidIdLengthException, InvalidEmailException, InvalidPasswordException {
		super();
		this.setId(id);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setEmail(email);
		this.setPassword(password);
		this.setContactNumber(contactNumber);
	}
	
	
	@Setter(value = AccessLevel.NONE)
	private String id;
	// it should have min length of 6.
	@Setter(value = AccessLevel.NONE)
	private String firstName;
	@Setter(value = AccessLevel.NONE)
	private String lastName;
	@Setter(value = AccessLevel.NONE)
	private String email;
	@Setter(value = AccessLevel.NONE)
	private String password;
	@Getter(value = AccessLevel.NONE)
	private BigDecimal contactNumber;
	// private stuff will be accesible only inside class.
	
	public  Register() {
		//EDC
		System.out.println("hello");
		
	}

	public void setId(String id) throws InvalidIdLengthException{
		// throws it will provide the list of exceptions maybe raised
		// it will hold the list of checked exceptions
		if(id.length()<6) {
			// it should raise the InvalidIdLengthException.
			
			throw new InvalidIdLengthException( "id is less than or equal to 6");
			//
		}
		this.id = id;
	}

	public void setFirstName(String firstName) throws InvalidNameException {
		if(firstName == null || firstName == "" || firstName.length()<2) {
			throw new InvalidNameException("first name is not valid");
		}
		this.firstName = firstName;
	}

	public void setLastName(String lastName) throws InvalidNameException {
		if(lastName == null || lastName == "" || lastName.length()<2)
			throw new InvalidNameException("last name is not valid");
		this.lastName = lastName;
	}

	public void setEmail(String email) throws InvalidEmailException {
		if(email == null || email == "" || email.length()<2)
			throw new InvalidEmailException("email is not valid");
		this.email = email;
	}

	public void setPassword(String password) throws InvalidPasswordException {
		if(password == null ||password == "" || password.length()<4)
			throw new InvalidPasswordException("password is not valid");
		this.password = password;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Register other = (Register) obj;
		return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(id, other.id) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(password, other.password);
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, firstName, id, lastName, password);
	}

	@Override
	public int compareTo(Register o) {
		// TODO Auto-generated method stub
		
		return o.id.compareTo(this.id);
	}

	public BigDecimal getContactNumber() {
		return contactNumber;
	}
	
	

}
