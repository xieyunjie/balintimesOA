package com.balintimes.oa.admin.domain;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

/**
 * domain 基类
 * @author NingBing
 *
 */
public class BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	protected Integer id;		// 编号


}
