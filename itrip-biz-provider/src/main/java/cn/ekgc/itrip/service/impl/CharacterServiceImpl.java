package cn.ekgc.itrip.service.impl;

import cn.ekgc.itrip.dao.CharacterDao;
import cn.ekgc.itrip.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * <b>酒店特色业务层接口实现类</b>
 * @author Qudoo
 * @version 3.0.0
 * @since 2019-12-17
 */
@Service("characterService")
@Transactional
public class CharacterServiceImpl implements CharacterService {
	@Autowired
	private CharacterDao characterDao;
	/**
	 * <b>获得所有酒店特色列表</b>
	 * @return List<Character>
	 * @throws Exception
	 */
	public List<Character> getHotelFeatureList() throws Exception {
		List<Character> characterList = characterDao.findHotelByQuery(null);
		return null;
	}
}
