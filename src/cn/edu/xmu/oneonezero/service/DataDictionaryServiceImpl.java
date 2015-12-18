package cn.edu.xmu.oneonezero.service;

import cn.edu.xmu.oneonezero.dao.DataDictionaryDao;
import cn.edu.xmu.oneonezero.entity.DataDictionary;

public class DataDictionaryServiceImpl implements DataDictionaryService{
	private DataDictionaryDao dataDictionaryDao;

	public void setDataDictionaryDao(DataDictionaryDao dataDictionaryDao) {
		this.dataDictionaryDao = dataDictionaryDao;
	}
	@Override
	public DataDictionary getDataDictionaryByName(String name) {
		return dataDictionaryDao.getDataDictionaryByName(name);
	}
	
	
}
