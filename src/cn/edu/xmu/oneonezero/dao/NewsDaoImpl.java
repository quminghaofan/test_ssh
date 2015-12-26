package cn.edu.xmu.oneonezero.dao;



import java.util.Calendar;
import java.util.Date;
import java.util.List;


import org.hibernate.Query;
import org.hibernate.SessionFactory;

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
		sessionFactory.getCurrentSession().merge(news);
		sessionFactory.getCurrentSession().flush();
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
		
		
		sessionFactory.getCurrentSession().saveOrUpdate(news);
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
	public List<News> getNewsToday(Date today) {
		String hql = "from News n where n.newsType='资讯' and n.state='审核通过' and n.onShowTime<? and n.offShowTime>? order by n.rank desc";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setDate(0, today);
		query.setDate(1, today);
		
		return query.list();
	}

	@Override
	public List<News> getNewsByEditorIdAndTimespace(long editorId, String newsType, Date startTime, Date endTime,
			String newsName, String state) {
		if(newsName==null)
			newsName="";
		if(newsType==null||newsType.equals(""))
		{
			String hql = "from  News n where n.editor.id=? and n.onShowTime>? "
					+ "and n.offShowTime<? and n.name like ? and n.state = ?";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			query.setLong(0, editorId);
			
			if(startTime!=null)
				query.setDate(1, startTime);
			else
			{
				Calendar temCal=Calendar.getInstance();
				temCal.set(2000,1,1);
				
				Date temDate=(Date) temCal.getTime();
				query.setDate(1, temDate);
			}
			if(endTime!=null)
				query.setDate(2, endTime);
			else
			{
				Calendar temCal=Calendar.getInstance();
				temCal.set(2050,1,1);
				
				Date temDate=(Date) temCal.getTime();
				query.setDate(2, temDate);
			}
			query.setString(3, "%"+newsName+"%");
			query.setString(4, state);
			
			if(query.list()==null||query.list().size()==0) 
				return null;
			return query.list();
		}
		else
		{
			String hql = "from  News n where n.editor.id=? and n.newsType=? and n.onShowTime>? "
					+ "and n.offShowTime<? and n.name like ? and n.state = ?";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			query.setLong(0, editorId);
			query.setString(1, newsType);
			if(startTime!=null)
				query.setDate(2, startTime);
			else
			{
				Calendar temCal=Calendar.getInstance();
				temCal.set(2000,1,1);
				
				Date temDate=(Date) temCal.getTime();
				query.setDate(2, temDate);
			}
			if(endTime!=null)
				query.setDate(3, endTime);
			else
			{
				Calendar temCal=Calendar.getInstance();
				temCal.set(2050,1,1);
				
				Date temDate=(Date) temCal.getTime();
				query.setDate(3, temDate);
			}
			query.setString(4, "%"+newsName+"%");
			query.setString(5, state);
			
			if(query.list()==null||query.list().size()==0) 
				return null;
			return query.list();
		}
	}

	
	@Override
	public List<News> getExaminedNewsByTimespace(String newsType, Date startTime, Date endTime, String newsName) {
		if(newsName==null)
			newsName="";
		if(newsType==null||newsType.equals(""))
		{
			String hql = "from  News n where n.onShowTime>? "
					+ "and n.offShowTime<? and n.name like ? and (n.state = '审核通过' or n.state= '审核不通过')";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			if(startTime!=null)
				query.setDate(0, startTime);
			else
			{
				Calendar temCal=Calendar.getInstance();
				temCal.set(2000,1,1);
				
				Date temDate=(Date) temCal.getTime();
				query.setDate(0, temDate);
			}
			if(endTime!=null)
				query.setDate(1, endTime);
			else
			{
				Calendar temCal=Calendar.getInstance();
				temCal.set(2050,1,1);
				
				Date temDate=(Date) temCal.getTime();
				query.setDate(1, temDate);
			}
			query.setString(2, "%"+newsName+"%");
			
			if(query.list()==null||query.list().size()==0) 
				return null;
			return query.list();
		}
		else
		{
			String hql = "from  News n where n.newsType=? and n.onShowTime>? "
					+ "and n.offShowTime<? and n.name like ? and (n.state = '审核通过' or n.state= '审核不通过')";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			query.setString(0, newsType);
			if(startTime!=null)
				query.setDate(1, startTime);
			else
			{
				Calendar temCal=Calendar.getInstance();
				temCal.set(2000,1,1);
				
				Date temDate=(Date) temCal.getTime();
				query.setDate(1, temDate);
			}
			if(endTime!=null)
				query.setDate(2, endTime);
			else
			{
				Calendar temCal=Calendar.getInstance();
				temCal.set(2050,1,1);
				
				Date temDate=(Date) temCal.getTime();
				query.setDate(2, temDate);
			}
			query.setString(3, "%"+newsName+"%");
			
			if(query.list()==null||query.list().size()==0) 
				return null;
			return query.list();
		}
		
	}
	
	@Override
	public List<News> getUnexaminedNewsByTimespace(String newsType, Date startTime, Date endTime, String newsName) {
		if(newsName==null)
			newsName="";
		if(newsType==null||newsType.equals(""))
		{
			String hql = "from  News n where n.onShowTime>? "
					+ "and n.offShowTime<? and n.name like ? and n.state = '未审核' ";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			if(startTime!=null)
				query.setDate(0, startTime);
			else
			{
				Calendar temCal=Calendar.getInstance();
				temCal.set(2000,1,1);
				
				Date temDate=(Date) temCal.getTime();
				query.setDate(0, temDate);
			}
			if(endTime!=null)
				query.setDate(1, endTime);
			else
			{
				Calendar temCal=Calendar.getInstance();
				temCal.set(2050,1,1);
				
				Date temDate=(Date) temCal.getTime();
				query.setDate(1, temDate);
			}
			query.setString(2, "%"+newsName+"%");
			
			if(query.list()==null||query.list().size()==0) 
				return null;
			return query.list();
		}
		else
		{
			String hql = "from  News n where n.newsType=? and n.onShowTime>? "
					+ "and n.offShowTime<? and n.name like ? and n.state = '未审核' ";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			query.setString(0, newsType);
			if(startTime!=null)
				query.setDate(1, startTime);
			else
			{
				Calendar temCal=Calendar.getInstance();
				temCal.set(2000,1,1);
				
				Date temDate=(Date) temCal.getTime();
				query.setDate(1, temDate);
			}
			if(endTime!=null)
				query.setDate(2, endTime);
			else
			{
				Calendar temCal=Calendar.getInstance();
				temCal.set(2050,1,1);
				
				Date temDate=(Date) temCal.getTime();
				query.setDate(2, temDate);
			}
			query.setString(3, "%"+newsName+"%");
			
			if(query.list()==null||query.list().size()==0) 
				return null;
			return query.list();
		}
	}

	@Override
	public List<News> getAdvertisementToday(Date today) {
		String hql = "from News n where n.newsType='广告' and n.state='审核通过' and n.onShowTime<? and n.offShowTime>? order by n.rank desc";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setDate(0, today);
		query.setDate(1, today);
		
		return query.list();
	}

	
	//异常代码：

}
