package cn.edu.xmu.oneonezero.service;

import java.util.List;

import net.sf.json.JSONObject;
import cn.edu.xmu.oneonezero.entity.CommodityArtwork;

public interface CommodityArtworkService {
	public List<CommodityArtwork> commodityArtworksToDisplay();//获取今天要展示的3个艺术品商品
	


	public List<CommodityArtwork> getCommodityArtworksByPositionAndVagueName(String artName,int start,int num);//按位置和模糊名称获取一系列艺术品商品
	
	public int getPageTotalByVagueName(String artName,int num);//根据模糊名字和每页数量获得商品总页数
	
	public JSONObject getCommodityArtworkWithJSONTypeById(long id);//根据id获取jsonObject类型艺术品商品

	public List<CommodityArtwork> getCommodityArtworksByVagueArtNameInDescendingOrder(String artName);//按价格从高到低排序，根据艺术品名称模糊分页获取艺术品商品
	
	public List<CommodityArtwork> getCommodityArtworksByVagueArtNameInAscendingOrder(String artName);//按价格从低到高排序，根据艺术品名称模糊分页获取艺术品商品

	public List<CommodityArtwork> getAllCommodityArtworks();//获取所有艺术品商品
	
	public List<CommodityArtwork> getCommodityArtworksByArtistId(long ownerId);//获取艺术家的所有艺术品商品

	public void insertCommodityArtwork(CommodityArtwork commodityArtwork);//添加艺术品商品 
	
	public CommodityArtwork getCommodityArtworkById(long commodityArtworkId);//根据id获取艺术品商品
	
	public void updateCommodityArtwork(CommodityArtwork commodityArtwork);//根据id更新艺术品商品
	
	

	public List<CommodityArtwork> getAllExhibitArtworks();//获取所有艺术品展品
	
	public List<CommodityArtwork> getCommodityArtworksByArtworkTypeIdVagueArtworkNamePageNumber(Long artworkTypeId, String artName, int start,int num);//根据艺术品类型id，模糊艺术品名称，页码，每页数量 分页获取艺术品商品，返回list
	
	public List<CommodityArtwork> getExhibitArtworksByArtworkTypeIdVagueArtworkNamePageNumber(Long artworkTypeId, String artName, int start,int num);//根据艺术品类型id，模糊艺术品名称，页码，每页数量 分页获取艺术品展品，返回list

	public List<CommodityArtwork> getExhibitArtworksByVagueArtNameAndPage(String artName, int start,int num);//根据模糊艺术品名称，页码，每页数量 分页获取艺术品展品，返回list

	public void setCommodityArtworkIsExistByArtworkId(long artworkId, boolean isExist);//根据id设置艺术品商品isExist

	public void deleteExhibitArtworkByArtworkId(long artworkId);//根据id设置艺术品商品isExist
	
	public List<CommodityArtwork> getExhibitArtworksByOwnerId(long artistId);//根据艺术家id获取展品
	
	public List<CommodityArtwork> getByVagueArtworkNameOrOwnerName(String sign,String name, String typeId);//sign=0,表根据艺术品名称搜索 sign=1，表根据卖家用户名搜索 艺术品商品包括展品
	
	public int getExhibitPageTotalByVagueName(String artName,int num);//根据模糊名字和每页数量获得展品总页数
	

	
}
