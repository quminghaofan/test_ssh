package cn.edu.xmu.oneonezero.service;

import java.util.List;

import net.sf.json.JSONObject;
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
	@Override
	public List<CommodityArtwork> getCommodityArtworksByPosition(int start, int num) {
		return commodityArtworkDao.getCommodityArtworksByPosition(start, num);
	}
	@Override
	public long getPageTotal(int num) {
		return commodityArtworkDao.getPageTotal(num);
	}
	@Override
	public JSONObject getCommodityArtworkWithJSONTypeById(long id) {
		return commodityArtworkDao.getCommodityArtworkWithJSONTypeById(id);
	}

}
