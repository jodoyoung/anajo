package org.anajo.server.comp.menu.service;

import java.util.List;

import org.anajo.server.comp.menu.MenuService;
import org.anajo.server.comp.menu.dao.MenuDao;
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
		return dao.getMenuList();
	}

	@Override
	public List<Menu> getMenuList(String menuId) {
		return dao.getMenuList(menuId);
	}

	@Override
	public Menu getMenu(String menuId) {
		return dao.getMenu(menuId);
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
		dao.deleteMenu(dao.getMenu(menuId));
	}

}
