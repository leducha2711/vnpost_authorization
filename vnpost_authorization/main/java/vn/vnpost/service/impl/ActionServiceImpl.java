package vn.vnpost.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.vnpost.convert.ActionConvert;
import vn.vnpost.dto.ActionDTO;
import vn.vnpost.entity.ActionEntity;
import vn.vnpost.repository.ActionRepository;
import vn.vnpost.service.ActionService;

@Service
@Transactional
public class ActionServiceImpl implements ActionService{

	@Autowired
	ActionRepository repository;
	@Autowired
	ActionConvert actionConvert;
	
	@Override
	public ActionDTO findByCode(String code) {
		ActionEntity actionEntity = repository.findByCode(code);
		return actionConvert.toDTO(actionEntity);
	}

	@Override
	public Boolean existsByIdIn(List<Integer> list) {
		// TODO Auto-generated method stub
		return repository.existsByIdIn(list);
	}

}
