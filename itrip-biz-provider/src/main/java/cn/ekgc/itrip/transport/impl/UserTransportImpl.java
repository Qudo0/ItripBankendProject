package cn.ekgc.itrip.transport.impl;

import cn.ekgc.itrip.pojo.entity.User;
import cn.ekgc.itrip.service.UserService;
import cn.ekgc.itrip.transport.UserTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *<b>用户信息传输层接口实现类</b>
 * @author Qudoo
 * @version 3.0.0
 * @since 2019-12-12
 */
@RestController("userTransport")
@RequestMapping("/user")
public class UserTransportImpl implements UserTransport {
	@Autowired
	private UserService userService;

	/**
	 * <b>通过用户用户账号获得对应的用户</b>
	 * @param userCode
	 * @return User
	 * @throws Exception
	 */
	@RequestMapping(value = "/code", method = RequestMethod.POST)
	public User getUserByUserCode(@RequestParam String userCode) throws Exception {
		return userService.getUserByUserCode(userCode);
	}

	/**
	 * <b>使用邮箱注册新用户</b>
	 * @param user
	 * @return Boolean
	 * @throws Exception
	 */
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public Boolean registryUserByEmail(@RequestBody User user) throws Exception {
		return userService.registryUserByEmail(user);
	}
	/**
	 * <b>激活已注册用户账号</b>
	 * @param userCode
	 * @return Boolean
	 * @throws Exception
	 */
	@RequestMapping(value = "/activation", method = RequestMethod.POST)
	public Boolean activationUser(@RequestParam String userCode) throws Exception {
		return userService.updateUserByUserCode(userCode);
	}

	/**
	 *<b>根据用户名和密码登录用户</b>
	 * @param userCode
	 * @param userPassword
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public User loginUser(@RequestParam String userCode, @RequestParam String userPassword) throws Exception {
		return userService.loginUser(userCode, userPassword);
	}

	/**
	 * <b>使用手机号码注册新用户</b>
	 * @param user
	 * @return boolean
	 * @throws Exception
	 */
	@RequestMapping(value = "/saveCellphoneUser", method = RequestMethod.POST)
	public boolean registryUserByCellphone(@RequestBody User user) throws Exception {
		return userService.registryUserByCellphone(user);
	}
}
