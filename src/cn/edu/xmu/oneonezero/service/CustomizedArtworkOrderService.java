package cn.edu.xmu.oneonezero.service;

import java.util.List;

import cn.edu.xmu.oneonezero.entity.CustomizedArtworkOrder;

public interface CustomizedArtworkOrderService {
public List<CustomizedArtworkOrder> getCustomizedArtworkOrdersByUserId(long userId);//获取用户id获取所有的定制品订单
	
	public List<CustomizedArtworkOrder> getFinishedCustomizedArtworkOrdersByUserId(long userId);//获取用户id获取所有的成品订单

}
