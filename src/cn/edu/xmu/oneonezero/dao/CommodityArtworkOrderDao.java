package cn.edu.xmu.oneonezero.dao;

import java.util.Date;
import java.util.List;

import cn.edu.xmu.oneonezero.entity.CommodityArtworkOrder;

public interface CommodityArtworkOrderDao {

	public List<CommodityArtworkOrder> getCommodityArtworkOrdersByOrderIdAndTimespace(String orderId,Date startTime,Date endTime);//1.根据订单编号查找一段时间的艺术品商品订单
	
	public List<CommodityArtworkOrder> getCommodityArtworkOrdersByVagueArtworkNameAndTimespace(String artworkName,Date startTime,Date endTime);//2.根据艺术品名模糊查找一段时间艺术品商品订单
	
	public List<CommodityArtworkOrder> getCommodityArtworkOrdersByArtworkTypeAndTimespace(String artworkType,Date startTime,Date endTime);//3.根据艺术品类型查找一段时间的艺术品商品订单
	
	public List<CommodityArtworkOrder> getCommodityArtworkOrdersByUserNameAndTimespace(String userName,Date startTime,Date endTime);//4.根据买家用户名查找一段时间的艺术品商品订单
	
	public List<CommodityArtworkOrder> getCommodityArtworkOrdersByArtistNameAndTimespace(String artistName,Date startTime,Date endTime);//5.根据卖家用户名查找一段时间的艺术品商品订单
	
	public List<CommodityArtworkOrder> getAllCommodityArtworkOrders();//获取所有艺术品商品订单

	public List<CommodityArtworkOrder> getCommodityArtworkOrdersByArtistId(long artistId);//获取艺术家的所有艺术品商品订单
	
	public List<CommodityArtworkOrder> getCommodityArtworkOrdersByUserId(long userId);//根据用户id获取所有艺术品商品订单
	
	public void insertCommodityArtworkOrder(CommodityArtworkOrder commodityArtworkOrder);//添加艺术品商品订单
	
	public boolean deleteCommodityArtworkOrder(long commodityArtworkId);//根据id删除艺术品商品订单
	
	public CommodityArtworkOrder getCommodityArtworkOrderByOrderId(long commodityArtworkOrderId);//根据订单id获取艺术品商品订单	

	public List<CommodityArtworkOrder> getCommodityArtworkOrdersByOwnerId(long ownerId);//根据卖家id 获得获得所有的艺术品商品订单
	
	public void updateCommodityArtworkOrderState(long orderId,String state );//根据订单id和state更新成品订单状态
	
	public List<CommodityArtworkOrder> getByOrderId(String name,String typeId, Date startTime,Date endTime);//name表示OrderId
	
	public List<CommodityArtworkOrder> getByArtworkName(String name,String typeId, Date startTime,Date endTime);//name表示ArtworkName
	
	public List<CommodityArtworkOrder> getByOwnerName(String name,String typeId, Date startTime,Date endTime);//name表示OwnerNama
	
	public List<CommodityArtworkOrder> getByUserName(String name,String typeId, Date startTime,Date endTime);//name表示UserName
	
}
