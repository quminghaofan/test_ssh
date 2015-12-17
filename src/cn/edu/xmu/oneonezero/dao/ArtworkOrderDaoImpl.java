package cn.edu.xmu.oneonezero.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import cn.edu.xmu.oneonezero.entity.ArtworkOrder;
import cn.edu.xmu.oneonezero.entity.News;

public class ArtworkOrderDaoImpl implements ArtworkOrderDao{

	private SessionFactory sessionFactory;//创建一个会话工厂实例

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<ArtworkOrder> getNewsByUserId(long userId) {
		String hql = "from  ArtworkOrder a where a.user.id=? order by a.placeTime desc";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setLong(0, userId);
		if(query.list()==null||query.list().size()==0) 
			return null;
		return query.list();
	}

}
