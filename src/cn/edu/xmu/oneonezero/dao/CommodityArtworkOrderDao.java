package cn.edu.xmu.oneonezero.dao;

import java.util.Date;
import java.util.List;

import cn.edu.xmu.oneonezero.entity.CommodityArtworkOrder;

/**
 * 艺术品商品订单
 * @author DELL
 *
 */
public interface CommodityArtworkOrderDao {

	/**
	 * 根据订单编号查找一段时间的艺术品商品订单
	 * @param orderId 订单编号
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @return List
	 */
	public List<CommodityArtworkOrder> getCommodityArtworkOrdersByOrderIdAndTimespace(String orderId,Date startTime,Date endTime);
	
	/**
	 * 根据艺术品名模糊查找一段时间艺术品商品订单
	 * @param artworkName 艺术品名
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @return List
	 */
	public List<CommodityArtworkOrder> getCommodityArtworkOrdersByVagueArtworkNameAndTimespace(String artworkName,Date startTime,Date endTime);
	
	/**
	 * 根据艺术品类型查找一段时间的艺术品商品订单
	 * @param artworkType 艺术品类型名称
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @return List
	 */
	public List<CommodityArtworkOrder> getCommodityArtworkOrdersByArtworkTypeAndTimespace(String artworkType,Date startTime,Date endTime);
	
	/**
	 * 根据买家用户名查找一段时间的艺术品商品订单
	 * @param userName 买家用户名
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @return List
	 */
	public List<CommodityArtworkOrder> getCommodityArtworkOrdersByUserNameAndTimespace(String userName,Date startTime,Date endTime);
	
	/**
	 * 根据卖家用户名查找一段时间的艺术品商品订单
	 * @param artistName 卖家用户名
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @return List
	 */
	public List<CommodityArtworkOrder> getCommodityArtworkOrdersByArtistNameAndTimespace(String artistName,Date startTime,Date endTime);
	
	/**
	 * 获取所有艺术品商品订单
	 * @return List
	 */
	public List<CommodityArtworkOrder> getAllCommodityArtworkOrders();

	/**
	 * 获取艺术家的所有艺术品商品订单
	 * @param artistId 艺术家id
	 * @return List
	 */
	public List<CommodityArtworkOrder> getCommodityArtworkOrdersByArtistId(long artistId);
	
	/**
	 * 根据用户id获取所有艺术品商品订单
	 * @param userId 用户id
	 * @return List
	 */
	public List<CommodityArtworkOrder> getCommodityArtworkOrdersByUserId(long userId);
	
	/**
	 * 添加艺术品商品订单,并返回其id
	 * @param commodityArtworkOrder 艺术品商品订单信息
	 * @return long
	 */
	public long insertCommodityArtworkOrder(CommodityArtworkOrder commodityArtworkOrder);
	
	/**
	 * 根据id删除艺术品商品订单
	 * @param commodityArtworkId 订单id
	 * @return boolean
	 */
	public boolean deleteCommodityArtworkOrder(long commodityArtworkId);
	
	/**
	 * 根据订单id获取艺术品商品订单	
	 * @param commodityArtworkOrderId 订单id
	 * @return CommodityArtworkOrder
	 */
	public CommodityArtworkOrder getCommodityArtworkOrderByOrderId(long commodityArtworkOrderId);

	/**
	 * 根据卖家id 获得获得所有的艺术品商品订单
	 * @param ownerId 卖家id 
	 * @return List
	 */
	public List<CommodityArtworkOrder> getCommodityArtworkOrdersByOwnerId(long ownerId);
	
	/**
	 * 根据订单id和state更新成品订单状态
	 * @param orderId 订单id
	 * @param state 成品订单状态
	 */
	public void updateCommodityArtworkOrderState(long orderId,String state );
	
	/**
	 * 根据订单编号获取一段时间的成品订单
	 * @param name 订单编号
	 * @param typeId 艺术品类型id
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @return List
	 */
	public List<CommodityArtworkOrder> getByOrderId(String name,String typeId, Date startTime,Date endTime);
	
	/**
	 * 根据艺术品名称获取一段时间的成品订单
	 * @param name 艺术品名称
	 * @param typeId 艺术品类型id
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @return List
	 */
	public List<CommodityArtworkOrder> getByArtworkName(String name,String typeId, Date startTime,Date endTime);
	
	/**
	 * 根据艺术品所有者的用户名获取一段时间的成品订单
	 * @param name 艺术品所有人用户名
	 * @param typeId 艺术品类型id
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @return List
	 */
	public List<CommodityArtworkOrder> getByOwnerName(String name,String typeId, Date startTime,Date endTime);
	
	/**
	 * 通过用户名获取用户一段时间的成品订单
	 * @param name 用户名
	 * @param typeId 艺术品类型id
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @return List
	 */
	public List<CommodityArtworkOrder> getByUserName(String name,String typeId, Date startTime,Date endTime);
	
	/**
	 * 批量插入成品订单
	 * @param aList 成品订单信息
	 */
	public void insertSomeCommodityArtworkOrders(List<CommodityArtworkOrder> aList);
	
	
	
}
