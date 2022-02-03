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
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;


@Setter
@Getter

//@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
//can we customize the table names
//entity class is used for ORM
@Entity 
@Table(name = "register")



public class Register implements Comparable<Register>
{
//	
//	public Register(String id,String firstName,String lastName, String email, String password, BigDecimal contactNumber) throws InvalidNameException, InvalidIdLengthException, InvalidEmailException, InvalidPasswordException {
//		super();
//		this.setId(id);
//		this.setFirstName(firstName);
//		this.setLastName(lastName);
//		this.setEmail(email);
//		this.setPassword(password);
//		this.setContactNumber(contactNumber);
//	}
	// it will consider this column as primary
	@Id 
	@Column(name = "regId")

	private String id;
	// it should have min length of 6.
	@Size(max=50)
	@NotBlank
	private String firstName;
	@Size(max=50)
	@NotBlank
	private String lastName;
	@Size(max=50)
	@Email
	private String email;
	@Size(max=100)
	@NotBlank
	private String password;
	
	@NotNull
	private BigDecimal contactNumber;
	// private stuff will be accesible only inside class.
	
	



	@Override
	public int hashCode() {
		return Objects.hash(email, firstName, id, lastName, password);
	}

	@Override
	public int compareTo(Register o) {
		// TODO Auto-generated method stub
		
		return o.id.compareTo(this.id);
	}

	@ManyToMany
	@JoinTable(name = "user_roles",joinColumns = @JoinColumn(name="regId"),
	inverseJoinColumns = @JoinColumn(name="role_id")) // registered user(regid) and role(roleid)
	private Set<Role> roles = new HashSet<>();
	
	

}
