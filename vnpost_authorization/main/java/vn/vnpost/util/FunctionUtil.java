package vn.vnpost.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import vn.vnpost.dto.ActionDetailDTO;
import vn.vnpost.service.ActionDetailService;
import vn.vnpost.service.ActionService;
import vn.vnpost.service.GroupService;

@Component
public class FunctionUtil {

	@Autowired
	ActionService actionService;
	@Autowired
	ActionDetailService actionDetailService;
	@Autowired
	GroupService groupService;
	
	public List<ActionDetailDTO> getFunc(String code){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		int actionid = actionService.findByCode(code).getId();
		List<ActionDetailDTO> results = new ArrayList<ActionDetailDTO>();
		for(GrantedAuthority authority :authentication.getAuthorities()) {
			int groupid = groupService.findByCode(authority.getAuthority()).getId();
			List<ActionDetailDTO> actionDetailDTOs= actionDetailService.findByActionIdAndGroupId(actionid, groupid);
			for (ActionDetailDTO actionDetailDTO : actionDetailDTOs) {
				results.add(actionDetailDTO);
			}
			
		}
		return results;
	}
}
