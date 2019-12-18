package cn.ekgc.itrip.dao;

import cn.ekgc.itrip.pojo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
/**
 * <b>用户信息数据持久层接口</b>
 * @author Qudoo
 * @version 3.0.0
 * @since 2019-12-12
 */
@Repository
public interface UserDao {
	/**
	 * <b>通过条件查询用户信息</b>
	 * @param queryMap
	 * @return List<User>
	 * @throws Exception
	 */
	List<User> findUserByQuery(Map<String, Object> queryMap) throws Exception;

	/**
	 * <b>保存用户信息</b>
	 * @param user
	 * @throws Exception
	 */
	void addUser(User user) throws Exception;

	/**
	 * <b>更改用户信息</b>
	 * @param user
	 * @throws Exception
	 */
	void updateUserByUser(User user) throws Exception;
}
