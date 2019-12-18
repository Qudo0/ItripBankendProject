package cn.ekgc.itrip.service;

import cn.ekgc.itrip.pojo.entity.Area;

import java.util.List;

/**
 * <b>地区信息业务层接口</b>
 * @author Qudoo
 * @version 3.0.0
 * @since 2019-12-17
 */
public interface AreaService {

	/**
	 * <b>根据国内外信息，获得热门城市列表</b>
	 * @param isChina
	 * @return List<Area>
	 * @throws Exception
	 */
	List<Area> getHotCityByIsChina(Integer isChina) throws Exception;
}
