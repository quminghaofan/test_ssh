package cn.edu.xmu.oneonezero.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import cn.edu.xmu.oneonezero.entity.CommodityArtworkOrder;

public class CommodityArtworkOrderDaoImpl implements CommodityArtworkOrderDao{
	private SessionFactory sessionFactory;//创建一个会话工厂实例

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<CommodityArtworkOrder> getCommodityArtworkOrdersByOrderIdAndTimespace(String orderId, Date startTime,
			Date endTime) {
		String hql = "from  CommodityArtworkOrder cao where cao.commodityArtwork.canSell=true and cao.orderId like ? and a.placeDate>? and a.placeDate<?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, orderId);
		if(startTime!=null)
			query.setDate(1, startTime);
		else
		{
			Calendar temCal=Calendar.getInstance();
			temCal.set(2015,1,1);
			
			Date temDate=(Date) temCal.getTime();
			query.setDate(1, temDate);
		}
		if(endTime!=null)
			query.setDate(2, endTime);
		else
		{
			Calendar temCal=Calendar.getInstance();
			temCal.set(2050,1,1);
			
			Date temDate=(Date) temCal.getTime();
			query.setDate(2, temDate);
		}
		if(query.list()==null||query.list().size()==0) 
			return null;
		return query.list();
	}

	@Override
	public List<CommodityArtworkOrder> getCommodityArtworkOrdersByVagueArtworkNameAndTimespace(String artworkName,
			Date startTime, Date endTime) {
		String hql = "from  CommodityArtworkOrder cao where cao.commodityArtwork.canSell=true and cao.commodityArtwork.name like ? and a.placeDate>? and a.placeDate<?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, artworkName);
		if(startTime!=null)
			query.setDate(1, startTime);
		else
		{
			Calendar temCal=Calendar.getInstance();
			temCal.set(2015,1,1);
			
			Date temDate=(Date) temCal.getTime();
			query.setDate(1, temDate);
		}
		if(endTime!=null)
			query.setDate(2, endTime);
		else
		{
			Calendar temCal=Calendar.getInstance();
			temCal.set(2050,1,1);
			
			Date temDate=(Date) temCal.getTime();
			query.setDate(2, temDate);
		}
		if(query.list()==null||query.list().size()==0) 
			return null;
		return query.list();
	}

	@Override
	public List<CommodityArtworkOrder> getCommodityArtworkOrdersByArtworkTypeAndTimespace(String artworkType,
			Date startTime, Date endTime) {
		String hql = "from  CommodityArtworkOrder cao where cao.commodityArtwork.canSell=true and cao.commodityArtwork.type.name like ? and a.placeDate>? and a.placeDate<?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, artworkType);
		if(startTime!=null)
			query.setDate(1, startTime);
		else
		{
			Calendar temCal=Calendar.getInstance();
			temCal.set(2015,1,1);
			
			Date temDate=(Date) temCal.getTime();
			query.setDate(1, temDate);
		}
		if(endTime!=null)
			query.setDate(2, endTime);
		else
		{
			Calendar temCal=Calendar.getInstance();
			temCal.set(2050,1,1);
			
			Date temDate=(Date) temCal.getTime();
			query.setDate(2, temDate);
		}
		if(query.list()==null||query.list().size()==0) 
			return null;
		return query.list();
	}

	@Override
	public List<CommodityArtworkOrder> getCommodityArtworkOrdersByUserNameAndTimespace(String userName, Date startTime,
			Date endTime) {
		String hql = "from  CommodityArtworkOrder cao where cao.commodityArtwork.canSell=true and cao.user.name = ? and a.placeDate>? and a.placeDate<?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, userName);
		if(startTime!=null)
			query.setDate(1, startTime);
		else
		{
			Calendar temCal=Calendar.getInstance();
			temCal.set(2015,1,1);
			
			Date temDate=(Date) temCal.getTime();
			query.setDate(1, temDate);
		}
		if(endTime!=null)
			query.setDate(2, endTime);
		else
		{
			Calendar temCal=Calendar.getInstance();
			temCal.set(2050,1,1);
			
			Date temDate=(Date) temCal.getTime();
			query.setDate(2, temDate);
		}
		if(query.list()==null||query.list().size()==0) 
			return null;
		return query.list();
	}

	@Override
	public List<CommodityArtworkOrder> getCommodityArtworkOrdersByArtistNameAndTimespace(String artistName,
			Date startTime, Date endTime) {
		String hql = "from  CommodityArtworkOrder cao where cao.commodityArtwork.canSell=true and cao.commodityArtwork.owner.name = ? and a.placeDate>? and a.placeDate<?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, artistName);
		if(startTime!=null)
			query.setDate(1, startTime);
		else
		{
			Calendar temCal=Calendar.getInstance();
			temCal.set(2015,1,1);
			
			Date temDate=(Date) temCal.getTime();
			query.setDate(1, temDate);
		}
		if(endTime!=null)
			query.setDate(2, endTime);
		else
		{
			Calendar temCal=Calendar.getInstance();
			temCal.set(2050,1,1);
			
			Date temDate=(Date) temCal.getTime();
			query.setDate(2, temDate);
		}
		if(query.list()==null||query.list().size()==0) 
			return null;
		return query.list();
	}

	@Override
	public List<CommodityArtworkOrder> getAllCommodityArtworkOrders() {
		String hql = "from  CommodityArtworkOrder cao where cao.commodityArtwork.cansale=true";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		if(query.list()==null||query.list().size()==0) 
			return null;
		return query.list();
	}

	@Override
	public List<CommodityArtworkOrder> getCommodityArtworkOrdersByArtistId(long artistId) {
		String hql = "from  CommodityArtworkOrder cao where cao.commodityArtwork.owner.id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setLong(0, artistId);
		if(query.list()==null||query.list().size()==0) 
			return null;
		return query.list();
	}

	@Override
	public List<CommodityArtworkOrder> getCommodityArtworkOrdersByUserId(long userId) {
		String hql = "from  CommodityArtworkOrder cao where cao.user.id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setLong(0, userId);
		if(query.list()==null||query.list().size()==0) 
			return null;
		return query.list();
	}

	@Override
	public void insertCommodityArtworkOrder(CommodityArtworkOrder commodityArtworkOrder) {
		sessionFactory.getCurrentSession().saveOrUpdate(commodityArtworkOrder);
	}

	@Override
	public boolean deleteCommodityArtworkOrder(long commodityArtworkId) {
		String hql = "delete CommodityArtworkOrder cao where cao.id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setLong(0, commodityArtworkId);
		
		return (query.executeUpdate() > 0);
	}

	@Override
	public CommodityArtworkOrder getCommodityArtworkOrderByOrderId(long commodityArtworkOrderId) {
		String hql = "from  CommodityArtworkOrder cao where cao.id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setLong(0, commodityArtworkOrderId);
		if(query.list()==null||query.list().size()==0) 
			return null;
		return (CommodityArtworkOrder) query.uniqueResult();
	}

	@Override
	public List<CommodityArtworkOrder> getCommodityArtworkOrdersByOwnerId(long ownerId) {
		String hql = "from  CommodityArtworkOrder cao where cao.commodityArtwork.owner.id=? ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setLong(0, ownerId);
		if(query.list()==null||query.list().size()==0) 
			return null;
		return query.list();
	}
	
	
}
