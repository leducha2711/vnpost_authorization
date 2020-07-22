package vn.vnpost.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PermissonDTO {
	private int id;

	private String code;

	private String name;

	private int status;

	private String url;
	private String checked;

	private List<ActionDTO> actions;
	@JsonIgnore
	private List<GroupDTO> groups;
}
