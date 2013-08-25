package org.anajo.server.comp.role.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.anajo.server.comp.member.model.Member;
import org.anajo.server.comp.menu.model.Menu;

/**
 * 사용자 권한
 * 
 * @author jodoyoung
 * 
 */
@Entity
@Table(name = "role")
public class Role implements Serializable {

	private static final long serialVersionUID = 36760716119823747L;

	private String roleId;

	private String roleName;

	private String description;

	private Set<Member> members = new HashSet<Member>();

	private Set<Menu> menus = new HashSet<Menu>();

	public Role() {
	}

	@Id
	@Column(name = "role_id")
	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	@Column(name = "role_name")
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToMany(mappedBy = "roles")
	public Set<Member> getMembers() {
		return members;
	}

	public void setMembers(Set<Member> members) {
		this.members = members;
	}

	@ManyToMany(mappedBy = "roles")
	public Set<Menu> getMenus() {
		return menus;
	}

	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
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
		return "Role [roleId=" + roleId + ", roleName=" + roleName + "]";
	}

}
