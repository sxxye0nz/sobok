package com.coding.cho.service.impl;

import org.springframework.stereotype.Service;

import com.coding.cho.domain.dto.member.MemberSaveDTO;
import com.coding.cho.domain.entity.MemberEntityRepository;
import com.coding.cho.domain.entity.MyRole;
import com.coding.cho.service.MemberService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberServiceProcess implements MemberService {

	//DAO - Repository
	public final MemberEntityRepository repository;
	
	@Override
	public void saveProcess(MemberSaveDTO encodeDto) {
		//일반 회원가입 처리
		
		repository.save(encodeDto //pass 암호화된 DTO
						.toEntity()	//dto
						.addRole(MyRole.USER));//
		
	}

	@Override
	public boolean emailCheckProcess(String email) {
		// ture: 존재시(사용불가)
		// flase: 사용가능
		return repository.existsByEmail(email);
	}

}
