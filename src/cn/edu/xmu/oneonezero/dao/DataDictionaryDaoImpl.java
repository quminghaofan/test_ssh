package cn.edu.xmu.oneonezero.dao;

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

}
