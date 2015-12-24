package cn.edu.xmu.oneonezero.dao;

import java.util.List;

import cn.edu.xmu.oneonezero.entity.CustomizedArtwork;

public interface CustomizedArtworkDao {

	public List<CustomizedArtwork> getAllCustomizedArtworks();//获取所有定制艺术品
	
	public List<CustomizedArtwork> getCustomizedArtworksByVagueArtworkNamePageNumber(Long artworkTypeId, String artName, int start,int num);//根据艺术品类型id，模糊艺术品名称，页码，每页数量 分页获取定制艺术品，返回list

	public void insertCustomizedArtwork(CustomizedArtwork customizedArtwork);//添加定制艺术品

	

}
