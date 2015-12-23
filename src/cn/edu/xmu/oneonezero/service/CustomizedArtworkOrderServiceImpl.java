package cn.edu.xmu.oneonezero.service;

import java.util.Date;
import java.util.List;

import cn.edu.xmu.oneonezero.dao.CustomizedArtworkOrderDao;
import cn.edu.xmu.oneonezero.entity.CustomizedArtworkOrder;

public class CustomizedArtworkOrderServiceImpl implements CustomizedArtworkOrderService{
	private CustomizedArtworkOrderDao customizedArtworkOrderDao;


	public void setCustomizedArtworkOrderDao(CustomizedArtworkOrderDao customizedArtworkOrderDao) {
		this.customizedArtworkOrderDao = customizedArtworkOrderDao;
	}


	@Override
	public List<CustomizedArtworkOrder> getCustomizedArtworkOrdersByUserId(long userId) {
		return customizedArtworkOrderDao.getCustomizedArtworkOrdersByUserId(userId);
	}




	@Override
	public List<CustomizedArtworkOrder> getCustomizedArtworkOrdersByOrderIdAndTimespace(String orderId, Date startTime,
			Date endTime) {
		return customizedArtworkOrderDao.getCustomizedArtworkOrdersByOrderIdAndTimespace(orderId, startTime, endTime);
	}


	@Override
	public List<CustomizedArtworkOrder> getCustomizedArtworkOrdersByVagueArtworkNameAndTimespace(String artworkName,
			Date startTime, Date endTime) {
		return customizedArtworkOrderDao.getCustomizedArtworkOrdersByVagueArtworkNameAndTimespace(artworkName, startTime, endTime);
	}


	@Override
	public List<CustomizedArtworkOrder> getCustomizedArtworkOrdersByArtworkTypeAndTimespace(String artworkType,
			Date startTime, Date endTime) {
		return customizedArtworkOrderDao.getCustomizedArtworkOrdersByArtworkTypeAndTimespace(artworkType, startTime, endTime);
	}


	@Override
	public List<CustomizedArtworkOrder> getCustomizedArtworkOrdersByUserNameAndTimespace(String userName,
			Date startTime, Date endTime) {
		return customizedArtworkOrderDao.getCustomizedArtworkOrdersByUserNameAndTimespace(userName, startTime, endTime);
	}


	@Override
	public List<CustomizedArtworkOrder> getCustomizedArtworkOrdersByArtistNameAndTimespace(String artistName,
			Date startTime, Date endTime) {
		return customizedArtworkOrderDao.getCustomizedArtworkOrdersByArtistNameAndTimespace(artistName, startTime, endTime);
	}


	@Override
	public List<CustomizedArtworkOrder> getAllCustomizedArtworkOrders() {
		return customizedArtworkOrderDao.getAllCustomizedArtworkOrders();
	}




	@Override
	public void insertCustomizedArtworkOrder(CustomizedArtworkOrder customizedArtworkOrder) {
		customizedArtworkOrderDao.insertCustomizedArtworkOrder(customizedArtworkOrder);
	}


	@Override
	public boolean deleteCustomizedArtworkOrder(long customizedArtworkId) {
		return customizedArtworkOrderDao.deleteCustomizedArtworkOrder(customizedArtworkId);
	}


	@Override
	public CustomizedArtworkOrder getCustomedArtworkOrderByOrderId(long customizedArtworkOrderId) {
		return customizedArtworkOrderDao.getCustomedArtworkOrderByOrderId(customizedArtworkOrderId);
	}
	
	
}
