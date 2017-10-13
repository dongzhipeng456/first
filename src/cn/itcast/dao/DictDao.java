package cn.itcast.dao;

import java.util.List;

import cn.itcast.pojo.BaseDict;

public interface DictDao {
	
	// 根据种类code查询对应的code信息
	public List<BaseDict> findCodeInfoByTypeCode(String typeCode) throws Exception;

}
