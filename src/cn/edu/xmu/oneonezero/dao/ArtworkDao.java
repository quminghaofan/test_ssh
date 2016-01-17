package cn.edu.xmu.oneonezero.dao;

import java.util.List;

import cn.edu.xmu.oneonezero.entity.Artwork;

/**
 * 艺术品基类
 * @author DELL
 *
 */
public interface ArtworkDao {
	/**
	 * 根据艺术品类别获取艺术品
	 * @param type 艺术品类别
	 * @return List
	 */
	public List<Artwork> getArtworksByType(String type);

	/**
	 * 根据艺术品类别、模糊艺术品名称分页获取艺术品
	 * @param type 艺术品类别
	 * @param artworkName 艺术品名称
	 * @param start 开始位置
	 * @param num 获取数量
	 * @return List
	 */
	public List<Artwork> getArtworksByTypeAndArtworkName(String type,String artworkName, int start, int num);
	
	/**
	 * 根据作者名称获取所有艺术品
	 * @param authorName 作者名称
	 * @return List
	 */
	public List<Artwork> getArtworksByAuthorName(String authorName);
	
	/**
	 * 根据艺术品id获取艺术品
	 * @param artworkId 艺术品id
	 * @return Artwork
	 */
	public Artwork getArtworkByArtworkId(long artworkId);//
	
	/**
	 * 根据artworkId更改artwork状态
	 * @param artworkId 艺术品id
	 * @param state 状态
	 */
	public void setArtworkState(long artworkId,boolean state);


}
