package cn.edu.xmu.oneonezero.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
		String hql = "from  CommodityArtworkOrder cao where cao.commodityArtwork.canSell=true and cao.orderId like ? and a.placeDate>=? and a.placeDate<?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, orderId);
		if(startTime!=null){
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

	@Override
	public List<CommodityArtworkOrder> getCommodityArtworkOrdersByVagueArtworkNameAndTimespace(String artworkName,
			Date startTime, Date endTime) {
		String hql = "from  CommodityArtworkOrder cao where cao.commodityArtwork.canSell=true and cao.commodityArtwork.name like ? and a.placeDate>=? and a.placeDate<?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, artworkName);
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

	@Override
	public List<CommodityArtworkOrder> getCommodityArtworkOrdersByArtworkTypeAndTimespace(String artworkType,
			Date startTime, Date endTime) {
		String hql = "from  CommodityArtworkOrder cao where cao.commodityArtwork.canSell=true and cao.commodityArtwork.type.name like ? and a.placeDate>=? and a.placeDate<?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, artworkType);
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

	@Override
	public List<CommodityArtworkOrder> getCommodityArtworkOrdersByUserNameAndTimespace(String userName, Date startTime,
			Date endTime) {
		String hql = "from  CommodityArtworkOrder cao where cao.commodityArtwork.canSell=true and cao.user.name like ? and a.placeDate>=? and a.placeDate<?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, "%"+userName+"%");
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

	@Override
	public List<CommodityArtworkOrder> getCommodityArtworkOrdersByArtistNameAndTimespace(String artistName,
			Date startTime, Date endTime) {
		String hql = "from  CommodityArtworkOrder cao where cao.commodityArtwork.canSell=true and cao.commodityArtwork.owner.name like ? and a.placeDate>=? and a.placeDate<?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, "%"+artistName+"%");
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

	@Override
	public List<CommodityArtworkOrder> getAllCommodityArtworkOrders() {
		String hql = "from  CommodityArtworkOrder cao where cao.commodityArtwork.canSell=true";
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
	public long insertCommodityArtworkOrder(CommodityArtworkOrder commodityArtworkOrder) {
		sessionFactory.getCurrentSession().merge(commodityArtworkOrder);
		sessionFactory.getCurrentSession().flush();
		return (Long) sessionFactory.getCurrentSession().createQuery("select max(cao.id) from CommodityArtworkOrder cao").uniqueResult();
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

	@Override
	public void updateCommodityArtworkOrderState(long orderId, String state) {
		CommodityArtworkOrder tempCAO=getCommodityArtworkOrderByOrderId(orderId);
		tempCAO.setState(state);
		sessionFactory.getCurrentSession().flush();
		
	}

	@Override
	public List<CommodityArtworkOrder> getByOrderId(String name, String typeId, Date startTime, Date endTime) {
		if(typeId==null||typeId.equals(""))
		{
			String hql = "from  CommodityArtworkOrder cao where cao.orderId like ?  and cao.placeDate>=? and cao.placeDate<?";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			
			query.setString(0, "%"+name+"%");
			
			if(startTime!=null)
			{
				java.sql.Date sqlStartTime=new java.sql.Date(startTime.getTime());				
				query.setDate(1, sqlStartTime);
				System.out.println("sqlStartTime:"+sqlStartTime.toString());
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
			String hql = "from  CommodityArtworkOrder cao where cao.orderId like ? and cao.commodityArtwork.type.id=? and cao.placeDate>=? and cao.placeDate<?";
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
	public List<CommodityArtworkOrder> getByArtworkName(String name, String typeId, Date startTime, Date endTime) {
		if(typeId==null||typeId.equals(""))
		{
			String hql = "from  CommodityArtworkOrder cao where cao.commodityArtwork.name like ?  and cao.placeDate>=? and cao.placeDate<?";
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
			String hql = "from  CommodityArtworkOrder cao where cao.commodityArtwork.name like ? and cao.commodityArtwork.type.id=? and cao.placeDate>=? and cao.placeDate<?";
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
	public List<CommodityArtworkOrder> getByOwnerName(String name, String typeId, Date startTime, Date endTime) {
		if(typeId==null||typeId.equals(""))
		{
			String hql = "from  CommodityArtworkOrder cao where cao.commodityArtwork.owner.name like ?  and cao.placeDate>=? and cao.placeDate<?";
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
			String hql = "from  CommodityArtworkOrder cao where cao.commodityArtwork.owner.name like ? and cao.commodityArtwork.type.id=? and cao.placeDate>=? and cao.placeDate<?";
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
	public List<CommodityArtworkOrder> getByUserName(String name, String typeId, Date startTime, Date endTime) {
		if(typeId==null||typeId.equals(""))
		{
			String hql = "from  CommodityArtworkOrder cao where cao.user.name like ?  and cao.placeDate>=? and cao.placeDate<?";
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
			String hql = "from  CommodityArtworkOrder cao where cao.user.name like ? and cao.commodityArtwork.type.id=? and cao.placeDate>=? and cao.placeDate<?";
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
	public void insertSomeCommodityArtworkOrders(List<CommodityArtworkOrder> aList) {
		for(int i=0; i<aList.size(); i++)
		{
			sessionFactory.getCurrentSession().saveOrUpdate(aList.get(i));
			if(i%20==0)
			{
				sessionFactory.getCurrentSession().flush();
			}
		}
		sessionFactory.getCurrentSession().flush();
	}
	
	
}
