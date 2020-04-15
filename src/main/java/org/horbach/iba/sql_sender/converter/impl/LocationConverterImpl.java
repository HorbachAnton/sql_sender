package org.horbach.iba.sql_sender.converter.impl;

import org.horbach.iba.sql_sender.converter.LocationConverter;
import org.horbach.iba.sql_sender.dto.LocationDTO;
import org.horbach.iba.sql_sender.entity.Location;

public class LocationConverterImpl implements LocationConverter {

	@Override
	public LocationDTO convertLocationToLocationDTO(Location location) {
		LocationDTO locationDTO = new LocationDTO();
		locationDTO.setId(location.getId());
		locationDTO.setTitle(location.getTitle());
		return locationDTO;
	}

	@Override
	public Location convertLocationDTOToLocation(LocationDTO locationDTO) {
		Location location = new Location();
		location.setId(locationDTO.getId());
		location.setTitle(locationDTO.getTitle());
		return location;
	}

}
