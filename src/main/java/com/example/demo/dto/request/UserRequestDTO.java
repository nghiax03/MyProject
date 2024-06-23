package com.example.demo.dto.request;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.util.EnumPattern;
import com.example.demo.util.EnumValue;
import com.example.demo.util.Gender;
import com.example.demo.util.GenderSubset;
import com.example.demo.util.PhoneNumber;
import com.example.demo.util.UserStatus;
import com.example.demo.util.UserType;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


//json <=> byte

public class UserRequestDTO implements Serializable {

	@NotBlank(message = "firstName must be not blank")
	private String firstName;
	
	@NotNull(message = "lastName must be not null")
	private String lastName;
	
	@Email(message = "email invalid format")
	private String email;
	
	//@Pattern(regexp = "^\\d{10}$", message = "phone invalid format")
	@PhoneNumber
	private String phone;
	
	@NotNull(message = "dateOfBirth must be not null")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "MM/ddd/yyyy")
	private Date dateOfBirth;
	
	@EnumPattern(name = "status", regexp = "ACTIVE|INACTIVE|NONE")
	private UserStatus status;
	
	@NotNull(message = "username must be not null")
	private String username;
	
	@NotNull(message = "password must be not null")
	private String password;
	
	@GenderSubset(anyOf = {Gender.MALE, Gender.FEMALE, Gender.OTHER})
	private Gender gender;
	
	@NotNull(message = "type must be not null")
	@EnumValue(name = "type", enumClass = UserType.class)
	private String type;
	
	public UserRequestDTO() {
		// TODO Auto-generated constructor stub
	}

	public UserRequestDTO(String firstName, String lastName, String email, String phone) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
