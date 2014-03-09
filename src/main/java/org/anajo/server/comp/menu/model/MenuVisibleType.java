package org.anajo.server.comp.menu.model;

/**
 * 메뉴 노출 유형
 * 
 * @author jodoyoung
 * 
 */
public enum MenuVisibleType {

	/** 노출 */
	VISIBLE(1),

	/** 숨김 */
	DISABLE(0);

	private int code;

	MenuVisibleType(int code) {
		this.code = code;
	}

	public int getCode() {
		return this.code;
	}

	public static MenuVisibleType codeFor(int code) {
		if (MenuVisibleType.VISIBLE.getCode() == code)
			return MenuVisibleType.VISIBLE;

		if (MenuVisibleType.DISABLE.getCode() == code)
			return MenuVisibleType.DISABLE;

		return MenuVisibleType.DISABLE;
	}
}
