package vn.vnpost.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import vn.vnpost.dto.ActionDetailDTO;
import vn.vnpost.dto.GroupDTO;
import vn.vnpost.dto.PermissonDTO;
import vn.vnpost.dto.UserDTO;
import vn.vnpost.service.GroupService;
import vn.vnpost.service.UserService;
import vn.vnpost.util.FunctionUtil;
import vn.vnpost.util.MenuUtils;
import vn.vnpost.util.UserUtil;

@Controller
public class GroupMemberController {
	@Autowired
	UserService userService;
	@Autowired
	GroupService  groupService;
	
	@Autowired
	MenuUtils menuUtils;
	@Autowired
	UserUtil userUtil;
	@Autowired
	FunctionUtil funcUtil;
	
	@GetMapping("/groupMember")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("QTND/groupMember");
		
		
		UserDTO userDTO = userUtil.getUser();
		mav.addObject("user", userDTO);
		List<PermissonDTO> permissonDTOs = menuUtils.getMenu();
		mav.addObject("menu", permissonDTOs);
		
		List<ActionDetailDTO> actionDetailDTOs = funcUtil.getFunc("USERGROUP");
		mav.addObject("funcs", actionDetailDTOs);
		
		List<String> list = new ArrayList<String>();
		for (ActionDetailDTO actionDetailDTO : actionDetailDTOs) {
			list.add(actionDetailDTO.getCode());
		}
		mav.addObject("act", list);
		mav.addObject("newgroup", new GroupDTO());
		mav.addObject("group", groupService.findAll());
		
		return mav;
	}
	
	@PostMapping("/groupMember/add")
	public String add(@ModelAttribute("new") GroupDTO groupDTO) {
		
		groupService.add(groupDTO);
		return "redirect:/groupMember";
	}
	@PostMapping("/groupMember/edit")
	public String edit(@ModelAttribute("new") GroupDTO groupDTO) {
		
		groupService.update(groupDTO);
		return "redirect:/groupMember";
	}
}
