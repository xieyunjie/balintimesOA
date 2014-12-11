package com.balintimes.oa.admin.domain;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 区域
 * 
 * @author bing.ning@balintimes.com
 *
 */
public class Area extends BaseDomain {
	private static final long serialVersionUID = 1L;

	public Integer getParent_id() {
		return parent_id;
	}

	public void setParent_id(int i) {
		this.parent_id = i;
	}

	public String getParent_ids() {
		return parent_ids;
	}

	public void setParent_ids(String parent_ids) {
		this.parent_ids = parent_ids;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCreate_by() {
		return create_by;
	}

	public void setCreate_by(String create_by) {
		this.create_by = create_by;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public String getUpdate_by() {
		return update_by;
	}

	public void setUpdate_by(String update_by) {
		this.update_by = update_by;
	}

	public Date getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getDel_flag() {
		return del_flag;
	}

	public void setDel_flag(String del_flag) {
		this.del_flag = del_flag;
	}

	public String getParent_name() {
		return parent_name;
	}

	public void setParent_name(String parent_name) {
		this.parent_name = parent_name;
	}

	public String getParent_code() {
		return parent_code;
	}

	public void setParent_code(String parent_code) {
		this.parent_code = parent_code;
	}

	@NotNull
	private Integer parent_id;
	private String parent_ids;
	private String parent_name;
	private String parent_code;
	@NotNull
	@Size(min = 2, max = 14)
	private String code;
	@NotNull
	@Size(min = 2, max = 14)
	private String name;
	@NotNull
	private String type;
	private String create_by;
	private Date create_date;
	private String update_by;
	private Date update_date;
	private String remarks;
	private String del_flag = "0";
}
