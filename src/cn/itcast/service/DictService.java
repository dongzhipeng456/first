package cn.itcast.service;

import java.util.List;

import cn.itcast.pojo.BaseDict;

public interface DictService {
	
	// ��������code��ѯ��Ӧ��code��Ϣ
	public List<BaseDict> findCodeInfoByTypeCode(String typeCode) throws Exception;

}
