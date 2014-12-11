/**
 * 系统设置Controller
 * Author: bing.ning@balintimes.com
 * Date: 2014-12-04
 */

package com.balintimes.oa.admin.web.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/sys")
public class SysController extends BaseController {
	
	/**
	 * 系统设置-首页
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String toIndex(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		return "/modules/sys/sysIndex";
	}
}
