package cn.edu.xmu.oneonezero.dao;

import cn.edu.xmu.oneonezero.entity.DataDictionary;

public interface DataDictionaryDao {
	public DataDictionary getDataDictionaryByName(String name);//根据name获取整个实体
}
