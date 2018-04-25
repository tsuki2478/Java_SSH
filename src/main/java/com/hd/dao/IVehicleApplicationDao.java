package com.hd.dao;

import com.hd.model.UseVehicleApplication;
import com.hd.utils.PageModel;

public interface IVehicleApplicationDao {
	void save(UseVehicleApplication uvp) throws RuntimeException;
	   void update(UseVehicleApplication uvp) throws RuntimeException;
	   void delete(UseVehicleApplication uvp) throws RuntimeException;
	   UseVehicleApplication findById(int id);
	   PageModel query(UseVehicleApplication uvp,int currentPage,int pageSize);
	void audit(Integer id, String state);
}
