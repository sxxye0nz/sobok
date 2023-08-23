package com.coding.cho.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.coding.cho.domain.dao.StepMapper;
import com.coding.cho.domain.dto.member.StepDTO;
import com.coding.cho.service.StepService;

import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@Service
public class StepServiceProcess implements StepService{

	private final StepMapper mapper;
	
	//공고글 등록
	@Override
	public void save(StepDTO dto) {
		mapper.save(dto);
		
	}

	//공고글 목록
	@Override
	public List<StepDTO> list() {
		List<StepDTO> stepList=mapper.list();
		return stepList;
	}

	//공고글 상세 조회
	@Override
	public void stepDetail(long sno, Model model) {
		StepDTO result=mapper.findByNo(sno); 
		model.addAttribute("detail", result);
		
	}

	//공고글 삭제
	@Override
	public void stepDelete(long sno) {
		mapper.deleteByNo(sno);
		
	}

	//공고글 수정
	@Override
	public void stepUpdate(long sno) {
		mapper.updateByNo(sno);
		
	}



}
