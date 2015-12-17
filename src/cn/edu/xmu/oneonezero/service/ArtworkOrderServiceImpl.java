package cn.edu.xmu.oneonezero.service;

import java.util.List;

import cn.edu.xmu.oneonezero.dao.ArtworkOrderDao;
import cn.edu.xmu.oneonezero.entity.ArtworkOrder;

public class ArtworkOrderServiceImpl implements ArtworkOrderService{
	private ArtworkOrderDao artworkOrderDao;
	
	public void setArtworkOrderDao(ArtworkOrderDao artworkOrderDao) {  
		this.artworkOrderDao=artworkOrderDao;
	}

	@Override
	public List<ArtworkOrder> getNewsByUserId(long userId) {
		return  artworkOrderDao.getNewsByUserId(userId);
	}
}
