package org.anajo.server.comp.member.model;

/**
 * 사용자 활성화 상태
 * 
 * @author jodoyoung
 * 
 */
public enum MemberEnabledType {

	DISABLE(0, "중지"),

	ACTIVE(1, "사용"),

	ACTIVATION(2, "인증");

	private int code;

	private String name;

	MemberEnabledType(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static MemberEnabledType codeFor(int code) {
		if (MemberEnabledType.DISABLE.getCode() == code)
			return MemberEnabledType.DISABLE;

		if (MemberEnabledType.ACTIVE.getCode() == code)
			return MemberEnabledType.ACTIVE;

		if (MemberEnabledType.ACTIVATION.getCode() == code)
			return MemberEnabledType.ACTIVATION;

		return null;
	}

	public MemberEnabledType codeFor(String name) {
		if (MemberEnabledType.DISABLE.getName().equals(name))
			return MemberEnabledType.DISABLE;

		if (MemberEnabledType.ACTIVE.getName().equals(name))
			return MemberEnabledType.ACTIVE;

		if (MemberEnabledType.ACTIVATION.getName().equals(name))
			return MemberEnabledType.ACTIVATION;

		return null;
	}
}
