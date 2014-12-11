package com.balintimes.oa.admin.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.balintimes.oa.admin.domain.User;
import com.balintimes.oa.admin.service.UserService;

@Controller
public class HelloWorldController {

	@Autowired
	private UserService userService;
	private List<User> userlist;
	
    @RequestMapping("/helloWorld")
    public String helloWorld(Model model) {
    	userlist = userService.findAllUsers();
        model.addAttribute("users", userlist);
        return "helloWorld";
    }
}
