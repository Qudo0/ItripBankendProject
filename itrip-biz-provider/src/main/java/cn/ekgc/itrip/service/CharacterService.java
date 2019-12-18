package cn.ekgc.itrip.service;

import java.util.List;
/**
 * <b>地区信息业务层接口</b>
 * @author Qudoo
 * @version 3.0.0
 * @since 2019-12-17
 */
public interface CharacterService {
	/**
	 * <b>获得所有酒店特色列表</b>
	 * @return List<Character>
	 * @throws Exception
	 */
	List<Character> getHotelFeatureList() throws Exception;
}
