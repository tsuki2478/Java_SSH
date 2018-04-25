package com.hd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hd.dao.IMenuDao;
import com.hd.model.TMenu;
import com.hd.service.IMenuService;
@Service
public class MenuServiceImpl implements IMenuService {

	@Resource
	private IMenuDao  dao;
	
	@Override
	public void save(TMenu menu) throws RuntimeException {
		// TODO Auto-generated method stub
		dao.save(menu);
	}

	@Override
	public void update(TMenu menu) throws RuntimeException {
		// TODO Auto-generated method stub
		dao.update(menu);

	}

	@Override
	public void remove(TMenu menu) throws RuntimeException {
		// TODO Auto-generated method stub
		dao.remove(menu);

	}

	@Override
	public TMenu findUserById(int id) {
		// TODO Auto-generated method stub
		return dao.findUserById(id);
	}

	@Override
	public List<TMenu> queryAll(TMenu menu) {
		// TODO Auto-generated method stub
		return dao.queryAll(menu);
	}

}
