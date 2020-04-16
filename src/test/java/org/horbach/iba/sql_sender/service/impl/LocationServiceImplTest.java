package org.horbach.iba.sql_sender.service.impl;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.horbach.iba.sql_sender.dao.LocationDAO;
import org.horbach.iba.sql_sender.dao.impl.LocationDAOImpl;
import org.horbach.iba.sql_sender.entity.Location;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LocationServiceImplTest {

	@Mock
	private static LocationDAO locationDAO;

	private static Location expectedLocation;

	private static List<Location> expectedLocations;

	private static LocationServiceImpl locationServiceImpl;

	@BeforeAll
	static void setUp() throws Exception {
		setUpExpectedLocation();
		setUpExpectedLocations();
		setUpLocationDAO();
		setUpLocationServiceImpl();
	}

	static void setUpExpectedLocation() {
		expectedLocation = new Location(1, "Festival");
	}

	static void setUpExpectedLocations() {
		expectedLocations = new ArrayList<Location>(Arrays.asList(expectedLocation, new Location()));
	}

	static void setUpLocationDAO() {
		locationDAO = mock(LocationDAOImpl.class);
		doReturn(expectedLocation).when(locationDAO).getLocation(1);
		doReturn(expectedLocations).when(locationDAO).getLocations();
	}

	static void setUpLocationServiceImpl() {
		locationServiceImpl = new LocationServiceImpl(locationDAO);
	}

	@Test
	void testSuccessGetLocation() {
		Location receivedLocation = locationServiceImpl.getLocation(1);
		assertThat(expectedLocation, allOf(sameInstance(receivedLocation), equalTo(receivedLocation)));
	}

	@Test
	void testSuccessGetLocations() {
		List<Location> receivedLocations = locationServiceImpl.getLocations();
		assertThat(expectedLocations, allOf(sameInstance(receivedLocations), equalTo(receivedLocations)));
	}

}
