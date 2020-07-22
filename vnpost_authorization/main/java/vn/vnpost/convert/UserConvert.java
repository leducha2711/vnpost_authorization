package vn.vnpost.convert;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vn.vnpost.dto.UserDTO;
import vn.vnpost.entity.UserEntity;

@Component
public class UserConvert {
	
	@Autowired
	EmployeeConvert employeeConvert;
	@Autowired
	GroupConvert groupConvert;
	
	public UserEntity toEntity(UserDTO dto) {
		ModelMapper mapper = new ModelMapper();
		UserEntity entity = mapper.map(dto, UserEntity.class);
		
		return entity;
	}
	public UserDTO toDTO(UserEntity entity) {
		ModelMapper mapper = new ModelMapper();
		UserDTO dto = mapper.map(entity, UserDTO.class);
		
		return dto;
	}
}
