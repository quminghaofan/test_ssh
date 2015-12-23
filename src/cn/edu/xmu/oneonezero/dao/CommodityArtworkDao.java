package cn.edu.xmu.oneonezero.dao;

import java.util.List;

import net.sf.json.JSONObject;
import cn.edu.xmu.oneonezero.entity.CommodityArtwork;
import cn.edu.xmu.oneonezero.entity.User;

public interface CommodityArtworkDao {
	public List<CommodityArtwork> commodityArtworksToDisplay();//获取今天要展示的3个艺术品商品

	
	
	public List<CommodityArtwork> getCommodityArtworksByPositionAndVagueName(String artName,int start,int num);//按位置和模糊名称获取一系列艺术品商品
	
	public int getPageTotalByVagueName(String artName,int num);//根据模糊名字和每页数量获得总页数
	
	public JSONObject getCommodityArtworkWithJSONTypeById(long id);//根据id获取jsonObject类型艺术品商品

	public List<CommodityArtwork> getCommodityArtworksByVagueArtNameInDescendingOrder(String artName);//按价格从高到低排序，根据艺术品名称模糊分页获取艺术品商品
	
	public List<CommodityArtwork> getCommodityArtworksByVagueArtNameInAscendingOrder(String artName);//按价格从低到高排序，根据艺术品名称模糊分页获取艺术品商品

	public List<CommodityArtwork> getAllCommodityArtworks();//获取所有艺术品商品
	
	public List<CommodityArtwork> getCommodityArtworksByArtistId(long ownerId);//获取艺术家的所有艺术品商品
	
	public void insertCommodityArtwork(CommodityArtwork commodityArtwork);//添加艺术品商品 
	
	public CommodityArtwork getCommodityArtworkById(long commodityArtworkId);//根据id获取艺术品商品
	
	public void updateCommodityArtwork(CommodityArtwork commodityArtwork);//根据id更新艺术品商品
	
	//根据id禁用艺术品商品
	
	public List<CommodityArtwork> getAllExhibitArtworks();//获取所有艺术品展品
	

}
