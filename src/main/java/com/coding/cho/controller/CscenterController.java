package com.coding.cho.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CscenterController {

	@GetMapping("/common/cscenter")
	public String cscenter() {
		return"user/cscenter/faq/list";
	}
}
