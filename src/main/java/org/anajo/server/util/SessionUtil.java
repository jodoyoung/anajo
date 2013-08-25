package org.anajo.server.util;

import org.anajo.server.comp.member.model.Member;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * 세션 제어 도구
 * 
 * @author jodoyoung
 * 
 */
public class SessionUtil {

	public static String getCurrentUserId() {
		return SessionUtil.getCurrentUser() == null ? null : SessionUtil
				.getCurrentUser().getMemberId();
	}

	public static String getCurrentUserEmail() {
		return SessionUtil.getCurrentUser() == null ? null : SessionUtil
				.getCurrentUser().getEmail();
	}

	public static String getCurrentUserName() {
		return SessionUtil.getCurrentUser() == null ? null : SessionUtil
				.getCurrentUser().getName();
	}

	public static Member getCurrentUser() {
		Member member = null;
		Object obj = SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		if (obj instanceof Member) {
			member = (Member) obj;
		}
		return member;
	}

}
