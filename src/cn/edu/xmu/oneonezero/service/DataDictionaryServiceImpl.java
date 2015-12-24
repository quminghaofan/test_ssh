package cn.edu.xmu.oneonezero.service;

import java.util.List;

import cn.edu.xmu.oneonezero.dao.DataDictionaryDao;
import cn.edu.xmu.oneonezero.entity.DataDictionary;

public class DataDictionaryServiceImpl implements DataDictionaryService{
	private DataDictionaryDao dataDictionaryDao;
	
	
	public DataDictionaryServiceImpl() {
	}


	public DataDictionaryServiceImpl(DataDictionaryDao dataDictionaryDao) {
		this.dataDictionaryDao = dataDictionaryDao;
	}


	public void setDataDictionaryDao(DataDictionaryDao dataDictionaryDao) {
		this.dataDictionaryDao = dataDictionaryDao;
	}
	@Override
	public DataDictionary getDataDictionaryByName(String name) {
		return dataDictionaryDao.getDataDictionaryByName(name);
	}


	@Override
	public List<DataDictionary> getAllArtworkTypes() {
		return dataDictionaryDao.getAllArtworkTypes();
	}


	@Override
	public List<DataDictionary> getAllRoles() {
		return dataDictionaryDao.getAllRoles();
	}


	@Override
	public boolean deleteArtworkType(long typeId) {
		return dataDictionaryDao.deleteArtworkType(typeId);
	}


	@Override
	public void insertDataDictionary(DataDictionary dataDictionary) {
		dataDictionaryDao.insertDataDictionary(dataDictionary);
	}
	
	
}
