package cn.edu.xmu.oneonezero.service;

import java.util.Date;
import java.util.List;

import cn.edu.xmu.oneonezero.entity.CustomizedArtworkOrder;

public interface CustomizedArtworkOrderService {
	/**
	 * 获取用户id获取所有的定制品订单
	 * @param userId long 用户id
	 * @return List<CustomizedArtworkOrder> 定制品订单列表
	 */
	public List<CustomizedArtworkOrder> getCustomizedArtworkOrdersByUserId(long userId);//获取用户id获取所有的定制品订单
	/**
	 * 根据订单编号查找一段时间的定制艺术品订单
	 * @param orderId String 订单id
	 * @param startTime Date 开始时间
	 * @param endTime Date 结束时间
	 * @return List<CustomizedArtworkOrder> 制成品订单列表
	 */
	public List<CustomizedArtworkOrder> getCustomizedArtworkOrdersByOrderIdAndTimespace(String orderId,Date startTime,Date endTime);//1.根据订单编号查找一段时间的定制艺术品订单
	/**
	 * 根据艺术品名模糊查找一段时间定制艺术品订单
	 * @param artworkName String 艺术品名
	 * @param startTime Date 开始时间
	 * @param endTime Date 结束时间
	 * @return List<CustomizedArtworkOrder> 制成品订单列表
	 */
	public List<CustomizedArtworkOrder> getCustomizedArtworkOrdersByVagueArtworkNameAndTimespace(String artworkName,Date startTime,Date endTime);//2.根据艺术品名模糊查找一段时间定制艺术品订单
	
	/**
	 * 根据艺术品类型查找一段时间的定制艺术品订单
	 * @param artworkType String 艺术品类型
	 * @param startTime Date 开始时间
	 * @param endTime Date 结束时间
	 * @return List<CustomizedArtworkOrder> 定制品订单列表
	 */
	public List<CustomizedArtworkOrder> getCustomizedArtworkOrdersByArtworkTypeAndTimespace(String artworkType,Date startTime,Date endTime);//3.根据艺术品类型查找一段时间的定制艺术品订单
	/**
	 * 根据买家用户名查找一段时间的定制艺术品订单
	 * @param userName String 用户名
	 * @param startTime Date 开始时间
	 * @param endTime Date 结束时间
	 * @return List<CustomizedArtworkOrder> 定制订单列表
	 */
	public List<CustomizedArtworkOrder> getCustomizedArtworkOrdersByUserNameAndTimespace(String userName,Date startTime,Date endTime);//4.根据买家用户名查找一段时间的定制艺术品订单
	/**
	 * 根据卖家用户名查找一段时间的定制艺术品订单
	 * @param artistName String 艺术家名
	 * @param startTime Date 开始时间
	 * @param endTime Date 结束时间
	 * @return List<CustomizedArtworkOrder> 定制品订单列表
	 */
	public List<CustomizedArtworkOrder> getCustomizedArtworkOrdersByArtistNameAndTimespace(String artistName,Date startTime,Date endTime);//5.根据卖家用户名查找一段时间的定制艺术品订单
/**
 * 获取所有定制品订单
 * @return List<CustomizedArtworkOrder> 定制品订单
 */
	public List<CustomizedArtworkOrder> getAllCustomizedArtworkOrders();//获取所有定制品订单
	
/**
 * 添加定制品订单
 * @param customizedArtworkOrder 定制品订单
 */
	public void insertCustomizedArtworkOrder(CustomizedArtworkOrder customizedArtworkOrder);//添加定制品订单
	/**
	 * 根据id删除定制艺术品
	 * @param customizedArtworkId long 定制品 订单id
	 * @return boolean 删除成功返回1，不成功返回0
	 */
	public boolean deleteCustomizedArtworkOrder(long customizedArtworkId);//根据id删除定制艺术品
	/**
	 * 根据订单id获取定制艺术品订单
	 * @param customizedArtworkOrderId long 定制品 订单id
	 * @return CustomizedArtworkOrder 定制品订单
	 */
	public CustomizedArtworkOrder getCustomedArtworkOrderByOrderId(long customizedArtworkOrderId);//根据订单id获取定制艺术品订单	
/**
 * 根据卖家id 获得获得所有的定制艺术品订单
 * @param ownerId long 拥有者id
 * @return List<CustomizedArtworkOrder> 定制品订单列表
 */
	public List<CustomizedArtworkOrder> getCustomizedArtworkOrdersByOwnerId(long ownerId);//根据卖家id 获得获得所有的定制艺术品订单
	/**
	 * sign=1表根据订单编号查找，=2表艺术品名，=3表卖家用户名，=4表买家用户名  typeId:艺术品类型id，为空值时表示不做限制  startTime~endTime:表示订单的下单时间在这个时间段，可以为空，表不做限制
	 * @param sign String
	 * @param name String
	 * @param typeId String
	 * @param startTime Date
	 * @param endTime Date
	 * @return List<CustomizedArtworkOrder> 定制品订单列表
	 */
	public List<CustomizedArtworkOrder> getByOrderIdOrArtworkNameOrOwnerNameOrUserName(String sign, String name, String typeId,Date startTime,Date endTime);
	//sign=1表根据订单编号查找，=2表艺术品名，=3表卖家用户名，=4表买家用户名  typeId:艺术品类型id，为空值时表示不做限制  startTime~endTime:表示订单的下单时间在这个时间段，可以为空，表不做限制
/**
 * 根据定制订单id更新stage属性
 * @param orderId long 订单id
 * @param stage String 
 */
	public void updateCustomizedArtworkOrderStage(long orderId,String stage);//根据定制订单id更新stage属性
	/**
	 * 根据定制订单id更新state属性
	 * @param orderId long 订单id
	 * @param state String
	 */
	public void updateCustomizedArtworkOrderState(long orderId,String state);//根据定制订单id更新state属性
	
	/**
	 * 更新定制订单
	 * @param customizedArtworkOrder CustomizedArtworkOrder 定制订单
	 */
	public void updateCustomizedArtworkOrder(CustomizedArtworkOrder customizedArtworkOrder);//更新定制订单
	
}
