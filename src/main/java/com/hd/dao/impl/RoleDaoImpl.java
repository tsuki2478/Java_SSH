package com.hd.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hd.dao.IRoleDao;
import com.hd.model.TRole;
import com.hd.utils.BaseDao;
@Repository

public class RoleDaoImpl   extends BaseDao<TRole> implements IRoleDao {

	@Override
	public void save(TRole role) throws RuntimeException {
		// TODO Auto-generated method stub
		super.getSession().save(role);
	}

	@Override
	public void update(TRole role) throws RuntimeException {
		// TODO Auto-generated method stub
			super.getSession().update(role);
	}

	@Override
	public void remove(TRole role) throws RuntimeException {
		// TODO Auto-generated method stub
		super.getSession().delete(role);
	}

	@Override
	public TRole findUserById(int id) {
		return (TRole) super.getSession().get(TRole.class, id);
		// TODO Auto-generated method stub

	}

	@Override
	public List<TRole> queryAll(TRole role) {
		// TODO Auto-generated method stub
		return super.getSession().createQuery("from TRole").list();
	}

}
