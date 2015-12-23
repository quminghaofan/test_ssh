package cn.edu.xmu.oneonezero.dao;

import java.util.List;

import net.sf.json.JSONObject;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import cn.edu.xmu.oneonezero.entity.CommodityArtwork;
import cn.edu.xmu.oneonezero.entity.User;

public class CommodityArtworkDaoImpl implements CommodityArtworkDao {

	private SessionFactory sessionFactory;//创建一个会话工厂实例

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<CommodityArtwork> commodityArtworksToDisplay() {
		String hql = "from Artwork a where (a.id=1 or a.id=2 or a.id=3) and a.canSell=true";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		return query.list();
	}

	@Override
	public List<CommodityArtwork> getCommodityArtworksByPositionAndVagueName(String artName,int start, int num) {
		String hql = "from Artwork a where a.canSell=true and a.name like ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, "%"+artName+"%");
		query.setFirstResult(start);
		query.setMaxResults(num);
		
		if(query.list()==null||query.list().size()==0)return null;
		
		return query.list();
	}

	public int getPageTotalByVagueName(String artName,int num) {
		String hql = "select count(*) from Artwork a where a.canSell=true and a.name like ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, "%"+artName+"%");
		int number=(int)Math.ceil(((Long)query.uniqueResult())/((double)num));
		if(number==0)return 1;
		return number;
	}

	@Override
	public JSONObject getCommodityArtworkWithJSONTypeById(long id) {
		String hql = "from Artwork a where a.canSell=true and a.id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setLong(0, id);
		if(query.list()==null||query.list().size()==0)return null;
		return JSONObject.fromObject(query.uniqueResult());
		
		
	}

	@Override
	public List<CommodityArtwork> getCommodityArtworksByVagueArtNameInDescendingOrder(String artName) {
		String hql = "from Artwork a where a.canSell=true and a.name like ? order by a.price desc";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, artName);
		if(query.list()==null||query.list().size()==0)return null;
		return query.list();
	}

	@Override
	public List<CommodityArtwork> getCommodityArtworksByVagueArtNameInAscendingOrder(String artName) {
		String hql = "from Artwork a where a.canSell=true and a.name like ? order by a.price asc";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, artName);
		if(query.list()==null||query.list().size()==0)return null;
		return query.list();
	}

	@Override
	public List<CommodityArtwork> getAllCommodityArtworks() {
		String hql = "from CommodityArtwork where a.canSell=true";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		return query.list();
	}

	@Override
	public List<CommodityArtwork> getCommodityArtworksByArtistId(long ownerId) {
		String hql = "from CommodityArtwork ca where ca.canSell=true and ca.owner.id= ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setLong(0, ownerId);
		
		return query.list();
	}

	@Override
	public void insertCommodityArtwork(CommodityArtwork commodityArtwork) {
		sessionFactory.getCurrentSession().saveOrUpdate(commodityArtwork);
	}

	@Override
	public CommodityArtwork getCommodityArtworkById(long commodityArtworkId) {
		String hql = "from CommodityArtwork ca where ca.id= ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setLong(0, commodityArtworkId);
		
		return (CommodityArtwork) query.uniqueResult();
	
	}

	@Override
	public void updateCommodityArtwork(CommodityArtwork commodityArtwork) {
		sessionFactory.getCurrentSession().saveOrUpdate(commodityArtwork);
	}

	@Override
	public List<CommodityArtwork> getAllExhibitArtworks() {
		String hql = "from CommodityArtwork where a.canSell=false";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		return query.list();
	}

	

	

}
