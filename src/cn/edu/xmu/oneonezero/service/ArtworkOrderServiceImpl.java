package cn.edu.xmu.oneonezero.service;

import java.util.Date;
import java.util.List;

import cn.edu.xmu.oneonezero.dao.ArtworkOrderDao;
import cn.edu.xmu.oneonezero.entity.ArtworkOrder;

public class ArtworkOrderServiceImpl implements ArtworkOrderService{
	private ArtworkOrderDao artworkOrderDao;
	
	public void setArtworkOrderDao(ArtworkOrderDao artworkOrderDao) {  
		this.artworkOrderDao=artworkOrderDao;
	}

	@Override
	public List<ArtworkOrder> getArtworkOrderByUserId(long userId) {
		return  artworkOrderDao.getArtworkOrderByUserId(userId);
	}

	@Override
	public List<ArtworkOrder> getOrdersByVagueArtworkNameAndTimespace(String artworkName, Date startTime,
			Date endTime) {
		return artworkOrderDao.getOrdersByVagueArtworkNameAndTimespace(artworkName, startTime, endTime);
	}

	@Override
	public List<ArtworkOrder> getOrdersByArtworkTypeAndTimespace(String artworkType, Date startTime, Date endTime) {
		return getOrdersByArtworkTypeAndTimespace(artworkType, startTime, endTime);
	}

	@Override
	public List<ArtworkOrder> getOrdersByArtistNameAndTimespace(String artistName, Date startTime, Date endTime) {
		return getOrdersByArtistNameAndTimespace(artistName, startTime, endTime);
	}

	@Override
	public List<ArtworkOrder> getOrdersByArtistId(long artistId) {
		return getOrdersByArtistId(artistId);
	}

	@Override
	public List<ArtworkOrder> getOrdersByOrderIdAndTimespace(String orderId, Date startTime, Date endTime) {
		return getOrdersByOrderIdAndTimespace(orderId, startTime, endTime);
	}

	@Override
	public List<ArtworkOrder> getOrdersByUserNameAndTimespace(String userName, Date startTime, Date endTime) {
		return getOrdersByUserNameAndTimespace(userName, startTime, endTime);
	}

	@Override
	public List<ArtworkOrder> getOrderByOrderId(long artworkOrderId) {
		return artworkOrderDao.getOrderByOrderId(artworkOrderId);
	}
	
	
}
