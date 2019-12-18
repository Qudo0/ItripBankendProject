package cn.ekgc.itrip.transport;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 *<b>酒店特色信息传输层接口</b>
 * @author Qudoo
 * @version 3.0.0
 * @since 2019-12-17
 */
@FeignClient(name = "itrip-biz-provider")
@RequestMapping("/character")
public interface CharacterTransport {

	/**
	 * <b>获得所有酒店特色列表</b>
	 * @return List<Character>
	 * @throws Exception
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	List<Character> getHotelFeatureList() throws Exception;
}
