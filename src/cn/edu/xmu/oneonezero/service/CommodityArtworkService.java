package cn.edu.xmu.oneonezero.service;

import java.util.List;

import net.sf.json.JSONObject;
import cn.edu.xmu.oneonezero.entity.CommodityArtwork;

public interface CommodityArtworkService {
	public List<CommodityArtwork> commodityArtworksToDisplay();//获取今天要展示的3个艺术品商品
	
	public List<CommodityArtwork> getCommodityArtworksByPosition(int start,int num);//获取今天要展示的3个艺术品商品

	public long getPageTotal(int num);//根据每页数量获得总页数

	public JSONObject getCommodityArtworkWithJSONTypeById(long id);//根据id获取jsonObject类型艺术品
}
