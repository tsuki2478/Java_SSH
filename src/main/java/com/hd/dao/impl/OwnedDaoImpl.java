package com.hd.dao.impl;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.hd.dao.IOwnedDao;
import com.hd.model.OwnedVehicle;
import com.hd.utils.BaseDao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.hd.dao.IOwnedDao;
import com.hd.model.OwnedVehicle;
import com.hd.utils.BaseDao;
@Repository
public class OwnedDaoImpl extends BaseDao<OwnedVehicle> implements IOwnedDao {

	@Override
	public List<OwnedVehicle> query() {
		
		return super.getSession().createQuery(" from OwnedVehicle ").list();
	}

	/**
	 * 批量保存
	 * 我们自己管理事务
	 * 每1000条保存一次
	 */
	@Override
	public void saveOwnedExcel(List<OwnedVehicle> list) {
		Session session = super.factory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			for (int i = 0; i < list.size(); i++) {
				OwnedVehicle ow = list.get(i);
				session.save(ow);
				if(i%1000==0){
					session.flush();
				}
			}
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		}finally{
			session.close();
		}
		
	}

	@Override
	public void update(OwnedVehicle ownedvehicle) {
		// TODO Auto-generated method stub
		super.getSession().update(ownedvehicle);
	}
	
	@Override
	public void remove(OwnedVehicle ownedVehicle) {
		// TODO Auto-generated method 
	 
		
		super.getSession().delete(ownedVehicle);
	}


}
