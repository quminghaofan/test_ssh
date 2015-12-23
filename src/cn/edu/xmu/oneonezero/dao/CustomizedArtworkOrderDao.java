package cn.edu.xmu.oneonezero.dao;

import java.util.Date;
import java.util.List;

import cn.edu.xmu.oneonezero.entity.CommodityArtworkOrder;
import cn.edu.xmu.oneonezero.entity.CustomizedArtwork;
import cn.edu.xmu.oneonezero.entity.CustomizedArtworkOrder;

public interface CustomizedArtworkOrderDao {
	public List<CustomizedArtworkOrder> getCustomizedArtworkOrdersByUserId(long userId);//根据用户id获取所有的定制品订单
	

	public List<CustomizedArtworkOrder> getCustomizedArtworkOrdersByOrderIdAndTimespace(String orderId,Date startTime,Date endTime);//1.根据订单编号查找一段时间的定制艺术品订单
	
	public List<CustomizedArtworkOrder> getCustomizedArtworkOrdersByVagueArtworkNameAndTimespace(String artworkName,Date startTime,Date endTime);//2.根据艺术品名模糊查找一段时间定制艺术品订单
	
	public List<CustomizedArtworkOrder> getCustomizedArtworkOrdersByArtworkTypeAndTimespace(String artworkType,Date startTime,Date endTime);//3.根据艺术品类型查找一段时间的定制艺术品订单
	
	public List<CustomizedArtworkOrder> getCustomizedArtworkOrdersByUserNameAndTimespace(String userName,Date startTime,Date endTime);//4.根据买家用户名查找一段时间的定制艺术品订单
	
	public List<CustomizedArtworkOrder> getCustomizedArtworkOrdersByArtistNameAndTimespace(String artistName,Date startTime,Date endTime);//5.根据卖家用户名查找一段时间的定制艺术品订单
	
	public List<CustomizedArtworkOrder> getAllCustomizedArtworkOrders();//获取所有定制艺术品订单
	

	public void insertCustomizedArtworkOrder(CustomizedArtworkOrder customizedArtworkOrder);//添加定制品订单
	
	public boolean deleteCustomizedArtworkOrder(long customizedArtworkId);//根据id删除定制艺术品

	public CustomizedArtworkOrder getCustomedArtworkOrderByOrderId(long customizedArtworkOrderId);//根据订单id获取定制艺术品订单	

	public List<CustomizedArtworkOrder> getCustomizedArtworkOrdersByOwnerId(long ownerId);//根据卖家id 获得获得所有的定制艺术品订单
	
}
