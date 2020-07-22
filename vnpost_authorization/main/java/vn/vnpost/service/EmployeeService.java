package vn.vnpost.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.vnpost.dto.EmployeeDTO;

@Service
public interface EmployeeService {
	public List<EmployeeDTO> findAll();
	public void save(EmployeeDTO employeeDTO);
	public EmployeeDTO findById(String id);
	public void DeleteById(String id);
}
