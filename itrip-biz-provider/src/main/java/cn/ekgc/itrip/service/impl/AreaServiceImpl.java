package cn.ekgc.itrip.service.impl;

import cn.ekgc.itrip.dao.AreaDao;
import cn.ekgc.itrip.pojo.entity.Area;
import cn.ekgc.itrip.service.AreaService;
import jdk.nashorn.internal.runtime.arrays.ArrayData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <b>地区信息业务层接口实现类</b>
 * @author Qudoo
 * @version 3.0.0
 * @since 2019-12-17
 */
@Service("areaService")
@Transactional
public class AreaServiceImpl implements AreaService {
	@Autowired
	private AreaDao areaDao;
	/**
	 * <b>根据国内外信息，获得热门城市列表</b>
	 * @param isChina
	 * @return
	 * @throws Exception
	 */
	public List<Area> getHotCityByIsChina(Integer isChina) throws Exception {
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("isChina", isChina);
		queryMap.put("isHot", 1);
		queryMap.put("isActivated", 1);

		List<Area> areaList = areaDao.findAreaByQuery(queryMap);
		return null;
	}
}
