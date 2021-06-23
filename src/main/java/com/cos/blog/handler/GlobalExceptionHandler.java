package com.cos.blog.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
//Exception 처리하기 


@ControllerAdvice //모든 입셉션이 발생하면. 이 클래스로 들어온다.
@RestController
public class GlobalExceptionHandler {


	@ExceptionHandler(value=IllegalArgumentException.class)
	public String handleArgumentException(IllegalArgumentException e) {
		return "<h1>"+e.getMessage()+"</h1>";
	}
	
	
}
