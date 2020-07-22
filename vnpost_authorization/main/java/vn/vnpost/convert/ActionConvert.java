package vn.vnpost.convert;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import vn.vnpost.dto.ActionDTO;
import vn.vnpost.entity.ActionEntity;

@Component
public class ActionConvert {
	public ActionEntity toEntity(ActionDTO dto) {
		ModelMapper mapper = new ModelMapper();
		ActionEntity entity = mapper.map(dto, ActionEntity.class);
		return entity;
	}
	public ActionDTO toDTO(ActionEntity entity) {
		ModelMapper mapper = new ModelMapper();
		ActionDTO dto = mapper.map(entity, ActionDTO.class);
		return dto;
	}
}
