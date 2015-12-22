package cn.edu.xmu.oneonezero.dao;

import java.util.List;

import cn.edu.xmu.oneonezero.entity.CustomizedArtwork;

public interface CustomizedArtworkDao {
	public List<CustomizedArtwork> getAllFinishedCustomizedArtworks();//获取所有定制艺术品成品

	public List<CustomizedArtwork> getAllCustomizedArtworks();//获取所有定制艺术品

}
