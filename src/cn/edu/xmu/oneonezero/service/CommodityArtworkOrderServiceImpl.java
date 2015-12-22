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
	
	
}
