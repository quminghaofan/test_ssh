package cn.edu.xmu.oneonezero.service;

import java.util.List;

import cn.edu.xmu.oneonezero.entity.ArtworkOrder;

public interface ArtworkOrderService {
	public List<ArtworkOrder> getNewsByUserId(long userId);//根据用户id获取所有的订单按照降序排列

}
