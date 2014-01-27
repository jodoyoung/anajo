package org.anajo.server.aspect;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.anajo.server.comp.menu.MenuService;
import org.anajo.server.comp.menu.model.Menu;
import org.anajo.server.comp.role.RoleManager;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MenuInterceptor extends HandlerInterceptorAdapter implements
		ApplicationContextAware {

	ApplicationContext appContext = null;

	@Override
	public void setApplicationContext(ApplicationContext ctx)
			throws BeansException {
		this.appContext = ctx;
	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res,
			Object handler) {
		MenuService menuService = (MenuService) appContext
				.getBean(MenuService.class);
		RoleManager roleManager = (RoleManager) appContext
				.getBean(RoleManager.class);

		Collection<Menu> menus = menuService.getMenuList("main");
		for (Menu menu : menus) {
			menu.setRoles(roleManager.getMenuRoles(menu.getMenuId()));
		}

		req.setAttribute("topMenus", menus);

		return true;
	}

}
