package vn.vnpost.convert;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import vn.vnpost.dto.ActionDetailDTO;
import vn.vnpost.entity.ActionDetailEntity;

@Component
public class ActionDetailConvert {
	public ActionDetailEntity toEntity(ActionDetailDTO dto) {
		ModelMapper mapper = new ModelMapper();
		ActionDetailEntity entity = mapper.map(dto, ActionDetailEntity.class);
		return entity;
	}
	public ActionDetailDTO toDTO(ActionDetailEntity entity) {
		ModelMapper mapper = new ModelMapper();
		ActionDetailDTO dto = mapper.map(entity, ActionDetailDTO.class);
		return dto;
	}
}
