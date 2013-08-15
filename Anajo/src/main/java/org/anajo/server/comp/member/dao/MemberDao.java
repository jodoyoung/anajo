package org.anajo.server.comp.member.dao;

import java.util.List;
import java.util.Map;

import org.anajo.server.comp.member.model.Member;

/**
 * 회원 데이터 제어
 * 
 * @author jodoyoung
 * 
 */
public interface MemberDao {

	/**
	 * 회원 목록 조회
	 * 
	 * @param searchValues
	 * @return
	 */
	List<Member> getMemberList(Map<String, Object> searchValues);

	/**
	 * 회원 조회
	 * 
	 * @param memberId
	 * @return
	 */
	Member getMember(String memberId);

	/**
	 * 회원 조회(Email)
	 * 
	 * @param email
	 * @return
	 */
	Member getMemberByEmail(String email);

	/**
	 * 회원 등록
	 * 
	 * @param member
	 */
	void insertMember(Member member);

	/**
	 * 회원 수정
	 * 
	 * @param member
	 */
	void updateMember(Member member);

	/**
	 * 회원 삭제
	 * 
	 * @param member
	 */
	void deleteMember(Member member);
}
