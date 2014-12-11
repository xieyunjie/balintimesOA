/**
 * 用户登录历史Controller
 * Author: bing.ning@balintimes.com
 * Date: 2014-12-03
 */

package com.balintimes.oa.admin.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.balintimes.oa.admin.service.LoginLogService;

@Controller
@RequestMapping(value = "/profile")
public class LoginLogController {
	@Autowired
	private LoginLogService loginLogService;
	
}
