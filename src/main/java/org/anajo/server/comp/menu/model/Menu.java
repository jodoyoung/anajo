package org.anajo.server.comp.menu.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.anajo.server.comp.role.model.Role;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 메뉴
 * 
 * @author jodoyoung
 * 
 */
public class Menu implements Serializable {

	private static final long serialVersionUID = 3062645177088323622L;

	private String menuId;

	private String title;

	private String link;

	private String parent;

	private List<Menu> childs = new ArrayList<Menu>();

	private Set<Role> roles = new HashSet<Role>();

	public Menu() {
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public List<Menu> getChilds() {
		return childs;
	}

	public void setChilds(List<Menu> childs) {
		this.childs = childs;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getAuthorities() {
		StringBuilder sb = new StringBuilder();

		Iterator<Role> it = this.roles.iterator();

		while (it.hasNext()) {
			Role r = it.next();
			sb.append("'").append(r.getRoleName()).append("'");
			if (it.hasNext()) {
				sb.append(",");
			}
		}

		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((menuId == null) ? 0 : menuId.hashCode());
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
		Menu other = (Menu) obj;
		if (menuId == null) {
			if (other.menuId != null)
				return false;
		} else if (!menuId.equals(other.menuId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
