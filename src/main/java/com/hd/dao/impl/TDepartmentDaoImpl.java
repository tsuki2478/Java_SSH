package com.hd.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.hd.dao.TDepartmentDao;
import com.hd.model.TDepartment;
import com.hd.utils.BaseDao;
@Repository
public class TDepartmentDaoImpl   extends BaseDao<TDepartment> implements TDepartmentDao {

	@Override
	public void save(TDepartment dept) throws RuntimeException {
		// TODO Auto-generated method stub
		super.getSession().save(dept);
	}

	@Override
	public void update(TDepartment dept) throws RuntimeException {
		// TODO Auto-generated method stub
		super.getSession().update(dept);

	}

	@Override
	public void remove(TDepartment dept) throws RuntimeException {
		// TODO Auto-generated method stub
		super.getSession().delete(dept);

	}

	@Override
	public TDepartment findUserById(int id) {
		// TODO Auto-generated method stub
		return (TDepartment) super.getSession().get(TDepartment.class, id);

	}

	@Override
	public List<TDepartment> queryAll(TDepartment dept) {
		// TODO Auto-generated method stub
		return super.getSession().createQuery(" from TDepartment ").list();
	}

}
