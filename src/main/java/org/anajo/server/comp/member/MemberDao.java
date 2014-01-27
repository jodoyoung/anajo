package org.anajo.server.comp.member;

import java.util.List;
import java.util.Map;

import org.anajo.server.comp.member.model.Member;
import org.springframework.stereotype.Repository;

/**
 * 회원 데이터 제어
 * 
 * @author jodoyoung
 * 
 */
@Repository
public interface MemberDao {

	/**
	 * 회원 목록 조회
	 * 
	 * @param searchValues
	 * @return
	 */
	List<Member> selectMembers(Map<String, Object> searchValues);

	/**
	 * 회원 조회
	 * 
	 * @param memberId
	 * @return
	 */
	Member selectMember(String memberId);

	/**
	 * 회원 조회(Email)
	 * 
	 * @param email
	 * @return
	 */
	Member selectMemberByEmail(String email);

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
	 * @param memberId
	 */
	void deleteMember(String memberId);
}
