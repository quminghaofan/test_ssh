package cn.edu.xmu.oneonezero.service;

import java.util.Date;
import java.util.List;

import cn.edu.xmu.oneonezero.entity.ArtworkOrder;

public interface ArtworkOrderService {

	
	
	
	
	/**
	 * 根据用户id获取所有的订单
	 * @param userId long 用户id
	 * @return List<ArtworkOrder> 订单列表
	 */
	public List<ArtworkOrder> getArtworkOrderByUserId(long userId);//根据用户id获取所有的订单
/**
 * 根据订单编号查找一段时间的订单
 * @param orderId String 订单id
 * @param startTime Date 开始时间
 * @param endTime Date 结束时间
 * @return List<ArtworkOrder> 订单列表
 */
	public List<ArtworkOrder> getOrdersByOrderIdAndTimespace(String orderId,Date startTime,Date endTime);//1.根据订单编号查找一段时间的订单
	/**
	 * 根据买家用户名查找一段时间的订单
	 * @param userName String 用户名
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @return List<ArtworkOrder> 订单列表
	 */
	public List<ArtworkOrder> getOrdersByUserNameAndTimespace(String userName,Date startTime,Date endTime);//4.根据买家用户名查找一段时间的订单
	/**
	 * 根据订单id获取订单
	 * @param artworkOrderId 订单id
	 * @return ArtworkOrder 订单
	 */
	public ArtworkOrder getOrderByOrderId(long artworkOrderId);//根据订单id获取订单	
	/**
	 * 根据id修改订单属性isAccept
	 * @param id 订单id
	 * @param isAccept 是否接受，1表示接受，0表示拒绝
	 */
	public void setArtworkOrderIsAccept(long id, String isAccept);//根据id修改订单属性isAccept
	/**
	 * 取消定制订单
	 * @param id 订单id
	 */
	public void cancelArtworkOrder(long id);//取消定制订单
	/**
	 * 根据订单id和state更新订单状态
	 * @param orderId 订单id
	 * @param state 订单状态
	 */
	public void updateArtworkOrderState(long orderId,String state );//根据订单id和state更新订单状态


	
}
