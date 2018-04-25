package com.hd.service.impl;

import java.util.List;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hd.dao.IUserDao;
import com.hd.model.TMenu;
import com.hd.model.TUser;
import com.hd.service.IUserService;
import com.hd.utils.PageModel;

@Service
public class UserServiceImpl implements IUserService {

	@Resource
	private IUserDao dao;

	@Override
	public void save(TUser user) throws RuntimeException {
		// TODO Auto-generated method stub
		dao.save(user);
	}

	@Override
	public void update(TUser user) throws RuntimeException {
		// TODO Auto-generated method stub
		dao.update(user);
	}

	@Override
	public void remove(TUser user) throws RuntimeException {
		// TODO Auto-generated method stub
		dao.remove(user);
	}

	@Override
	public TUser findUserById(int id) {
		// TODO Auto-generated method stub
		return dao.findUserById(id);
	}

	@Override
	public List<TUser> queryAll(TUser user) {
		// TODO Auto-generated method stub
		return dao.queryAll(user);
	}

	@Override
	public PageModel queryPage(TUser user, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return dao.queryPage(user, currentPage, pageSize);
	}

	@Override
	public TUser login(TUser user) {
		// TODO Auto-generated method stub
		user = dao.login(user);
		if (user != null) {
			// 表示用户登录成功，我们需要根据用户的编号查询出该用户具有的所有的权限

			List<TMenu> list = dao.queryCurrentUserSecurity(user.getId());
			// 将查询出来的所有的权限绑定到当前用户中

			user.setUserMenus(list);
			// System.out.println(list.size());

		}
		return user;
	}

	@Override
	public void saveSynchroUser() throws RuntimeException {
		// TODO Auto-generated method stub
		dao.saveSynchroUser();
	}

}
