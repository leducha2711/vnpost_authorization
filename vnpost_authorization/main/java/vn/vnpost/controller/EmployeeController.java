package vn.vnpost.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import vn.vnpost.dto.ActionDetailDTO;
import vn.vnpost.dto.PermissonDTO;
import vn.vnpost.dto.UserDTO;
import vn.vnpost.service.EmployeeService;
import vn.vnpost.util.FunctionUtil;
import vn.vnpost.util.MenuUtils;
import vn.vnpost.util.UserUtil;

@Controller
public class EmployeeController {

	@Autowired
	MenuUtils menuUtils;
	@Autowired
	UserUtil userUtil;
	@Autowired
	FunctionUtil funcUtil;
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/employees")
	public ModelAndView employee() {
		ModelAndView mav = new ModelAndView("QTND/employees");
		
		
		UserDTO userDTO = userUtil.getUser();
		mav.addObject("user", userDTO);
		List<PermissonDTO> permissonDTOs = menuUtils.getMenu();
		mav.addObject("menu", permissonDTOs);
		
		List<ActionDetailDTO> actionDetailDTOs = funcUtil.getFunc("McasEmployee");
		mav.addObject("funcs", actionDetailDTOs);
		List<String> list = new ArrayList<String>();
		
		for (ActionDetailDTO actionDetailDTO : actionDetailDTOs) {
			list.add(actionDetailDTO.getCode());
		}
		mav.addObject("act", list);
		
		mav.addObject("emp",employeeService.findAll() );
		
		return mav;
	}
}
