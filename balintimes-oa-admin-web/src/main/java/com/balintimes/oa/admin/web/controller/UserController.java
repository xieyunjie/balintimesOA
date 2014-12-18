package com.balintimes.oa.admin.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.balintimes.oa.admin.domain.User;
import com.balintimes.oa.admin.service.UserService;

@Controller
@RequestMapping("/org/user")
public class UserController
{
	@Autowired
	private UserService UserService;

	@RequestMapping(method = RequestMethod.GET)
	public String toIndex(HttpServletRequest request,
			HttpServletResponse response, Model model)
	{
		// List<Area> list = this.areaService.findAllAreas();
		// model.addAttribute("list", list);

		List<User> users = this.UserService.findAllUsers();
		model.addAttribute("list", users);
		return "/modules/user/userlist";
	}

}
