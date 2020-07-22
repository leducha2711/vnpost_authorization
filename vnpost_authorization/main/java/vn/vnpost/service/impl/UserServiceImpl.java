package vn.vnpost.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.vnpost.convert.UserConvert;
import vn.vnpost.dto.UserDTO;
import vn.vnpost.entity.UserEntity;
import vn.vnpost.repository.UserRepository;
import vn.vnpost.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	@Autowired
	UserConvert userConvert;
	
	@Override
	public UserDTO findByUsername(String username) {
		UserEntity userEntity = userRepository.findByUsername(username);
		return userConvert.toDTO(userEntity);
	}

}
