package cn.edu.xmu.oneonezero.service;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.edu.xmu.oneonezero.entity.News;

@Transactional
public interface NewsService {  

//为view层提供直接调用的接口
public News  getNews(long id);  

public void insertNews(News news);  

public boolean delNews(long id);  

public boolean updateNews(News news);

public List<News> getNewsByEditor(String editorId);//根据采编id得到所有的软文

public List<News> getExaminedNewsByEditor(String editorId);//根据采编id得到所有已经审核的软文

public List<News> getUnexaminedNewsByEditor(String editorId);//根据采编id得到所有未审核的软文



public List<News> getExaminedNews();//得到所有经过审核的软文

public List<News> getUnexaminedNews();//得到所有未审核的软文

public List<News> getExaminedNewsByVagueNewsName(String newsName);//根据软文名字得到所有经过审核的软文

public List<News> getUnexaminedNewsByVagueNewsName(String newsName);//根据软文名字得到所有未审核的软文

public List<News> getUnexaminedNewsByEditorName(String editorName);//根据采编名字得到所有 未审核 的软文

public List<News> getUnPassedNewsByEditorName(String editorName);//根据采编名字得到所有 审核未通过 的软文

public List<News> getPassedNewsByEditorName(String editorName);//根据采编名字得到所有 审核通过 的软文

public List<News> getUnPassedNewsByVagueNewsName(String newsName);//根据软文名字得到所有 审核未通过 的软文

public List<News> getPassedNewsByVagueNewsName(String newsName);//根据软文名字得到所有 审核通过 的软文

public List<News> getNewsVagueByEditorNameAndNewsName(String editorName,String newsName);//根据采编名和软文模糊名返回相关的软文


public List<News> getDraftByEditorName(String editorName);//获取某个采编的所有草稿

public List<News> getDraftByEditorNameAndVagueNewsName(String editorName,String newsName);//模糊软文名字获取草稿

public List<News> getUnexaminedNewsByEditorNameAndVagueNewsName(String editorName,String newsName);//模糊软文名字获取未审核

public List<News> getPassedNewsByEditorNameAndVagueNewsName(String editorName,String newsName);//模糊软文名字获取已通过

public List<News> getUnpassedNewsByEditorNameAndVagueNewsName(String editorName,String newsName);//模糊软文名字获取未通过


public void updateStateToDraft(long newsId);//根据软文id将其状态改为草稿状态

public List<News> getTopFourNews(Date today);//获取4个放在首页展示的软文


public List<News> getNewsByUserIdAndTimespace(long userId, String newsType, Date startTime, Date endTime,String newsName, String state);//根据userID、模糊名称、审核状态，查询startTime<上架时间&下架时间<endTime的新闻

public List<News> getNewsByTimespace(String newsType, Date startTime, Date endTime,String newsName, String state);//根据模糊名称、审核状态，查询startTime<上架时间&下架时间<endTime的新闻



}  