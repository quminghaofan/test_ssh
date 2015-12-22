package cn.edu.xmu.oneonezero.dao;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import cn.edu.xmu.oneonezero.entity.User;



public class UserDaoImpl implements UserDao {

	private SessionFactory sessionFactory;//创建一个会话工厂实例

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	


	@Override
	public boolean delUser(long id) {
		String hql = "delete User u where u.id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setLong(0, id);
		
		return (query.executeUpdate() > 0);
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
	public boolean updateUser(User user) {
		String hql = "update User u set u.address= ?,u.bankCardAccount=?,u.headPhoto=?,"
				+ "u.mobile=?,u.name=?,u.password=?,u.description=?,u.role=?,u.nickName=?,u.state=?,u.idPhoto =?,u.realName=? where u.id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, user.getAddress());
		query.setString(1, user.getBankCardAccount());
		query.setString(2, user.getHeadPhoto());
		query.setString(3, user.getMobile());
		query.setString(4, user.getName());
		query.setString(5, user.getPassword());
		query.setString(6, user.getDescription());
		query.setEntity(7, user.getRole());
		query.setString(8, user.getNickName());
		query.setBoolean(9, user.getState());
		query.setString(10, user.getIdPhoto());
		query.setString(11, user.getRealName());
		query.setLong(12, user.getId());
		
		return (query.executeUpdate() > 0);
		
	}



	@Override
	public boolean isLoginSuccessful(String userName, String psw) {
		String hql = "from User u where u.name = ? and u.password=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, userName);
		query.setString(1, psw);
		
		return !query.list().isEmpty();
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		String hql = "from User";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		return query.list();
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUserByUserName(String userName) {
		String hql = "from User u where u.name = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, userName);
		
		return query.list();
	}



	@Override
	public List<User> getUsersByRole(String role) {
		String hql="from User u where u.role = ?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, role);
		
		return query.list();
	}



	@Override
	public User getUserByUserNameAndPassword(String userName, String password) {
		String hql="from User u where u.name= ? and u.password= ?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, userName);
		query.setString(1, password);
		if(query.list()==null||query.list().size()==0) return null;
		return (User) query.list().get(0);
	}



	@Override
	public boolean isNameExist(String userName) {
		String hql="from User u where u.name= ?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, userName);
		if(query.list().size()!=0) 
			return true;
		return false;
	}
	
	
	
	
	

}
