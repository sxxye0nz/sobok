package com.coding.cho.service;

import java.util.List;

import org.springframework.ui.Model;

import com.coding.cho.domain.dto.member.StepDTO;

public interface StepService {

	//공지글 등록
	void save(StepDTO dto);
	
	//공고글 리스트
	public List<StepDTO> list();

	//공고글 상세조회
	void stepDetail(long sno, Model model);

	//공고글 삭제
	void stepDelete(long sno);

	//공고글 수정
	void stepUpdate(long sno);


}
