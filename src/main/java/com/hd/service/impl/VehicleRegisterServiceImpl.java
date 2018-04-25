package com.hd.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hd.dao.IVehicleRegisterDao;
import com.hd.model.UseVehicleRegister;
import com.hd.service.IVehicleRegisterService;
import com.hd.utils.PageModel;
@Service
public class VehicleRegisterServiceImpl implements IVehicleRegisterService {

	@Resource
	private IVehicleRegisterDao rdao;
	@Override
	public void save(UseVehicleRegister uvr) throws RuntimeException {
		// TODO Auto-generated method stub
		rdao.save(uvr);
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
