package vn.vnpost.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.vnpost.dto.PermissonDTO;
import vn.vnpost.dto.UserDTO;
import vn.vnpost.service.GroupService;
import vn.vnpost.service.UserService;
import vn.vnpost.util.MenuUtils;

@Controller
public class HomeController {
	
	@Autowired
	UserService userService;
	@Autowired
	GroupService  groupService;
	
	@Autowired
	MenuUtils menuUtils;
	
	@GetMapping("/")
	public String home(HttpServletRequest request) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username =userDetails.getUsername();
		UserDTO userDTO = userService.findByUsername(username);
		request.setAttribute("user", userDTO);
		
		List<PermissonDTO> permissonDTOs = menuUtils.getMenu();
		request.setAttribute("menu", permissonDTOs);
		return "index";
	}
	@GetMapping("/dang-nhap")
	public String login(HttpServletRequest  request, @RequestParam(name="accessDenies", required = false) String deny) {
		if(deny !=null) {
			request.setAttribute("e", deny);
		}
		return "Login";
	}
}
