package cn.edu.xmu.oneonezero.service;

import java.util.List;

import cn.edu.xmu.oneonezero.entity.Artwork;

public interface ArtworkService {
	public List<Artwork> getArtworksByType(String type);//根据艺术品类别获取艺术品

	public List<Artwork> getArtworksByTypeAndArtworkName(String type,String artworkName, int start, int num);//根据艺术品类别、模糊艺术品名称分页获取艺术品
	
}
