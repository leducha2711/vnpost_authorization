package vn.vnpost.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssignmentGroupDTO {
	private String code;
	private List<String> actionList;
	private List<String> actionDetailList;
	private List<String> permissList;
}
