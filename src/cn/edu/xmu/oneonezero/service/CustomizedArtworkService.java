package cn.edu.xmu.oneonezero.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.edu.xmu.oneonezero.entity.CustomizedArtwork;

@Transactional
public interface CustomizedArtworkService {
/**
 * 获取所有定制艺术品
 * @return List<CustomizedArtwork> 定制品列表
 */
	public List<CustomizedArtwork> getAllCustomizedArtworks();//获取所有定制艺术品
	/**
	 * 添加定制艺术品
	 * @param customizedArtwork 定制品
	 */
	public void insertCustomizedArtwork(CustomizedArtwork customizedArtwork);//添加定制艺术品
	/**
	 * 根据id获取定制艺术品
	 * @param customizedArtworkId long 定制品id
	 * @return 定制品
	 */
	public CustomizedArtwork getCustomizedArtworkById(long customizedArtworkId);//根据id获取定制艺术品

/**
 * 根据艺术品类型id，模糊艺术品名称，页码，每页数量 分页获取定制艺术品，返回list
 * @param artworkTypeId Long 艺术品类型id
 * @param artName String 艺术品名
 * @param start int
 * @param num int
 * @return List<CustomizedArtwork> 定制品订单列表
 */
	public List<CustomizedArtwork> getCustomizedArtworksByVagueArtworkNamePageNumber(Long artworkTypeId, String artName, int start,int num);//根据艺术品类型id，模糊艺术品名称，页码，每页数量 分页获取定制艺术品，返回list
/**
 * 根据id设置定制艺术品isExist
 * @param artworkId 艺术品id
 * @param isExist 是否存在，1表示存在，0表示不存在
 */
	public void setCustomizedArtworkIsExistByArtworkId(long artworkId, boolean isExist);//根据id设置定制艺术品isExist
	/**
	 * sign=0,表根据定制品名称搜索 sign=1，表根据卖家用户名搜索 typeId:艺术品类型id，为空值表示不做限制
	 * @param sign String
	 * @param name String
	 * @param typeId String
	 * @return 定制品列表
	 */
	public List<CustomizedArtwork> getByCustomizedArtworkNameOrOwnerId(String sign, String name, String typeId);//sign=0,表根据定制品名称搜索 sign=1，表根据卖家用户名搜索 typeId:艺术品类型id，为空值表示不做限制


}
