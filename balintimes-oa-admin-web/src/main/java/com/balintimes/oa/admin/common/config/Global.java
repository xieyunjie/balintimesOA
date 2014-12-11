package com.balintimes.oa.admin.common.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.Assert;

import com.balintimes.oa.admin.common.utils.PropertiesLoader;

/**
 * 全局配置类
 */
public class Global {

	/**
	 * 保存全局属性值
	 */
	private static Map<String, String> map = new HashMap<String, String>();

	/**
	 * 属性文件加载对象
	 */
	private static PropertiesLoader propertiesLoader = new PropertiesLoader(
			"balintimes-oa.properties");

	/**
	 * 获取配置
	 */
	public static String getConfig(String key) {
		String value = map.get(key);
		if (value == null) {
			value = propertiesLoader.getProperty(key);
			map.put(key, value);
		}
		return value;
	}

	// ///////////////////////////////////////////////////////

	/**
	 * 获取管理端根路径
	 */
	public static String getAdminPath() {
		return getConfig("adminPath");
	}

	/**
	 * 获取前端根路径
	 */
	public static String getFrontPath() {
		return getConfig("frontPath");
	}

	/**
	 * 获取URL后缀
	 */
	public static String getUrlSuffix() {
		return getConfig("urlSuffix");
	}

	/**
	 * 是否是演示模式，演示模式下不能修改用户、角色、密码、菜单、授权
	 */
	public static Boolean isDemoMode() {
		String dm = getConfig("demoMode");
		return "true".equals(dm) || "1".equals(dm);
	}

	/**
	 * 在修改系统用户和角色时是否同步到Activiti
	 */
	public static Boolean isSynActivitiIndetity() {
		String dm = getConfig("activiti.isSynActivitiIndetity");
		return "true".equals(dm) || "1".equals(dm);
	}

	/**
	 * 获取CKFinder上传文件的根目录
	 * 
	 * @return
	 */
	public static String getCkBaseDir() {
		String dir = getConfig("userfiles.basedir");
		Assert.hasText(dir, "配置文件里没有配置userfiles.basedir属性");
		if (!dir.endsWith("/")) {
			dir += "/";
		}
		return dir;
	}

	public static final String MSG_TYPE_WARNING = "warning";
	public static final String MSG_TYPE_PRIMARY = "primary";
	public static final String MSG_TYPE_SUCCESS = "success";
	public static final String MSG_TYPE_INFO = "info";
	public static final String MSG_TYPE_DANGER = "danger";
	public static final String MSG_TYPE_ERROR = "error";
}
