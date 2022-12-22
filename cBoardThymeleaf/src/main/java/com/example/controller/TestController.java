package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	@RequestMapping("/hello")
	public void hello(Model m) {
		m.addAttribute("msg", "헬로우 타임리프");
	}
	
	@RequestMapping(value= {"/", "index"})
	public String index() {
		
		return "index";
	}
}
