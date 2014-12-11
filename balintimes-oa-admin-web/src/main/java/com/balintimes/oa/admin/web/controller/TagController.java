/**
 * 自定义tag处理controller
 *
 */
package com.balintimes.oa.admin.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 标签Controller
 */
@Controller
@RequestMapping("/tag")
public class TagController extends BaseController {

	/**
	 * 树结构选择标签（treeselect.tag）
	 */
	@RequestMapping("treeselect")
	public String treeselect(HttpServletRequest request, Model model) {
		model.addAttribute("url", request.getParameter("url")); // 树结构数据URL
		model.addAttribute("extId", request.getParameter("extId")); // 排除的编号ID
		model.addAttribute("checked", request.getParameter("checked")); // 是否可复选
		model.addAttribute("selectIds", request.getParameter("selectIds")); // 指定默认选中的ID
		model.addAttribute("module", request.getParameter("module")); // 过滤栏目模型（仅针对CMS的Category树）
		return "modules/sys/tagTreeselect";
	}

	/**
	 * 图标选择标签（iconselect.tag）
	 */
	@RequestMapping("iconselect")
	public String iconselect(HttpServletRequest request, Model model) {
		model.addAttribute("value", request.getParameter("value"));
		return "modules/sys/tagIconselect";
	}

}
