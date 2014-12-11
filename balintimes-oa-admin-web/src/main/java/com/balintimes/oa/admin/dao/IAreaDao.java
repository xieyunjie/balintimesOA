package com.balintimes.oa.admin.dao;

import java.util.List;

import com.balintimes.oa.admin.domain.Area;

/**
 * 字典Dao
 * @author bing.ning@balintimes.com
 *
 */
public interface IAreaDao {
	/**
	 * 获取所有区域
	 * @return
	 */
	List<Area> findAllAreas();
	
	/**
	 * 根据ID查找
	 * @param id
	 * @return
	 */
	Area get(Integer id);
	
	/**
	 * 新增保存
	 * @param area
	 */
	void insert(Area area);

	/**
	 * 修改保存
	 * @param area
	 */
	void update(Area area);
	
	/**
	 * 删除区域
	 * @param id
	 */
	void delete(Integer id);
	
	/**
	 * 根据上级查找下级
	 * @param string
	 * @return
	 */
	/**
	 * 根据上级查找下级
	 * @param string
	 * @return
	 */
	List<Area> findByParentIdsLike(String parentIds);
}
