/**
 * 區域管理服务
 * Author: bing.ning@balintimes.com
 * Date: 2014-12-04
 */
package com.balintimes.oa.admin.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.balintimes.oa.admin.dao.IAreaDao;
import com.balintimes.oa.admin.domain.Area;

@Service
public class AreaService {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private IAreaDao areaDao;

	/**
	 * 查找所有区域信息
	 * 
	 * @return
	 */
	@Cacheable(value="areaCache")
	public List<Area> findAllAreas() {
		return areaDao.findAllAreas();
	}

	/**
	 * 根据ID查找区域
	 * 
	 * @param id
	 * @return
	 */
	public Area get(Integer id) {
		return this.areaDao.get(id);
	}

	/**
	 * 区域保存
	 * 
	 * @param area
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { SQLException.class })
	@CacheEvict(value = "areaCache", allEntries = true)
	public void save(Area area) throws SQLException {
		Area parent = this.get(area.getParent_id());
		String oldParentIds = area.getParent_ids(); // 获取修改前的parentIds，用于更新子节点的parentIds
		area.setParent_ids(parent.getParent_ids() + parent.getId() + ",");
		if (area.getId() == null || area.getId() == 0) {
			// 新增保存
			area.setCreate_by("admin");
			area.setCreate_date(new Date());
			areaDao.insert(area);
		} else {
			// 修改保存
			areaDao.update(area);
		}
		// 更新子节点 parentIds
		List<Area> list = areaDao.findByParentIdsLike(area.getId().toString());
		if (list == null) {
			return;
		}

		for (Area e : list) {
			e.setParent_ids(e.getParent_ids().replace(oldParentIds,
					area.getParent_ids()));
			areaDao.update(e);
		}
	}
	
	@Transactional(rollbackFor = { SQLException.class })
	@CacheEvict(value = "areaCache", allEntries = true)
	public void delete(Integer id) throws SQLException {
		areaDao.delete(id);
	}
}
