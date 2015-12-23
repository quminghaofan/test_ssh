package cn.edu.xmu.oneonezero.dao;

import java.util.List;

import cn.edu.xmu.oneonezero.entity.DataDictionary;

public interface DataDictionaryDao {
	public DataDictionary getDataDictionaryByName(String name);//根据name获取整个实体
	
	public List<String> getAllArtworkTypes();//获取所有艺术品类别
	
	public List<String> getAllRoles();//获取所有角色
	
	public boolean deleteArtworkType(long typeId);//根据id删除艺术品类型
	
	public void insertDataDictionary(DataDictionary dataDictionary);//添加数据字典



}
