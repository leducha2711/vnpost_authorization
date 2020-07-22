package vn.vnpost.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import vn.vnpost.entity.ActionDetailEntity;
import vn.vnpost.entity.ActionEntity;
import vn.vnpost.entity.GroupEntity;
import vn.vnpost.repository.ActionRepository;
import vn.vnpost.repository.GroupRepository;
import vn.vnpost.util.UrlServletUtils;

public class GroupFilter implements Filter{
	@Autowired
	UrlServletUtils  urlServletUtils;
	@Autowired
	GroupRepository groupRepository;
	@Autowired
	ActionRepository actionRepository;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		HttpServletResponse response2 = (HttpServletResponse) response;
		HttpServletRequest request2 = (HttpServletRequest) request;
		String url = urlServletUtils.getUrl(request2);
		Boolean check = false;
		for(GrantedAuthority authority : authentication.getAuthorities()) {
			GroupEntity groupEntity = groupRepository.findByCode(authority.getAuthority());
			ActionEntity actionEntity = actionRepository.findByUrl(url);
			for(ActionDetailEntity actionDetailEntity : groupEntity.getActiondetails()) {
				if(actionDetailEntity.getAction().getCode().equals(actionEntity.getCode())) {
					check=true;
					break;
				}else {
					check=false;
				}
			}
		}
		if(check==true) {
			chain.doFilter(request2, response2);
		}else {
			response2.sendRedirect("/");
		}
	}

}
