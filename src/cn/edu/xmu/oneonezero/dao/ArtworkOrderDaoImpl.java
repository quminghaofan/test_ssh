package cn.edu.xmu.oneonezero.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import cn.edu.xmu.oneonezero.entity.ArtworkOrder;
import cn.edu.xmu.oneonezero.entity.CommodityArtworkOrder;
/**
 * 艺术品订单基类接口的实现
 * @author DELL
 *
 */
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
		String hql = "from  ArtworkOrder a where a.orderId like ? and a.placeDate>=? and a.placeDate<?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, orderId);
		if(startTime!=null)
		{
			java.sql.Date sqlStartTime=new java.sql.Date(startTime.getTime());
			query.setDate(1, sqlStartTime);
		}
		else
		{
			Calendar temCal=Calendar.getInstance();
			temCal.set(2015,1,1);
			
			Date temDate=(Date) temCal.getTime();
			query.setDate(1, temDate);
		}
		if(endTime!=null)
		{
			java.sql.Date sqlEndTime=new java.sql.Date(endTime.getTime());
			query.setDate(2, sqlEndTime);
		}
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
	public List<ArtworkOrder> getOrdersByUserNameAndTimespace(String userName, Date startTime, Date endTime) {
		String hql = "from  ArtworkOrder a where a.user.name like ? and a.placeDate>=? and a.placeDate<?";
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
	public ArtworkOrder getOrderByOrderId(long artworkOrderId) {
		String hql = "from  ArtworkOrder a where a.id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setLong(0, artworkOrderId);
		if(query.list()==null||query.list().size()==0) 
			return null;
		return (ArtworkOrder) query.uniqueResult();
	}

	@Override
	public void setArtworkOrderIsAccept(long id, String isAccept) {
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

	@Override
	public void updateArtworkOrderState(long orderId, String state) {
		ArtworkOrder tempAO=getOrderByOrderId(orderId);
		tempAO.setState(state);
		sessionFactory.getCurrentSession().flush();
	}

}
