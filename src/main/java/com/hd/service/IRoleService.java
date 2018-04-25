package com.hd.service;

import java.util.List;

import com.hd.model.TRole;

public interface IRoleService {

	/**
	 * 增加
	 * 
	 * @param user
	 * @throws RuntimeException
	 */
	
	void save(TRole role) throws RuntimeException;

	/**
	 * 修改
	 * 
	 * @param user
	 * @throws RuntimeException
	 */
	void update(TRole role) throws RuntimeException;

	/**
	 * 删除
	 * 
	 * @param user
	 * @throws RuntimeException
	 */
	void remove(TRole role) throws RuntimeException;

	/**
	 * 寻找单个
	 * 
	 * @param user
	 * @throws RuntimeException
	 */
	TRole findUserById(int id);

/**
	 * 查询全部
	 * 
	 * @param user
	 * @throws RuntimeException
	 */
	List<TRole> queryAll(TRole role);
}
