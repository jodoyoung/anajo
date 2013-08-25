package org.anajo.server.comp.role;

import java.util.List;

import org.anajo.server.comp.role.model.Role;

/**
 * 권한 제어 서비스
 * 
 * @author jodoyoung
 * 
 */
public interface RoleManager {

	/**
	 * 권한 목록 조회
	 * 
	 * @return
	 */
	List<Role> getRoleList();

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
	void createRole(Role role);

	/**
	 * 권한 수정
	 * 
	 * @param role
	 */
	void updateRole(Role role);

	/**
	 * 권한 삭제
	 * 
	 * @param roleId
	 */
	void deleteRole(String roleId);
}
