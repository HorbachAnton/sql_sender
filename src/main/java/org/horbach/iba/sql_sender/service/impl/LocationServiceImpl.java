package org.horbach.iba.sql_sender.service.impl;

import java.util.List;

import org.horbach.iba.sql_sender.dao.LocationDAO;
import org.horbach.iba.sql_sender.entity.Location;
import org.horbach.iba.sql_sender.service.LocationService;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class LocationServiceImpl implements LocationService {

	LocationDAO locationDAO;

	public LocationServiceImpl() {

	}

	public LocationServiceImpl(LocationDAO locationDAO) {
		this.locationDAO = locationDAO;
	}

	@Override
	public Location getLocation(int id) {
		return locationDAO.getLocation(id);
	}

	@Override
	public List<Location> getLocations() {
		return locationDAO.getLocations();
	}

	@Override
	public void saveLocation(Location location) {
		locationDAO.saveLocation(location);
	}

	@Override
	public void updateLocation(Location location) {
		locationDAO.updateLocation(location);
	}

	@Override
	public void deleteLocation(Location location) {
		locationDAO.deleteLocation(location);
	}

}
