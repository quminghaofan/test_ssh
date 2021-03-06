package cn.edu.xmu.oneonezero.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import cn.edu.xmu.oneonezero.entity.CustomizedArtworkOrder;
/**
 * 订制品订单接口的实现
 * @author DELL
 *
 */
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
		String hql = "from  CustomizedArtworkOrder cao where cao.orderId like ? and a.placeDate>=? and a.placeDate<?";
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
			
			SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				Date temDate=format.parse("3000-01-01 12:00:00");
				query.setDate(2, new java.sql.Date(temDate.getTime()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(query.list()==null||query.list().size()==0) 
			return null;
		return query.list();
	}

	@Override
	public List<CustomizedArtworkOrder> getCustomizedArtworkOrdersByVagueArtworkNameAndTimespace(String artworkName,
			Date startTime, Date endTime) {
		String hql = "from  CustomizedArtworkOrder cao where cao.customizedArtwork.name like ? and a.placeDate>=? and a.placeDate<?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, artworkName);
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
			SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				Date temDate=format.parse("3000-01-01 12:00:00");
				query.setDate(2, new java.sql.Date(temDate.getTime()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(query.list()==null||query.list().size()==0) 
			return null;
		return query.list();
	}

	@Override
	public List<CustomizedArtworkOrder> getCustomizedArtworkOrdersByArtworkTypeAndTimespace(String artworkType,
			Date startTime, Date endTime) {
		String hql = "from  CustomizedArtworkOrder cao where cao.customizedArtwork.type.name like ? and a.placeDate>=? and a.placeDate<?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, artworkType);
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
			SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				Date temDate=format.parse("3000-01-01 12:00:00");
				query.setDate(2, new java.sql.Date(temDate.getTime()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(query.list()==null||query.list().size()==0) 
			return null;
		return query.list();
	}

	@Override
	public List<CustomizedArtworkOrder> getCustomizedArtworkOrdersByUserNameAndTimespace(String userName,
			Date startTime, Date endTime) {
		String hql = "from  CustomizedArtworkOrder cao where cao.user.name like ? and a.placeDate>=? and a.placeDate<?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, "%"+userName+"%");
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
			SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				Date temDate=format.parse("3000-01-01 12:00:00");
				query.setDate(2, new java.sql.Date(temDate.getTime()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(query.list()==null||query.list().size()==0) 
			return null;
		return query.list();
	}

	@Override
	public List<CustomizedArtworkOrder> getCustomizedArtworkOrdersByArtistNameAndTimespace(String artistName,
			Date startTime, Date endTime) {
		String hql = "from  CustomizedArtworkOrder cao where cao.customizedArtwork.owner.name like ? and a.placeDate>=? and a.placeDate<?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, "%"+artistName+"%");
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
		{
			SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				Date temDate=format.parse("3000-01-01 12:00:00");
				query.setDate(2, new java.sql.Date(temDate.getTime()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
			String hql = "from  CustomizedArtworkOrder cao where cao.orderId like ?  and cao.placeDate>=? and cao.placeDate<?";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			
			query.setString(0, "%"+name+"%");
			
			if(startTime!=null)
			{
				java.sql.Date sqlStartTime=new java.sql.Date(startTime.getTime());				
				query.setDate(1, sqlStartTime);
			}
			else
			{
				SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				try {
					Date temDate=format.parse("2000-01-01 12:00:00");
					query.setDate(1, new java.sql.Date(temDate.getTime()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(endTime!=null)
			{
				java.sql.Date sqlEndTime=new java.sql.Date(endTime.getTime());
				query.setDate(2, sqlEndTime);
			}
			else
			{
				SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				try {
					Date temDate=format.parse("3000-01-01 12:00:00");
					query.setDate(2, new java.sql.Date(temDate.getTime()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(query.list()==null||query.list().size()==0) 
				return null;
			return query.list();
		}
		else
		{
			String hql = "from  CustomizedArtworkOrder cao where cao.orderId like ? and cao.customizedArtwork.type.id=? and cao.placeDate>=? and cao.placeDate<?";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			
			query.setString(0, "%"+name+"%");
			Long tem1=Long.parseLong(typeId);
			query.setLong(1,tem1);
			
			if(startTime!=null)
			{
				java.sql.Date sqlStartTime=new java.sql.Date(startTime.getTime());				
				query.setDate(2, sqlStartTime);
			}
			else
			{
				SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				try {
					Date temDate=format.parse("2000-01-01 12:00:00");
					query.setDate(2, new java.sql.Date(temDate.getTime()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(endTime!=null)
			{
				java.sql.Date sqlEndTime=new java.sql.Date(endTime.getTime());
				query.setDate(3, sqlEndTime);
			}
			else
			{
				SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				try {
					Date temDate=format.parse("3000-01-01 12:00:00");
					query.setDate(3, new java.sql.Date(temDate.getTime()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
			String hql = "from  CustomizedArtworkOrder cao where cao.customizedArtwork.name like ?  and cao.placeDate>=? and cao.placeDate<?";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			
			query.setString(0, "%"+name+"%");
			
			if(startTime!=null)
			{
				java.sql.Date sqlStartTime=new java.sql.Date(startTime.getTime());				
				query.setDate(1, sqlStartTime);
			}
			else
			{
				SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				try {
					Date temDate=format.parse("2000-01-01 12:00:00");
					query.setDate(1, new java.sql.Date(temDate.getTime()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(endTime!=null)
			{
				java.sql.Date sqlEndTime=new java.sql.Date(endTime.getTime());
				query.setDate(2, sqlEndTime);
			}
			else
			{
				SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				try {
					Date temDate=format.parse("3000-01-01 12:00:00");
					query.setDate(2, new java.sql.Date(temDate.getTime()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(query.list()==null||query.list().size()==0) 
				return null;
			return query.list();
		}
		else
		{
			String hql = "from  CustomizedArtworkOrder cao where cao.customizedArtwork.name like ? and cao.customizedArtwork.type.id=? and cao.placeDate>=? and cao.placeDate<?";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			
			query.setString(0, "%"+name+"%");
			Long tem1=Long.parseLong(typeId);
			query.setLong(1,tem1);
			
			if(startTime!=null)
			{
				java.sql.Date sqlStartTime=new java.sql.Date(startTime.getTime());				
				query.setDate(2, sqlStartTime);
			}
			else
			{
				SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				try {
					Date temDate=format.parse("2000-01-01 12:00:00");
					query.setDate(2, new java.sql.Date(temDate.getTime()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(endTime!=null)
			{
				java.sql.Date sqlEndTime=new java.sql.Date(endTime.getTime());
				query.setDate(3, sqlEndTime);
			}
			else
			{
				SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				try {
					Date temDate=format.parse("3000-01-01 12:00:00");
					query.setDate(3, new java.sql.Date(temDate.getTime()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
			String hql = "from  CustomizedArtworkOrder cao where cao.customizedArtwork.owner.name like ?  and cao.placeDate>=? and cao.placeDate<?";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			
			query.setString(0, "%"+name+"%");
			
			if(startTime!=null)
			{
				java.sql.Date sqlStartTime=new java.sql.Date(startTime.getTime());				
				query.setDate(1, sqlStartTime);
			}
			else
			{
				SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				try {
					Date temDate=format.parse("2000-01-01 12:00:00");
					query.setDate(1, new java.sql.Date(temDate.getTime()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(endTime!=null)
			{
				java.sql.Date sqlEndTime=new java.sql.Date(endTime.getTime());
				query.setDate(2, sqlEndTime);
			}
			else
			{
				SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				try {
					Date temDate=format.parse("3000-01-01 12:00:00");
					query.setDate(2, new java.sql.Date(temDate.getTime()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(query.list()==null||query.list().size()==0) 
				return null;
			return query.list();
		}
		else
		{
			String hql = "from  CustomizedArtworkOrder cao where cao.customizedArtwork.owner.name like ? and cao.customizedArtwork.type.id=? and cao.placeDate>=? and cao.placeDate<?";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			
			query.setString(0, "%"+name+"%");
			Long tem1=Long.parseLong(typeId);
			query.setLong(1,tem1);
			
			if(startTime!=null)
			{
				java.sql.Date sqlStartTime=new java.sql.Date(startTime.getTime());				
				query.setDate(2, sqlStartTime);
			}
			else
			{
				SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				try {
					Date temDate=format.parse("2000-01-01 12:00:00");
					query.setDate(2, new java.sql.Date(temDate.getTime()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(endTime!=null)
			{
				java.sql.Date sqlEndTime=new java.sql.Date(endTime.getTime());
				query.setDate(3, sqlEndTime);
			}
			else
			{
				SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				try {
					Date temDate=format.parse("3000-01-01 12:00:00");
					query.setDate(3, new java.sql.Date(temDate.getTime()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
			String hql = "from  CustomizedArtworkOrder cao where cao.user.name like ?  and cao.placeDate>=? and cao.placeDate<?";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			
			query.setString(0, "%"+name+"%");
			
			if(startTime!=null)
			{
				java.sql.Date sqlStartTime=new java.sql.Date(startTime.getTime());				
				query.setDate(1, sqlStartTime);
			}
			else
			{
				SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				try {
					Date temDate=format.parse("2000-01-01 12:00:00");
					query.setDate(1, new java.sql.Date(temDate.getTime()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(endTime!=null)
			{
				java.sql.Date sqlEndTime=new java.sql.Date(endTime.getTime());
				query.setDate(2, sqlEndTime);
			}
			else
			{
				SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				try {
					Date temDate=format.parse("3000-01-01 12:00:00");
					query.setDate(2, new java.sql.Date(temDate.getTime()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(query.list()==null||query.list().size()==0) 
				return null;
			return query.list();
		}
		else
		{
			String hql = "from  CustomizedArtworkOrder cao where cao.user.name like ? and cao.customizedArtwork.type.id=? and cao.placeDate>=? and cao.placeDate<?";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			
			query.setString(0, "%"+name+"%");
			Long tem1=Long.parseLong(typeId);
			query.setLong(1,tem1);
			
			if(startTime!=null)
			{
				java.sql.Date sqlStartTime=new java.sql.Date(startTime.getTime());
				query.setDate(2, sqlStartTime);
			}
			else
			{
				SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				try {
					Date temDate=format.parse("2000-01-01 12:00:00");
					query.setDate(2, new java.sql.Date(temDate.getTime()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(endTime!=null)
			{
				java.sql.Date sqlEndTime=new java.sql.Date(endTime.getTime());
				query.setDate(3, sqlEndTime);
			}
			else
			{
				SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				try {
					Date temDate=format.parse("3000-01-01 12:00:00");
					query.setDate(3, new java.sql.Date(temDate.getTime()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
