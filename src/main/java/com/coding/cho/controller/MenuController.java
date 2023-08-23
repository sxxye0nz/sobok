package com.coding.cho.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coding.cho.domain.dto.member.StepDTO;
import com.coding.cho.service.StepService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MenuController {

	private final StepService service;
	
	//////////////////////*스테이 페이지*/////////////////////////
	@GetMapping("/menu/stays-board")
	public String staysBoard() {
		return "menu/stays-board";
	}
	
	//////////////////////*모집 공고글 페이지*/////////////////////////

	@GetMapping("/menu/step/step-write")
	public String stepWrite() {
		return "menu/step/step-write";
	}
	@GetMapping("/menu/step/step-detail")
	public String stepDetail() {
		return "menu/step/step-detail";
	}
	@GetMapping("/menu/step/step-update")
	public String stepUpdate() {
		return "/menu/step/step-update";
	}
	//공고글 등록
	@PostMapping("/menu/step/step-write")	//Authentication auth: 현재 로그인되어있는 이메일 정보 받아오기
	public String stepSave(StepDTO dto,Authentication auth, Model model) {		
		service.save(dto.email(auth.getName()));
		System.out.println("dto출력>>>>"+dto);
		return "redirect:/menu/step-board";
	}
	//공고글 리스트 출력
	@GetMapping("/menu/step-board")	//Authentication auth: 현재 로그인되어있는 이메일 정보 받아오기
	public String stepList(Model model) {		
		List<StepDTO> stepList = service.list();
		model.addAttribute("list", stepList);
		return "menu/step-board";
	}
	
	//공고글 번호 -> 공고글 상세 조회
	@GetMapping("/menu/step-board/{sno}")
	public String stepDetail(@PathVariable(name="sno")long sno, Model model) {
		service.stepDetail(sno,model);
		return"menu/step/step-detail";
	}
	
	//공고글 삭제
	@DeleteMapping("/menu/step-board/{sno}")
	public String stepDelete(@PathVariable(name="sno")long sno) {
		service.stepDelete(sno);
		return "redirect:/menu/step-board";
	}
	
	//공고글 수정
	@PutMapping("/menu/step-board/{sno}")
	public String stepUpdate(@PathVariable(name="sno")long sno, Model model) {
		service.stepUpdate(sno);
		return "redirect:/menu/step-board/"+sno;
	}

	//////////////////////*스텝 후기 페이지*/////////////////////////
	@GetMapping("/menu/review-board")
	public String reviewBoard() {
		return "menu/review-board";
	}
}
