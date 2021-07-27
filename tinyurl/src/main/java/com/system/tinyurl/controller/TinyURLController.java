package com.system.tinyurl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.system.tinyurl.services.TinyURLService;

@RestController
public class TinyURLController {
	
	@Autowired
	private TinyURLService tinyURLService;
	
	@GetMapping("/home")
	public String home() {
		return "Welcome to TinyURL service.";
	}
	
	@GetMapping("/generate")
	public String generateURL(String url) {
		return tinyURLService.generateURL(url);
	}
	
}
