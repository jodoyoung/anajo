package org.anajo.server.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

public class AuthenticationSuccessHandler extends
		SavedRequestAwareAuthenticationSuccessHandler {
	private static final Logger log = LoggerFactory
			.getLogger(AuthenticationSuccessHandler.class);

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		log.debug("############ : Login Success !");
		super.onAuthenticationSuccess(request, response, authentication);
	}
}
