package org.anajo.server.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

	private static final Logger logger = LoggerFactory
			.getLogger(AuthController.class);

	@RequestMapping("/loginPage")
	public String loginPage(Model model) {
		return "auth/login.tiles";
	}

	@RequestMapping("/logoutPage")
	public String logoutPage(Model model) {
		return "auth/logout.tiles";
	}

	@RequestMapping("/loginFailed")
	public String loginFailed(Model model) {
		return "auth/login_failed.tiles";
	}

	@RequestMapping("/accessDenied")
	public String accessDenied(Model model) {
		return "auth/access_denied.tiles";
	}
}
