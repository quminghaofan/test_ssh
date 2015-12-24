package cn.edu.xmu.oneonezero.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import cn.edu.xmu.oneonezero.entity.DataDictionary;

public class DataDictionaryDaoImpl implements DataDictionaryDao{

	private SessionFactory sessionFactory;//创建一个会话工厂实例

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public DataDictionary getDataDictionaryByName(String name) {
		String hql = "from DataDictionary d where d.name=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, name);
		
		return (DataDictionary)query.uniqueResult();
	}
	@Override
	public List<DataDictionary> getAllArtworkTypes() {
		String hql = "from DataDictionary d where d.number like ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		query.setString(0, "02"+"__");
		return query.list();
		
	}
	@Override
	public List<DataDictionary> getAllRoles() {
		String hql = "from DataDictionary d where d.number like ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		query.setString(0, "01"+"__");
		return query.list();
	}
	@Override
	public boolean deleteArtworkType(long typeId) {
		String hql = "delete DataDictionary d where d.id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setLong(0, typeId);
		
		return (query.executeUpdate() > 0);

	}
	@Override
	public void insertDataDictionary(DataDictionary dataDictionary) {
		sessionFactory.getCurrentSession().saveOrUpdate(dataDictionary);
	}

}
