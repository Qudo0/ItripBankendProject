package cn.ekgc.itrip.util;

import java.util.Random;

/**
 * <b>系统各种编号生成工具类</b>
 * @author Qudoo
 * @version 1.0.0
 * @since 2019-12-13
 */
public class SystemCodeUtil {

	/**
	 * <b>生成四位激活码</b>
	 * @return
	 * @throws Exception
	 */
	public static String creatCDKey() throws Exception {
		Random random = new Random();
		StringBuffer cdKey = new StringBuffer();
		for (int i = 0 ; i < ConstantUtil.CDKEY_LENGTH ; i++) {
			cdKey.append(random.nextInt(10));
		}
		return cdKey.toString();
	}
}
