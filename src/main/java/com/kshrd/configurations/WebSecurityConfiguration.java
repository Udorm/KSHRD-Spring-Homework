package com.kshrd.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	UserDetailsService userDetailsService;
	@Autowired
	AuthenticationSuccessHandler successHandler;
	@Autowired
	AuthenticationEntryPoint authenticationEntryPoint;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.formLogin()
			.loginPage("/login") //Custom login page
			//.successForwardUrl("/index");
			.successHandler(successHandler);
		
		http.logout()
			.logoutSuccessUrl("/")
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
		
		http.authorizeRequests()
			.antMatchers("/admin/**").hasRole("ADMIN")
			.antMatchers("/dba/**").hasAnyRole("ADMIN", "DBA")
			.antMatchers("/user/**").hasAnyRole("ADMIN", "DBA", "USER");
		
		http.exceptionHandling()
			.authenticationEntryPoint(authenticationEntryPoint);
	}
}
