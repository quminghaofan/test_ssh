package cn.edu.xmu.oneonezero.service;

import java.util.List;

import cn.edu.xmu.oneonezero.entity.DataDictionary;

public interface DataDictionaryService {
	public DataDictionary getDataDictionaryByName(String name);//根据name获取整个实体
	
	public List<String> getAllArtworkTypes();//获取所有艺术品类别

	public List<String> getAllRoles();//获取所有角色
	
	
}
