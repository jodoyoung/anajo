package org.anajo.server.comp.member;

import java.util.List;
import java.util.Map;

import org.anajo.server.comp.member.model.Member;
import org.anajo.server.comp.role.RoleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

	@Autowired
	private RoleManager roleManager;

	@Autowired
	private MemberDao dao;

	@Override
	public List<Member> getMemberList(Map<String, Object> searchValues) {
		return dao.selectMembers(searchValues);
	}

	@Override
	public Member getMember(String memberId) {
		Member member = dao.selectMember(memberId);
		member.setRoles(roleManager.getUserRoles(memberId));
		return member;
	}

	@Override
	public Member getMemberByEmail(String email) {
		return dao.selectMemberByEmail(email);
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
		dao.deleteMember(memberId);
	}

}