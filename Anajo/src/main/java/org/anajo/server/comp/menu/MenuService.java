package org.anajo.server.comp.menu;

import java.util.List;

import org.anajo.server.comp.menu.model.Menu;

/**
 * 메뉴 서비스
 * 
 * @author jodoyoung
 * 
 */
public interface MenuService {

	/**
	 * 전체 메뉴 조회
	 * 
	 * @return
	 */
	List<Menu> getMenuList();

	/**
	 * menuId에 해당하는 메뉴의 하위 메뉴 목록 조회
	 * 
	 * @param menuId
	 * @return
	 */
	List<Menu> getMenuList(String menuId);

	/**
	 * 메뉴 조회
	 * 
	 * @param menuId
	 * @return
	 */
	Menu getMenu(String menuId);

	/**
	 * 메뉴 등록
	 * 
	 * @param menu
	 */
	void createMenu(Menu menu);

	/**
	 * 메뉴 수정
	 * 
	 * @param menu
	 */
	void updateMenu(Menu menu);

	/**
	 * 메뉴 삭제
	 * 
	 * @param menuId
	 */
	void deleteMenu(String menuId);
}
