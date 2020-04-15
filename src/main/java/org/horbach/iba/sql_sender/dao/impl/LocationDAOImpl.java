package org.horbach.iba.sql_sender.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.horbach.iba.sql_sender.dao.LocationDAO;
import org.horbach.iba.sql_sender.entity.Location;
import org.horbach.iba.sql_sender.entity.Ticket;

public class LocationDAOImpl extends AbstractBasicDAOImpl implements LocationDAO {

	private static final String GET_LOCATION_QUERY = "SELECT * FROM location";

	public LocationDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Location getLocation(int id) {
		return (Location) getById(Location.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Location> getLocations() {
		return getCurrentSession().createSQLQuery(GET_LOCATION_QUERY).addEntity(Ticket.class).list();
	}

	@Override
	public void saveLocation(Location location) {
		save(location);
	}

	@Override
	public void updateLocation(Location location) {
		update(location);
	}

	@Override
	public void deleteLocation(Location location) {
		delete(location);
	}

}
