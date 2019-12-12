package cn.ekgc.itrip.service;

import cn.ekgc.itrip.pojo.entity.User;
/**
 * <b>用户信息业务层接口</b>
 * @author Qudoo
 * @version 3.0.0
 * @since 2019-12-12
 */
public interface UserService {

	/**
	 * <b>通过用户用户账号获得对应的用户</b>
	 * @param userCode
	 * @return User
	 * @throws Exception
	 */
	User getUserByUserCode(String userCode) throws Exception;

	/**
	 * <b>使用邮箱注册新用户</b>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	Boolean registryUserByEmail(User user)  throws Exception;
}
