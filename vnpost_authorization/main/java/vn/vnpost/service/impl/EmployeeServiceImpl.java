package vn.vnpost.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.vnpost.convert.EmployeeConvert;
import vn.vnpost.dto.EmployeeDTO;
import vn.vnpost.entity.EmployeeEntity;
import vn.vnpost.repository.EmployeeRepository;
import vn.vnpost.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	EmployeeConvert convert;
	@Override
	public List<EmployeeDTO> findAll() {
		List<EmployeeDTO> employeeDTOs = new ArrayList<EmployeeDTO>();
		List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
		for (EmployeeEntity employeeEntity : employeeEntities) {
			employeeDTOs.add(convert.toDTO(employeeEntity));
		}
		return employeeDTOs;
	}
	@Override
	public void save(EmployeeDTO employeeDTO) {
		
		employeeRepository.save(convert.toEntity(employeeDTO));
		
	}
	@Override
	public EmployeeDTO findById(String id) {
		EmployeeEntity employeeEntity=employeeRepository.findById(id);
		return convert.toDTO(employeeEntity);
	}
	@Override
	public void DeleteById(String id) {
		EmployeeEntity entity  = convert.toEntity(findById(id));
		employeeRepository.delete(entity);
	}
	
	
}
