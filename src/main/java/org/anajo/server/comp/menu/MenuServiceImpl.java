package org.anajo.server.comp.menu;

import java.util.List;

import org.anajo.server.comp.menu.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {

	@Autowired
	MenuDao dao;

	@Override
	public List<Menu> getMenuList() {
		return this.getMenuList(null);
	}

	@Override
	public List<Menu> getMenuList(String menuId) {
		return dao.selectMenus(menuId);
	}

	@Override
	public Menu getMenu(String menuId) {
		return dao.selectMenu(menuId);
	}

	@Override
	public void createMenu(Menu menu) {
		dao.insertMenu(menu);
	}

	@Override
	public void updateMenu(Menu menu) {
		dao.updateMenu(menu);
	}

	@Override
	public void deleteMenu(String menuId) {
		dao.deleteMenu(menuId);
	}

}
