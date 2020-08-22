package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.vo.TestVO;

@RestController
public class HelloController {
	
	@GetMapping(path = "/hello")
	public String HelloSpringWorld() {
		
		return "Hello~! Spring world!";
	}
	
	@GetMapping("/user")
	public TestVO getTestVO(@RequestParam("name")String name) {
		TestVO temp=new TestVO();
		temp.setName(name);
		temp.setPwd("b");
		return temp;
	}
	
	
	@RequestMapping(value = "/test")
	public String getNewFile() {
		return "NewFile";
	}
	
	@RequestMapping(value = "/test2")
	public ModelAndView getJsp() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("NewFile");
		return mv;	
	}
}
