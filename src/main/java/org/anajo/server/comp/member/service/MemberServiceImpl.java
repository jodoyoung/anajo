package org.anajo.server.comp.member.service;

import java.util.List;
import java.util.Map;

import org.anajo.server.comp.member.MemberService;
import org.anajo.server.comp.member.dao.MemberHibernateDao;
import org.anajo.server.comp.member.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberHibernateDao dao;

	@Override
	public List<Member> getMemberList(Map<String, Object> searchValues) {
		return dao.getMemberList(searchValues);
	}

	@Override
	public Member getMember(String memberId) {
		return dao.getMember(memberId);
	}

	@Override
	public Member getMemberByEmail(String email) {
		return dao.getMemberByEmail(email);
	}

	@Override
	public void createMember(Member member) {
		dao.insertMember(member);
	}

	@Override
	public void updateMember(Member member) {
		dao.updateMember(member);
	}

	@Override
	public void deleteMember(String memberId) {
		dao.deleteMember(dao.getMember(memberId));
	}

}