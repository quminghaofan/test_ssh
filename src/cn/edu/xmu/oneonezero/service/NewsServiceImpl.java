package cn.edu.xmu.oneonezero.service;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.edu.xmu.oneonezero.dao.NewsDao;
import cn.edu.xmu.oneonezero.entity.News;

@Transactional
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
	public List<News> getExaminedNewsByVagueNewsName(String newsName) {
		return newsDao.getExaminedNewsByVagueNewsName(newsName);
	}


	@Override
	public List<News> getUnexaminedNewsByVagueNewsName(String newsName) {
		return newsDao.getUnexaminedNewsByVagueNewsName(newsName);
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
	public List<News> getUnPassedNewsByVagueNewsName(String newsName) {
		return newsDao.getUnPassedNewsByVagueNewsName(newsName);
	}


	@Override
	public List<News> getPassedNewsByVagueNewsName(String newsName) {
		return newsDao.getPassedNewsByVagueNewsName(newsName);
	}


	@Override
	public List<News> getNewsVagueByEditorNameAndNewsName(String editorName, String newsName) {
		return newsDao.getNewsVagueByEditorNameAndNewsName(editorName, newsName);
	}


	@Override
	public List<News> getDraftByEditorName(String editorName) {
		return newsDao.getDraftByEditorName(editorName);
	}


	@Override
	public List<News> getDraftByEditorNameAndVagueNewsName(String editorName, String newsName) {
		return newsDao.getDraftByEditorNameAndVagueNewsName(editorName, newsName);
	}


	@Override
	public List<News> getUnexaminedNewsByEditorNameAndVagueNewsName(String editorName, String newsName) {
		return newsDao.getUnexaminedNewsByEditorNameAndVagueNewsName(editorName, newsName);
	}


	@Override
	public List<News> getPassedNewsByEditorNameAndVagueNewsName(String editorName, String newsName) {
		return newsDao.getPassedNewsByEditorNameAndVagueNewsName(editorName, newsName);
	}


	@Override
	public List<News> getUnpassedNewsByEditorNameAndVagueNewsName(String editorName, String newsName) {
		return newsDao.getUnpassedNewsByEditorNameAndVagueNewsName(editorName, newsName);
	}


	@Override
	public void updateStateToDraft(long newsId) {
		newsDao.updateStateToDraft(newsId);
	}




	@Override
	public List<News> getNewsByEditorIdAndTimespace(long editorId, String newsType, Date startTime, Date endTime,
			String newsName, String state) {
		return newsDao.getNewsByEditorIdAndTimespace(editorId, newsType, startTime, endTime, newsName, state);
	
	}




	@Override
	public List<News> getTopFourNews(Date today) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<News> getNewsToday(Date today) {
		return newsDao.getNewsToday(today);
	}


	@Override
	public List<News> getAdvertisementToday(Date today) {
		return newsDao.getAdvertisementToday(today);
	}


	@Override
	public List<News> getNewsByTimespace(String newsType, Date startTime, Date endTime, String newsName, String state) {
		if(state.equals("1"))
			return newsDao.getUnexaminedNewsByTimespace(newsType, startTime, endTime, newsName);
		else
			return newsDao.getExaminedNewsByTimespace(newsType, startTime, endTime, newsName);
	}
	


}
