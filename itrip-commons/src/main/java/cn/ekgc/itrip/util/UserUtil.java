package cn.ekgc.itrip.util;

/**
 * <b>用户注册验证工具类</b>
 * @author Qudoo
 * @version 3.0.0
 * @since 2019-12-12
 */
public class UserUtil {
	/**
	 * <b>邮箱正则表达式</b>
	 */
	public static final String emailRegEx = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
	/**
	 * <b>手机号码正则表达式</b>
	 */
	public static final String cellphoneRegEx = "^1[0-9]{10}$";

	/**
	 * <b>判断用户账户是否符合规则</b>
	 * @param userCode
	 * @return boolean
	 */
	public static boolean checkUserCodePattern(String userCode) {
		if (userCode !=null && !"".equals(userCode.trim())) {
			if (userCode.matches(emailRegEx)){
				return true;
			}else if (userCode.matches(cellphoneRegEx)) {
				return true;
			}
		}
		return false;
	}
}
