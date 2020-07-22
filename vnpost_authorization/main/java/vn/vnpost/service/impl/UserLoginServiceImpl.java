package vn.vnpost.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.vnpost.entity.GroupEntity;
import vn.vnpost.entity.UserEntity;
import vn.vnpost.repository.UserRepository;

@Service
@Transactional
public class UserLoginServiceImpl implements UserDetailsService{
	@Autowired
    PasswordEncoder passwordEncoder;
	
	@Autowired
	UserRepository  userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity= userRepository.findByUsername(username);
		if(userEntity== null) {
			throw new UsernameNotFoundException("No user");
		}
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		GroupEntity groupEntity = userEntity.getGroup();
		authorities.add(new SimpleGrantedAuthority(groupEntity.getCode()));
		String pass =passwordEncoder.encode(userEntity.getPassword());
		UserDetails userDetails = new org.springframework.security.core.userdetails.User(userEntity.getUsername(),pass, true, true, true, true, authorities);
		return userDetails;
	}

}
