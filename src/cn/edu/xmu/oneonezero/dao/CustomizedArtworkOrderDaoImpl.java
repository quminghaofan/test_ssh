package cn.edu.xmu.oneonezero.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import cn.edu.xmu.oneonezero.entity.CustomizedArtworkOrder;

public class CustomizedArtworkOrderDaoImpl implements CustomizedArtworkOrderDao{
	private SessionFactory sessionFactory;//创建一个会话工厂实例

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<CustomizedArtworkOrder> getCustomizedArtworkOrdersByUserId(long userId) {
		String hql = "from  CustomizedArtworkOrder cao where cao.user.id=? ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setLong(0, userId);
		if(query.list()==null||query.list().size()==0) 
			return null;
		return query.list();
	}


	@Override
	public List<CustomizedArtworkOrder> getCustomizedArtworkOrdersByOrderIdAndTimespace(String orderId, Date startTime,
			Date endTime) {
		String hql = "from  CustomizedArtworkOrder cao where cao.orderId like ? and a.placeDate>? and a.placeDate<?";
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
	public List<CustomizedArtworkOrder> getCustomizedArtworkOrdersByVagueArtworkNameAndTimespace(String artworkName,
			Date startTime, Date endTime) {
		String hql = "from  CustomizedArtworkOrder cao where cao.customizedArtwork.name like ? and a.placeDate>? and a.placeDate<?";
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
	public List<CustomizedArtworkOrder> getCustomizedArtworkOrdersByArtworkTypeAndTimespace(String artworkType,
			Date startTime, Date endTime) {
		String hql = "from  CustomizedArtworkOrder cao where cao.customizedArtwork.type.name like ? and a.placeDate>? and a.placeDate<?";
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
	public List<CustomizedArtworkOrder> getCustomizedArtworkOrdersByUserNameAndTimespace(String userName,
			Date startTime, Date endTime) {
		String hql = "from  CustomizedArtworkOrder cao where cao.user.name = ? and a.placeDate>? and a.placeDate<?";
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
	public List<CustomizedArtworkOrder> getCustomizedArtworkOrdersByArtistNameAndTimespace(String artistName,
			Date startTime, Date endTime) {
		String hql = "from  CustomizedArtworkOrder cao where cao.customizedArtwork.owner.name = ? and a.placeDate>? and a.placeDate<?";
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
	public List<CustomizedArtworkOrder> getAllCustomizedArtworkOrders() {
		String hql = "from  CustomizedArtworkOrder cao  ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		if(query.list()==null||query.list().size()==0) 
			return null;
		return query.list();
	}


	@Override
	public void insertCustomizedArtworkOrder(CustomizedArtworkOrder customizedArtworkOrder) {
		sessionFactory.getCurrentSession().merge(customizedArtworkOrder);
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public boolean deleteCustomizedArtworkOrder(long customizedArtworkId) {
		String hql = "delete CustomizedArtworkOrder cao where cao.id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setLong(0, customizedArtworkId);
		
		return (query.executeUpdate() > 0);
	}

	@Override
	public CustomizedArtworkOrder getCustomedArtworkOrderByOrderId(long customizedArtworkOrderId) {
		String hql = "from  CustomizedArtworkOrder cao where cao.id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setLong(0, customizedArtworkOrderId);
		if(query.list()==null||query.list().size()==0) 
			return null;
		return (CustomizedArtworkOrder) query.uniqueResult();
	}

	@Override
	public List<CustomizedArtworkOrder> getCustomizedArtworkOrdersByOwnerId(long ownerId) {
		String hql = "from  CustomizedArtworkOrder cao where cao.customizedArtwork.owner.id=? ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setLong(0, ownerId);
		if(query.list()==null||query.list().size()==0) 
			return null;
		return query.list();
	}

	@Override
	public List<CustomizedArtworkOrder> getByOrderId(String name, String typeId, Date startTime, Date endTime) {
		if(typeId==null||typeId.equals(""))
		{
			String hql = "from  CustomizedArtworkOrder cao where cao.orderId = ?  and cao.placeDate>? and cao.placeDate<?";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			
			query.setString(0, name);
			
			if(startTime!=null)
				query.setDate(1, startTime);
			else
			{
				Calendar temCal=Calendar.getInstance();
				temCal.set(2000,1,1);
				
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
		else
		{
			String hql = "from  CustomizedArtworkOrder cao where cao.orderId = ? and cao.customizedArtwork.type.id=? and cao.placeDate>? and cao.placeDate<?";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			
			query.setString(0, name);
			Long tem1=Long.parseLong(typeId);
			query.setLong(1,tem1);
			
			if(startTime!=null)
				query.setDate(2, startTime);
			else
			{
				Calendar temCal=Calendar.getInstance();
				temCal.set(2000,1,1);
				
				Date temDate=(Date) temCal.getTime();
				query.setDate(2, temDate);
			}
			if(endTime!=null)
				query.setDate(3, endTime);
			else
			{
				Calendar temCal=Calendar.getInstance();
				temCal.set(2050,1,1);
				
				Date temDate=(Date) temCal.getTime();
				query.setDate(3, temDate);
			}
			if(query.list()==null||query.list().size()==0) 
				return null;
			return query.list();
		}
	}

	@Override
	public List<CustomizedArtworkOrder> getByArtworkName(String name, String typeId, Date startTime, Date endTime) {
		if(typeId==null||typeId.equals(""))
		{
			String hql = "from  CustomizedArtworkOrder cao where cao.customizedArtwork.name = ?  and cao.placeDate>? and cao.placeDate<?";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			
			query.setString(0, name);
			
			if(startTime!=null)
				query.setDate(1, startTime);
			else
			{
				Calendar temCal=Calendar.getInstance();
				temCal.set(2000,1,1);
				
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
		else
		{
			String hql = "from  CustomizedArtworkOrder cao where cao.customizedArtwork.name = ? and cao.customizedArtwork.type.id=? and cao.placeDate>? and cao.placeDate<?";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			
			query.setString(0, name);
			Long tem1=Long.parseLong(typeId);
			query.setLong(1,tem1);
			
			if(startTime!=null)
				query.setDate(2, startTime);
			else
			{
				Calendar temCal=Calendar.getInstance();
				temCal.set(2000,1,1);
				
				Date temDate=(Date) temCal.getTime();
				query.setDate(2, temDate);
			}
			if(endTime!=null)
				query.setDate(3, endTime);
			else
			{
				Calendar temCal=Calendar.getInstance();
				temCal.set(2050,1,1);
				
				Date temDate=(Date) temCal.getTime();
				query.setDate(3, temDate);
			}
			if(query.list()==null||query.list().size()==0) 
				return null;
			return query.list();
		}
	}

	@Override
	public List<CustomizedArtworkOrder> getByOwnerName(String name, String typeId, Date startTime, Date endTime) {
		if(typeId==null||typeId.equals(""))
		{
			String hql = "from  CustomizedArtworkOrder cao where cao.customizedArtwork.owner.name = ?  and cao.placeDate>? and cao.placeDate<?";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			
			query.setString(0, name);
			
			if(startTime!=null)
				query.setDate(1, startTime);
			else
			{
				Calendar temCal=Calendar.getInstance();
				temCal.set(2000,1,1);
				
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
		else
		{
			String hql = "from  CustomizedArtworkOrder cao where cao.customizedArtwork.owner.name = ? and cao.customizedArtwork.type.id=? and cao.placeDate>? and cao.placeDate<?";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			
			query.setString(0, name);
			Long tem1=Long.parseLong(typeId);
			query.setLong(1,tem1);
			
			if(startTime!=null)
				query.setDate(2, startTime);
			else
			{
				Calendar temCal=Calendar.getInstance();
				temCal.set(2000,1,1);
				
				Date temDate=(Date) temCal.getTime();
				query.setDate(2, temDate);
			}
			if(endTime!=null)
				query.setDate(3, endTime);
			else
			{
				Calendar temCal=Calendar.getInstance();
				temCal.set(2050,1,1);
				
				Date temDate=(Date) temCal.getTime();
				query.setDate(3, temDate);
			}
			if(query.list()==null||query.list().size()==0) 
				return null;
			return query.list();
		}
	}

	@Override
	public List<CustomizedArtworkOrder> getByUserName(String name, String typeId, Date startTime, Date endTime) {
		if(typeId==null||typeId.equals(""))
		{
			String hql = "from  CustomizedArtworkOrder cao where cao.user.name = ?  and cao.placeDate>? and cao.placeDate<?";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			
			query.setString(0, name);
			
			if(startTime!=null)
				query.setDate(1, startTime);
			else
			{
				Calendar temCal=Calendar.getInstance();
				temCal.set(2000,1,1);
				
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
		else
		{
			String hql = "from  CustomizedArtworkOrder cao where cao.user.name = ? and cao.customizedArtwork.type.id=? and cao.placeDate>? and cao.placeDate<?";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			
			query.setString(0, name);
			Long tem1=Long.parseLong(typeId);
			query.setLong(1,tem1);
			
			if(startTime!=null)
				query.setDate(2, startTime);
			else
			{
				Calendar temCal=Calendar.getInstance();
				temCal.set(2000,1,1);
				
				Date temDate=(Date) temCal.getTime();
				query.setDate(2, temDate);
			}
			if(endTime!=null)
				query.setDate(3, endTime);
			else
			{
				Calendar temCal=Calendar.getInstance();
				temCal.set(2050,1,1);
				
				Date temDate=(Date) temCal.getTime();
				query.setDate(3, temDate);
			}
			if(query.list()==null||query.list().size()==0) 
				return null;
			return query.list();
		}
	}

	@Override
	public void updateCustomizedArtworkOrderStage(long orderId, String stage) {
		CustomizedArtworkOrder customizedArtworkOrder=getCustomedArtworkOrderByOrderId(orderId);
		customizedArtworkOrder.setStage(stage);
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void updateCustomizedArtworkOrderState(long orderId, String state) {
		CustomizedArtworkOrder customizedArtworkOrder=getCustomedArtworkOrderByOrderId(orderId);
		customizedArtworkOrder.setState(state);
		sessionFactory.getCurrentSession().flush();
		
	}


	@Override
	public void updateCustomizedArtworkOrder(CustomizedArtworkOrder customizedArtworkOrder) {
		sessionFactory.getCurrentSession().saveOrUpdate(customizedArtworkOrder);
		sessionFactory.getCurrentSession().flush();
	}
	
	
	
}
