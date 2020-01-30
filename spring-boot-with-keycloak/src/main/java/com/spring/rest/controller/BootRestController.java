package com.spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.service.StudentService;

@RestController
public class BootRestController {
	
	@Autowired
	StudentService studentService;
	
	
	@RequestMapping("/rest")
	public String rest(){
		return "rest";
		
	}

}
