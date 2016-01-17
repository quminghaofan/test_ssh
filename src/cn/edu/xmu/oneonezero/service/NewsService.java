package cn.edu.xmu.oneonezero.service;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.edu.xmu.oneonezero.entity.News;

@Transactional
public interface NewsService {  

//为view层提供直接调用的接口
	/**
	 * 根据id获取软文
	 * @param id 软文id
	 * @return News 软文
	 */
public News  getNews(long id);  
/**
 * 插入软文
 * @param news News 软文
 */
public void insertNews(News news);  
/**
 * 删除软文
 * @param id long 软文id
 * @return 删除成功返回1，失败返回0
 */
public boolean delNews(long id);  
/**
 * 更新软文
 * @param news 软文
 * @return 更新成功返回1，失败返回0
 */
public boolean updateNews(News news);
/**
 * 根据采编id得到所有的软文
 * @param editorId String 采编id
 * @return List<News> 软文列表
 */
public List<News> getNewsByEditor(String editorId);//根据采编id得到所有的软文
/**
 * 根据采编id得到所有已经审核的软文
 * @param editorId String 采编id
 * @return List<News> 软文列表
 */
public List<News> getExaminedNewsByEditor(String editorId);//根据采编id得到所有已经审核的软文
/**
 * 根据采编id得到所有未审核的软文
 * @param editorId String 采编id
 * @return List<News> 软文列表
 */
public List<News> getUnexaminedNewsByEditor(String editorId);//根据采编id得到所有未审核的软文


/**
 * 得到所有经过审核的软文
 * @return List<News> 软文列表
 */
public List<News> getExaminedNews();//得到所有经过审核的软文
/**
 * 得到所有未审核的软文
 * @return List<News> 软文列表
 */
public List<News> getUnexaminedNews();//得到所有未审核的软文
/**
 * 根据软文名字得到所有经过审核的软文
 * @param newsName String 软文名称
 * @return List<News> 软文列表
 */
public List<News> getExaminedNewsByVagueNewsName(String newsName);//根据软文名字得到所有经过审核的软文
/**
 * 根据软文名字得到所有未审核的软文
 * @param newsName String 软文名称
 * @return List<News> 软文列表
 */
public List<News> getUnexaminedNewsByVagueNewsName(String newsName);//根据软文名字得到所有未审核的软文
/**
 * 根据采编名字得到所有 未审核 的软文
 * @param editorName String 采编名
 * @return List<News> 软文列表
 */
public List<News> getUnexaminedNewsByEditorName(String editorName);//根据采编名字得到所有 未审核 的软文
/**
 * 根据采编名字得到所有 审核未通过 的软文
 * @param editorName String 采编名
 * @return List<News> 软文列表
 */
public List<News> getUnPassedNewsByEditorName(String editorName);//根据采编名字得到所有 审核未通过 的软文
/**
 * 根据采编名字得到所有 审核通过 的软文
 * @param editorName String 采编名
 * @return List<News> 软文列表
 */
public List<News> getPassedNewsByEditorName(String editorName);//根据采编名字得到所有 审核通过 的软文
/**
 * 根据软文名字得到所有 审核未通过 的软文
 * @param newsName String 软文名
 * @return List<News> 软文列表
 */
public List<News> getUnPassedNewsByVagueNewsName(String newsName);//根据软文名字得到所有 审核未通过 的软文
/**
 * 根据软文名字得到所有 审核通过 的软文
 * @param newsName String 软文名
 * @return List<News> 软文列表
 */
public List<News> getPassedNewsByVagueNewsName(String newsName);//根据软文名字得到所有 审核通过 的软文
/**
 * 根据采编名和软文模糊名返回相关的软文
 * @param editorName String 采编名
 * @param newsName String 软文名
 * @return List<News> 软文列表
 */
public List<News> getNewsVagueByEditorNameAndNewsName(String editorName,String newsName);//根据采编名和软文模糊名返回相关的软文

/**
 * 获取某个采编的所有草稿
 * @param editorName String 采编名
 * @return List<News> 软文列表
 */
public List<News> getDraftByEditorName(String editorName);//获取某个采编的所有草稿
/**
 * 模糊软文名字获取草稿
 * @param editorName String 采编名
 * @param newsName
 * @return List<News> 软文列表
 */
public List<News> getDraftByEditorNameAndVagueNewsName(String editorName,String newsName);//模糊软文名字获取草稿
/**
 * 模糊软文名字获取未审核
 * @param editorName String 采编名
 * @param newsName newsName String 软文名
 * @return List<News> 软文列表
 */
public List<News> getUnexaminedNewsByEditorNameAndVagueNewsName(String editorName,String newsName);//模糊软文名字获取未审核
/**
 * 模糊软文名字获取已通过
 * editorName String 采编名
 * @param newsName newsName String 软文名
 * @return List<News> 软文列表
 */
public List<News> getPassedNewsByEditorNameAndVagueNewsName(String editorName,String newsName);//模糊软文名字获取已通过
/**
 * 模糊软文名字获取未通过
 * editorName String 采编名
 * @param newsName newsName String 软文名
 * @return List<News> 软文列表
 */
public List<News> getUnpassedNewsByEditorNameAndVagueNewsName(String editorName,String newsName);//模糊软文名字获取未通过

/**
 * 根据软文id将其状态改为草稿状态
 * @param newsId long 软文id
 */
public void updateStateToDraft(long newsId);//根据软文id将其状态改为草稿状态
/**
 * 获取4个放在首页展示的软文
 * @param today Date 今天日期
 * @return List<News> 软文列表
 */
public List<News> getTopFourNews(Date today);//获取4个放在首页展示的软文

/**
 * 根据采编ID、模糊名称、审核状态（4种），查询startTime<上架时间&下架时间<endTime的新闻
 * @param editorId long 采编id
 * @param newsType String 软文类型
 * @param startTime Date 开始时间
 * @param endTime Date 结束时间
 * @param newsName String 软文名
 * @param state String 软文状态
 * @return List<News> 软文列表
 */
public List<News> getNewsByEditorIdAndTimespace(long editorId, String newsType, Date startTime, Date endTime,String newsName, String state);//根据采编ID、模糊名称、审核状态（4种），查询startTime<上架时间&下架时间<endTime的新闻
/**
 * 根据模糊名称、审核状态（2种 0已审核与1未审核），查询startTime<上架时间&下架时间<endTime的新闻
 * @param newsType String 软文类型
 * @param startTime Date 开始时间
 * @param endTime Date 结束时间
 * @param newsName String 软文名
 * @param state String 软文状态
 * @return List<News> 软文列表
 */
public List<News> getNewsByTimespace(String newsType, Date startTime, Date endTime,String newsName, String state);//根据模糊名称、审核状态（2种 0已审核与1未审核），查询startTime<上架时间&下架时间<endTime的新闻
/**
 * 获取放在首页展示的软文
 * @param today Date 今天日期
 * @return List<News> 软文列表
 */
public List<News> getNewsToday(Date today);//获取放在首页展示的软文
/**
 * 获取放在首页展示的广告
 * @param today Date 今天日期
 * @return List<News> 软文列表
 */
public List<News> getAdvertisementToday(Date today);//获取放在首页展示的广告



}  