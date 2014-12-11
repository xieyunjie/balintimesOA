/**
 * 系统设置Controller
 * Author: bing.ning@balintimes.com
 * Date: 2014-12-04
 */

package com.balintimes.oa.admin.web.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.balintimes.oa.admin.common.config.Global;
import com.balintimes.oa.admin.domain.Area;
import com.balintimes.oa.admin.service.AreaService;

@Controller
@RequestMapping(value = "/org/area")
public class AreaController extends BaseController {
	@Autowired
	private AreaService areaService;

	@ModelAttribute("area")
	public Area get(@RequestParam(required = false) Integer id) {
		if (id == null) {
			return new Area();
		}
		return areaService.get(id);
	}

	/**
	 * 區域管理-首页
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String toIndex(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		List<Area> list = this.areaService.findAllAreas();
		model.addAttribute("list", list);

		return "/modules/area/arealist";
	}

	/**
	 * 区域管理-添加、修改
	 * 
	 * @param area
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/form")
	public String form(Area area, Model model,
			RedirectAttributes redirectAttributes) {
		if (area.getId() != null && area.getId().equals(1)) {
	        this.addWarningMessage(redirectAttributes, "修改区域失败, 不允许修改顶级区域.");
			return "redirect:/org/area";
		}

		if (area.getParent_id() == null) {
			area.setParent_id(1);
		}
		Area parent = areaService.get(area.getParent_id());
		if (parent != null) {
			area.setParent_name(parent.getName());
			area.setParent_code(parent.getCode());
		}
		model.addAttribute("area", area);
		return "modules/area/areaForm";
	}

	@RequestMapping(value = "/save")
	public String save(@Valid Area area, BindingResult result, Model model,
			RedirectAttributes redirectAttributes) {
		
		if (result.hasErrors()) {
			return "modules/area/areaForm";
		} 
		
		try {
			areaService.save(area);
	        this.addInfoMessage(redirectAttributes, "保存区域" + area.getName() + "成功");
			return "redirect:/org/area/";
		} catch (SQLException e) {
	        this.addErrorMessage(redirectAttributes, "保存区域" + area.getName() + "失败");
			return "redirect:/org/area/";
		}
	}

	@RequestMapping(value = "/delete")
	public String delete(Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null && id.equals(1)) {
		        this.addWarningMessage(redirectAttributes, "删除区域失败, 不允许删除顶级区域或编号为空");
			} else {
				areaService.delete(id);
				this.addInfoMessage(redirectAttributes, "删除区域成功");
			}
		} catch (SQLException e) {
			this.addErrorMessage(redirectAttributes, "删除区域失败");
		}
		
		return "redirect:/org/area/";
	}

	/**
	 * 返回区域树形数据
	 * 
	 * @param extId
	 * @param response
	 * @return
	 * @throws Exception
	 */

	@RequestMapping(value = "/treeData", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Map<String, Object>> treeData(
			@RequestParam(required = false) Integer extId,
			HttpServletResponse response) throws Exception {

		// Thread.sleep(3000);

		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		List<Area> list = areaService.findAllAreas();
		for (int i = 0; i < list.size(); i++) {
			Area e = list.get(i);
			if (extId == null
					|| (extId != null && !extId.equals(e.getId()) && e
							.getParent_ids().indexOf("," + extId + ",") == -1)) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id", e.getId());
				map.put("pId", e.getParent_id() != null ? e.getParent_id() : 0);
				map.put("name", e.getName());
				mapList.add(map);
			}
		}
		// throw new Exception("test");
		return mapList;
	}

	/**
	 * 区域管理-区域选择
	 */
	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public String toSelect(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		List<Area> list = this.areaService.findAllAreas();
		model.addAttribute("list", list);

		return "/modules/area/areaselect";
	}
}
