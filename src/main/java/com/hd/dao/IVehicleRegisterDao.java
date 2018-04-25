package com.hd.dao;

import com.hd.model.UseVehicleRegister;
import com.hd.utils.PageModel;

public interface IVehicleRegisterDao {
	void save(UseVehicleRegister uvr) throws RuntimeException;

	void update(UseVehicleRegister uvr) throws RuntimeException;

	void delete(UseVehicleRegister uvr) throws RuntimeException;

	UseVehicleRegister findById(int id);

	PageModel query(UseVehicleRegister uvr, int currentPage, int pageSize);
}
