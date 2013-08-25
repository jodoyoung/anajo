package org.anajo.server.comp.menu.dao;

import java.util.List;

import org.anajo.server.comp.menu.model.Menu;

/**
 * 메뉴 데이터 제어
 * 
 * @author jodoyoung
 * 
 */
public interface MenuDao {

	/**
	 * 전체 메뉴 조회
	 * 
	 * @return
	 */
	List<Menu> getMenuList();

	/**
	 * 메뉴 ID에 해당하는 메뉴의 하위 메뉴 목록 조회
	 * 
	 * @param menuId
	 * @return
	 */
	List<Menu> getMenuList(String menuId);

	/**
	 * 메뉴 조회
	 * 
	 * @return
	 */
	Menu getMenu(String menuId);

	/**
	 * 메뉴 등록
	 * 
	 * @param menu
	 */
	void insertMenu(Menu menu);

	/**
	 * 메뉴 수정
	 * 
	 * @param menu
	 */
	void updateMenu(Menu menu);

	/**
	 * 메뉴 삭제
	 * 
	 * @param menu
	 */
	void deleteMenu(Menu menu);
}
