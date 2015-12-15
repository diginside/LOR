package com.lor.rentalapp.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lor.rentalapp.service.AuthenticationService;

public class RestAuthenticationFilter implements Filter {

	public static final String AUTHENTICATION_HEADER = "Authorization";

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filter)
			throws IOException, ServletException {
		
		if (request instanceof HttpServletRequest) {
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			String authCredentials = httpRequest.getHeader(AUTHENTICATION_HEADER);
			
			AuthenticationService authService = new AuthenticationService();
			boolean authStatus = authService.authenticate(authCredentials);
			
			if (authStatus) {
				filter.doFilter(request, response);
			} else {
				if (response instanceof HttpServletResponse) {
					HttpServletResponse httpResponse = (HttpServletResponse) response;
					httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				}
			}
		}
		
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
