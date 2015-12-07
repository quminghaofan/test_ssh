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
				+ "n.offShowTime=?,n.onShowTime=?,n.picUrl=?,n.rank=?,n.state=?,n.name=? where n.id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, news.getChiefEditor());
		query.setEntity(1, news.getEditor());//check
		query.setString(2, news.getContent());
		query.setString(3, news.getOffShowTime());
		query.setString(4, news.getOnShowTime());
		query.setString(5, news.getPicUrl());
		query.setString(6, news.getRank());
		query.setString(7, news.getState());
		query.setString(8, news.getName());
		query.setLong(9, news.getId());
		
		return (query.executeUpdate() > 0);
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
		String hql = "from News n where n.editor.name=? and n.state='Unexamined' ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		query.setString(0, editor);
		
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<News> getExaminedNewsByEditor(String editor) {
		String hql = "from News n where n.editor.name=? and (n.state='Passed' or n.state='Unpassed')";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		query.setString(0, editor);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<News> getExaminedNews() {
		String hql = "from News n where n.state='Unexamined'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<News> getUnexaminedNews() {
		String hql = "from News n where n.state='Unexamined' ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<News> getExaminedNewsByName(String newsName) {
		String hql = "from News n where n.name=? and (n.state='Passed' or n.state='Unpassed')";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		query.setString(0, newsName);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<News> getUnexaminedNewsByName(String newsName) {
		String hql = "from News n where n.name=? and n.state='Unexamined'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		query.setString(0, newsName);
		return query.list();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<News> getUnexaminedNewsByEditorName(String editorName) {
		String hql = "from News n where n.editor.name=? and n.state='Unexamined'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		query.setString(0, editorName);
		return query.list();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<News> getUnPassedNewsByEditorName(String editorName) {
		String hql = "from News n where n.editor.name=? and n.state='Unpassed'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		query.setString(0, editorName);
		return query.list();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<News> getPassedNewsByEditorName(String editorName) {
		String hql = "from News n where n.editor.name=? and n.state='Passed'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		query.setString(0, editorName);
		return query.list();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<News> getUnPassedNewsByNewsName(String newsName) {
		String hql = "from News n where n.name=? and n.state='Unpassed'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		query.setString(0, newsName);
		return query.list();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<News> getPassedNewsByNewsName(String newsName) {
		String hql = "from News n where n.editor=? and n.state='Passed'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		query.setString(0, newsName);
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
		String hql="from News n where n.editor.name=? and n.state='Draft'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		
		query.setString(0, editorName);
		
		return query.list();
	}

	@Override
	public List<News> getDraftByEditorNameAndNewsName(String editorName, String newsName) {
		String hql="from News n where n.editor.name=? and n.name=? and n.state='Draft'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		
		query.setString(0, editorName);
		query.setString(1, newsName);
		
		return query.list();
	}

	@Override
	public List<News> getUnexaminedNewsByEditorNameAndNewsName(String editorName, String newsName) {
		String hql="from News n where n.editor.name=? and n.name=? and n.state='Unexamined'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		
		query.setString(0, editorName);
		query.setString(1, newsName);
		
		return query.list();
	}

	@Override
	public List<News> getPassedNewsByEditorNameAndNewsName(String editorName, String newsName) {
		String hql="from News n where n.editor.name=? and n.name=? and n.state='Passed'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		
		query.setString(0, editorName);
		query.setString(1, newsName);
		
		return query.list();
	}

	@Override
	public List<News> getUnpassedNewsByEditorNameAndNewsName(String editorName, String newsName) {
		String hql="from News n where n.editor.name=? and n.name=? and n.state='Unpassed'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		
		query.setString(0, editorName);
		query.setString(1, newsName);
		
		return query.list();
	}
	
	//异常代码：
	


	
	

}
