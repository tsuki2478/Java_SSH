package com.hd.dao;

import java.util.List;


import com.hd.model.TMenu;


public interface IMenuDao {

	/**
	 * 增加
	 * 
	 * @param user
	 * @throws RuntimeException
	 */
	void save(TMenu menu) throws RuntimeException;

	/**
	 * 修改
	 * 
	 * @param user
	 * @throws RuntimeException
	 */
	void update(TMenu menu) throws RuntimeException;

	/**
	 * 删除
	 * 
	 * @param user
	 * @throws RuntimeException
	 */
	void remove(TMenu menu) throws RuntimeException;

	/**
	 * 寻找单个
	 * 
	 * @param user
	 * @throws RuntimeException
	 */
	TMenu  findUserById(int id);

	/*	  查询全部
	 * 
	 * @param user
	 * @throws RuntimeException
	 */
	List<TMenu> queryAll(TMenu menu);
}