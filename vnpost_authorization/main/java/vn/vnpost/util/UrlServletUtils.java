package vn.vnpost.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

@Component
public class UrlServletUtils {
	public String getUrl(HttpServletRequest request) {
		String rawUrl = request.getServletPath();
		return rawUrl;
	}
}
