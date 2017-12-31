package com.kshrd.configurations;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomerSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		String redirectUrl = (String)request.getSession().getAttribute("REQUESTED_URL");
		
		if (redirectUrl == null){
			for (GrantedAuthority authority : authentication.getAuthorities()) {
				if (authority.getAuthority().equals("ROLE_ADMIN"))
					redirectUrl = "/admin";
				if (authority.getAuthority().equals("ROLE_DBA"))
					redirectUrl = "/dba";
				if (authority.getAuthority().equals("ROLE_USER"))
					redirectUrl = "/user";
			}
		}
		
		response.sendRedirect(redirectUrl);
	}

}
