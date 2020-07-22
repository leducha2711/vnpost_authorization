package vn.vnpost.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.vnpost.dto.PermissonDTO;

@Service
public interface PermissonService {
	public List<PermissonDTO> findAll();
	public PermissonDTO findById(int id);
}
