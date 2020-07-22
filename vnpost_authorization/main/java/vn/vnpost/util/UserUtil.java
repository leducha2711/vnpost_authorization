package vn.vnpost.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import vn.vnpost.dto.UserDTO;
import vn.vnpost.service.UserService;

@Component
public class UserUtil {
	@Autowired
	UserService userService;
	public UserDTO getUser() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username =userDetails.getUsername();
		UserDTO userDTO = userService.findByUsername(username);
		return userDTO;
	}
}
