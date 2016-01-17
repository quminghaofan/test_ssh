package cn.edu.xmu.oneonezero.dao;

import java.util.Date;
import java.util.List;

import cn.edu.xmu.oneonezero.entity.CommodityArtworkOrder;
import cn.edu.xmu.oneonezero.entity.CustomizedArtworkOrder;

/**
 * 订制品订单
 * @author DELL
 *
 */
public interface CustomizedArtworkOrderDao {
	/**
	 * 
	 * @param userId
	 * @return
	 */
	public List<CustomizedArtworkOrder> getCustomizedArtworkOrdersByUserId(long userId);//根据用户id获取所有的定制品订单
	
	/**
	 * 
	 * @param orderId
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public List<CustomizedArtworkOrder> getCustomizedArtworkOrdersByOrderIdAndTimespace(String orderId,Date startTime,Date endTime);//1.根据订单编号查找一段时间的定制艺术品订单
	
	/**
	 * 
	 * @param artworkName
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public List<CustomizedArtworkOrder> getCustomizedArtworkOrdersByVagueArtworkNameAndTimespace(String artworkName,Date startTime,Date endTime);//2.根据艺术品名模糊查找一段时间定制艺术品订单
	
	/**
	 * 
	 * @param artworkType
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public List<CustomizedArtworkOrder> getCustomizedArtworkOrdersByArtworkTypeAndTimespace(String artworkType,Date startTime,Date endTime);//3.根据艺术品类型查找一段时间的定制艺术品订单
	
	/**
	 * 
	 * @param userName
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public List<CustomizedArtworkOrder> getCustomizedArtworkOrdersByUserNameAndTimespace(String userName,Date startTime,Date endTime);//4.根据买家用户名查找一段时间的定制艺术品订单
	
	/**
	 * 
	 * 
	 * @param artistName
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public List<CustomizedArtworkOrder> getCustomizedArtworkOrdersByArtistNameAndTimespace(String artistName,Date startTime,Date endTime);//5.根据卖家用户名查找一段时间的定制艺术品订单
	
	/**
	 * 获取所有定制艺术品订单
	 * @return List
	 */
	public List<CustomizedArtworkOrder> getAllCustomizedArtworkOrders();//
	
	/**
	 * 添加定制品订单
	 * @param customizedArtworkOrder 定制品订单信息
	 */
	public void insertCustomizedArtworkOrder(CustomizedArtworkOrder customizedArtworkOrder);//
	
	/**
	 * 根据id删除定制艺术品
	 * @param customizedArtworkId 订单id
	 * @return boolean
	 */
	public boolean deleteCustomizedArtworkOrder(long customizedArtworkId);//

	/**
	 * 根据订单id获取定制艺术品订单	
	 * @param customizedArtworkOrderId 订单id
	 * @return CustomizedArtworkOrder
	 */
	public CustomizedArtworkOrder getCustomedArtworkOrderByOrderId(long customizedArtworkOrderId);//

	/**
	 * 根据卖家id 获得获得所有的定制艺术品订单
	 * @param ownerId 卖家id 
	 * @return List
	 */
	public List<CustomizedArtworkOrder> getCustomizedArtworkOrdersByOwnerId(long ownerId);//
	
	/**
	 * 根据订单编号获取一段时间的定制订单
	 * @param name 订单编号
	 * @param typeId 艺术品类型
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @return List
	 */
	public List<CustomizedArtworkOrder> getByOrderId(String name,String typeId, Date startTime,Date endTime);//name表示OrderId
	
	/**
	 * 根据艺术品名称获取一段时间的定制订单
	 * @param name 艺术品名称
	 * @param typeId 艺术品类型
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @return List
	 */
	public List<CustomizedArtworkOrder> getByArtworkName(String name,String typeId, Date startTime,Date endTime);//name表示ArtworkName
	
	/**
	 * 根据卖家用户名获取一段时间的定制订单
	 * @param name 卖家用户名
	 * @param typeId 艺术品类型
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @return List
	 */
	public List<CustomizedArtworkOrder> getByOwnerName(String name,String typeId, Date startTime,Date endTime);//name表示OwnerNama
	
	/**
	 * 根据买家用户名获取一段时间的定制订单
	 * @param name 买家用户名
	 * @param typeId 艺术品类型
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @return List
	 */
	public List<CustomizedArtworkOrder> getByUserName(String name,String typeId, Date startTime,Date endTime);//name表示UserName
	
	/**
	 * 根据定制订单id更新stage属性
	 * @param orderId 定制订单id
	 * @param stage 
	 */
	public void updateCustomizedArtworkOrderStage(long orderId,String stage);//
	
	/**
	 * 根据定制订单id更新state属性
	 * @param orderId 定制订单id
	 * @param state 
	 */
	public void updateCustomizedArtworkOrderState(long orderId,String state);//
	
	/**
	 * 更新定制订单
	 * @param customizedArtworkOrder 定制订单信息
	 */
	public void updateCustomizedArtworkOrder(CustomizedArtworkOrder customizedArtworkOrder);//

	
}
