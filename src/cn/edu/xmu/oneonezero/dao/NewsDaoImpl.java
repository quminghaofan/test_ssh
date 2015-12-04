package cn.edu.xmu.oneonezero.dao;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import cn.edu.xmu.oneonezero.entity.News;


public class NewsDaoImpl implements NewsDao {

	private SessionFactory sessionFactory;//创建一个会话工厂实例

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public News getNews(long id) {
		String hql = "from News n where n.id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setLong(0, id);
		
		return (News)query.uniqueResult();
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
		String hql = "update News n set n.chiefEditor= ?,n.editor=?,n.content=?,"
				+ "n.offShowTime=?,n.onShowTime=?,n.picUrl=?,n.rank=?,n.isExamined=?,n.isPassed=? where n.id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, news.getChiefEditor());
		query.setString(1, news.getEditor());
		query.setString(2, news.getContent());
		query.setString(3, news.getOffShowTime());
		query.setString(4, news.getOnShowTime());
		query.setString(5, news.getPicUrl());
		query.setString(6, news.getRank());
		query.setBoolean(7, news.getIsExamined());
		query.setBoolean(8, news.getIsPassed());
		query.setLong(9, news.getId());
		
		return (query.executeUpdate() > 0);
	}

	@Override
	public List<News> getNewsByEditor(String editor) {
		String hql = "from News";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		ArrayList<News> alist=new ArrayList<News>();
		for(int i=0; i<query.list().size(); i++)
		{
			if(((News)query.list().get(i)).getEditor()==editor)
				alist.add((News)query.list().get(i));
		}
		
		return alist;
	}

	@Override
	public List<News> getUnexaminedNewsByEditor(String editor) {
		String hql = "from News";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		ArrayList<News> alist=new ArrayList<News>();
		for(int i=0; i<query.list().size(); i++)
		{
			if(((News)query.list().get(i)).getEditor()==editor)
			{
				if(!((News)query.list().get(i)).getIsExamined())
					alist.add((News)query.list().get(i));
			}
		}
		
		return alist;
	}

	@Override
	public List<News> getExaminedNewsByEditor(String editor) {
		String hql = "from News";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		ArrayList<News> alist=new ArrayList<News>();
		for(int i=0; i<query.list().size(); i++)
		{
			if(((News)query.list().get(i)).getEditor()==editor)
			{
				if(((News)query.list().get(i)).getIsExamined())
					alist.add((News)query.list().get(i));
			}
		}
		
		return alist;
	}

	@Override
	public List<News> getExaminedNews() {
		String hql = "from News";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		ArrayList<News> alist=new ArrayList<News>();
		for(int i=0; i<query.list().size(); i++)
		{
			if(((News)query.list().get(i)).getIsExamined())
			{
					alist.add((News)query.list().get(i));
			}
		}
		
		return alist;
	}

	@Override
	public List<News> getUnexaminedNews() {
		String hql = "from News";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		ArrayList<News> alist=new ArrayList<News>();
		for(int i=0; i<query.list().size(); i++)
		{
			if(!(((News)query.list().get(i)).getIsExamined()))
			{
					alist.add((News)query.list().get(i));
			}
		}
		
		return alist;
	}

	@Override
	public List<News> getExaminedNewsByName(String newsName) {
		String hql = "from News";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		ArrayList<News> alist=new ArrayList<News>();
		for(int i=0; i<query.list().size(); i++)
		{
			if((((News)query.list().get(i)).getName()==newsName)&&((News)query.list().get(i)).getIsExamined())
			{
					alist.add((News)query.list().get(i));
			}
		}
		
		return alist;
	}

	@Override
	public List<News> getUnexaminedNewsByName(String newsName) {
		String hql = "from News";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		ArrayList<News> alist=new ArrayList<News>();
		for(int i=0; i<query.list().size(); i++)
		{
			if((((News)query.list().get(i)).getName()==newsName)&&!(((News)query.list().get(i)).getIsExamined()))
			{
					alist.add((News)query.list().get(i));
			}
		}
		
		return alist;
	}

	@Override
	public List<News> getUnexaminedNewsByEditorName(String editorName) {
		String hql = "from News";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		ArrayList<News> alist=new ArrayList<News>();
		for(int i=0; i<query.list().size(); i++)
		{
			if((((News)query.list().get(i)).getEditor()==editorName)&&!(((News)query.list().get(i)).getIsExamined()))
			{
					alist.add((News)query.list().get(i));
			}
		}
		
		return alist;
	}

	@Override
	public List<News> getUnPassedNewsByEditorName(String editorName) {
		String hql = "from News";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		ArrayList<News> alist=new ArrayList<News>();
		for(int i=0; i<query.list().size(); i++)
		{
			if((((News)query.list().get(i)).getEditor()==editorName)&&((News)query.list().get(i)).getIsExamined()&&!(((News)query.list().get(i)).getIsPassed()))
			{
					alist.add((News)query.list().get(i));
			}
		}
		
		return alist;
	}

	@Override
	public List<News> getPassedNewsByEditorName(String editorName) {
		String hql = "from News";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		ArrayList<News> alist=new ArrayList<News>();
		for(int i=0; i<query.list().size(); i++)
		{
			if((((News)query.list().get(i)).getEditor()==editorName)&&((News)query.list().get(i)).getIsExamined()&&(((News)query.list().get(i)).getIsPassed()))
			{
					alist.add((News)query.list().get(i));
			}
		}
		
		return alist;
	}

	@Override
	public List<News> getUnPassedNewsByNewsName(String newsName) {
		String hql = "from News";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		ArrayList<News> alist=new ArrayList<News>();
		for(int i=0; i<query.list().size(); i++)
		{
			if((((News)query.list().get(i)).getName()==newsName)&&((News)query.list().get(i)).getIsExamined()&&(!((News)query.list().get(i)).getIsPassed()))
			{
					alist.add((News)query.list().get(i));
			}
		}
		
		return alist;
	}

	@Override
	public List<News> getPassedNewsByNewsName(String newsName) {
		String hql = "from News";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		ArrayList<News> alist=new ArrayList<News>();
		for(int i=0; i<query.list().size(); i++)
		{
			if((((News)query.list().get(i)).getName()==newsName)&&((News)query.list().get(i)).getIsExamined()&&(((News)query.list().get(i)).getIsPassed()))
			{
					alist.add((News)query.list().get(i));
			}
		}
		
		return alist;
	}
	
	
	


	
	

}
