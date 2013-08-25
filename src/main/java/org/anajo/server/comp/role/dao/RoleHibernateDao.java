package org.anajo.server.comp.role.dao;

import java.util.List;

import org.anajo.server.comp.role.model.Role;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleHibernateDao implements RoleDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Role> getRoles() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Role.class);
		return criteria.list();
	}

	@Override
	public Role getRole(String roleId) {
		Session session = sessionFactory.getCurrentSession();
		return (Role) session.get(Role.class, roleId);
	}

	@Override
	public void insertRole(Role role) {
		Session session = sessionFactory.getCurrentSession();
		session.save(role);
	}

	@Override
	public void updateRole(Role role) {
		Session session = sessionFactory.getCurrentSession();
		session.update(role);
	}

	@Override
	public void deleteRole(Role role) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(role);
	}

}
