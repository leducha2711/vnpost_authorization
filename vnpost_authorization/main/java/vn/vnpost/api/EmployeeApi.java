package vn.vnpost.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.vnpost.dto.EmployeeDTO;
import vn.vnpost.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeApi {
	@Autowired
	EmployeeService  employeeService;
	
	@PostMapping
	public ResponseEntity<EmployeeDTO> addEmp(@RequestBody EmployeeDTO employeeDTO){
		employeeService.save(employeeDTO);
		return new ResponseEntity<>( HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public EmployeeDTO edit(@PathVariable("id")String id) {
		
		return employeeService.findById(id);
	}
	
	@PutMapping
	public ResponseEntity<EmployeeDTO> update(@RequestBody EmployeeDTO employeeDTO) {
		employeeService.save(employeeDTO);
		return new ResponseEntity<>( HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<EmployeeDTO> delete(@PathVariable("id")String id){
		employeeService.DeleteById(id);
		return new ResponseEntity<>( HttpStatus.OK);
	}
}
