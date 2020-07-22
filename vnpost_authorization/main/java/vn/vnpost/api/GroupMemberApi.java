package vn.vnpost.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vn.vnpost.dto.AssignmentGroupDTO;
import vn.vnpost.dto.GroupDTO;
import vn.vnpost.service.GroupService;

@RestController
@RequestMapping("/api/memberGroup")
public class GroupMemberApi {

	@Autowired
	GroupService groupService;
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<GroupDTO> delete(@PathVariable("id")int id){
		groupService.DeleteById(id);
		return new ResponseEntity<>( HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public GroupDTO edit(@PathVariable("id")int id) {
		
		return groupService.findById(id);
		
	}
	
	@GetMapping
	public GroupDTO findByCode(@RequestParam("code")String code) {
		return groupService.getByCode(code);
	}
	
	@GetMapping("/search")
	public List<GroupDTO> findByCodeAndName(@RequestParam("code")String code,
			@RequestParam("name") String name) {
		return groupService.findByCodeAndName(code, name);
	}
	
	@PutMapping("/assigment")
	public ResponseEntity<GroupDTO> assignment(@RequestBody AssignmentGroupDTO groupDTO){
		
		groupService.assignmentGroup(groupDTO);		
		return new ResponseEntity<>( HttpStatus.OK);
	}
}
