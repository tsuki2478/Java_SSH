package com.hd.dao;

import java.util.List;

import com.hd.model.TMenu;
import com.hd.model.TUser;
import com.hd.utils.PageModel;

public interface IUserDao {

	/**
	 * 增加
	 * 
	 * @param user
	 * @throws RuntimeException
	 */
	void save(TUser user) throws RuntimeException;

	/**
	 * 修改
	 * 
	 * @param user
	 * @throws RuntimeException
	 */
	void update(TUser user) throws RuntimeException;

	/**
	 * 删除
	 * 
	 * @param user
	 * @throws RuntimeException
	 */
	void remove(TUser user) throws RuntimeException;
	/**
	 * 寻找单个
	 * 
	 * @param user
	 * @throws RuntimeException
	 */
	TUser findUserById(int id);

	/**
	 * 查询全部
	 * 
	 * @param user
	 * @throws RuntimeException
	 */
	List<TUser> queryAll(TUser user);
	/**
	 * 
	 * 分页查询
	 * @return
	 */
	/**
	 * 同步数据
	 * @throws RuntimeException
	 */
	void saveSynchroUser() throws RuntimeException;
	
	PageModel  queryPage(TUser user,int currentPage, int pageSize );
/**
 * 登录
 * @param user
 * @return
 */
     TUser  login(TUser  user);
/**
 * 登录后扫描其权限作用
 * @param id
 */
     List<TMenu> queryCurrentUserSecurity(Integer id);
}
