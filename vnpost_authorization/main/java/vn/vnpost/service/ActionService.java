package vn.vnpost.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.vnpost.dto.ActionDTO;

@Service
public interface ActionService {

	public ActionDTO findByCode(String code);
	public Boolean existsByIdIn(List<Integer> list );
}
