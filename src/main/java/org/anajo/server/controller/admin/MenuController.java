package org.anajo.server.controller.admin;

import org.anajo.server.comp.menu.MenuService;
import org.anajo.server.comp.menu.model.Menu;
import org.anajo.server.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin/menu")
public class MenuController {

	@Autowired
	MenuService menuService;

	/**
	 * Menu 목록
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("")
	public String menuList(Model model) {
		model.addAttribute("menus", menuService.getMenuList());
		return "admin/menu/list.admin";
	}

	/**
	 * Menu 보기
	 * 
	 * @param menuId
	 * @return
	 */
	@RequestMapping(value = "/read")
	public String Menu(@RequestParam String menuId, Model model) {
		model.addAttribute("menu", menuService.getMenu(menuId));
		return "admin/menu/read.admin";
	}

	/**
	 * Menu 작성 페이지로 이동
	 * 
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String writeCreateMenu(Model model) {
		model.addAttribute("menuId", IdGenerator.createUUID());
		return "admin/menu/create.admin";
	}

	/**
	 * Menu 등록
	 * 
	 * @param Menu
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createMenu(@RequestBody Menu menu) {
		menu.setMenuId(IdGenerator.createUUID());
		menuService.createMenu(menu);
		return "forward:/admin/menu";
	}

	/**
	 * Menu 수정 페이지로 이동
	 * 
	 * @param menuId
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String writeUpdateMenu(@RequestParam String menuId, Model model) {
		model.addAttribute("menu", menuService.getMenu(menuId));
		return "admin/menu/update.admin";
	}

	/**
	 * Menu 수정
	 * 
	 * @param menu
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateMenu(@ModelAttribute Menu menu) {
		menuService.updateMenu(menu);
		return "forward:/admin/menu";
	}

	/**
	 * Menu 삭제
	 * 
	 * @param menuId
	 * @return
	 */
	@RequestMapping(value = "/delete")
	public String deleteMenu(@RequestParam String menuId) {
		menuService.deleteMenu(menuId);
		return "forward:/admin/menu";
	}
}
