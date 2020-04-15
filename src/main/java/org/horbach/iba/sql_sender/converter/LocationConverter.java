package org.horbach.iba.sql_sender.converter;

import org.horbach.iba.sql_sender.dto.LocationDTO;
import org.horbach.iba.sql_sender.entity.Location;

public interface LocationConverter {
	
	LocationDTO convertLocationToLocationDTO(Location location);
	
	Location convertLocationDTOToLocation(LocationDTO locationDTO);

}
