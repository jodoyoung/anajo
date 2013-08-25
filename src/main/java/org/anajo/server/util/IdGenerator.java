package org.anajo.server.util;

import java.util.UUID;

/**
 * ID 생성기
 * 
 * @author jodoyoung
 * 
 */
public class IdGenerator {

	/**
	 * UUID 생성
	 * 
	 * @return
	 */
	public static String createUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	public static void main(String[] args) {
		System.out.println(IdGenerator.createUUID());
	}
}
