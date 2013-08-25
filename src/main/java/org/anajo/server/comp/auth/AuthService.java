package org.anajo.server.comp.auth;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * 인증 서비스
 * 
 * @author jodoyoung
 * 
 */
public interface AuthService {

	/**
	 * 로그인
	 * 
	 * @param email
	 * @param password
	 * @return
	 */
	UserDetails login(String email, String password);
}
