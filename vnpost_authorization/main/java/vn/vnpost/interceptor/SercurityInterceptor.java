package vn.vnpost.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import vn.vnpost.entity.ActionDetailEntity;
import vn.vnpost.entity.ActionEntity;
import vn.vnpost.entity.GroupEntity;
import vn.vnpost.repository.ActionRepository;
import vn.vnpost.repository.GroupRepository;
import vn.vnpost.util.UrlServletUtils;

@Component
public class SercurityInterceptor implements HandlerInterceptor{

	@Autowired
	UrlServletUtils  urlServletUtils;
	@Autowired
	GroupRepository groupRepository;
	@Autowired
	ActionRepository actionRepository;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		String url = urlServletUtils.getUrl(request);
		Boolean check = false;
		for(GrantedAuthority authority : authentication.getAuthorities()) {
			GroupEntity groupEntity = groupRepository.findByCode(authority.getAuthority());
			ActionEntity actionEntity = actionRepository.findByUrl(url);
			if(actionEntity.getId()>0) {
				for(ActionDetailEntity actionDetailEntity : groupEntity.getActiondetails()) {
					System.out.println(actionDetailEntity.getName());
					if(actionDetailEntity.getAction().getId()== actionEntity.getId()) {
						check = true;
						break;
					}else {
						check = false;
					}
				}
			}
			
			
		}
		if(!check) {
			
			response.sendRedirect("/");
		}
		return true;
	}
}
