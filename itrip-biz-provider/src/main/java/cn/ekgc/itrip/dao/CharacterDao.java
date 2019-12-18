package cn.ekgc.itrip.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
/**
 * <b>酒店信息数据持久层接口</b>
 * @author Qudoo
 * @version 3.0.0
 * @since 2019-12-18
 */
@Repository
public interface CharacterDao {
	/**
	 * <b>获得所有酒店特色列表</b>
	 * @return List<Character>
	 * @throws Exception
	 */
	List<Character> findHotelByQuery(Map<String, Object> queryMap);
}
