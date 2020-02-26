package com.lti.core.daos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.lti.core.entities.AdminDetails;
import com.lti.core.entities.FlightDetails;
import com.lti.core.entities.FlightScheduleDetails;
import com.lti.core.entities.UserDetails;
import com.lti.core.exceptions.HrExceptions;

public interface AdminDao {

	public void addFlight(FlightDetails flightDetails) throws HrExceptions;
	public void deleteFlight(FlightDetails flightDetails) throws HrExceptions;
	public List<FlightDetails> getFlights() throws HrExceptions;
	public List<AdminDetails> isValid(AdminDetails adminDetails);

}
