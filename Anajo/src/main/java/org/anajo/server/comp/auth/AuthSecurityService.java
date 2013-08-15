package org.anajo.server.comp.auth;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.anajo.server.comp.member.MemberService;
import org.anajo.server.comp.member.model.Member;
import org.anajo.server.comp.role.model.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("authService")
@Transactional
public class AuthSecurityService implements AuthService, UserDetailsService {

	private static final Logger logger = LoggerFactory
			.getLogger(AuthSecurityService.class);

	@Autowired
	MemberService memberService;

	@Autowired
	private HttpServletRequest request;

	@Override
	public UserDetails login(String email, String password) {
		UserDetails member = loadUserByUsername(email);

		if (password.equals(member.getPassword())) {
			return member;
		}

		return null;
	}

	@Override
	public UserDetails loadUserByUsername(String email)
			throws UsernameNotFoundException {

		Member member = memberService.getMemberByEmail(email);

		if (member == null)
			throw new UsernameNotFoundException("User Not Found!");

		logger.debug("Member >>> {}", member);

		List<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();

		for (Role role : member.getRoles()) {
			SimpleGrantedAuthority auth = new SimpleGrantedAuthority(
					role.getRoleName());
			roles.add(auth);
		}

		UserDetails user = new User(member.getEmail(), member.getPassword(),
				roles);

		logger.debug("User >>> {}", user);

		return user;
	}

	/**
	 * 현재 접속중인 사용자 정보 조회
	 * 
	 * @return
	 */
	public static UserDetails getCurrnetUser() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			logger.debug("Current User Name > username : {}",
					((UserDetails) principal).getUsername());
			return (UserDetails) principal;
		} else {
			logger.debug("User Not Found > username : {}", principal.toString());
			return null;
		}
	}
}
