package cn.edu.xmu.oneonezero.service;

import java.util.List;

import net.sf.json.JSONObject;
import cn.edu.xmu.oneonezero.entity.CommodityArtwork;

public interface CommodityArtworkService {
	/**
	 * 获取今天要展示的3个艺术品商品
	 * @return List<CommodityArtwork> 三个制成品
	 */
	public List<CommodityArtwork> commodityArtworksToDisplay();//获取今天要展示的3个艺术品商品
	

/**
 * 
	public List<CommodityArtwork> getCommodityArtworksByPositionAndVagueName(String artName,int start,int num);//
 * @param artName String 艺术品名
 * @param start int 
 * @param num int
 * @return List<CommodityArtwork> 制成品订单列表
 */
	public List<CommodityArtwork> getCommodityArtworksByPositionAndVagueName(String artName,int start,int num);//按位置和模糊名称获取一系列艺术品商品
	/**
	 * 根据模糊名字和每页数量获得商品总页数
	 * @param artName 艺术品名
	 * @param num 每页数量
	 * @return int 总页数
	 */
	public int getPageTotalByVagueName(String artName,int num);//根据模糊名字和每页数量获得商品总页数
	/**
	 * 根据id获取jsonObject类型艺术品商品
	 * @param id long 
	 * @return JSONObject
	 */
	public JSONObject getCommodityArtworkWithJSONTypeById(long id);//根据id获取jsonObject类型艺术品商品
/**
 * 按价格从高到低排序，根据艺术品名称模糊分页获取艺术品商品
 * @param artName String 艺术品名
 * @return List<CommodityArtwork> 制成品列表
 */
	public List<CommodityArtwork> getCommodityArtworksByVagueArtNameInDescendingOrder(String artName);//按价格从高到低排序，根据艺术品名称模糊分页获取艺术品商品
	/**
	 * 按价格从低到高排序，根据艺术品名称模糊分页获取艺术品商品
	 * @param artName String 艺术品名
	 * @return List<CommodityArtwork> 制成品列表
	 */
	public List<CommodityArtwork> getCommodityArtworksByVagueArtNameInAscendingOrder(String artName);//按价格从低到高排序，根据艺术品名称模糊分页获取艺术品商品
/**
 * 获取所有艺术品商品
 * @return List<CommodityArtwork> 制成品列表
 */
	public List<CommodityArtwork> getAllCommodityArtworks();//获取所有艺术品商品
	/**
	 * 获取艺术家的所有艺术品商品
	 * @param ownerId long 拥有者id
	 * @return List<CommodityArtwork> 制成品列表
	 */
	public List<CommodityArtwork> getCommodityArtworksByArtistId(long ownerId);//获取艺术家的所有艺术品商品
/**
 * 添加艺术品商品
 * @param commodityArtwork CommodityArtwork 制成品
 */
	public void insertCommodityArtwork(CommodityArtwork commodityArtwork);//添加艺术品商品 
	/**
	 * 根据id获取艺术品商品
	 * @param commodityArtworkId long 制成品id
	 * @return CommodityArtwork 制成品
	 */
	public CommodityArtwork getCommodityArtworkById(long commodityArtworkId);//根据id获取艺术品商品
	/**
	 * 根据id更新艺术品商品
	 * @param commodityArtwork CommodityArtwork 制成品
	 */
	public void updateCommodityArtwork(CommodityArtwork commodityArtwork);//根据id更新艺术品商品
	
	
/**
 * 获取所有艺术品展品
 * @return  List<CommodityArtwork> 艺术品展品列表
 */
	public List<CommodityArtwork> getAllExhibitArtworks();//获取所有艺术品展品
	/**
	 * 根据艺术品类型id，模糊艺术品名称，页码，每页数量 分页获取艺术品商品，返回list
	 * @param artworkTypeId Long 艺术品类型id
	 * @param artName String 艺术品名
	 * @param start int 首个艺术品序号
	 * @param num int 每页个数
	 * @return List<CommodityArtwork> 制成品列表
	 */
	public List<CommodityArtwork> getCommodityArtworksByArtworkTypeIdVagueArtworkNamePageNumber(Long artworkTypeId, String artName, int start,int num);//根据艺术品类型id，模糊艺术品名称，页码，每页数量 分页获取艺术品商品，返回list
	/**
	 * 根据艺术品类型id，模糊艺术品名称，页码，每页数量 分页获取艺术品展品，返回list
	 * @param artworkTypeId Long 艺术品类型id
	 * @param artName String 艺术品名
	 * @param start int 首个艺术品序号
	 * @param num int 每页个数
	 * @return List<CommodityArtwork> 艺术品展品列表
	 */
	public List<CommodityArtwork> getExhibitArtworksByArtworkTypeIdVagueArtworkNamePageNumber(Long artworkTypeId, String artName, int start,int num);//根据艺术品类型id，模糊艺术品名称，页码，每页数量 分页获取艺术品展品，返回list
/**
 * 根据模糊艺术品名称，页码，每页数量 分页获取艺术品展品，返回list
 * @param artName String 艺术品名
 * @param start int 首个艺术品序号
 * @param num int 每页个数
 * @return List<CommodityArtwork> 艺术品展品列表
 */
	public List<CommodityArtwork> getExhibitArtworksByVagueArtNameAndPage(String artName, int start,int num);//根据模糊艺术品名称，页码，每页数量 分页获取艺术品展品，返回list
/**
 * 根据id设置艺术品商品isExist
 * @param artworkId long 艺术品id
 * @param isExist Boolean 是否存在，1代表存在，0代表不存在
 */
	public void setCommodityArtworkIsExistByArtworkId(long artworkId, boolean isExist);//根据id设置艺术品商品isExist
/**
 * 根据id设置艺术品商品isExist
 * @param artworkId long 艺术品id
 */
	public void deleteExhibitArtworkByArtworkId(long artworkId);//根据id设置艺术品商品isExist
	/**
	 * 根据艺术家id获取展品
	 * @param artistId 艺术家id
	 * @return List<CommodityArtwork> 艺术品展品列表
	 */
	public List<CommodityArtwork> getExhibitArtworksByOwnerId(long artistId);//根据艺术家id获取展品
	/**
	 * sign=0,表根据艺术品名称搜索 sign=1，表根据卖家用户名搜索 艺术品商品包括展品
	 * @param sign String
	 * @param name String 艺术品名
	 * @param typeId String 种类id
	 * @return List<CommodityArtwork> 艺术品列表
	 */
	public List<CommodityArtwork> getByVagueArtworkNameOrOwnerName(String sign,String name, String typeId);//sign=0,表根据艺术品名称搜索 sign=1，表根据卖家用户名搜索 艺术品商品包括展品
	/**
	 * 根据模糊名字和每页数量获得展品总页数
	 * @param artName String 艺术品名
	 * @param num int 每页数量
	 * @return int 展品总页数
	 */
	public int getExhibitPageTotalByVagueName(String artName,int num);//根据模糊名字和每页数量获得展品总页数
	

	
}
