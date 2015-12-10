package cn.edu.xmu.oneonezero.service;

import java.util.List;

import cn.edu.xmu.oneonezero.dao.CommodityArtworkDao;
import cn.edu.xmu.oneonezero.dao.NewsDao;
import cn.edu.xmu.oneonezero.entity.CommodityArtwork;

public class CommodityArtworkServiceImpl implements CommodityArtworkService{

	private CommodityArtworkDao commodityArtworkDao;
	
	public void setCommodityArtworkDao(CommodityArtworkDao commodityArtworkDao) {  
	    this.commodityArtworkDao=commodityArtworkDao;
	}
	@Override
	public List<CommodityArtwork> commodityArtworksToDisplay() {
		return commodityArtworkDao.commodityArtworksToDisplay();
	}

}
