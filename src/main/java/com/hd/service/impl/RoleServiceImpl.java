package com.hd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hd.dao.IRoleDao;
import com.hd.model.TRole;
import com.hd.service.IRoleService;
@Service
public class RoleServiceImpl implements IRoleService {
		@Resource
		private IRoleDao  dao;
		
	@Override
	public void save(TRole role) throws RuntimeException {
		// TODO Auto-generated method stub
			dao.save(role);
	}

	@Override
	public void update(TRole role) throws RuntimeException {
		// TODO Auto-generated method stub
			dao.update(role);
	}

	@Override
	public void remove(TRole role) throws RuntimeException {
		// TODO Auto-generated method stub
			dao.remove(role);
	}

	@Override
	public TRole findUserById(int id) {
		return dao.findUserById(id);
	}

	@Override
	public List<TRole> queryAll(TRole role) {
		// TODO Auto-generated method stub
		return	dao.queryAll(role);
	}

}
