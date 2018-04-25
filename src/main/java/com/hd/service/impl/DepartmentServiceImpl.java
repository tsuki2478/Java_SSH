package com.hd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hd.dao.TDepartmentDao;
import com.hd.model.TDepartment;
import com.hd.service.IDepartmentService;
@Service
public class DepartmentServiceImpl implements IDepartmentService {
	
	@Resource
	private TDepartmentDao dao;
	@Override
	public void save(TDepartment dept) throws RuntimeException {
		// TODO Auto-generated method stub
			dao.save(dept);
	}

	@Override
	public void update(TDepartment dept) throws RuntimeException {
		// TODO Auto-generated method stub
			dao.update(dept);
	}

	@Override
	public void remove(TDepartment dept) throws RuntimeException {
		// TODO Auto-generated method stub
			dao.remove(dept);
	}

	@Override
	public TDepartment findUserById(int id) {
		return dao.findUserById(id);
	}

	@Override
	public List<TDepartment> queryAll(TDepartment dept) {
		// TODO Auto-generated method stub
		return dao.queryAll(dept);
	}

}
