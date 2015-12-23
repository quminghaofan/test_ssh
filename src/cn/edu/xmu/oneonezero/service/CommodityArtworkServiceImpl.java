package cn.edu.xmu.oneonezero.service;

import java.util.List;

import net.sf.json.JSONObject;
import cn.edu.xmu.oneonezero.dao.CommodityArtworkDao;
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
	public List<CommodityArtwork> getCommodityArtworksByPositionAndVagueName(String artName, int start, int num) {
		return commodityArtworkDao.getCommodityArtworksByPositionAndVagueName(artName, start, num);
	}
	@Override
	public int getPageTotalByVagueName(String artName, int num) {
		return commodityArtworkDao.getPageTotalByVagueName(artName, num);
	}
	@Override
	public JSONObject getCommodityArtworkWithJSONTypeById(long id) {
		return commodityArtworkDao.getCommodityArtworkWithJSONTypeById(id);
	}
	@Override
	public List<CommodityArtwork> getCommodityArtworksByVagueArtNameInDescendingOrder(String artName) {
		return commodityArtworkDao.getCommodityArtworksByVagueArtNameInDescendingOrder(artName);
	}
	@Override
	public List<CommodityArtwork> getCommodityArtworksByVagueArtNameInAscendingOrder(String artName) {
		return commodityArtworkDao.getCommodityArtworksByVagueArtNameInAscendingOrder(artName);
	}
	@Override
	public List<CommodityArtwork> getAllCommodityArtworks() {
		return commodityArtworkDao.getAllCommodityArtworks();
	}
	@Override
	public List<CommodityArtwork> getCommodityArtworksByArtistId(long ownerId) {
		return commodityArtworkDao.getCommodityArtworksByArtistId(ownerId);
	}
	@Override
	public void insertCommodityArtwork(CommodityArtwork commodityArtwork) {
		commodityArtworkDao.insertCommodityArtwork(commodityArtwork);
	}
	@Override
	public CommodityArtwork getCommodityArtworkById(long commodityArtworkId) {
		return commodityArtworkDao.getCommodityArtworkById(commodityArtworkId);
	}
	@Override
	public void updateCommodityArtwork(CommodityArtwork commodityArtwork) {
		commodityArtworkDao.updateCommodityArtwork(commodityArtwork);
	}
	@Override
	public List<CommodityArtwork> getAllExhibitArtworks() {
		return commodityArtworkDao.getAllExhibitArtworks();
	}
}
