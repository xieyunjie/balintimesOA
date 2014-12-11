package com.balintimes.oa.admin.dao.mybatis;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.balintimes.oa.admin.dao.IDictDao;
import com.balintimes.oa.admin.dao.IUserDao;
import com.balintimes.oa.admin.domain.AreaType;
import com.balintimes.oa.admin.domain.Dict;
import com.balintimes.oa.admin.domain.User;
import com.balintimes.oa.admin.persistence.mybatis.mappers.DictMapper;
import com.balintimes.oa.admin.persistence.mybatis.mappers.UserMapper;

/**
 * 字典DaoImple
 * @author bing.ning@balintimes.com
 *
 */
@Repository
public class DictDaoImpl implements IDictDao {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private DictMapper dictMapper;

	/**
	 * 获取所有字典
	 * @return
	 */
	@Cacheable(value="dictCache")
	public List<Dict> findAllDicts(){
 		return dictMapper.findAllDicts();
	}
}
