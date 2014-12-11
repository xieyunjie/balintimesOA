package com.balintimes.oa.admin.common.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.balintimes.oa.admin.dao.IDictDao;
import com.balintimes.oa.admin.domain.Dict;

/**
 * 字典工具
 * 
 * @author bing.ning@balintimes.com
 *
 */
@Component
public class DictUtils {
	@Autowired
	private IDictDao dictDao;

	public final String CACHE_DICT_MAP = "dictMap";

	public String getDictLabel(String value, String type, String defaultValue) {
		if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(value)) {
			for (Dict dict : getDictList(type)) {
				if (type.equals(dict.getType())
						&& value.equals(dict.getValue())) {
					return dict.getLabel();
				}
			}
		}
		return defaultValue;
	}

	public String getDictValue(String label, String type, String defaultLabel) {
		if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(label)) {
			for (Dict dict : getDictList(type)) {
				if (type.equals(dict.getType())
						&& label.equals(dict.getLabel())) {
					return dict.getValue();
				}
			}
		}
		return defaultLabel;
	}

	@Cacheable(value="dictCache",key="(#root.method.name).concat('-').concat(#type)")
	public List<Dict> getDictList(String type) {
		Map<String, List<Dict>> dictMap = new HashMap<String, List<Dict>>();
		for (Dict dict : dictDao.findAllDicts()) {
			List<Dict> dictList = dictMap.get(dict.getType());
			if (dictList != null) {
				dictList.add(dict);
			} else {
				List<Dict> newDictList = new ArrayList<Dict>();
				newDictList.add(dict);
				dictMap.put(dict.getType(), newDictList);
			}
		}

		// 直接返回缓存数据
		List<Dict> dictList = dictMap.get(type);
		if (dictList == null) {
			dictList = new ArrayList<Dict>();
		}
		return dictList;
	}
}
