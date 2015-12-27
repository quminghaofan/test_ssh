package cn.edu.xmu.oneonezero.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import cn.edu.xmu.oneonezero.entity.Artwork;

public class ArtworkDaoImpl implements ArtworkDao{
	private SessionFactory sessionFactory;//创建一个会话工厂实例

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Artwork> getArtworksByType(String type) {
		String hql = "from  Artwork a where a.isExist=true and a.type.name like ? ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, type);
		if(query.list()==null||query.list().size()==0) 
			return null;
		return query.list();
	}

	@Override
	public List<Artwork> getArtworksByTypeAndArtworkName(String type, String artworkName, int start, int num) {
		String hql = "from Artwork a where a.isExist=true and a.type.name= ? and a.name like ? ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, type);
		query.setString(1, "%"+artworkName+"%");
		query.setFirstResult(start*num);
		query.setMaxResults(num);
		
		if(query.list()==null||query.list().size()==0)return null;
		
		return query.list();
	}

	@Override
	public List<Artwork> getArtworksByAuthorName(String authorName) {
		String hql = "from  Artwork a where a.isExist=true and a.author like ? ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, authorName);
		if(query.list()==null||query.list().size()==0) 
			return null;
		return query.list();
	}

	@Override
	public void setArtworkState(long artworkId, boolean state) {
		getArtworkByArtworkId(artworkId).setIsExist(state);
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public Artwork getArtworkByArtworkId(long artworkId) {
		String hql = "from  Artwork a where a.isExist=true and a.id = ? ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setLong(0, artworkId);
		if(query.list()==null||query.list().size()==0) 
			return null;
		return (Artwork) query.uniqueResult();
	}
}
