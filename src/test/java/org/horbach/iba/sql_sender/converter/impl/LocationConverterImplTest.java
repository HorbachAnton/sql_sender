package org.horbach.iba.sql_sender.converter.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.horbach.iba.sql_sender.converter.LocationConverter;
import org.horbach.iba.sql_sender.dto.LocationDTO;
import org.horbach.iba.sql_sender.entity.Location;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/context/converter-context/converter-context.xml" })
class LocationConverterImplTest {

	@Autowired
	private LocationConverter locationConverter;

	private static LocationDTO locationDTO;

	private static Location location;

	@BeforeAll
	static void setUp() throws Exception {
		setUpLocationDTO();
		setUpLocation();
	}

	static void setUpLocationDTO() {
		locationDTO = new LocationDTO(1, "Festival");
	}

	static void setUpLocation() {
		location = new Location(1, "Festival");
	}

	@Test
	void testSuccessConvertLocationToLocationDTO() {
		assertThat(locationDTO, equalTo(locationConverter.convertLocationToLocationDTO(location)));
	}

	@Test
	void testSuccessConvertLocationDTOToLocation() {
		assertThat(location, equalTo(locationConverter.convertLocationDTOToLocation(locationDTO)));
	}

}
