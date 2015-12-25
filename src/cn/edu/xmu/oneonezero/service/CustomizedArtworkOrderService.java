package cn.edu.xmu.oneonezero.service;

import java.util.Date;
import java.util.List;

import cn.edu.xmu.oneonezero.entity.CustomizedArtworkOrder;

public interface CustomizedArtworkOrderService {
	public List<CustomizedArtworkOrder> getCustomizedArtworkOrdersByUserId(long userId);//获取用户id获取所有的定制品订单
	
	public List<CustomizedArtworkOrder> getCustomizedArtworkOrdersByOrderIdAndTimespace(String orderId,Date startTime,Date endTime);//1.根据订单编号查找一段时间的定制艺术品订单
	
	public List<CustomizedArtworkOrder> getCustomizedArtworkOrdersByVagueArtworkNameAndTimespace(String artworkName,Date startTime,Date endTime);//2.根据艺术品名模糊查找一段时间定制艺术品订单
	
	public List<CustomizedArtworkOrder> getCustomizedArtworkOrdersByArtworkTypeAndTimespace(String artworkType,Date startTime,Date endTime);//3.根据艺术品类型查找一段时间的定制艺术品订单
	
	public List<CustomizedArtworkOrder> getCustomizedArtworkOrdersByUserNameAndTimespace(String userName,Date startTime,Date endTime);//4.根据买家用户名查找一段时间的定制艺术品订单
	
	public List<CustomizedArtworkOrder> getCustomizedArtworkOrdersByArtistNameAndTimespace(String artistName,Date startTime,Date endTime);//5.根据卖家用户名查找一段时间的定制艺术品订单

	public List<CustomizedArtworkOrder> getAllCustomizedArtworkOrders();//获取所有定制品订单
	

	public void insertCustomizedArtworkOrder(CustomizedArtworkOrder customizedArtworkOrder);//添加定制品订单
	
	public boolean deleteCustomizedArtworkOrder(long customizedArtworkId);//根据id删除定制艺术品
	
	public CustomizedArtworkOrder getCustomedArtworkOrderByOrderId(long customizedArtworkOrderId);//根据订单id获取定制艺术品订单	

	public List<CustomizedArtworkOrder> getCustomizedArtworkOrdersByOwnerId(long ownerId);//根据卖家id 获得获得所有的定制艺术品订单
	
	public List<CustomizedArtworkOrder> getByOrderIdOrArtworkNameOrOwnerNameOrUserName(String sign, String name, String typeId,Date startTime,Date endTime);
	//sign=1表根据订单编号查找，=2表艺术品名，=3表卖家用户名，=4表买家用户名  typeId:艺术品类型id，为空值时表示不做限制  startTime~endTime:表示订单的下单时间在这个时间段，可以为空，表不做限制

	public void updateCustomizedArtworkOrderStage(long orderId,String stage);//根据定制订单id更新stage属性
	
	public void updateCustomizedArtworkOrderState(long orderId,String state);//根据定制订单id更新state属性
	
	
}
