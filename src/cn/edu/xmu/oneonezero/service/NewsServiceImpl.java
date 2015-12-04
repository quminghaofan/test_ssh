package cn.edu.xmu.oneonezero.service;

import java.util.List;

import cn.edu.xmu.oneonezero.dao.NewsDao;
import cn.edu.xmu.oneonezero.entity.News;

public class NewsServiceImpl implements NewsService {

	private NewsDao newsDao; //创建一个UserDao实例

	public void setNewsDao(NewsDao newsDao) {  
	    this.newsDao=newsDao;
	}
	

	@Override
	public boolean delNews(long id) {
		return newsDao.delNews(id);
	}


	@Override
	public News getNews(long id) 
	{
		return newsDao.getNews(id);
	}

	@Override
	public void insertNews(News news)
	{
		newsDao.insertNews(news);
	}
	

	@Override
	public boolean updateNews(News news) {
		return newsDao.updateNews(news);
	}


	@Override
	public List<News> getNewsByEditor(String editor) {
		return newsDao.getNewsByEditor(editor);
	}


	@Override
	public List<News> getExaminedNewsByEditor(String editor) {
		return newsDao.getExaminedNewsByEditor(editor);
	}



	@Override
	public List<News> getUnexaminedNewsByEditor(String editor) {
		return newsDao.getUnexaminedNewsByEditor(editor);
	}


	@Override
	public List<News> getExaminedNews() {
		return newsDao.getExaminedNews();
	}


	@Override
	public List<News> getUnexaminedNews() {
		return newsDao.getUnexaminedNews();
	}


	@Override
	public List<News> getExaminedNewsByName(String newsName) {
		return newsDao.getExaminedNewsByName(newsName);
	}


	@Override
	public List<News> getUnexaminedNewsByName(String newsName) {
		return newsDao.getUnexaminedNewsByName(newsName);
	}


	@Override
	public List<News> getUnexaminedNewsByEditorName(String editorName) {
		return newsDao.getUnexaminedNewsByEditorName(editorName);
	}


	@Override
	public List<News> getUnPassedNewsByEditorName(String editorName) {
		return newsDao.getUnPassedNewsByEditorName(editorName);
	}


	@Override
	public List<News> getPassedNewsByEditorName(String editorName) {
		return newsDao.getPassedNewsByEditorName(editorName);
	}


	@Override
	public List<News> getUnPassedNewsByNewsName(String newsName) {
		return newsDao.getUnPassedNewsByNewsName(newsName);
	}


	@Override
	public List<News> getPassedNewsByNewsName(String newsName) {
		return newsDao.getPassedNewsByNewsName(newsName);
	}


	@Override
	public List<News> getNewsVagueByEditorNameAndNewsName(String editorName, String newsName) {
		return newsDao.getNewsVagueByEditorNameAndNewsName(editorName, newsName);
	}
	
}
