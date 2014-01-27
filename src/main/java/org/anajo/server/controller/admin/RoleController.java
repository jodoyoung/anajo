package org.anajo.server.controller.admin;

import org.anajo.server.comp.role.RoleManager;
import org.anajo.server.comp.role.model.Role;
import org.anajo.server.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 권한 제어
 * 
 * @author jodoyoung
 * 
 */
@Controller
@RequestMapping("/admin/role")
public class RoleController {

	@Autowired
	RoleManager roleManager;

	/**
	 * 권한 목록
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("")
	public String roleList(Model model) {
		model.addAttribute("roles", roleManager.getRoles());
		return "admin/role/list.tiles";
	}

	/**
	 * 권한 보기
	 * 
	 * @param roleId
	 * @return
	 */
	@RequestMapping(value = "/read")
	public String role(@RequestParam String roleId, Model model) {
		model.addAttribute("role", roleManager.getRole(roleId));
		return "admin/role/read.tiles";
	}

	/**
	 * 권한 작성 페이지로 이동
	 * 
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String writeCreateRole(Model model) {
		model.addAttribute("roleId", IdGenerator.createUUID());
		return "admin/role/create.tiles";
	}

	/**
	 * 권한 추가
	 * 
	 * @param role
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createRole(@ModelAttribute Role role) {
		roleManager.createRole(role);
		return "forward:/admin/role";
	}

	/**
	 * 권한 수정 페이지로 이동
	 * 
	 * @param roleId
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String writeUpdateRole(@RequestParam String roleId, Model model) {
		model.addAttribute("role", roleManager.getRole(roleId));
		return "admin/role/update.tiles";
	}

	/**
	 * 권한 수정
	 * 
	 * @param role
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateRole(@ModelAttribute Role role) {
		roleManager.updateRole(role);
		return "forward:/admin/role";
	}

	/**
	 * 권한 삭제
	 * 
	 * @param roleId
	 * @return
	 */
	@RequestMapping(value = "/delete")
	public String deleteRole(@RequestParam String roleId) {
		roleManager.deleteRole(roleId);
		return "forward:/admin/role";
	}

}
