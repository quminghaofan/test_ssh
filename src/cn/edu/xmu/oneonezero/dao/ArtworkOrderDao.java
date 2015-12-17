package cn.edu.xmu.oneonezero.dao;

import java.util.List;

import cn.edu.xmu.oneonezero.entity.ArtworkOrder;

public interface ArtworkOrderDao {

	public List<ArtworkOrder> getNewsByUserId(long userId);//根据用户id获取所有的订单
}
