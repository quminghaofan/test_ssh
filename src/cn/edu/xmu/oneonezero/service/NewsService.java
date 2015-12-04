package cn.edu.xmu.oneonezero.service;

import java.util.List;

import cn.edu.xmu.oneonezero.entity.News;

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

public List<News> getExaminedNewsByName(String newsName);//根据软文名字得到所有经过审核的软文

public List<News> getUnexaminedNewsByName(String newsName);//根据软文名字得到所有未审核的软文

public List<News> getUnexaminedNewsByEditorName(String editorName);//根据采编名字得到所有 未审核 的软文

public List<News> getUnPassedNewsByEditorName(String editorName);//根据采编名字得到所有 审核未通过 的软文

public List<News> getPassedNewsByEditorName(String editorName);//根据采编名字得到所有 审核通过 的软文

public List<News> getUnPassedNewsByNewsName(String newsName);//根据软文名字得到所有 审核未通过 的软文

public List<News> getPassedNewsByNewsName(String newsName);//根据软文名字得到所有 审核通过 的软文












}  