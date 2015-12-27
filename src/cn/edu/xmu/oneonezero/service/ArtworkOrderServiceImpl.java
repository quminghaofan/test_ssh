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
	public List<ArtworkOrder> getOrdersByOrderIdAndTimespace(String orderId, Date startTime, Date endTime) {
		return getOrdersByOrderIdAndTimespace(orderId, startTime, endTime);
	}

	@Override
	public List<ArtworkOrder> getOrdersByUserNameAndTimespace(String userName, Date startTime, Date endTime) {
		return getOrdersByUserNameAndTimespace(userName, startTime, endTime);
	}

	@Override
	public ArtworkOrder getOrderByOrderId(long artworkOrderId) {
		return artworkOrderDao.getOrderByOrderId(artworkOrderId);
	}

	@Override
	public void setArtworkOrderIsAccept(long id, String isAccept) {
		artworkOrderDao.setArtworkOrderIsAccept(id, isAccept);
	}

	@Override
	public void cancelArtworkOrder(long id) {
		artworkOrderDao.cancelArtworkOrder(id);
	}
	
	
}
