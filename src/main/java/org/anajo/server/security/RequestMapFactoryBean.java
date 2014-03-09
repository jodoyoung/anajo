package org.anajo.server.security;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.anajo.server.comp.menu.MenuService;
import org.anajo.server.comp.menu.model.Menu;
import org.anajo.server.comp.role.RoleManager;
import org.anajo.server.comp.role.model.Role;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

/**
 * ResourceMap 생성
 * 
 * @author jodoyoung
 * @date 2014.02.08
 */
public class RequestMapFactoryBean implements
		FactoryBean<LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>>> {

	@Autowired
	MenuService menuService;

	@Autowired
	RoleManager roleManager;

	@Override
	public LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> getObject()
			throws Exception {
		List<Menu> menus = menuService.getMenuList();

		LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> requestMap = new LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>>();

		for (Menu menu : menus) {
			Set<Role> roles = roleManager.getMenuRoles(menu.getMenuId());

			if (roles.size() == 0)
				continue;

			Collection<ConfigAttribute> securityRoles = new LinkedHashSet<ConfigAttribute>();

			for (Role role : roles) {
				securityRoles.add(role);
			}

			String url = menu.getLink();
			String lastString = url.substring(url.length() - 1, url.length());
			if ("/".equals(lastString)) {
				url = url.substring(0, url.length() - 1);
			}
			url += "/**";

			requestMap.put(new AntPathRequestMatcher(url), securityRoles);
		}

		return requestMap;
	}

	@Override
	public Class getObjectType() {
		return LinkedHashMap.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}
