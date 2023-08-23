package com.coding.cho.domain.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.coding.cho.domain.dto.member.StepDTO;

@Mapper
public interface StepMapper {

	//공고글 등록
	void save(StepDTO dto);

	//공고글 목록
	List<StepDTO> list();

	//공고글 상세조회
	StepDTO findByNo(long sno);
	
	//공고글 삭제
	void deleteByNo(long sno);

	//공고글 수정
	void updateByNo(long sno);





}
