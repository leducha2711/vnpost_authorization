package vn.vnpost.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.vnpost.dto.UserDTO;

@Service
@Transactional
public interface UserService {
	public UserDTO findByUsername(String username);
}
