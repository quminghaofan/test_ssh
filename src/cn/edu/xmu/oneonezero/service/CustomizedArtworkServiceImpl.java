package cn.edu.xmu.oneonezero.service;

import java.util.List;

import cn.edu.xmu.oneonezero.dao.CustomizedArtworkDao;
import cn.edu.xmu.oneonezero.entity.CustomizedArtwork;

public class CustomizedArtworkServiceImpl implements CustomizedArtworkService{
	private CustomizedArtworkDao customizedArtworkDao;


	public void setCustomizedArtworkDao(CustomizedArtworkDao customizedArtworkDao) {
		this.customizedArtworkDao = customizedArtworkDao;
	}




	@Override
	public List<CustomizedArtwork> getAllCustomizedArtworks() {
		return customizedArtworkDao.getAllCustomizedArtworks();
	}




	@Override
	public List<CustomizedArtwork> getCustomizedArtworksByVagueArtworkNamePageNumber(Long artworkTypeId, String artName,
			int start, int num) {
		return customizedArtworkDao.getCustomizedArtworksByVagueArtworkNamePageNumber(artworkTypeId, artName, start, num);
	}




	@Override
	public void insertCustomizedArtwork(CustomizedArtwork customizedArtwork) {
		customizedArtworkDao.insertCustomizedArtwork(customizedArtwork);
		
	}




	@Override
	public CustomizedArtwork getCustomizedArtworkById(long customizedArtworkId) {
		return customizedArtworkDao.getCustomizedArtworkById(customizedArtworkId);
	}




	@Override
	public void setCustomizedArtworkIsExistByArtworkId(long artworkId, boolean isExist) {
		customizedArtworkDao.setCustomizedArtworkIsExistByArtworkId(artworkId, isExist);
	}




	@Override
	public List<CustomizedArtwork> getByCustomizedArtworkNameOrOwnerId(String sign, String name, String typeId) {
		if(sign.equals("0"))
			return customizedArtworkDao.getByVagueArtworkName(name, typeId);
		else
			return customizedArtworkDao.getByVagueOwnerName(name, typeId);
	}

}
