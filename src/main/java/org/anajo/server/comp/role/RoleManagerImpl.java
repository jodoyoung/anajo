package org.anajo.server.comp.role;

import java.util.Set;

import org.anajo.server.comp.role.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleManagerImpl implements RoleManager {

	@Autowired
	RoleDao dao;

	@Override
	public Set<Role> getRoles() {
		return dao.selectRoles();
	}

	@Override
	public Set<Role> getUserRoles(String memberId) {
		return dao.selectUserRoles(memberId);
	}

	@Override
	public Set<Role> getMenuRoles(String menuId) {
		return dao.selectMenuRoles(menuId);
	}

	@Override
	public Role getRole(String roleId) {
		return dao.selectRole(roleId);
	}

	@Override
	public void createRole(Role role) {
		dao.insertRole(role);
	}

	@Override
	public void updateRole(Role role) {
		dao.updateRole(role);
	}

	@Override
	public void deleteRole(String roleId) {
		dao.deleteRole(roleId);
	}

}
