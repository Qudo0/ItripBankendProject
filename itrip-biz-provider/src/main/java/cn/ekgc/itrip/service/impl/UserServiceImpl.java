package cn.ekgc.itrip.service.impl;

import cn.ekgc.itrip.dao.UserDao;
import cn.ekgc.itrip.pojo.entity.User;
import cn.ekgc.itrip.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <b>用户信息业务层接口实现类</b>
 * @author Qudoo
 * @version 3.0.0
 * @since 2019-12-12
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	/**
	 * <b>通过用户用户账号获得对应的用户</b>
	 * @param userCode
	 * @return User
	 * @throws Exception
	 */
	public User getUserByUserCode(String userCode) throws Exception {
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("userCode", userCode);
		List<User> userList = userDao.findUserByQuery(queryMap);
		if (userList != null && userList.size() > 0) {
			return userList.get(0);
		}
		return null;
	}

	/**
	 * <b>使用邮箱注册新用户</b>
	 * @param user
	 * @return Boolean
	 * @throws Exception
	 */
	public Boolean registryUserByEmail(User user) throws Exception {
		try {
			userDao.addUser(user);
			return true;
		}catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}
}
