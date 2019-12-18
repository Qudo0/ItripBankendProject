package cn.ekgc.itrip.transport;

import cn.ekgc.itrip.pojo.entity.Area;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 *<b>地区信息传输层接口</b>
 * @author Qudoo
 * @version 3.0.0
 * @since 2019-12-17
 */
@FeignClient(name = "itrip-biz-provider")
@RequestMapping("/area")
public interface AreaTransport {

	/**
	 * <b>根据国内外信息，获得热门城市列表</b>
	 * @param isChina
	 * @return List<Area>
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryHotCity", method = RequestMethod.POST)
	List<Area> getHotCityByIsChina(@RequestParam Integer isChina) throws Exception;
}
