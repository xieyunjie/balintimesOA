package com.balintimes.oa.admin.domain;


/**
 * 区域类型
 * @author bing.ning@balintimes.com
 *
 */
public class AreaType {
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	private Integer id;
	private String name;
	private String value;
}
