
package com.hd.service;

import java.io.File;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.hd.model.OwnedVehicle;

public interface IOwnedService {

	List<OwnedVehicle> query();

	void readExcel(File upload) throws IOException;

	InputStream exportExcel() throws IOException;
	
	void update (OwnedVehicle ownedvehicle);
	
	void remove (OwnedVehicle ownedVehicle);

}
