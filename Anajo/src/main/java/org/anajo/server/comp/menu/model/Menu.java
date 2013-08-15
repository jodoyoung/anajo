package org.anajo.server.comp.menu.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.anajo.server.comp.role.model.Role;
import org.springframework.context.annotation.Lazy;

/**
 * 메뉴
 * 
 * @author jodoyoung
 * 
 */
@Entity
@Table(name = "menu")
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

	@Id
	@Column(name = "menu_id")
	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	@Column(name = "title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "link")
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Column(name = "parent")
	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	@Transient
	public List<Menu> getChilds() {
		return childs;
	}

	public void setChilds(List<Menu> childs) {
		this.childs = childs;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "menu_role", joinColumns = { @JoinColumn(name = "menu_id") }, inverseJoinColumns = { @JoinColumn(name = "role_id") })
	@Lazy(false)
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
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

	@Transient
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
	public String toString() {
		return "Menu [menuId=" + menuId + ", title=" + title + ", link=" + link
				+ "]";
	}

}
