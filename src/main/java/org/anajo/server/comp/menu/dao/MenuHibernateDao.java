package org.anajo.server.comp.menu.dao;

import java.util.List;

import org.anajo.server.comp.menu.model.Menu;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MenuHibernateDao implements MenuDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Menu> getMenuList() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Menu.class);
		return criteria.list();
	}

	@Override
	public List<Menu> getMenuList(String menuId) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Menu.class);
		criteria.add(Restrictions.eq("parent", menuId));
		return criteria.list();
	}

	@Override
	public Menu getMenu(String menuId) {
		Session session = sessionFactory.getCurrentSession();
		return (Menu) session.get(Menu.class, menuId);
	}

	@Override
	public void insertMenu(Menu menu) {
		Session session = sessionFactory.getCurrentSession();
		session.save(menu);
	}

	@Override
	public void updateMenu(Menu menu) {
		Session session = sessionFactory.getCurrentSession();
		session.update(menu);
	}

	@Override
	public void deleteMenu(Menu menu) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(menu);
	}

}