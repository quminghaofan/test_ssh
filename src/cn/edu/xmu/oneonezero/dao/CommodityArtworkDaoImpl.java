package cn.edu.xmu.oneonezero.dao;

import java.util.List;

import net.sf.json.JSONObject;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import cn.edu.xmu.oneonezero.entity.CommodityArtwork;

public class CommodityArtworkDaoImpl implements CommodityArtworkDao {

	private SessionFactory sessionFactory;//创建一个会话工厂实例

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<CommodityArtwork> commodityArtworksToDisplay() {
		String hql = "from CommodityArtwork a where a.isExist=true and a.canSell=true";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(4);
		return query.list();
	}

	@Override
	public List<CommodityArtwork> getCommodityArtworksByPositionAndVagueName(String artName,int start, int num) {
		String hql = "from CommodityArtwork a where a.isExist=true and a.canSell=true and a.name like ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, "%"+artName+"%");
		query.setFirstResult(start*num);
		query.setMaxResults(num);
		
		if(query.list()==null||query.list().size()==0)return null;
		
		return query.list();
	}

	public int getPageTotalByVagueName(String artName,int num) {
		String hql = "select count(*) from CommodityArtwork a where a.isExist=true and a.canSell=true and a.name like ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, "%"+artName+"%");
		int number=(int)Math.ceil(((Long)query.uniqueResult())/((double)num));
		if(number==0)return 1;
		return number;
	}

	@Override
	public JSONObject getCommodityArtworkWithJSONTypeById(long id) {
		String hql = "from CommodityArtwork a where a.canSell=true and a.id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setLong(0, id);
		if(query.list()==null||query.list().size()==0)return null;
		return JSONObject.fromObject(query.uniqueResult());
		
		
	}

	@Override
	public List<CommodityArtwork> getCommodityArtworksByVagueArtNameInDescendingOrder(String artName) {
		String hql = "from CommodityArtwork a where a.isExist=true and a.canSell=true and a.name like ? order by a.price desc";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, artName);
		if(query.list()==null||query.list().size()==0)return null;
		return query.list();
	}

	@Override
	public List<CommodityArtwork> getCommodityArtworksByVagueArtNameInAscendingOrder(String artName) {
		String hql = "from CommodityArtwork a where a.isExist=true and a.canSell=true and a.name like ? order by a.price asc";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, artName);
		if(query.list()==null||query.list().size()==0)return null;
		return query.list();
	}

	@Override
	public List<CommodityArtwork> getAllCommodityArtworks() {
		String hql = "from CommodityArtwork  a where a.isExist=true and a.canSell=true";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		return query.list();
	}

	@Override
	public List<CommodityArtwork> getCommodityArtworksByArtistId(long ownerId) {
		String hql = "from CommodityArtwork ca where ca.isExist=true and ca.owner.id= ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setLong(0, ownerId);
		
		return query.list();
	}

	@Override
	public void insertCommodityArtwork(CommodityArtwork commodityArtwork) {
		sessionFactory.getCurrentSession().saveOrUpdate(commodityArtwork);
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public CommodityArtwork getCommodityArtworkById(long commodityArtworkId) {
		String hql = "from CommodityArtwork ca where ca.isExist=true and ca.id= ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setLong(0, commodityArtworkId);
		
		return (CommodityArtwork) query.uniqueResult();
	
	}

	@Override
	public void updateCommodityArtwork(CommodityArtwork commodityArtwork) {
		sessionFactory.getCurrentSession().saveOrUpdate(commodityArtwork);
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public List<CommodityArtwork> getAllExhibitArtworks() {
		String hql = "from CommodityArtwork a where a.isExist=true and a.canSell=false";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		return query.list();
	}

	@Override
	public void prohibitCommodityArtwork(long commodityArtworkId) {
		CommodityArtwork temCommodityArtwork=getCommodityArtworkById(commodityArtworkId);
		temCommodityArtwork.setIsExist(false);
		sessionFactory.getCurrentSession().flush();
		
	}

	@Override
	public List<CommodityArtwork> getCommodityArtworksByArtworkTypeIdVagueArtworkNamePageNumber(long artworkTypeId, String artName,
			int start, int num) {
		String hql = "from CommodityArtwork a where a.isExist=true and a.type.id=? and a.canSell=true and a.name like ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setLong(0, artworkTypeId);
		query.setString(1, "%"+artName+"%");
		query.setFirstResult(start*num);
		query.setMaxResults(num);
		
		if(query.list()==null||query.list().size()==0)return null;
		
		return query.list();
	}

	@Override
	public List<CommodityArtwork> getExhibitArtworksByArtworkTypeIdVagueArtworkNamePageNumber(long artworkTypeId,
			String artName, int start, int num) {
		String hql = "from CommodityArtwork a where a.isExist=true and a.type.id=? and a.canSell=false and a.name like ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setLong(0, artworkTypeId);
		query.setString(1, "%"+artName+"%");
		query.setFirstResult(start*num);
		query.setMaxResults(num);
		
		if(query.list()==null||query.list().size()==0)return null;
		
		return query.list();
	}

	@Override
	public List<CommodityArtwork> getExhibitArtworksByVagueArtNameAndPage(String artName, int start, int num) {
		if(artName==null) artName="";
		String hql = "from CommodityArtwork a where a.canSell=false and a.name like ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, "%"+artName+"%");
		query.setFirstResult(start*num);
		query.setMaxResults(num);
		
		if(query.list()==null||query.list().size()==0)return null;
		
		return query.list();
	}

	@Override
	public void setCommodityArtworkIsExistByArtworkId(long artworkId, boolean isExist) {
		CommodityArtwork commodityArtwork=getCommodityArtworkById(artworkId);
		commodityArtwork.setIsExist(isExist);
		sessionFactory.getCurrentSession().flush();
		
	}

	@Override
	public void deleteExhibitArtworkByArtworkId(long artworkId) {
		String hql = "delete CommodityArtwork ca where ca.id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
	
		query.setLong(0, artworkId);
		query.executeUpdate();
	}

	@Override
	public List<CommodityArtwork> getExhibitArtworksByOwnerId(long artistId) {
		String hql = "from CommodityArtwork a where a.canSell=false and a.owner.id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setLong(0, artistId);
		
		if(query.list()==null||query.list().size()==0)return null;
		
		return query.list();
	}

	@Override
	public List<CommodityArtwork> getByVagueArtworkName(String name, String typeId) {
		if(typeId.equals("0"))
		{
			String hql = "from CommodityArtwork a where a.isExist=true and a.name like ?";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			query.setString(0, "%"+name+"%");
			
			if(query.list()==null||query.list().size()==0)return null;
			
			return query.list();
		}
		else{
			String hql = "from CommodityArtwork a where a.isExist=true and a.name like ? and a.type.id=?";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			query.setString(0, "%"+name+"%");
			long temp=Long.parseLong(typeId);
			query.setLong(1, temp);
			
			if(query.list()==null||query.list().size()==0)return null;
			
			return query.list();
		}
		
	}

	@Override
	public List<CommodityArtwork> getByVagueOwnerName(String name, String typeId) {
		if(typeId.equals("0"))
		{
			String hql = "from CommodityArtwork a where a.isExist=true and a.owner.name like ?";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			query.setString(0, "%"+name+"%");
			
			if(query.list()==null||query.list().size()==0)return null;
			
			return query.list();
		}
		else{
			String hql = "from CommodityArtwork a where a.isExist=true and a.owner.name like ? and a.type.id=?";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			query.setString(0, "%"+name+"%");
			long temp=Long.parseLong(typeId);
			query.setLong(1, temp);
			
			if(query.list()==null||query.list().size()==0)return null;
			
			return query.list();
		}
	}

	@Override
	public int getExhibitPageTotalByVagueName(String artName, int num) {
		String hql = "select count(*) from CommodityArtwork a where a.isExist=true and a.canSell=false and a.name like ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, "%"+artName+"%");
		int number=(int)Math.ceil(((Long)query.uniqueResult())/((double)num));
		if(number==0)return 1;
		return number;
	}

	

	

}
