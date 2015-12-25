package cn.edu.xmu.oneonezero.dao;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import cn.edu.xmu.oneonezero.entity.User;



public class UserDaoImpl implements UserDao {

	private SessionFactory sessionFactory;//创建一个会话工厂实例

	


	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Override
	public User getUser(long id) {
		
		String hql = "from User u where u.id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setLong(0, id);
		
		return (User)query.uniqueResult();
	}


	@Override
	public void insertUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public void updateUser(User user) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	
	}



	@Override
	public boolean isLoginSuccessful(String userName, String psw) {
		String hql = "from User u where u.state=true and u.name = ? and u.password=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, userName);
		query.setString(1, psw);
		
		return !query.list().isEmpty();
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		String hql = "from User where u.state=true";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		return query.list();
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUserByUserName(String userName) {
		String hql = "from User u where u.state=true and  u.name like ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, "%"+userName+"%");
		
		return query.list();
	}



	@Override
	public List<User> getUsersByRole(String role) {
		String hql="from User u where u.state=true and u.role = ?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, role);
		
		return query.list();
	}



	@Override
	public User getUserByUserNameAndPassword(String userName, String password) {
		String hql="from User u where u.state=true and  u.name= ? and u.password= ?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, userName);
		query.setString(1, password);
		if(query.list()==null||query.list().size()==0) return null;
		return (User) query.list().get(0);
	}



	@Override
	public boolean isNameExist(String userName) {
		String hql="from User u where u.state=true and  u.name= ?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, userName);
		if(query.list().size()!=0) 
			return true;
		return false;
	}



	@Override
	public List<User> getAllManager() {
		String hql="from User u where u.state=true and  (u.role.name='普通管理员' or u.role.name='采编' or u.role.name='主编')";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		if(query.list().size()!=0)
			if(query.list()==null||query.list().size()==0) return null;
			return query.list();
	}

	@Override
	public void setUserState(long userId,boolean state) {
		getUser(userId).setState(state);
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public List<User> getAllCommonUsersAndArtist() {
		String hql="from User u where u.state=true and  (u.role.name='普通用户' or u.role.name='艺术家')";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		if(query.list().size()!=0)
			if(query.list()==null||query.list().size()==0) return null;
			return query.list();
	}

	@Override
	public List<User> getAllPreparativeArtist() {
		String hql="from User u where u.state=true and  u.role.name='预备艺术家' ";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		if(query.list().size()!=0)
			if(query.list()==null||query.list().size()==0) return null;
			return query.list();
	}

	@Override
	public List<User> getPreparativeUserByUserName(String userName) {
		String hql = "from User u where u.state=true and u.role='预备艺术家' and u.name like ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, "%"+userName+"%");
		return query.list();
	}

	@Override
	public List<User> getCommonUsersAndArtistByUserName(String userName) {
		String hql = "from User u where u.state=true and  (u.role.name='普通用户' or u.role.name='艺术家') and u.name like ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, "%"+userName+"%");
		return query.list();
	}
	
	

	
	
	
	
	

}
