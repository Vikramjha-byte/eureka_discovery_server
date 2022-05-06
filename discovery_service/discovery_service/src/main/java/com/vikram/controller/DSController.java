package com.vikram.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DSController {
	
	@Value("${service.instance.name}")
	private String instance;
	
	@RequestMapping("/")
	public String getMessage() {
		return "Hello from"+ instance;
	}

}
