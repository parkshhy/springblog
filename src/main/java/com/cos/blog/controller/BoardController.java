package com.cos.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

	//" " , "/" 아무것도 안붙였을때랑, / 일 경우이동
	@GetMapping({"","/"})
	public String index() {
		//WEB-INF/views/index.jsp
		return "index";
	}
	
	
	
	
}
