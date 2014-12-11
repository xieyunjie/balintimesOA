package com.balintimes.oa.admin.dao;

import java.util.List;

import com.balintimes.oa.admin.domain.Dict;

/**
 * 字典Dao
 * @author bing.ning@balintimes.com
 *
 */
public interface IDictDao {
	/**
	 * 获取所有字典
	 * @return
	 */
	List<Dict> findAllDicts();
}
