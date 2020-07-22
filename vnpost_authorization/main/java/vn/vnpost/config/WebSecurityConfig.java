package vn.vnpost.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import vn.vnpost.service.impl.UserLoginServiceImpl;



@Configuration
@EnableWebSecurity
@EntityScan(basePackages = "vn.vnpost.entity")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	UserLoginServiceImpl loginServiecImpl;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        
        return new BCryptPasswordEncoder();
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().anyRequest().authenticated().
		and().formLogin().loginPage("/dang-nhap").loginProcessingUrl("/login").
		defaultSuccessUrl("/").failureUrl("/dang-nhap?accessDenies=true").permitAll().
		and().logout().permitAll();
	}
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**","/img/**");
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(loginServiecImpl).passwordEncoder(passwordEncoder);
	}
}
