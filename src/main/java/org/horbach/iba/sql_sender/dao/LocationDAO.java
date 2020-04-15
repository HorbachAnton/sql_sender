package org.horbach.iba.sql_sender.dao;

import java.util.List;

import org.horbach.iba.sql_sender.entity.Location;

public interface LocationDAO {

	Location getLocation(int id);

	List<Location> getLocations();

	void saveLocation(Location location);

	void updateLocation(Location location);

	void deleteLocation(Location location);

}
