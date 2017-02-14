package com.emall.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.emall.web.domain.User;

@Controller
public class VController {
	
	Map<String, User> users = new HashMap<String, User>();
	
	public VController(){
		System.out.println("我的构造函数");
		User u1 = new User();
		u1.setAge("22");
		u1.setUsername("Momo");
		u1.setEmail("12414@qq.com");
		u1.setPassword("12314");
		users.put("1", u1);
		User u2 = new User();
		u2.setAge("14");
		u2.setUsername("莫莫");
		u2.setEmail("shay@163.com");
		u2.setPassword("12675");
		users.put("2", u2);
	}
	
	@RequestMapping(value="/contact",method=RequestMethod.GET)
	public String userlist(Model model){
		System.out.println("lalalalaal....");
		return "/contact";
	}

}
