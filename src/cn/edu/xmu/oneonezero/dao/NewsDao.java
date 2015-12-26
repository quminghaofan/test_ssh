package cn.edu.xmu.oneonezero.dao;

import java.util.Date;
import java.util.List;

import cn.edu.xmu.oneonezero.entity.News;

public interface NewsDao {


public News getNews(long id);  //根据软文ID得到对象

public void insertNews(News rr);  //添加到数据库

public boolean delNews(long id);	//根据id删除对象

public boolean updateNews(News rr);	//更新

public List<News> getNewsByEditor(String editor);

public List<News> getUnexaminedNewsByEditor(String editor);//未审核

public List<News> getExaminedNewsByEditor(String editor);//已经审核

public List<News> getNewsVagueByEditorNameAndNewsName(String editorName,String newsName);//根据采编名和软文模糊名返回相关的软文

public List<News> getExaminedNews();//得到所有经过审核的软文

public List<News> getUnexaminedNews();//得到所有未审核的软文

public List<News> getExaminedNewsByVagueNewsName(String newsName);//根据软文名字得到所有经过审核的软文

public List<News> getUnexaminedNewsByVagueNewsName(String newsName);//根据软文名字得到所有未审核的软文

public List<News> getUnexaminedNewsByEditorName(String editorName);//根据采编名字得到所有 未审核 的软文

public List<News> getUnPassedNewsByEditorName(String editorName);//根据采编名字得到所有 审核未通过 的软文

public List<News> getPassedNewsByEditorName(String editorName);//根据采编名字得到所有 审核通过 的软文

public List<News> getUnPassedNewsByVagueNewsName(String newsName);//根据模糊软文名字得到所有 审核未通过 的软文

public List<News> getPassedNewsByVagueNewsName(String newsName);//根据模糊软文名字得到所有 审核通过 的软文

public List<News> getDraftByEditorName(String editorName);//获取某个采编的所有草稿

public List<News> getDraftByEditorNameAndVagueNewsName(String editorName,String newsName);//模糊软文名字获取草稿

public List<News> getUnexaminedNewsByEditorNameAndVagueNewsName(String editorName,String newsName);//模糊软文名字获取未审核

public List<News> getPassedNewsByEditorNameAndVagueNewsName(String editorName,String newsName);//模糊软文名字获取已通过

public List<News> getUnpassedNewsByEditorNameAndVagueNewsName(String editorName,String newsName);//模糊软文名字获取未通过

public void updateStateToDraft(long newsId);//根据软文id将其状态改为草稿状态



public List<News> getNewsByEditorIdAndTimespace(long editorId, String newsType, Date startTime, Date endTime,String newsName,String state);//根据采编ID、模糊名称、审核状态，查询startTime<上架时间&下架时间<endTime的新闻

public List<News> getExaminedNewsByTimespace(String newsType, Date startTime, Date endTime,String newsName);//根据模糊名称、审核状态（已审核），查询startTime<上架时间&下架时间<endTime的新闻

public List<News> getUnexaminedNewsByTimespace(String newsType, Date startTime, Date endTime,String newsName);//根据模糊名称、审核状态（未审核），查询startTime<上架时间&下架时间<endTime的新闻

public List<News> getNewsToday(Date today);//获取放在首页展示的软文

public List<News> getAdvertisementToday(Date today);//获取放在首页展示的广告





}