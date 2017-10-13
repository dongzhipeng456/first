package cn.itcast.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.dao.DictDao;
import cn.itcast.pojo.BaseDict;

@Service
public class DictServiceImpl implements DictService {
	
	@Autowired
	private DictDao dictDao;

	@Override
	public List<BaseDict> findCodeInfoByTypeCode(String typeCode) throws Exception {
		List<BaseDict> list = dictDao.findCodeInfoByTypeCode(typeCode);
		return list;
	}

}
