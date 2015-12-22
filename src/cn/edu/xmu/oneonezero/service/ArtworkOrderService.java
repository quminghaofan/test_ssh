package cn.edu.xmu.oneonezero.service;

import java.util.Date;
import java.util.List;

import cn.edu.xmu.oneonezero.entity.ArtworkOrder;

public interface ArtworkOrderService {
	public List<ArtworkOrder> getOrdersByVagueArtworkNameAndTimespace(String artworkName,Date startTime,Date endTime);//2.根据艺术品名模糊查找一段时间订单
	public List<ArtworkOrder> getOrdersByArtworkTypeAndTimespace(String artworkType,Date startTime,Date endTime);//3.根据艺术品类型查找一段时间的订单
	public List<ArtworkOrder> getOrdersByArtistNameAndTimespace(String artistName,Date startTime,Date endTime);//5.根据卖家用户名查找一段时间的订单

	public List<ArtworkOrder> getOrdersByArtistId(long artistId);//获取艺术家的所有订单
	
	
	
	
	
	public List<ArtworkOrder> getArtworkOrderByUserId(long userId);//根据用户id获取所有的订单

	public List<ArtworkOrder> getOrdersByOrderIdAndTimespace(String orderId,Date startTime,Date endTime);//1.根据订单编号查找一段时间的订单
	
	public List<ArtworkOrder> getOrdersByUserNameAndTimespace(String userName,Date startTime,Date endTime);//4.根据买家用户名查找一段时间的订单
	
}
