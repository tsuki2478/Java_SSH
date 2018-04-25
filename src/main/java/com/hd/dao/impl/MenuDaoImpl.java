package com.hd.dao.impl;

import java.util.List;



import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.hd.dao.IMenuDao;
import com.hd.model.TMenu;
import com.hd.utils.BaseDao;
@Repository
public class MenuDaoImpl extends BaseDao<TMenu>  implements IMenuDao {

	@Override
	public void save(TMenu menu) throws RuntimeException {
		// TODO Auto-generated method stub
			super.getSession().save(menu);
	}

	@Override
	public void update(TMenu menu) throws RuntimeException {
		// TODO Auto-generated method stub
			super.getSession().update(menu);
	}

	/**
	 * 伪删除数据 将isdelete标志置为1
	 */
	@Override
	public void remove(TMenu menu) throws RuntimeException {
		// TODO Auto-generated method stub
		String hql = " update TMenu set isdelete=1 where id=:id";
		Query query = super.getSession().createQuery(hql);
		query.setParameter("id", menu.getId());
		query.executeUpdate();
	}

	@Override
	public TMenu findUserById(int id) {
		// TODO Auto-generated method stub
		return (TMenu) super.getSession().get(TMenu.class, id);
	}

	@Override
	public List<TMenu> queryAll(TMenu menu) {
		// TODO Auto-generated method stub
		return  super.getSession().createQuery(" from TMenu  where isdelete=2 or isdelete is null ").list(); 
	}

}
