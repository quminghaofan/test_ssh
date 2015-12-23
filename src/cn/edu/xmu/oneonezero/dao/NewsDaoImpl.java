package cn.edu.xmu.oneonezero.dao;



import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import cn.edu.xmu.oneonezero.entity.News;


public class NewsDaoImpl implements NewsDao {

	private SessionFactory sessionFactory;//创建一个会话工厂实例


	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public News getNews(long id) {
		String hql = "from News n where n.id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setLong(0, id);
		
		return (News)query.list().get(0);
	}

	@Override
	public void insertNews(News news) {
		sessionFactory.getCurrentSession().save(news);
	}

	@Override
	public boolean delNews(long id) {
		String hql = "delete News n where n.id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setLong(0, id);
		
		return (query.executeUpdate() > 0);
	}

	@Override
	public boolean updateNews(News news) {
//		String hql = "update News n set n.chiefEditor= ?,n.editor=?,n.content=?,"
//				+ "n.offShowTime=?,n.onShowTime=?,n.picUrl=?,n.rank=?,n.state=?,n.name=? where n.id = ?";
//		query.setEntity(0, news.getChiefEditor());
//		query.setEntity(1, news.getEditor());//check
//		query.setString(2, news.getContent());
//		query.setString(3, news.getOffShowTime());
//		query.setString(4, news.getOnShowTime());
//		query.setString(5, news.getPicUrl());
//		query.setString(6, news.getRank());
//		query.setString(7, news.getState());
//		query.setString(8, news.getName());
//		query.setLong(9, news.getId());
		
		
		sessionFactory.getCurrentSession().saveOrUpdate(news);
//		sessionFactory.getCurrentSession().persist(news);
		sessionFactory.getCurrentSession().flush();
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<News> getNewsByEditor(String editor) {
		String hql = "from News n where n.editor.name=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, editor);
		
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<News> getUnexaminedNewsByEditor(String editor) {
		String hql = "from News n where n.editor.name=? and （n.state='审核通过' or n.state='审核不通过'） ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		query.setString(0, editor);
		
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<News> getExaminedNewsByEditor(String editor) {
		String hql = "from News n where n.editor.name=? and (n.state='审核通过' or n.state='审核不通过')";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		query.setString(0, editor);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<News> getExaminedNews() {
		String hql = "from News n where n.state='审核通过' or n.state='审核不通过'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<News> getUnexaminedNews() {
		String hql = "from News n where n.state='未审核' ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<News> getExaminedNewsByVagueNewsName(String newsName) {
		String hql = "from News n where n.name like ? and (n.state='审核通过' or n.state='审核不通过')";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		query.setString(0, "%"+newsName+"%");
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<News> getUnexaminedNewsByVagueNewsName(String newsName) {
		String hql = "from News n where n.name like ? and n.state='未审核'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		query.setString(0, "%"+newsName+"%");
		return query.list();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<News> getUnexaminedNewsByEditorName(String editorName) {
		String hql = "from News n where n.editor.name=? and n.state='未审核'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		query.setString(0, editorName);
		return query.list();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<News> getUnPassedNewsByEditorName(String editorName) {
		String hql = "from News n where n.editor.name=? and n.state='审核不通过'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		query.setString(0, editorName);
		return query.list();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<News> getPassedNewsByEditorName(String editorName) {
		String hql = "from News n where n.editor.name=? and n.state='审核通过'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		query.setString(0, editorName);
		return query.list();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<News> getUnPassedNewsByVagueNewsName(String newsName) {
		String hql = "from News n where n.name like ? and n.state='审核不通过'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		query.setString(0, "%"+newsName+"%");
		return query.list();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<News> getPassedNewsByVagueNewsName(String newsName) {
		String hql = "from News n where n.name like ? and n.state='审核通过'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		query.setString(0, "%"+newsName+"%");
		return query.list();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<News> getNewsVagueByEditorNameAndNewsName(String editorName, String newsName) {
		String hql="from News n where n.editor.name=? and n.name like ?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		
		query.setString(0, editorName);
		query.setString(1, "%"+newsName+"%");
		
		return query.list();
	
	}

	@Override
	public List<News> getDraftByEditorName(String editorName) {
		String hql="from News n where n.editor.name=? and n.state='草稿'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		
		query.setString(0, editorName);
		
		return query.list();
	}

	@Override
	public List<News> getDraftByEditorNameAndVagueNewsName(String editorName, String newsName) {
		String hql="from News n where n.editor.name=? and n.name like ? and n.state='草稿'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		
		query.setString(0, editorName);
		query.setString(1, "%"+newsName+"%");
		
		return query.list();
	}

	@Override
	public List<News> getUnexaminedNewsByEditorNameAndVagueNewsName(String editorName, String newsName) {
		String hql="from News n where n.editor.name=? and n.name like ? and n.state='未审核'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		
		query.setString(0, editorName);
		query.setString(1, "%"+newsName+"%");
		
		return query.list();
	}

	@Override
	public List<News> getPassedNewsByEditorNameAndVagueNewsName(String editorName, String newsName) {
		String hql="from News n where n.editor.name=? and n.name like ? and n.state='审核通过'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		
		query.setString(0, editorName);
		query.setString(1, "%"+newsName+"%");
		
		return query.list();
	}

	@Override
	public List<News> getUnpassedNewsByEditorNameAndVagueNewsName(String editorName, String newsName) {
		String hql="from News n where n.editor.name=? and n.name like ? and n.state='审核不通过'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		
		query.setString(0, editorName);
		query.setString(1, "%"+newsName+"%");
		
		return query.list();
	}

	@Override
	public void updateStateToDraft(long newsId) {
		String hql = "update News n set n.state= '草稿' where n.id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setLong(0, newsId);
		
		query.executeUpdate();

	}

	@Override
	public List<News> getTopFourNews(Date today) {
		String hql = "from News n where n.onShowTime<? and n.offShowTime>? and n.rank<=4 order by u.rank desc";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setDate(0, today);
		query.setDate(1, today);
		
		return query.list();
	}

	@Override
	public List<News> getNewsByUserIdAndTimespace(long userId, String newsType, Date startTime, Date endTime,
			String newsName, String state) {
		String hql = "from News n where n.id=? and n.newsType=? and n.onShowTime>? and n.offShowTime<? "
				+ "and n.name like ? and n.state=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setLong(0, userId);
		query.setString(1, newsType);
		query.setDate(2, startTime);//如果用户不输入，是否在view层就处理好（比如设定一个早一些的时间）
		query.setDate(3, endTime);
		query.setString(4, newsName);
		query.setString(5, state);
		if(query.list()==null||query.list().size()==0) 
			return null;
		return query.list();
	}

	@Override
	public List<News> getNewsByTimespace(String newsType, Date startTime, Date endTime, String newsName, String state) {
		String hql = "from News n where n.newsType=? and n.onShowTime>? and n.offShowTime<? "
				+ "and n.name like ? and n.state=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, newsType);
		query.setDate(1, startTime);
		query.setDate(2, endTime);
		query.setString(3, newsName);
		query.setString(4, state);
		if(query.list()==null||query.list().size()==0) 
			return null;
		return query.list();
	}

	
	//异常代码：

}
