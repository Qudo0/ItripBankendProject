package cn.ekgc.itrip.transport;

import cn.ekgc.itrip.pojo.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *<b>用户信息传输层接口</b>
 * @author Qudoo
 * @version 3.0.0
 * @since 2019-12-12
 */
@FeignClient(name = "itrip-biz-provider")
@RequestMapping("/user")
public interface UserTransport {
	/**
	 * <b>通过用户用户账号获得对应的用户</b>
	 * @param userCode
	 * @return User
	 * @throws Exception
	 */
	@RequestMapping(value = "/code", method = RequestMethod.POST)
	User getUserByUserCode(@RequestParam String userCode) throws Exception;

	/**
	 * <b>使用邮箱注册新用户</b>
	 * @param user
	 * @return Boolean
	 * @throws Exception
	 */
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	Boolean registryUserByEmail(@RequestBody User user) throws Exception;

	/**
	 * <b>激活已注册用户账号</b>
	 * @param userCode
	 * @return Boolean
	 * @throws Exception
	 */
	@RequestMapping(value = "/activation", method = RequestMethod.POST)
	Boolean activationUser(@RequestParam String userCode) throws Exception;

	/**
	 *<b>根据用户名和密码登录用户</b>
	 * @param userCode
	 * @param userPassword
	 * @return User
	 * @throws Exception
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	User loginUser(@RequestParam String userCode, @RequestParam String userPassword) throws Exception;

	/**
	 * <b>使用手机号码注册新用户</b>
	 * @param user
	 * @return boolean
	 * @throws Exception
	 */
	@RequestMapping(value = "/saveCellphoneUser", method = RequestMethod.POST)
	boolean registryUserByCellphone(@RequestBody User user) throws Exception;
}
