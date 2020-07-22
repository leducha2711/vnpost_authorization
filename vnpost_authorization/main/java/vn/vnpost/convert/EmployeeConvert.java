package vn.vnpost.convert;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import vn.vnpost.dto.EmployeeDTO;
import vn.vnpost.entity.EmployeeEntity;

@Component
public class EmployeeConvert {
	public EmployeeEntity toEntity(EmployeeDTO dto) {
		ModelMapper mapper = new ModelMapper();
		EmployeeEntity entity = mapper.map(dto, EmployeeEntity.class);
		return entity;
	}
	public EmployeeDTO toDTO(EmployeeEntity entity) {
		ModelMapper mapper = new ModelMapper();
		EmployeeDTO dto = mapper.map(entity, EmployeeDTO.class);
		return dto;
	}
}
