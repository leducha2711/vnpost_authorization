package vn.vnpost.convert;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vn.vnpost.dto.PermissonDTO;
import vn.vnpost.entity.PermissonEntity;

@Component
public class PermissonConvert {
	@Autowired
	ActionConvert actionConvert;
	@Autowired
	GroupConvert groupConvert;
	
	public PermissonEntity toEntity(PermissonDTO dto) {
		ModelMapper mapper = new ModelMapper();
		PermissonEntity entity = mapper.map(dto, PermissonEntity.class);
		return entity;
	}
	public PermissonDTO toDTO(PermissonEntity entity) {
		ModelMapper mapper = new ModelMapper();
		PermissonDTO dto = mapper.map(entity, PermissonDTO.class);
		
		return dto;
	}
}
