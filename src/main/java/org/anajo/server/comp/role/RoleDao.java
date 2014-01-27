package org.anajo.server.comp.role;

import java.util.Set;

import org.anajo.server.comp.role.model.Role;
import org.springframework.stereotype.Repository;

/**
 * 권한 데이터 제어
 * 
 * @author jodoyoung
 * 
 */
@Repository
public interface RoleDao {

	/**
	 * 권한 목록 조회
	 * 
	 * @return
	 */
	Set<Role> selectRoles();

	/**
	 * 사용자별 권한 목록 조회
	 * 
	 * @param memberId
	 * @return
	 */
	Set<Role> selectUserRoles(String memberId);

	/**
	 * 메뉴별 권한 목록 조회
	 * 
	 * @param menuId
	 * @return
	 */
	Set<Role> selectMenuRoles(String menuId);

	/**
	 * 권한 조회
	 * 
	 * @param roleId
	 * @return
	 */
	Role selectRole(String roleId);

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
	 * @param roleId
	 */
	void deleteRole(String roleId);
}
