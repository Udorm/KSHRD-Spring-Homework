package com.kshrd.configurations;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint{

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		
		System.out.println("authentication entry point");
		System.out.println("Requested URI: " + request.getRequestURI());
		System.out.println("Requested URL: " + request.getRequestURL());
		
		request.getSession().setAttribute("REQUESTED_URL", request.getRequestURL().toString());
		
		response.sendRedirect("/login");
	}

}
