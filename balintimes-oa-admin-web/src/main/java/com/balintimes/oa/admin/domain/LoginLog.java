/**
 * 用户登录历史
 * Author: bing.ning@balintimes.com
 * Date: 2014-12-03
 */

package com.balintimes.oa.admin.domain;

import java.util.Date;

public class LoginLog {
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public String getBrowseUserAgent() {
		return browseUserAgent;
	}

	public void setBrowseUserAgent(String browseUserAgent) {
		this.browseUserAgent = browseUserAgent;
	}

	private int id;
	private String userId;
	private String userName;
	private Date loginDate;
	private String loginIp;
	private String browseUserAgent;
}
