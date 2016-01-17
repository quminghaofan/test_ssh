package cn.edu.xmu.oneonezero.dao;

import java.util.Date;
import java.util.List;

import cn.edu.xmu.oneonezero.entity.News;

/**
 * 软文
 * 
 * @author DELL
 * 
 */
public interface NewsDao {

	/**
	 * 根据软文ID得到对象
	 * @param id 软文ID
	 * @return News
	 */
	public News getNews(long id); 

	/**
	 * 添加到数据库
	 * @param rr 软文信息
	 */
	public void insertNews(News rr); 

	/**
	 * 根据id删除对象
	 * @param id 
	 * @return boolean
	 */
	public boolean delNews(long id); 

	/**
	 * 更新 
	 * @param rr 软文信息
	 * @return boolean
	 */
	public boolean updateNews(News rr); 

	/**
	 * 根据采编用户名获取所有软文
	 * @param editor 采编用户名
	 * @return List
	 */
	public List<News> getNewsByEditor(String editor);

	/**
	 * 根据采编用户名获取已审核的软文
	 * @param editor 采编用户名
	 * @return List
	 */
	public List<News> getUnexaminedNewsByEditor(String editor);

	/**
	 * 
	 * @param editor
	 * @return
	 */
	public List<News> getExaminedNewsByEditor(String editor);

	/**
	 * 根据采编名和软文模糊名返回相关的软文
	 * @param editorName 采编用户名
	 * @param newsName 软文模糊名
	 * @return List
	 */
	public List<News> getNewsVagueByEditorNameAndNewsName(String editorName,
			String newsName);

	/**
	 * 得到所有经过审核的软文
	 * @return List
	 */
	public List<News> getExaminedNews(); 

	/**
	 * 得到所有未审核的软文
	 * @return List
	 */
	public List<News> getUnexaminedNews(); 

	/**
	 * 根据软文名字得到所有经过审核的软文
	 * @param newsName 软文名字
	 * @return List
	 */
	public List<News> getExaminedNewsByVagueNewsName(String newsName); 

	/**
	 * 根据软文名字得到所有未审核的软文
	 * @param newsName 软文名字
	 * @return List
	 */
	public List<News> getUnexaminedNewsByVagueNewsName(String newsName); 

	/**
	 * 根据采编用户名得到所有未审核的软文
	 * @param editorName 采编用户名
	 * @return List
	 */
	public List<News> getUnexaminedNewsByEditorName(String editorName); 

	/**
	 * 根据采编用户名得到所有审核未通过的软文
	 * @param editorName 采编用户名
	 * @return List
	 */
	public List<News> getUnPassedNewsByEditorName(String editorName); 

	/**
	 * 根据采编用户名得到所有审核通过 的软文
	 * @param editorName 采编用户名
	 * @return List
	 */
	public List<News> getPassedNewsByEditorName(String editorName); 

	/**
	 * 根据模糊软文名字得到所有审核未通过的软文
	 * @param newsName 模糊软文名字
	 * @return List
	 */
	public List<News> getUnPassedNewsByVagueNewsName(String newsName); 

	/**
	 * 根据模糊软文名字得到所有审核通过 的软文
	 * @param newsName 模糊软文名字
	 * @return List
	 */
	public List<News> getPassedNewsByVagueNewsName(String newsName); 

	/**
	 * 获取某个采编的所有草稿
	 * @param editorName 采编用户名
	 * @return List
	 */
	public List<News> getDraftByEditorName(String editorName); 

	/**
	 * 根据采编用户名、模糊软文名字获取草稿
	 * @param editorName 采编用户名
	 * @param newsName 模糊软文名字
	 * @return List
	 */
	public List<News> getDraftByEditorNameAndVagueNewsName(String editorName,
			String newsName); 

	/**
	 * 根据采编用户名、模糊软文名字获取未审核
	 * @param editorName 采编用户名
	 * @param newsName 模糊软文名字
	 * @return List
	 */
	public List<News> getUnexaminedNewsByEditorNameAndVagueNewsName(
			String editorName, String newsName); 

	/**
	 * 根据采编用户名、模糊软文名字获取已通过
	 * @param editorName 采编用户名
	 * @param newsName 模糊软文名字
	 * @return List
	 */
	public List<News> getPassedNewsByEditorNameAndVagueNewsName(
			String editorName, String newsName); 

	/**
	 * 根据采编用户名、模糊软文名字获取未通过软文
	 * @param editorName 采编用户名
	 * @param newsName 模糊软文名字
	 * @return List
	 */
	public List<News> getUnpassedNewsByEditorNameAndVagueNewsName(
			String editorName, String newsName); 

	/**
	 * 根据软文id将其状态改为草稿状态
	 * @param newsId 软文id
	 */
	public void updateStateToDraft(long newsId); 

	/**
	 * 根据采编ID、模糊名称、审核状态，查询startTime<上架时间&下架时间<endTime的软文
	 * @param editorId 采编ID
	 * @param newsType 软文类型
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @param newsName 模糊名称
	 * @param state 审核状态
	 * @return List
	 */
	public List<News> getNewsByEditorIdAndTimespace(long editorId,
			String newsType, Date startTime, Date endTime, String newsName,
			String state); 

	/**
	 * 根据模糊名称、审核状态（已审核），查询startTime<上架时间&下架时间<endTime的新闻
	 * @param newsType 审核状态（已审核）
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @param newsName 模糊名称
	 * @return List
	 */
	public List<News> getExaminedNewsByTimespace(String newsType,
			Date startTime, Date endTime, String newsName); 

	/**
	 * 根据模糊名称、审核状态（未审核），查询startTime<上架时间&下架时间<endTime的新闻
	 * @param newsType 审核状态（未审核）
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @param newsName 模糊名称
	 * @return List
	 */
	public List<News> getUnexaminedNewsByTimespace(String newsType,
			Date startTime, Date endTime, String newsName); 

	/**
	 * 获取放在首页展示的新闻
	 * @param today 现在时间
	 * @return List
	 */
	public List<News> getNewsToday(Date today); 

	/**
	 * 获取放在首页展示的广告
	 * @param today 现在时间
	 * @return List
	 */
	public List<News> getAdvertisementToday(Date today); 

}