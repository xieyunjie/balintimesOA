/**
 * controller基类
 * Author: bing.ning@balintimes.com
 * Date: 2014-12-03
 */
package com.balintimes.oa.admin.web.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.balintimes.oa.admin.common.config.Global;
import com.balintimes.oa.admin.common.utils.web.Pager;

/**
 * controller基类
 * @author bing.ning@balintimes.com
 */
public class BaseController {
	private Integer pageSize = Integer.valueOf(Global.getConfig("page.pageSize"));
	private Integer minPageSize = 10;
	private Integer maxPageSize = 100;
	
	 //初始化分页相关信息  
    protected void initPage(Map<String,Object> map, Integer pageNum, Integer totalCount){
        if(null==pageSize || pageSize.equals("")){  
            pageSize = minPageSize;  
        }  
        if(pageSize>maxPageSize){  
            pageSize = maxPageSize;  
        }  
        Integer totalPage = (totalCount+pageSize-1)/pageSize;  
        if(null==pageNum || 0==pageNum){  
            pageNum = 1;  
        }else if(pageNum>totalPage){  
            pageNum = totalPage;  
        }  
        map.put("startIndex", Pager.getStartIndex(pageNum, pageSize));  
        map.put("pageNum", pageNum);  
        map.put("totalPage", totalPage);  
        map.put("pageSize", pageSize);  
        map.put("totalCount", totalCount);  
    }  
      
    //将相关数据放入model  
    protected void initResult(Model model, List<Object> list, Map<String,Object> map){  
        model.addAttribute("list", list);  
        Iterator it = map.entrySet().iterator();   
        while(it.hasNext()){   
            Map.Entry m = (Map.Entry)it.next();   
            model.addAttribute(m.getKey().toString(), m.getValue());  
       }   
    } 
    
    /**
	 * 添加Flash消息
     * @param messages 消息
	 */
	protected void addMessage(RedirectAttributes redirectAttributes, String messageType, String... messages) {
		StringBuilder sb = new StringBuilder();
		for (String message : messages){
			sb.append(message).append(messages.length>1?"<br/>":"");
		}
		redirectAttributes.addFlashAttribute("msgtype", messageType);
        redirectAttributes.addFlashAttribute("msg",sb.toString());
	}
	
	protected void addWarningMessage(RedirectAttributes redirectAttributes, String... messages){
		this.addMessage(redirectAttributes, Global.MSG_TYPE_WARNING, messages);
	}
	
	protected void addDangerMessage(RedirectAttributes redirectAttributes, String... messages){
		this.addMessage(redirectAttributes, Global.MSG_TYPE_DANGER, messages);
	}
	
	protected void addErrorMessage(RedirectAttributes redirectAttributes, String... messages){
		this.addMessage(redirectAttributes, Global.MSG_TYPE_ERROR, messages);
	}
	
	protected void addInfoMessage(RedirectAttributes redirectAttributes, String... messages){
		this.addMessage(redirectAttributes, Global.MSG_TYPE_INFO, messages);
	}
	
	protected void addPrimaryMessage(RedirectAttributes redirectAttributes, String... messages){
		this.addMessage(redirectAttributes, Global.MSG_TYPE_PRIMARY, messages);
	}
	
	protected void addSuccessMessage(RedirectAttributes redirectAttributes, String... messages){
		this.addMessage(redirectAttributes, Global.MSG_TYPE_SUCCESS, messages);
	}
}
