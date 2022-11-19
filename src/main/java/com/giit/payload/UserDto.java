package com.giit.payload;

import java.util.Date;

import javax.persistence.Column;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
public class UserDto {
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String phone;
	private String gender;
	private Date dob;
	

}
