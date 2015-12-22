package cn.edu.xmu.oneonezero.service;

import java.util.List;

import cn.edu.xmu.oneonezero.dao.CustomizedArtworkDao;
import cn.edu.xmu.oneonezero.entity.CustomizedArtwork;

public class CustomizedArtworkServiceImpl implements CustomizedArtworkService{
	private CustomizedArtworkDao customizedArtworkDao;


	public void setCustomizedArtworkDao(CustomizedArtworkDao customizedArtworkDao) {
		this.customizedArtworkDao = customizedArtworkDao;
	}


	@Override
	public List<CustomizedArtwork> getAllFinishedCustomizedArtworks() {
		return customizedArtworkDao.getAllFinishedCustomizedArtworks();
	}


	@Override
	public List<CustomizedArtwork> getAllCustomizedArtworks() {
		return customizedArtworkDao.getAllCustomizedArtworks();
	}

}
