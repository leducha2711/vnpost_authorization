package vn.vnpost.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTO {

	private String id;

	private String address;
	private Date dateOfBirth;

	private String fullname;

	private int gender;

	private String idcard;

	private String phonenumber;
	private String email;
	private int status;
	
	private String typeidcard;
	@JsonIgnore
	private UserDTO user;
}
