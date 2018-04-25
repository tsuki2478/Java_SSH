package com.hd.service;

import java.util.List;

import com.hd.model.TDepartment;

public interface IDepartmentService {
	/**
	 * 增加
	 * 
	 * @param user
	 * @throws RuntimeException
	 */
	void save(TDepartment dept) throws RuntimeException;

	/**
	 * 修改
	 * 
	 * @param user
	 * @throws RuntimeException
	 */
	void update(TDepartment dept) throws RuntimeException;

	/**
	 * 删除
	 * 
	 * @param user
	 * @throws RuntimeException
	 */
	void remove(TDepartment dept) throws RuntimeException;

	/**
	 * 寻找单个
	 * 
	 * @param user
	 * @throws RuntimeException
	 */
	TDepartment findUserById(int id);

	/**
	 * 查询全部
	 * 
	 * @param user
	 * @throws RuntimeException
	 */
	List<TDepartment> queryAll(TDepartment dept);

}
