package com.emall.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.emall.web.domain.User;

@Controller
public class HelloController {
	
	@RequestMapping({"/hello","/"})
	public String hello(User user, Model model) {
		System.out.println("username=" + user.getUsername());
		user.setAge("22");
		model.addAttribute(user);
		return "/hello";		
	}

}
