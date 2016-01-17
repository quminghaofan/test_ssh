package cn.edu.xmu.oneonezero.service;

import java.util.List;

import cn.edu.xmu.oneonezero.entity.Artwork;

public interface ArtworkService {
	/**
	 * 根据艺术品类别获取艺术品
	 * @param type 种类
	 * @return 艺术品列表
	 */
	public List<Artwork> getArtworksByType(String type);//根据艺术品类别获取艺术品
/**
 * 根据艺术品类别、模糊艺术品名称分页获取艺术品
 * @param type 种类
 * @param artworkName 艺术品名称
 * @param start 首个艺术品序号
 * @param num 每页艺术品个数
 * @return 艺术品列表
 */
	public List<Artwork> getArtworksByTypeAndArtworkName(String type,String artworkName, int start, int num);//根据艺术品类别、模糊艺术品名称分页获取艺术品
	/**
	 * 根据作者id获取所有艺术品
	 * @param authorName 作者id
	 * @return 艺术品列表
	 */
	public List<Artwork> getArtworksByAuthorName(String authorName);//根据作者id获取所有艺术品
/**
 * 根据艺术品id获取艺术品
 * @param artworkId 艺术品id
 * @return 艺术品
 */
	public Artwork getArtworkByArtworkId(long artworkId);//根据艺术品id获取艺术品
	
/**
 * 根据artworkId更改artwork状态
 * @param artworkId 艺术品id
 * @param state 状态
 */
	public void setArtworkState(long artworkId,boolean state);//根据artworkId更改artwork状态

	
}
