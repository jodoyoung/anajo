package org.anajo.server.comp.member.dao;

import java.util.List;
import java.util.Map;

import org.anajo.server.comp.member.model.Member;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberHibernateDao implements MemberDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Member> getMemberList(Map<String, Object> searchValues) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Member.class);

		for (String key : searchValues.keySet()) {
			criteria.add(Restrictions.like(key, searchValues.get(key)));
		}

		return criteria.list();
	}

	@Override
	public Member getMember(String memberId) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Member.class);
		criteria.add(Restrictions.eq("memberId", memberId));

		if (criteria.list().size() < 1) {
			return null;
		}

		return (Member) criteria.list().get(0);
	}

	@Override
	public Member getMemberByEmail(String email) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Member.class);
		criteria.add(Restrictions.eq("email", email));

		if (criteria.list().size() < 1) {
			return null;
		}

		return (Member) criteria.list().get(0);
	}

	@Override
	public void insertMember(Member member) {
		Session session = sessionFactory.getCurrentSession();
		session.save(member);
	}

	@Override
	public void updateMember(Member member) {
		Session session = sessionFactory.getCurrentSession();
		session.update(member);
	}

	@Override
	public void deleteMember(Member member) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(member);
	}

}
