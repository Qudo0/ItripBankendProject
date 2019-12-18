package cn.ekgc.itrip.controller;

import cn.ekgc.itrip.controller.base.BaseController;
import cn.ekgc.itrip.pojo.entity.User;
import cn.ekgc.itrip.pojo.vo.Dto;
import cn.ekgc.itrip.transport.UserTransport;
import cn.ekgc.itrip.util.MD5Util;
import cn.ekgc.itrip.util.UserUtil;
import cn.ekgc.itrip.util.jwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <b>用户注册控制层</b>
 * @author Qudoo
 * @version 3.0.0
 * @since 2019-12-12
 */
@RestController("authController")
@RequestMapping("/auth")
public class AuthController extends BaseController {
	@Resource
	private UserTransport userTransport;
	@Autowired
	private StringRedisTemplate redisTemplate;

	/**
	 * <b>检测用户输入的手机号或邮箱是否可用</b>
	 * @param name
	 * @return Dto<User>
	 * @throws Exception
	 */
	@RequestMapping(value = "/api/ckusr", method = RequestMethod.GET)
	public Dto<User> checkUserCodeFromRegist(String name) throws Exception {
		Dto<User> resultDto = new Dto<User>();
		if (UserUtil.checkUserCodePattern(name)){
			User user = userTransport.getUserByUserCode(name);
			if (user == null) {
				resultDto.setSuccess("true");
				return resultDto;
			}
		}
		resultDto.setSuccess("false");
		resultDto.setMsg("该邮箱地址或手机号码格式不正确，或者已被占用");
		return resultDto;
	}

	/**
	 * <b>使用邮箱注册新用户</b>
	 * @param user
	 * @return Dto<User>
	 * @throws Exception
	 */
	@RequestMapping(value = "/api/doregister", method = RequestMethod.POST)
	public Dto<User> registryUserByEmail(@RequestBody User user) throws Exception {
		Dto<User> resultDto = new Dto<User>();
		if (user.getUserCode() != null && !"".equals(user.getUserCode().trim())
			&& user.getUserPassword() != null && !"".equals(user.getUserPassword().trim())) {
			if (UserUtil.checkUserCodePattern(user.getUserCode())) {
				if (userTransport.getUserByUserCode(user.getUserCode()) == null) {
					user.setUserPassword(MD5Util.encrypt(user.getUserPassword()));
					if (userTransport.registryUserByEmail(user)) {
						resultDto.setSuccess("true");
						resultDto.setMsg("请在30分钟内登录您的邮箱，进行账号激活！");
					}else {
						resultDto.setSuccess("false");
						resultDto.setMsg("系统错误，请联系管理员大白菜:123456！");
					}
				}else {
					resultDto.setSuccess("false");
					resultDto.setMsg("该邮箱已被注册，请直接进行登录操作！");
				}
			}else {
				resultDto.setSuccess("false");
				resultDto.setMsg("请填写正确的email地址！");
			}
		}else {
			resultDto.setSuccess("false");
			resultDto.setMsg("请填写您的email地址或手机号码！");
		}
		return resultDto;
	}

	/**
	 * <b>激活已注册用户账号</b>
	 * @param user
	 * @param code
	 * @return Dto<User>
	 * @throws Exception
	 */
	@RequestMapping(value = "/api/activate", method = RequestMethod.PUT)
	public Dto<User> activationUser(@RequestParam String user, String code) throws Exception {
		Dto<User> resultDto = new Dto<User>();
		if (user != null && !"".equals(user.trim())
				&& code != null && !"".equals(code.trim())) {
			String CDKey = redisTemplate.opsForValue().get(user);
			if (CDKey.equals(code.trim())) {
				if(userTransport.activationUser(user)){
					resultDto.setSuccess("true");
					resultDto.setMsg("账户已激活！");
				}else{
					resultDto.setSuccess("false");
					resultDto.setMsg("系统错误，请联系管理员大白菜:123456！");
				}
			}else{
				resultDto.setSuccess("false");
				resultDto.setMsg("激活码错误，请重新输入！");
			}
		}else {
			resultDto.setSuccess("false");
			resultDto.setMsg("email地址和激活码不能为空！");
		}
		return resultDto;
	}

	/**
	 * <b>使用手机号码注册新用户</b>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/api/registerbyphone", method = RequestMethod.POST)
	public Dto<User> registeByPhone(@RequestBody User user) throws Exception {
		Dto<User> resultDto = new Dto<User>();
		if (user.getUserCode() != null && !"".equals(user.getUserCode().trim())
				&& user.getUserPassword() != null && !"".equals(user.getUserPassword().trim())){
			User userTest = userTransport.getUserByUserCode(user.getUserCode());
			if (userTest == null) {
				user.setUserPassword(MD5Util.encrypt(user.getUserPassword()));
				if (userTransport.registryUserByCellphone(user)) {
					resultDto.setSuccess("true");
					resultDto.setMsg("请在5分钟之内输入验证码，进行账号激活！");
				}else {
					resultDto.setSuccess("false");
					resultDto.setMsg("系统错误，请联系管理员大白菜:123456！");
				}
			}else {
				resultDto.setSuccess("false");
				resultDto.setMsg("手机号码已存在，请直接进行登录操作！");
			}
		}else {
			resultDto.setSuccess("false");
			resultDto.setMsg("手机号码不能为空！");
		}
		return resultDto;
	}

	/**
	 * <b>通过登录名和密码登录用户</b>
	 * @param name
	 * @param password
	 * @return Dto<User>
	 */
	@RequestMapping(value = "/api/dologin", method = RequestMethod.POST)
	public Dto<User> loginUser(String name, String password) throws Exception {
		Dto<User> resultDto = new Dto<User>();
		if (name != null && !"".equals(name.trim()) &&
			password != null && !"".equals(password.trim())) {
			password = MD5Util.encrypt(password);
			User user = userTransport.loginUser(name, password);
			if (user != null) {
				String jwtJSon = jwtTokenUtil.encryptToken(user.getId());
				response.setHeader("Authorization", jwtJSon);
				resultDto.setSuccess("true");
				resultDto.setData(user);
				return resultDto;
			}
		}
		resultDto.setSuccess("false");
		resultDto.setMsg("登录失败，请确认您的账号和密码，并重新登录");
		return resultDto;
	}
}
