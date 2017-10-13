package cn.itcast.service;

import java.util.List;

import cn.itcast.pojo.BaseDict;

public interface DictService {
	
	// 根据种类code查询对应的code信息
	public List<BaseDict> findCodeInfoByTypeCode(String typeCode) throws Exception;

}
