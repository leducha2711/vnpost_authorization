package vn.vnpost.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import vn.vnpost.dto.GroupDTO;
import vn.vnpost.dto.PermissonDTO;
import vn.vnpost.service.GroupService;

@Component
public class MenuUtils {

	@Autowired
	GroupService groupService;
	
	public List<PermissonDTO> getMenu(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		List<PermissonDTO> permissonDTOs= new ArrayList<PermissonDTO>();
		for(GrantedAuthority grantedAuthority : auth.getAuthorities()) {
			GroupDTO groupDTO = groupService.findByCode(grantedAuthority.getAuthority());
			for(PermissonDTO permissonDTO :groupDTO.getPermissons()) {
				permissonDTOs.add(permissonDTO);
			}
		}
		return permissonDTOs;
		
	}
}
