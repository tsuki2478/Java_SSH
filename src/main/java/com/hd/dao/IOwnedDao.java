package com.hd.dao;

import java.util.List;

import com.hd.model.OwnedVehicle;




public interface IOwnedDao {

	List<OwnedVehicle> query();

	void saveOwnedExcel(List<OwnedVehicle> list);
	
	void update (OwnedVehicle ownedvehicle);
	
	void remove (OwnedVehicle ownedVehicle);
}
