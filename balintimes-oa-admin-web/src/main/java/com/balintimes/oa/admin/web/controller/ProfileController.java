/**
 * 个人信息Controller
 * Author: bing.ning@balintimes.com
 * Date: 2014-12-03
 */

package com.balintimes.oa.admin.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.balintimes.oa.admin.domain.LoginLog;
import com.balintimes.oa.admin.domain.User;
import com.balintimes.oa.admin.service.LoginLogService;
import com.balintimes.oa.admin.service.UserService;

@Controller
@RequestMapping(value = "/profile")
public class ProfileController extends BaseController {
	@Autowired
	private UserService userService;
	@Autowired
	private LoginLogService loginLogService;

	/**
	 * 个人信息-首页
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String toIndex(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		User user = userService.findUserById(1);
		model.addAttribute("user", user);
		return "/modules/profile/profileindex";
	}

	/**
	 * 个人信息-历史
	 */
	@RequestMapping(value = "/log", method = {RequestMethod.GET, RequestMethod.POST})
	public String toLog(HttpServletRequest request,
			HttpServletResponse response, Model model,
			@RequestParam(required = false) Integer page) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userId", 1);
        Integer totalCount = this.loginLogService.findLoginLogTotalCountByUserId(1);  
        this.initPage(map, page, totalCount);  
          
        List list = this.loginLogService.findLoginLogByUserId(map);
        this.initResult(model, list, map); 
        
        return "/modules/profile/profilelog";
	}

	/**
	 * 个人信息-修改密码
	 */
	@RequestMapping(value = "/editpassword", method = RequestMethod.GET)
	public String toEditPassword(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		return "/modules/profile/profileeditpassword";
	}
}
