package com.coding.cho.domain.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MyRole {

	USER("ROLE_USER", "일반사용자"),
	ADMIN("ROLE_ADMIN", "관리자");
	
	private final String roleName;
	private final String koName;
	
	public final String roleName(){
		return roleName;
	}
	public final String koName(){
		return koName;
	}
}
