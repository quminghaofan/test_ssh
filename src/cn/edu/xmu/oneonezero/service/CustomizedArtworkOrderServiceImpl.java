package cn.edu.xmu.oneonezero.service;

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
	public List<CustomizedArtworkOrder> getFinishedCustomizedArtworkOrdersByUserId(long userId) {
		return customizedArtworkOrderDao.getFinishedCustomizedArtworkOrdersByUserId(userId);
	}
	
	
}
