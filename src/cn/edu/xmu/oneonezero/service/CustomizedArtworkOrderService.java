package cn.edu.xmu.oneonezero.service;

import java.util.Date;
import java.util.List;

import cn.edu.xmu.oneonezero.entity.CustomizedArtworkOrder;

public interface CustomizedArtworkOrderService {
	public List<CustomizedArtworkOrder> getCustomizedArtworkOrdersByUserId(long userId);//获取用户id获取所有的定制品订单
	
	public List<CustomizedArtworkOrder> getFinishedCustomizedArtworkOrdersByUserId(long userId);//获取用户id获取所有的成品订单

	public List<CustomizedArtworkOrder> getCustomizedArtworkOrdersByOrderIdAndTimespace(String orderId,Date startTime,Date endTime);//1.根据订单编号查找一段时间的定制艺术品订单
	
	public List<CustomizedArtworkOrder> getCustomizedArtworkOrdersByVagueArtworkNameAndTimespace(String artworkName,Date startTime,Date endTime);//2.根据艺术品名模糊查找一段时间定制艺术品订单
	
	public List<CustomizedArtworkOrder> getCustomizedArtworkOrdersByArtworkTypeAndTimespace(String artworkType,Date startTime,Date endTime);//3.根据艺术品类型查找一段时间的定制艺术品订单
	
	public List<CustomizedArtworkOrder> getCustomizedArtworkOrdersByUserNameAndTimespace(String userName,Date startTime,Date endTime);//4.根据买家用户名查找一段时间的定制艺术品订单
	
	public List<CustomizedArtworkOrder> getCustomizedArtworkOrdersByArtistNameAndTimespace(String artistName,Date startTime,Date endTime);//5.根据卖家用户名查找一段时间的定制艺术品订单

	public List<CustomizedArtworkOrder> getAllCustomizedArtworkOrders();//获取所有艺术品成品订单
	
	public List<CustomizedArtworkOrder> getAllFinishedCustomizedArtworkOrders();//获取所有定制艺术品订单

	
	
}
