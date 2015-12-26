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


	@Override
	public List<CustomizedArtworkOrder> getCustomizedArtworkOrdersByOwnerId(long ownerId) {
		return customizedArtworkOrderDao.getCustomizedArtworkOrdersByOwnerId(ownerId);
	}


	@Override
	public List<CustomizedArtworkOrder> getByOrderIdOrArtworkNameOrOwnerNameOrUserName(String sign, String name,
			String typeId, Date startTime, Date endTime) {
		if(sign.equals("1"))
			return customizedArtworkOrderDao.getByOrderId(name, typeId, startTime, endTime);
		else if(sign.equals("2"))
			return customizedArtworkOrderDao.getByArtworkName(name, typeId, startTime, endTime);
		else if(sign.equals("3"))
			return customizedArtworkOrderDao.getByOwnerName(name, typeId, startTime, endTime);
		else
			return customizedArtworkOrderDao.getByUserName(name, typeId, startTime, endTime);
	}


	@Override
	public void updateCustomizedArtworkOrderStage(long orderId, String stage) {
		customizedArtworkOrderDao.updateCustomizedArtworkOrderStage(orderId, stage);
	}


	@Override
	public void updateCustomizedArtworkOrderState(long orderId, String state) {
		customizedArtworkOrderDao.updateCustomizedArtworkOrderState(orderId, state);
		
	}




	@Override
	public void updateCustomizedArtworkOrder(CustomizedArtworkOrder customizedArtworkOrder) {
		customizedArtworkOrderDao.updateCustomizedArtworkOrder(customizedArtworkOrder);
	}
	
	
}
