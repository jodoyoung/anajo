package org.anajo.server.comp.menu;

import java.util.List;

import org.anajo.server.comp.menu.model.Menu;
import org.springframework.stereotype.Repository;

/**
 * 메뉴 데이터 제어
 * 
 * @author jodoyoung
 * 
 */
@Repository
public interface MenuDao {

	/**
	 * 메뉴의 하위 메뉴 목록 조회 상위 메뉴 ID가 null일 경우 전체 조회
	 * 
	 * @param parentMenuId
	 * @return
	 */
	List<Menu> selectMenus(String parentMenuId);

	/**
	 * 메뉴 조회
	 * 
	 * @return
	 */
	Menu selectMenu(String menuId);

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
	 * @param menuId
	 */
	void deleteMenu(String menuId);
}
