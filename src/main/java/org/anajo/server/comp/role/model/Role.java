package org.anajo.server.comp.role.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.anajo.server.comp.member.model.Member;
import org.anajo.server.comp.menu.model.Menu;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.security.access.ConfigAttribute;

/**
 * 사용자 권한
 * 
 * @author jodoyoung
 * 
 */
public class Role implements Serializable, ConfigAttribute {

	private static final long serialVersionUID = 36760716119823747L;

	private String roleId;

	private String roleName;

	private String description;

	private Set<Member> members = new HashSet<Member>();

	private Set<Menu> menus = new HashSet<Menu>();

	public Role() {
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Member> getMembers() {
		return members;
	}

	public void setMembers(Set<Member> members) {
		this.members = members;
	}

	public Set<Menu> getMenus() {
		return menus;
	}

	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}

	@Override
	public String getAttribute() {
		return this.roleName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
