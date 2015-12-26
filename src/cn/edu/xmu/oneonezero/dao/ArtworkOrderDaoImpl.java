package cn.edu.xmu.oneonezero.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import cn.edu.xmu.oneonezero.entity.ArtworkOrder;

public class ArtworkOrderDaoImpl implements ArtworkOrderDao{

	private SessionFactory sessionFactory;//创建一个会话工厂实例

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<ArtworkOrder> getArtworkOrderByUserId(long userId) {
		String hql = "from  ArtworkOrder a where a.user.id=? order by a.placeTime desc";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setLong(0, userId);
		if(query.list()==null||query.list().size()==0) 
			return null;
		return query.list();
	}
//from News n where n.onShowTime<? and n.offShowTime>? and n.rank<=4 order by u.rank desc";
	
	@Override
	public List<ArtworkOrder> getOrdersByOrderIdAndTimespace(String orderId, Date startTime, Date endTime) {
		String hql = "from  ArtworkOrder a where a.orderId like ? and a.placeDate>? and a.placeDate<?";
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
	public List<ArtworkOrder> getOrdersByVagueArtworkNameAndTimespace(String artworkName, Date startTime,
			Date endTime) {
		return null;
	}

	@Override
	public List<ArtworkOrder> getOrdersByArtworkTypeAndTimespace(String artworkType, Date startTime, Date endTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArtworkOrder> getOrdersByUserNameAndTimespace(String userName, Date startTime, Date endTime) {
		String hql = "from  ArtworkOrder a where a.user.name like ? and a.placeDate>? and a.placeDate<?";
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
	public List<ArtworkOrder> getOrdersByArtistNameAndTimespace(String artistName, Date startTime, Date endTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArtworkOrder> getOrdersByArtistId(long artistId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	@Override
	public ArtworkOrder getOrderByOrderId(long artworkOrderId) {
		String hql = "from  ArtworkOrder a where a.id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setLong(0, artworkOrderId);
		if(query.list()==null||query.list().size()==0) 
			return null;
		return (ArtworkOrder) query.uniqueResult();
	}

	@Override
	public void setArtworkOrderIsAccept(long id, boolean isAccept) {
		ArtworkOrder aOrder=getOrderByOrderId(id);
		aOrder.setIsAccept(isAccept);
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void cancelArtworkOrder(long id) {
		ArtworkOrder artworkOrder=getOrderByOrderId(id);
		artworkOrder.setIsCancelled(true);
		sessionFactory.getCurrentSession().flush();
	}

}
