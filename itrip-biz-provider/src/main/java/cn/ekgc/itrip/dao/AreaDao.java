package cn.ekgc.itrip.dao;

import cn.ekgc.itrip.pojo.entity.Area;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <b>地区信息数据持久层接口</b>
 * @author Qudoo
 * @version 3.0.0
 * @since 2019-12-17
 */
@Repository
public interface AreaDao {
	/**
	 * <b>根据条件查询地区列表</b>
	 * @return List<Area>
	 * @throws Exception
	 */
	List<Area> findAreaByQuery(Map<String, Object> queryMap) throws Exception;
}
