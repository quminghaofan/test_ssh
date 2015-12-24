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

	@Override
	public List<Artwork> getArtworksByAuthorName(String authorName) {
		return artworkDao.getArtworksByAuthorName(authorName);
	}

	@Override
	public Artwork getArtworkByArtworkId(long artworkId) {
		return artworkDao.getArtworkByArtworkId(artworkId);
	}

	@Override
	public void setArtworkState(long artworkId, boolean state) {
		artworkDao.setArtworkState(artworkId, state);
	}
	
	
}
