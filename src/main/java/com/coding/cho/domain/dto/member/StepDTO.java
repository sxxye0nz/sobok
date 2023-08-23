package com.coding.cho.domain.dto.member;


import java.time.LocalDateTime;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@ToString
@Getter
@Setter
public class StepDTO {

	private long sno;
	private String title;
	private String content;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;
	private String region;
	private String lastDate;
	private String gender;
	private int people;
	
	private String email;
	
	public StepDTO email(String email) {
		this.email=email;
		return this;
	}
	

}
