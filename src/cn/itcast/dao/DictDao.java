package cn.itcast.dao;

import java.util.List;

import cn.itcast.pojo.BaseDict;

public interface DictDao {
	
	// ��������code��ѯ��Ӧ��code��Ϣ
	public List<BaseDict> findCodeInfoByTypeCode(String typeCode) throws Exception;

}
