package cn.edu.xmu.oneonezero.dao;

import java.util.List;

import org.json.simple.JSONObject;

import cn.edu.xmu.oneonezero.entity.CommodityArtwork;

public interface CommodityArtworkDao {
	public List<CommodityArtwork> commodityArtworksToDisplay();//获取今天要展示的3个艺术品商品

	public List<CommodityArtwork> getCommodityArtworksByPosition(int start,int num);//按位置获取一系列艺术品
	
	public long getPageTotal(int num);//根据每页数量获得总页数
	
	public JSONObject getCommodityArtworkWithJSONTypeById(long id);//根据id获取jsonObject类型艺术品

}
