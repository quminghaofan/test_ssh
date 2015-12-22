package cn.edu.xmu.oneonezero.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import cn.edu.xmu.oneonezero.entity.CustomizedArtworkOrder;

public class CustomizedArtworkOrderDaoImpl implements CustomizedArtworkOrderDao{
	private SessionFactory sessionFactory;//创建一个会话工厂实例

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<CustomizedArtworkOrder> getCustomizedArtworkOrdersByUserId(long userId) {
		String hql = "from  CustomizedArtworkOrder cao.user.id=? ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setLong(0, userId);
		if(query.list()==null||query.list().size()==0) 
			return null;
		return query.list();
	}

	@Override
	public List<CustomizedArtworkOrder> getFinishedCustomizedArtworkOrdersByUserId(long userId) {
		String hql = "from  CustomizedArtworkOrder cao.user.id=? and cao.isFinished=true";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setLong(0, userId);
		if(query.list()==null||query.list().size()==0) 
			return null;
		return query.list();
	}
}
