package com.balintimes.oa.admin.dao.mybatis;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.balintimes.oa.admin.dao.IAreaDao;
import com.balintimes.oa.admin.domain.Area;
import com.balintimes.oa.admin.persistence.mybatis.mappers.AreaMapper;

/**
 * 字典DaoImple
 * @author bing.ning@balintimes.com
 *
 */
@Repository
public class AreaDaoImpl implements IAreaDao {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private AreaMapper areaMapper;

	/**
	 * 获取所有区域
	 * @return
	 */
	
	public List<Area> findAllAreas(){
		return areaMapper.findAllAreas();
	}
	
	/**
	 * 根据ID查找
	 * @param id
	 * @return
	 */
	public Area get(Integer id){
		return areaMapper.get(id);
	}
	
	/**
	 * 新建保存
	 * @param area
	 */
	public void insert(Area area){
		areaMapper.insert(area);
	}

	/**
	 * 修改保存
	 * @param area
	 */
	public void update(Area area){
		areaMapper.update(area);
	}
	
	/**
	 * 删除区域
	 * @param id
	 */
	public void delete(Integer id){
		areaMapper.delete(id);
	}
	
	/**
	 * 根据上级查找下级
	 * @param string
	 * @return
	 */
	public List<Area> findByParentIdsLike(String parentIds){
		return areaMapper.findByParentIdsLike(parentIds);
	}
}
