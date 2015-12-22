package cn.edu.xmu.oneonezero.service;

import java.util.List;

import cn.edu.xmu.oneonezero.dao.ArtworkDao;
import cn.edu.xmu.oneonezero.entity.Artwork;

public class ArtworkServiceImpl implements ArtworkService{
	private ArtworkDao artworkDao;
	
	public void setArtworkDao(ArtworkDao artworkDao) {  
		this.artworkDao=artworkDao;
	}

	@Override
	public List<Artwork> getArtworksByType(String type) {
		return artworkDao.getArtworksByType(type);
	}

	@Override
	public List<Artwork> getArtworksByTypeAndArtworkName(String type, String artworkName, int start, int num) {
		return artworkDao.getArtworksByTypeAndArtworkName(type, artworkName, start, num);
	}
	
	
}