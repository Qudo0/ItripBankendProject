package cn.ekgc.itrip.service.impl;

import cn.ekgc.itrip.dao.UserDao;
import cn.ekgc.itrip.pojo.entity.User;
import cn.ekgc.itrip.service.UserService;
import cn.ekgc.itrip.util.ConstantUtil;
import cn.ekgc.itrip.util.SystemCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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
	@Autowired
	private StringRedisTemplate redisTemplate;
	@Autowired
	private JavaMailSender mailSender;

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
			String activeCode = SystemCodeUtil.creatCDKey();
			redisTemplate.opsForValue().set(user.getUserCode(), activeCode);
			redisTemplate.expire(user.getUserCode(), ConstantUtil.ACTIVE_CODE_TIMEOUT * 60, TimeUnit.SECONDS);

			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setFrom(ConstantUtil.MAIL_FROM);

			mailMessage.setTo(user.getUserCode());
			mailMessage.setSubject("爱旅行账户激活码");
			mailMessage.setText("您的激活码是："+ activeCode + "，请在" +
					ConstantUtil.ACTIVE_CODE_TIMEOUT + "分钟内登录系统，输入本验证码激活您的账户！");
			mailSender.send(mailMessage);
			return true;
		}catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * <b>通过用户账号更改用户信息</b>
	 * @param userCode
	 * @return
	 * @throws Exception
	 */
	public Boolean updateUserByUserCode(String userCode) throws Exception {
		User user = new User();
		user.setUserCode(userCode);
		user.setActivated(ConstantUtil.USER_ACTIVATED_ENABLE);
		try {
			userDao.updateUserByUser(user);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * <b>根据用户名和密码登录用户</b>
	 * @param userCode
	 * @param userPassword
	 * @return User
	 * @throws Exception
	 */
	public User loginUser(String userCode, String userPassword) throws Exception {
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("userCode", userCode);
		queryMap.put("userPassword", userPassword);
		queryMap.put("activated", ConstantUtil.USER_ACTIVATED_ENABLE);
		List<User> userList = userDao.findUserByQuery(queryMap);
		if (userList != null && userList.size() > 0) {
			return userList.get(0);
		}
		return null;
	}

	/**
	 * <b>通过手机号码注册新用户</b>
	 * @param user
	 * @return boolean
	 * @throws Exception
	 */
	public boolean registryUserByCellphone(User user) throws Exception {
		try {
			userDao.addUser(user);
			return true;
		}catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}
}
