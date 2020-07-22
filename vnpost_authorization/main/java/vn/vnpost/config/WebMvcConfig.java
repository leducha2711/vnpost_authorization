package vn.vnpost.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import vn.vnpost.interceptor.SercurityInterceptor;
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{

	@Autowired
	 SercurityInterceptor sercurityInterceptor;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(sercurityInterceptor).addPathPatterns("/*").excludePathPatterns("/dang-nhap","/");
	}
}
