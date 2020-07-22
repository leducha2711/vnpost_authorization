package vn.vnpost.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

	private int id;

	private String email;

	private String password;

	private int status;

	private String username;
	private GroupDTO group;
	
	private EmployeeDTO employee;
	
}
