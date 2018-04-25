package com.hd.service;

import java.util.List;

import com.hd.model.TUser;
import com.hd.utils.PageModel;

public interface IUserService {
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
	PageModel  queryPage(TUser user,int currentPage, int pageSize );
	/**
	 * 数据同步
	 * @throws RuntimeException
	 */
	void saveSynchroUser() throws RuntimeException;
	/**
	 * 登录
	 * @param user
	 * @return
	 */	
	
	 TUser  login(TUser  user);

}
