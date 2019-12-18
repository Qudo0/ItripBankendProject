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
	Boolean registryUserByEmail(User user) throws Exception;

	/**
	 * <b>通过用户账号更改用户信息</b>
	 * @param userCode
	 * @return Boolean
	 * @throws Exception
	 */
	Boolean updateUserByUserCode(String userCode) throws Exception;

	/**
	 * <b>根据用户名和密码登录用户</b>
	 * @param userCode
	 * @param userPassword
	 * @return
	 * @throws Exception
	 */
	User loginUser(String userCode, String userPassword) throws Exception;

	/**
	 * <b>使用手机号码注册新用户</b>
	 * @param user
	 * @return boolean
	 * @throws Exception
	 */
	boolean registryUserByCellphone(User user) throws Exception;
}
