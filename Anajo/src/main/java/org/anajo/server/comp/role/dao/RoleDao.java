package org.anajo.server.comp.role.dao;

import java.util.List;

import org.anajo.server.comp.role.model.Role;

/**
 * 권한 데이터 제어
 * 
 * @author jodoyoung
 * 
 */
public interface RoleDao {

	/**
	 * 전체 권한 목록 조회
	 * 
	 * @return
	 */
	List<Role> getRoles();

	/**
	 * 권한 조회
	 * 
	 * @param roleId
	 * @return
	 */
	Role getRole(String roleId);

	/**
	 * 권한 등록
	 * 
	 * @param role
	 */
	void insertRole(Role role);

	/**
	 * 권한 수정
	 * 
	 * @param role
	 */
	void updateRole(Role role);

	/**
	 * 권한 삭제
	 * 
	 * @param role
	 */
	void deleteRole(Role role);
}
