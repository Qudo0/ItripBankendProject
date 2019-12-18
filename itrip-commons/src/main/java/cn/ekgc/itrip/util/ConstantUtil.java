package cn.ekgc.itrip.util;

import java.util.Properties;

/**
 * <b>系统常量工具类</b>
 * @author Qudoo
 * @version 1.0.0
 * @since 2019-12-13
 */
public class ConstantUtil {
	private static final Properties props = new Properties();

	static {
		try {
			props.load(ConstantUtil.class.getClassLoader().getResourceAsStream("itrip.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * <b>激活码长度</b>
	 */
	public static final Integer CDKEY_LENGTH = Integer.parseInt(props.getProperty("cdKey.length"));
	/**
	 * <b>redis缓存时间</b>
	 */
	public static final Long ACTIVE_CODE_TIMEOUT = Long.parseLong(props.getProperty("active.code.timeout"));
	/**
	 * <b>验证码发送邮箱地址</b>
	 */
	public static final String MAIL_FROM = props.getProperty("mail.from");
	/**
	 * <b>用户账户可用</b>
	 */
	public static final Integer USER_ACTIVATED_ENABLE = Integer.parseInt(props.getProperty("user.activated.enable"));
	/**
	 * <b>用户账户不可用</b>
	 */
	public static final Integer USER_ACTIVATED_DISABLE = Integer.parseInt(props.getProperty("user.activated.disable"));
	/**
	 * <b>Token私密</b>
	 */
	public static final String AUTH_SECRET = props.getProperty("auth.secret");
}
