package cn.edu.xmu.oneonezero.service;

import java.util.List;

import cn.edu.xmu.oneonezero.entity.DataDictionary;

public interface DataDictionaryService {
	/**
	 * 根据name获取整个实体
	 * @param name String 实体名
	 * @return DataDictionary 数据字典
	 */
	public DataDictionary getDataDictionaryByName(String name);//根据name获取整个实体
	/**
	 * 获取所有艺术品类别
	 * @return List<DataDictionary> 艺术品类别列表
	 */
	public List<DataDictionary> getAllArtworkTypes();//获取所有艺术品类别
/**
 * 获取所有角色
 * @return List<DataDictionary> 角色列表
 */
	public List<DataDictionary> getAllRoles();//获取所有角色
	/**
	 * 根据id删除艺术品类型
	 * @param typeId 艺术品类型id
	 * @return 删除成功返回1，失败返回0
	 */
	public boolean deleteArtworkType(long typeId);//根据id删除艺术品类型
	/**
	 * 添加艺术品类型数据字典
	 * @param artworkTypeDataDictionary DataDictionary 艺术品类型
	 */
	public void insertArtworkTypeDataDictionary(DataDictionary artworkTypeDataDictionary);//添加艺术品类型数据字典

}
