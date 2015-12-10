package cn.edu.xmu.oneonezero.service;

import java.util.List;

import cn.edu.xmu.oneonezero.entity.CommodityArtwork;

public interface CommodityArtworkService {
	public List<CommodityArtwork> commodityArtworksToDisplay();//获取今天要展示的3个艺术品商品
	
}
