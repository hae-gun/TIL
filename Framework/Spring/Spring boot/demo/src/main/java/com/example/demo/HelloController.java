package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController {

	@GetMapping
	public String hello() {
		return "hello";
	}
	
	@GetMapping("/viewtest")
	public String test() {
		return "viewtest";
	}
	
	
}