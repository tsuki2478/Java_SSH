package com.hd.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.hd.dao.IUserDao;
import com.hd.model.TMenu;
import com.hd.model.TUser;
import com.hd.utils.BaseDao;
import com.hd.utils.PageModel;

@Repository
public class UserDaoImpl extends BaseDao<TUser> implements IUserDao {

	@Override
	public void save(TUser user) throws RuntimeException {
		// TODO Auto-generated method stub
		super.getSession().save(user);
	}

	@Override
	public void update(TUser user) throws RuntimeException {
		// TODO Auto-generated method stub
		super.getSession().update(user);
	}

	@Override
	public void remove(TUser user) throws RuntimeException {
		// TODO Auto-generated method stub
		super.getSession().delete(user);
	}

	@Override
	public TUser findUserById(int id) {
		// TODO Auto-generated method stub
		return (TUser) super.getSession().get(TUser.class, id);
	}

	@Override
	public List<TUser> queryAll(TUser user) {
		// TODO Auto-generated method stub
		String hql = " from TUser ";

		return super.getSession().createQuery(hql).list();
	}

	/**
	 * 分页查询数据方式
	 */
	@Override
	public PageModel queryPage(TUser user, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		StringBuilder queryHql = new StringBuilder(" from TUser where 1=1 ");
		StringBuilder countHql = new StringBuilder(
				" select count(*) from TUser where 1=1 ");
		StringBuilder whereHql = new StringBuilder();
		Map<String, Object> params = new HashMap<String, Object>();
		if (user!=null) {
		
		if (!"".equals(user.getUsername()) && user.getUsername() != null) {
			// 表示需要根据用户名查询   like 近似。。。查询一般这个
			whereHql.append("and username like :username");
			params.put("username", "%" + user.getUsername() + "%");
			}
		}	
		return queryPageModel(queryHql, countHql, whereHql, currentPage,
				pageSize, params);

	}

	@Override
	public TUser login(TUser user) {
		// TODO Auto-generated method stub
	String hql="from TUser where username=:username and pwd=:pwd";
	Query query = super.getSession().createQuery(hql);	
	query.setProperties(user);
	List<TUser> list=query.list();
	if (list!=null && list.size()>0) {
		return list.get(0);
	}
	
	return null;
	}
	/**
	 * 数据同步
	 */
	@Override
	public void saveSynchroUser() throws RuntimeException {
		String sql = "insert into t_user(id, username, pwd, realname, sex, phone, depid) select id, username, pwd, realname, sex, phone, depid from t_user@dbms_xe t2 where t2.id not in (select id from t_user)";
//		String  sql="insert into t_user(id, username, pwd, realname, sex, phone, depid)values(seq_t_role.nextval,'?','?','?','?','?','?')";
		super.getSession().createSQLQuery(sql).executeUpdate();
	}
	
/**
 * 根据 用户编号查询对应所有的权限。。
 */
	@Override
	public List<TMenu> queryCurrentUserSecurity(Integer id) {
		// TODO Auto-generated method stub
	String sql="select * from  t_menu  t1 where t1.id in(select  menuid from t_role_menu t2 where t2.roleid in(select  roleid from t_user_role t3 where t3.userid = :id))";
		 SQLQuery query = super.getSession().createSQLQuery(sql);
		query.setParameter("id", id);
		query.addEntity(TMenu.class);
		List<TMenu> list=query.list();
		return  list;
		
	}
}
