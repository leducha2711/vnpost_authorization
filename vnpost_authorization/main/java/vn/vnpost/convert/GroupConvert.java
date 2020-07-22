package vn.vnpost.convert;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vn.vnpost.dto.GroupDTO;
import vn.vnpost.entity.GroupEntity;

@Component
public class GroupConvert {
	@Autowired
	UserConvert userConvert;
	
	public GroupEntity toEntity(GroupDTO dto) {
		ModelMapper mapper = new ModelMapper();
		GroupEntity entity = mapper.map(dto, GroupEntity.class);
		return entity;
	}
	public GroupDTO toDTO(GroupEntity entity) {
		ModelMapper mapper = new ModelMapper();
		GroupDTO dto = mapper.map(entity, GroupDTO.class);
		return dto;
	}
}
