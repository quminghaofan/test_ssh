package cn.edu.xmu.oneonezero.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import cn.edu.xmu.oneonezero.entity.CommodityArtwork;
import cn.edu.xmu.oneonezero.entity.CustomizedArtwork;

public class CustomizedArtworkDaoImpl implements CustomizedArtworkDao {
	private SessionFactory sessionFactory;//创建一个会话工厂实例

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Override
	public List<CustomizedArtwork> getAllCustomizedArtworks() {
		String hql = "from CustomizedArtwork c where c.isExist=true";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		return query.list();
	}


	@Override
	public List<CustomizedArtwork> getCustomizedArtworksByVagueArtworkNamePageNumber(Long artworkTypeId, String artName,
			int start, int num) {
		String hql = "from CustomizedArtwork a where a.isExist=true and a.type.id=? and a.name like ?";
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
		sessionFactory.getCurrentSession().flush();
	}


	@Override
	public void setCustomizedArtworkIsExistByArtworkId(long artworkId, boolean isExist) {
		CustomizedArtwork customizedArtwork=getCustomizedArtworkById(artworkId);
		customizedArtwork.setIsExist(isExist);
		sessionFactory.getCurrentSession().flush();
	}


	@Override
	public CustomizedArtwork getCustomizedArtworkById(long customizedArtworkId) {
		String hql = "from CustomizedArtwork a where a.isExist=true and  a.id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setLong(0, customizedArtworkId);
		
		if(query.list()==null||query.list().size()==0)return null;
		
		return (CustomizedArtwork) query.uniqueResult();
	}


	@Override
	public List<CustomizedArtwork> getByVagueArtworkName(String name, String typeId) {
		if(typeId.equals("0"))
		{
			String hql = "from CustomizedArtwork a where a.isExist=true and a.name like ?";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			query.setString(0, "%"+name+"%");
			
			if(query.list()==null||query.list().size()==0)return null;
			
			return query.list();
		}
		else{
			String hql = "from CustomizedArtwork a where a.isExist=true and a.name like ? and a.type.id=?";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			query.setString(0, "%"+name+"%");
			long temp=Long.parseLong(typeId);
			query.setLong(1, temp);
			
			if(query.list()==null||query.list().size()==0)return null;
			
			return query.list();
		}
	}


	@Override
	public List<CustomizedArtwork> getByVagueOwnerName(String name, String typeId) {
		if(typeId.equals("0"))
		{
			String hql = "from CustomizedArtwork a where a.isExist=true and a.owner.name like ?";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			query.setString(0, "%"+name+"%");
			
			if(query.list()==null||query.list().size()==0)return null;
			
			return query.list();
		}
		else{
			String hql = "from CustomizedArtwork a where a.isExist=true and a.owner.name like ? and a.type.id=?";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			query.setString(0, "%"+name+"%");
			long temp=Long.parseLong(typeId);
			query.setLong(1, temp);
			
			if(query.list()==null||query.list().size()==0)return null;
			
			return query.list();
		}
	}
}
