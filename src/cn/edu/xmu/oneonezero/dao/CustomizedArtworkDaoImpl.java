package cn.edu.xmu.oneonezero.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import cn.edu.xmu.oneonezero.entity.CustomizedArtwork;

public class CustomizedArtworkDaoImpl implements CustomizedArtworkDao {
	private SessionFactory sessionFactory;//创建一个会话工厂实例

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Override
	public List<CustomizedArtwork> getAllCustomizedArtworks() {
		String hql = "from CustomizedArtWork ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		return query.list();
	}
}
