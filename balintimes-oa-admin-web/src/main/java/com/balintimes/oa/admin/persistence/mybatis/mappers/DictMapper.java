package com.balintimes.oa.admin.persistence.mybatis.mappers;

import java.util.List;

import com.balintimes.oa.admin.domain.AreaType;
import com.balintimes.oa.admin.domain.Dict;
import com.balintimes.oa.admin.domain.User;

/**
 * 字典Mapper
 * @author bing.ning@balintimes.com
 *
 */
public interface DictMapper {
	//获取所有字典
	List<Dict> findAllDicts();
}
