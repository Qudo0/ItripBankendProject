package cn.ekgc.itrip.controller;

import cn.ekgc.itrip.controller.base.BaseController;
import cn.ekgc.itrip.pojo.entity.User;
import cn.ekgc.itrip.pojo.vo.Dto;
import cn.ekgc.itrip.transport.UserTransport;
import cn.ekgc.itrip.util.UserUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
		Boolean flag = userTransport.registryUserByEmail(user);
		if (flag) {
			resultDto.setSuccess("true");
			return resultDto;
		}
		resultDto.setSuccess("false");
		return resultDto;
	}
}
