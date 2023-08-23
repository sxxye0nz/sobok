package com.coding.cho.domain.dto.member;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.coding.cho.domain.entity.MemberEntity;

import lombok.Setter;

@Setter
public class MemberSaveDTO {

	private String email;
	private String pass;
	private String name;
	
	//편의메서드
	public MemberSaveDTO encodePassword(PasswordEncoder pe) {
		pass=pe.encode(pass);//비밀번호 인코딩 
		return this;
	}
	
	//저장시에는 Entity로 저장
	public MemberEntity toEntity() {
		return MemberEntity.builder()
				.email(email)
				.pass(pass)// 인코딩 된 비밀번호
				.name(name)
				.build();
	}
}
