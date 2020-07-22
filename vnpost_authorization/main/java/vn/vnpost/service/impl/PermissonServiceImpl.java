package vn.vnpost.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.vnpost.convert.PermissonConvert;
import vn.vnpost.dto.PermissonDTO;
import vn.vnpost.entity.PermissonEntity;
import vn.vnpost.repository.PermissonRepsitory;
import vn.vnpost.service.PermissonService;

@Service
@Transactional
public class PermissonServiceImpl implements PermissonService{

	@Autowired
	PermissonConvert  permissonConvert;
	@Autowired
	PermissonRepsitory permissonRepsitory;
	
	@Override
	public List<PermissonDTO> findAll() {
		List<PermissonDTO> dtos = new ArrayList<PermissonDTO>();
		List<PermissonEntity> entities = permissonRepsitory.findAll();
		for (PermissonEntity permissonEntity : entities) {
			dtos.add(permissonConvert.toDTO(permissonEntity));
		}
		return dtos;
	}

	@Override
	public PermissonDTO findById(int id) {
		// TODO Auto-generated method stub
		return permissonConvert.toDTO(permissonRepsitory.findById(id).get());
	}

}
