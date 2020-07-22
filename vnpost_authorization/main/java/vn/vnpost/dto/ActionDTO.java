package vn.vnpost.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActionDTO {

	private int id;
	private String name;
	private String code;
	private String url;
	private String checked;
	private List<ActionDetailDTO> actiondetails;
	@JsonIgnore
	private PermissonDTO permisson;
}
