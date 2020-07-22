package vn.vnpost.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupDTO {
	
	private int id;

	private String code;

	private String name;

	private int status;
	private List<ActionDetailDTO> actiondetails;
	@JsonIgnore
	private List<UserDTO> users;
	
	private List<PermissonDTO> permissons;
}
