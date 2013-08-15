package org.anajo.server.comp.role.service;

import java.util.List;

import org.anajo.server.comp.role.RoleManager;
import org.anajo.server.comp.role.dao.RoleDao;
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
	public List<Role> getRoleList() {
		return dao.getRoles();
	}

	@Override
	public void createRole(Role role) {
		dao.insertRole(role);
	}

	@Override
	public Role getRole(String roleId) {
		return dao.getRole(roleId);
	}

	@Override
	public void updateRole(Role role) {
		dao.updateRole(role);
	}

	@Override
	public void deleteRole(String roleId) {
		dao.deleteRole(dao.getRole(roleId));
	}

}
