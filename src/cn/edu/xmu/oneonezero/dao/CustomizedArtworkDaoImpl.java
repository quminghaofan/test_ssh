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
		String hql = "from CustomizedArtwork ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		return query.list();
	}


	@Override
	public List<CustomizedArtwork> getCustomizedArtworksByVagueArtworkNamePageNumber(Long artworkTypeId, String artName,
			int start, int num) {
		String hql = "from CustomizedArtwork a where a.type.id=? and a.name like ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setLong(0, artworkTypeId);
		query.setString(1, "%"+artName+"%");
		query.setFirstResult(start);
		query.setMaxResults(num);
		
		if(query.list()==null||query.list().size()==0)return null;
		
		return query.list();
	}


	@Override
	public void insertCustomizedArtwork(CustomizedArtwork customizedArtwork) {
		sessionFactory.getCurrentSession().saveOrUpdate(customizedArtwork);
	}
}
