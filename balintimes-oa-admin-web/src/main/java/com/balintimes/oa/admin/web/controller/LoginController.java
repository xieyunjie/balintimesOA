package com.balintimes.oa.admin.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	/**
	 * 管理登录
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request, HttpServletResponse response, Model model) {
		/*
		User user = UserUtils.getUser();
		// 如果已经登录，则跳转到管理首页
		if(user.getId() != null){
			return "redirect:"+Global.getAdminPath();
		}
		*/
		return "login";
	}
	
	/**
	 * 登陆验证
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginValidate(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "redirect:/index";
	}
	
	/**
	 * 进入首页
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String toIndex(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "index";
	}
}
