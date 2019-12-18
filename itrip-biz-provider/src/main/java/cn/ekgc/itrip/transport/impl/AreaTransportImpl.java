package cn.ekgc.itrip.transport.impl;

import cn.ekgc.itrip.pojo.entity.Area;
import cn.ekgc.itrip.service.AreaService;
import cn.ekgc.itrip.transport.AreaTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *<b>地区信息传输层接口实现类</b>
 * @author Qudoo
 * @version 3.0.0
 * @since 2019-12-17
 */
@RestController("areaTransport")
@RequestMapping("/area")
public class AreaTransportImpl implements AreaTransport {

	@Autowired
	private AreaService areaService;
	/**
	 * <b>根据国内外信息，获得热门城市列表</b>
	 * @param isChina
	 * @return List<Area>
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryHotCity", method = RequestMethod.POST)
	public List<Area> getHotCityByIsChina(@RequestParam Integer isChina) throws Exception {
		return areaService.getHotCityByIsChina(isChina);
	}
}
