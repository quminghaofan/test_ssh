package cn.edu.xmu.oneonezero.dao;

import java.util.List;

import net.sf.json.JSONObject;
import cn.edu.xmu.oneonezero.entity.CommodityArtwork;

/**
 * 制成品
 * @author DELL
 *
 */
public interface CommodityArtworkDao {
	/**
	 * 获取展品
	 * @return List
	 */
	public List<CommodityArtwork> commodityArtworksToDisplay();

	/**
	 * 按模糊名称分页获取艺术品商品
	 * @param artName 艺术品名称
	 * @param start 开始位置
	 * @param num 数量
	 * @return List
	 */
	public List<CommodityArtwork> getCommodityArtworksByPositionAndVagueName(String artName,int start,int num);
	
	/**
	 * 根据模糊名字和每页数量获得总页数
	 * @param artName 模糊艺术品名字
	 * @param num 每页数量
	 * @return int
	 */
	public int getPageTotalByVagueName(String artName,int num);
	
	/**
	 * 根据id获取jsonObject类型艺术品商品
	 * @param id 
	 * @return JSONObject
	 */
	public JSONObject getCommodityArtworkWithJSONTypeById(long id);

	/**
	 * 按价格从高到低排序，根据艺术品名称模糊获取艺术品商品
	 * @param artName 艺术品名称
	 * @return List
	 */
	public List<CommodityArtwork> getCommodityArtworksByVagueArtNameInDescendingOrder(String artName);
	
	/**
	 * 按价格从低到高排序，根据艺术品名称模糊获取艺术品商品
	 * @param artName 艺术品名称
	 * @return List
	 */ 
	public List<CommodityArtwork> getCommodityArtworksByVagueArtNameInAscendingOrder(String artName);

	/**
	 * 获取所有艺术品商品
	 * @return List
	 */
	public List<CommodityArtwork> getAllCommodityArtworks();
	
	/**
	 * 获取艺术家的所有艺术品商品
	 * @param ownerId 艺术品所有者id
	 * @return List
	 */
	public List<CommodityArtwork> getCommodityArtworksByArtistId(long ownerId);
	
	/**
	 * 添加艺术品商品 
	 * @param commodityArtwork 艺术品商品 信息
	 */
	public void insertCommodityArtwork(CommodityArtwork commodityArtwork);
	
	/**
	 * 根据id获取艺术品商品
	 * @param commodityArtworkId 制成品id
	 * @return CommodityArtwork
	 */
	public CommodityArtwork getCommodityArtworkById(long commodityArtworkId);
	
	/**
	 * 根据id更新艺术品商品
	 * @param commodityArtwork 艺术品商品 信息
	 */
	public void updateCommodityArtwork(CommodityArtwork commodityArtwork);
	
	/**
	 * 根据id禁用艺术品商品
	 * @param commodityArtworkId 制成品id
	 */
	public void prohibitCommodityArtwork(long commodityArtworkId);
	
	/**
	 * 获取所有艺术品展品
	 * @return List
	 */
	public List<CommodityArtwork> getAllExhibitArtworks();
	
	/**
	 * 根据艺术品类型id，模糊艺术品名称，页码，每页数量 分页获取商品艺术品
	 * @param artworkTypeId 艺术品类型id
	 * @param artName 模糊艺术品名称
	 * @param start 页码
	 * @param num 每页数量
	 * @return List
	 */
	public List<CommodityArtwork> getCommodityArtworksByArtworkTypeIdVagueArtworkNamePageNumber(long artworkTypeId, String artName, int start,int num);

	/**
	 * 根据艺术品类型id，模糊艺术品名称，页码，每页数量 分页获取艺术品展品
	 * @param artworkTypeId 艺术品类型id
	 * @param artName 模糊艺术品名称
	 * @param start 页码
	 * @param num 每页数量
	 * @return List
	 */
	public List<CommodityArtwork> getExhibitArtworksByArtworkTypeIdVagueArtworkNamePageNumber(long artworkTypeId, String artName, int start,int num);

	/**
	 * 根据模糊艺术品名称，页码，每页数量 分页获取艺术品展品，返回list
	 * @param artName 模糊艺术品名称
	 * @param start 页码
	 * @param num 每页数量
	 * @return List
	 */
	public List<CommodityArtwork> getExhibitArtworksByVagueArtNameAndPage(String artName, int start,int num);

	/**
	 * 根据id设置艺术品商品isExist
	 * @param artworkId 艺术品id
	 * @param isExist 
	 */
	public void setCommodityArtworkIsExistByArtworkId(long artworkId, boolean isExist);

	/**
	 * 删除
	 * @param artworkId 艺术品id
	 */
	public void deleteExhibitArtworkByArtworkId(long artworkId);
	
	/**
	 * 根据艺术家id获取展品
	 * @param artistId 艺术家id
	 * @return List
	 */
	public List<CommodityArtwork> getExhibitArtworksByOwnerId(long artistId);

	/**
	 * 根据艺术品名称搜索
	 * @param name 艺术品名称
	 * @param typeId 艺术品类型id
	 * @return List
	 */
	public List<CommodityArtwork> getByVagueArtworkName(String name, String typeId);
	
	/**
	 * 根据卖家用户名搜索
	 * @param name 卖家用户名
	 * @param typeId 艺术品类型id
	 * @return List
	 */
	public List<CommodityArtwork> getByVagueOwnerName(String name, String typeId);
	
	/**
	 * 根据模糊名字和每页数量获得展品总页数
	 * @param artName 模糊名字
	 * @param num 每页数量
	 * @return int
	 */
	public int getExhibitPageTotalByVagueName(String artName,int num);
	
	
}
