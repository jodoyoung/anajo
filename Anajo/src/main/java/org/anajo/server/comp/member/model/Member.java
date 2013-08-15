package org.anajo.server.comp.member.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.anajo.server.comp.role.model.Role;

/**
 * 사용자
 * 
 * @author jodoyoung
 * 
 */
@Entity
@Table(name = "member")
public class Member implements Serializable {

	private static final long serialVersionUID = -1492634488516865570L;

	private String memberId;

	private String email;

	private String name;

	private String password;

	private MemberEnabledType enabled;

	private Set<Role> roles = new HashSet<Role>();

	public Member() {
	}

	@Id
	@Column(name = "member_id")
	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "enabled")
	public int getEnabled() {
		return this.enabled.getCode();
	}

	public void setEnabled(int enabled) {
		this.enabled = MemberEnabledType.codeFor(enabled);
	}

	@ManyToMany
	@JoinTable(name = "member_role", joinColumns = { @JoinColumn(name = "member_id") }, inverseJoinColumns = { @JoinColumn(name = "role_id") })
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Transient
	public String getEnabledStr() {
		return this.enabled.getName();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((memberId == null) ? 0 : memberId.hashCode());
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
		Member other = (Member) obj;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", email=" + email
				+ ", password=" + password + "]";
	}

}
