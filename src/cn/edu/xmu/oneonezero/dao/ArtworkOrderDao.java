package cn.edu.xmu.oneonezero.dao;

import java.util.Date;
import java.util.List;

import cn.edu.xmu.oneonezero.entity.ArtworkOrder;

/**
 * 艺术品订单基类
 * @author DELL
 *
 */
public interface ArtworkOrderDao {
	
	/**
	 * 根据用户id获取所有的订单
	 * @param userId 用户id
	 * @return List
	 */
	public List<ArtworkOrder> getArtworkOrderByUserId(long userId);

	/**
	 * 根据订单编号查找一段时间的订单
	 * @param orderId 订单编号
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @return List
	 */
	public List<ArtworkOrder> getOrdersByOrderIdAndTimespace(String orderId,Date startTime,Date endTime);
	
	/**
	 * 根据买家用户名查找一段时间的订单
	 * @param userName 买家用户名
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @return List
	 */
	public List<ArtworkOrder> getOrdersByUserNameAndTimespace(String userName,Date startTime,Date endTime);
	
	/**
	 * 根据订单id获取订单	
	 * @param artworkOrderId 订单id
	 * @return ArtworkOrder
	 */
	public ArtworkOrder getOrderByOrderId(long artworkOrderId);
	
	/**
	 * 根据id修改订单属性isAccept
	 * @param id 订单id
	 * @param isAccept 
	 */
	public void setArtworkOrderIsAccept(long id, String isAccept);
	
	/**
	 * 取消定制订单
	 * @param id 订单id
	 */
	public void cancelArtworkOrder(long id);
	
	/**
	 * 根据订单id和state更新订单状态
	 * @param orderId 订单id
	 * @param state 订单状态
	 */
	public void updateArtworkOrderState(long orderId,String state );


	
	
}
