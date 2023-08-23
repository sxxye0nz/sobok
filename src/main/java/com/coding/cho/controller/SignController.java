package com.coding.cho.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coding.cho.domain.dto.member.MemberSaveDTO;
import com.coding.cho.service.MemberService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class SignController {
	
	public final MemberService service;
	public final PasswordEncoder pe;
	//로그인 페이지
	@GetMapping("/signin")
	public String signin() {
		return "sign/signin";
	}
	
	//회원가입 페이지
	@GetMapping("/signup")
	public String signup() {
		return "sign/signup";
	}
	
	//회원가입처리
	@PostMapping("/signup")
	public String signup(MemberSaveDTO dto) {
		service.saveProcess(dto.encodePassword(pe));//인코딩된 패스워드로 업데이트해서 넘겨준다
		return "redirect:/signin";//회원가입이 성공하면 로그인페이지로 이동
	}

	@ResponseBody
	@GetMapping("/common/email-check")
	public boolean emailCheck(String email) {
		
		return service.emailCheckProcess(email);
	}
}
