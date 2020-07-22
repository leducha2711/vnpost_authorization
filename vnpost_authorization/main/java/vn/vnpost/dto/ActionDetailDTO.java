package vn.vnpost.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActionDetailDTO {


    private int id;

    private String name;

    private String code;

    private int status;
    @JsonIgnore
    private ActionDTO action;

    private String url;
    private String checked;
    @JsonIgnore
    List<GroupDTO> groups = new ArrayList<>();
}
