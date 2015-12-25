package cn.edu.xmu.oneonezero.service;

import java.util.List;

import cn.edu.xmu.oneonezero.entity.DataDictionary;

public interface DataDictionaryService {
	public DataDictionary getDataDictionaryByName(String name);//根据name获取整个实体
	
	public List<DataDictionary> getAllArtworkTypes();//获取所有艺术品类别

	public List<DataDictionary> getAllRoles();//获取所有角色
	
	public boolean deleteArtworkType(long typeId);//根据id删除艺术品类型
	
	public void insertArtworkTypeDataDictionary(DataDictionary artworkTypeDataDictionary);//添加艺术品类型数据字典

}
