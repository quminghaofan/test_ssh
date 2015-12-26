package cn.edu.xmu.oneonezero.dao;

import java.util.Date;
import java.util.List;

import cn.edu.xmu.oneonezero.entity.ArtworkOrder;

public interface ArtworkOrderDao {
	
	

	
	
	
	
	
	public List<ArtworkOrder> getArtworkOrderByUserId(long userId);//根据用户id获取所有的订单

	public List<ArtworkOrder> getOrdersByOrderIdAndTimespace(String orderId,Date startTime,Date endTime);//1.根据订单编号查找一段时间的订单
	
	public List<ArtworkOrder> getOrdersByUserNameAndTimespace(String userName,Date startTime,Date endTime);//4.根据买家用户名查找一段时间的订单
	
	public ArtworkOrder getOrderByOrderId(long artworkOrderId);//根据订单id获取订单	
	
	//
	public void setArtworkOrderIsAccept(long id, boolean isAccept);//根据id修改订单属性isAccept
	
	public void cancelArtworkOrder(long id);//取消定制订单

	
	
}
