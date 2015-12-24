package cn.edu.xmu.oneonezero.service;

import java.util.Date;
import java.util.List;

import cn.edu.xmu.oneonezero.dao.CommodityArtworkOrderDao;
import cn.edu.xmu.oneonezero.entity.CommodityArtworkOrder;

public class CommodityArtworkOrderServiceImpl implements CommodityArtworkOrderService{
	private CommodityArtworkOrderDao commodityArtworkOrderDao;


	public void setCommodityArtworkOrderDao(CommodityArtworkOrderDao commodityArtworkOrderDao) {
		this.commodityArtworkOrderDao = commodityArtworkOrderDao;
	}


	@Override
	public List<CommodityArtworkOrder> getCommodityArtworkOrdersByOrderIdAndTimespace(String orderId, Date startTime,
			Date endTime) {
		return commodityArtworkOrderDao.getCommodityArtworkOrdersByOrderIdAndTimespace(orderId, startTime, endTime);
	}


	@Override
	public List<CommodityArtworkOrder> getCommodityArtworkOrdersByVagueArtworkNameAndTimespace(String artworkName,
			Date startTime, Date endTime) {
		return commodityArtworkOrderDao.getCommodityArtworkOrdersByVagueArtworkNameAndTimespace(artworkName, startTime, endTime);
	}


	@Override
	public List<CommodityArtworkOrder> getCommodityArtworkOrdersByArtworkTypeAndTimespace(String artworkType,
			Date startTime, Date endTime) {
		return commodityArtworkOrderDao.getCommodityArtworkOrdersByArtworkTypeAndTimespace(artworkType, startTime, endTime);
	}


	@Override
	public List<CommodityArtworkOrder> getCommodityArtworkOrdersByUserNameAndTimespace(String userName, Date startTime,
			Date endTime) {
		return commodityArtworkOrderDao.getCommodityArtworkOrdersByUserNameAndTimespace(userName, startTime, endTime);
	}


	@Override
	public List<CommodityArtworkOrder> getCommodityArtworkOrdersByArtistNameAndTimespace(String artistName,
			Date startTime, Date endTime) {
		return commodityArtworkOrderDao.getCommodityArtworkOrdersByArtistNameAndTimespace(artistName, startTime, endTime);
	}


	@Override
	public List<CommodityArtworkOrder> getAllCommodityArtworkOrders() {
		return commodityArtworkOrderDao.getAllCommodityArtworkOrders();
	}


	@Override
	public List<CommodityArtworkOrder> getCommodityArtworkOrdersByArtistId(long artistId) {
		return commodityArtworkOrderDao.getCommodityArtworkOrdersByArtistId(artistId);
	}


	@Override
	public List<CommodityArtworkOrder> getCommodityArtworkOrdersByUserId(long userId) {
		return commodityArtworkOrderDao.getCommodityArtworkOrdersByUserId(userId);
	}


	@Override
	public void insertCommodityArtworkOrder(CommodityArtworkOrder commodityArtworkOrder) {
		commodityArtworkOrderDao.insertCommodityArtworkOrder(commodityArtworkOrder);
	}


	@Override
	public boolean deleteCommodityArtworkOrder(long commodityArtworkId) {
		return commodityArtworkOrderDao.deleteCommodityArtworkOrder(commodityArtworkId);
	}


	@Override
	public CommodityArtworkOrder getCommodityArtworkOrderByOrderId(long commodityArtworkOrderId) {
		return commodityArtworkOrderDao.getCommodityArtworkOrderByOrderId(commodityArtworkOrderId);
	}


	@Override
	public List<CommodityArtworkOrder> getCommodityArtworkOrdersByOwnerId(long ownerId) {
		return commodityArtworkOrderDao.getCommodityArtworkOrdersByOwnerId(ownerId);
	}


	@Override
	public void updateCommodityArtworkOrderState(long orderId, String state) {
		commodityArtworkOrderDao.updateCommodityArtworkOrderState(orderId, state);
	}
	
	
}
