package cn.ekgc.itrip.transport.impl;

import cn.ekgc.itrip.service.CharacterService;
import cn.ekgc.itrip.transport.CharacterTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/**
 *<b>酒店特色传输层接口实现类</b>
 * @author Qudoo
 * @version 3.0.0
 * @since 2019-12-17
 */
@RestController("characterTransport")
@RequestMapping("/character")
public class CharacterTransportImpl implements CharacterTransport {
	@Autowired
	private CharacterService characterService;

	/**
	 * <b>获得所有酒店特色列表</b>
	 * @return List<Character>
	 * @throws Exception
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public List<Character> getHotelFeatureList() throws Exception {
		return characterService.getHotelFeatureList();
	}
}
