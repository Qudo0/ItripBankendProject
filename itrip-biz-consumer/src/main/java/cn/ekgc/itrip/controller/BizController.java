package cn.ekgc.itrip.controller;

import cn.ekgc.itrip.pojo.entity.Area;
import cn.ekgc.itrip.pojo.vo.Dto;
import cn.ekgc.itrip.transport.AreaTransport;
import cn.ekgc.itrip.transport.CharacterTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <b>主业务控制层</b>
 * @author Qudoo
 * @version 3.0.0
 * @since 2019-12-17
 */
@RestController("bizController")
@RequestMapping("/biz")
public class BizController {

	@Autowired
	private AreaTransport areaTransport;
	@Autowired
	private CharacterTransport characterTransport;
	/**
	 * <b>根据国内外信息，查询相应热门城市</b>
	 * @param isChina
	 * @return Dto<Object>
	 * @throws Exception
	 */
	@RequestMapping(value = "/api/hotel/queryhotcity/{isChina}", method = RequestMethod.GET)
	public Dto<Object> queryHotCity(@PathVariable("isChina") Integer isChina) throws Exception {
		Dto<Object> resultDto = new Dto<Object>();
		List<Area> hotCityList = areaTransport.getHotCityByIsChina(isChina);
		resultDto.setSuccess("true");
		resultDto.setData(hotCityList);
		return resultDto;
	}

	/**
	 * <b>查询酒店特色列表</b>
	 * @return Dto<Object>
	 * @throws Exception
	 */
	@RequestMapping(value = "/api/hotel/queryhotelfeature", method = RequestMethod.GET)
	public Dto<Object> queryHotelFeatureList() throws Exception {
		Dto<Object> resultDto = new Dto<Object>();
		List<Character> characterList = characterTransport.getHotelFeatureList();
		resultDto.setSuccess("true");
		resultDto.setData(characterList);
		return resultDto;
	}
}
