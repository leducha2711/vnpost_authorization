package vn.vnpost.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.vnpost.dto.AssignmentGroupDTO;
import vn.vnpost.dto.GroupDTO;

@Service
public interface GroupService {
	public GroupDTO findByUsername(String username);
	public GroupDTO findByCode(String code);
	public List<GroupDTO> findAll();
	
	public GroupDTO findById(int id);
	public void DeleteById(int id);
	
	public void add(GroupDTO groupDTO);
	public void update(GroupDTO groupDTO);
	public GroupDTO getByCode(String code);
	public void assignmentGroup(AssignmentGroupDTO assignmentGroupDTO);
	
	public List<GroupDTO> findByCodeAndName(String code, String name);
}
