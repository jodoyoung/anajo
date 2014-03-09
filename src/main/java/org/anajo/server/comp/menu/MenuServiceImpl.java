package org.anajo.server.comp.menu;

import java.util.List;

import org.anajo.server.comp.menu.model.Menu;
import org.anajo.server.comp.role.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {

	@Autowired
	MenuDao menuDao;

	@Autowired
	RoleDao roleDao;

	@Override
	public List<Menu> getMenuList() {
		return this.getMenuList(null);
	}

	@Cacheable(value = "testCache")
	@Override
	public List<Menu> getMenuList(String menuId) {
		return menuDao.selectMenus(menuId);
	}

	@Cacheable(value = "testCache")
	@Override
	public Menu getMenu(String menuId) {
		Menu menu = menuDao.selectMenu(menuId);
		menu.setRoles(roleDao.selectMenuRoles(menuId));
		return menu;
	}

	@CacheEvict(value = "testCache")
	@Override
	public void createMenu(Menu menu) {
		menuDao.insertMenu(menu);
	}

	@CacheEvict(value = "testCache")
	@Override
	public void updateMenu(Menu menu) {
		menuDao.updateMenu(menu);
	}

	@CacheEvict(value = "testCache")
	@Override
	public void deleteMenu(String menuId) {
		menuDao.deleteMenu(menuId);
	}

}
