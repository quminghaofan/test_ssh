package cn.edu.xmu.oneonezero.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.json.simple.JSONObject;

import cn.edu.xmu.oneonezero.entity.CommodityArtwork;
import cn.edu.xmu.oneonezero.entity.User;

public class CommodityArtworkDaoImpl implements CommodityArtworkDao {

	private SessionFactory sessionFactory;//创建一个会话工厂实例

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<CommodityArtwork> commodityArtworksToDisplay() {
		String hql = "from Artwork a where (a.id=1 or a.id=2 or a.id=3)";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		return query.list();
	}

	@Override
	public List<CommodityArtwork> getCommodityArtworksByPosition(int start, int num) {
		String hql = "from Artwork limit ? ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, start);
		query.setInteger(1, num);
		
		if(query.list()==null||query.list().size()==0)return null;
		
		return query.list();
	}

	@Override
	public long getPageTotal(int num) {
		String hql = "select count(*) from Artwork a where a.orderType='艺术品商品'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		return (long)Math.ceil(((Double)query.uniqueResult())/num);
	}

	@Override
	public JSONObject getCommodityArtworkWithJSONTypeById(long id) {
		String hql = "from Artwork a where a.orderType='艺术品商品' and a.id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setLong(0, id);
		
		return (JSONObject)query.uniqueResult();
	}

	

}
