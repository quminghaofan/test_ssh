package cn.edu.xmu.oneonezero.dao;

import java.util.List;

import cn.edu.xmu.oneonezero.entity.DataDictionary;
/**
 * 数据字典
 * @author DELL
 *
 */
public interface DataDictionaryDao {
	/**
	 * 根据name获取整个实体
	 * @param name 名称
	 * @return DataDictionary
	 */
	public DataDictionary getDataDictionaryByName(String name);//
	
	/**
	 * 获取所有艺术品类别
	 * @return List
	 */
	public List<DataDictionary> getAllArtworkTypes();//
	
	/**
	 * 获取所有角色
	 * @return List
	 */
	public List<DataDictionary> getAllRoles();//
	
	/**
	 * 根据id删除艺术品类型
	 * @param typeId 
	 * @return boolean
	 */
	public boolean deleteArtworkType(long typeId);//
	
	/**
	 * 添加艺术品类型数据字典
	 * @param artworkTypeDataDictionary 数据字典信息
	 */
	public void insertArtworkTypeDataDictionary(DataDictionary artworkTypeDataDictionary);//



}
