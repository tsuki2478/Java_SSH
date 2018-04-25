package com.hd.dao.impl;

import org.springframework.stereotype.Repository;

import com.hd.dao.IVehicleRegisterDao;
import com.hd.model.UseVehicleRegister;
import com.hd.utils.BaseDao;
import com.hd.utils.PageModel;
@Repository
public class VehicleRegisterDaoImpl extends BaseDao<UseVehicleRegister> implements IVehicleRegisterDao {

	@Override
	public void save(UseVehicleRegister uvr) throws RuntimeException {
		getSession().save(uvr);

	}

	@Override
	public void update(UseVehicleRegister uvr) throws RuntimeException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(UseVehicleRegister uvr) throws RuntimeException {
		// TODO Auto-generated method stub

	}

	@Override
	public UseVehicleRegister findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageModel query(UseVehicleRegister uvr, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

}
