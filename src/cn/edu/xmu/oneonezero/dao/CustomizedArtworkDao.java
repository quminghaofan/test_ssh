package cn.edu.xmu.oneonezero.dao;

import java.util.List;

import cn.edu.xmu.oneonezero.entity.CommodityArtwork;
import cn.edu.xmu.oneonezero.entity.CustomizedArtwork;

/**
 * 订制品
 * @author DELL
 *
 */
public interface CustomizedArtworkDao {

	/**
	 * 获取所有定制艺术品
	 * @return List
	 */
	public List<CustomizedArtwork> getAllCustomizedArtworks();
	
	/**
	 * 根据艺术品类型id，模糊艺术品名称，页码，每页数量 分页获取定制艺术品 
	 * @param artworkTypeId 艺术品类型id
	 * @param artName 模糊艺术品名称
	 * @param start 页码
	 * @param num 每页数量
	 * @return List
	 */
	public List<CustomizedArtwork> getCustomizedArtworksByVagueArtworkNamePageNumber(Long artworkTypeId, String artName, int start,int num);

	/**
	 * 添加定制艺术品
	 * @param customizedArtwork 定制艺术品信息
	 */
	public void insertCustomizedArtwork(CustomizedArtwork customizedArtwork);
	
	/**
	 * 根据id获取定制艺术品
	 * @param customizedArtworkId 艺术品 id
	 * @return CustomizedArtwork
	 */
	public CustomizedArtwork getCustomizedArtworkById(long customizedArtworkId);

	/**
	 * 根据id设置定制艺术品isExist
	 * @param artworkId 艺术品 id
	 * @param isExist 
	 */
	public void setCustomizedArtworkIsExistByArtworkId(long artworkId, boolean isExist);
	
	/**
	 * 根据艺术品名称搜索
	 * @param name 艺术品名称
	 * @param typeId 艺术品类型id
	 * @return List
	 */
	public List<CustomizedArtwork> getByVagueArtworkName(String name, String typeId);
	
	/**
	 * 根据卖家用户名搜索
	 * @param name 卖家用户名
	 * @param typeId 艺术品类型id
	 * @return List
	 */
	public List<CustomizedArtwork> getByVagueOwnerName(String name, String typeId);

}
