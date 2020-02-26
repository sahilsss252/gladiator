package com.lti.core.services;

import java.util.List;

import com.lti.core.entities.AdminDetails;
import com.lti.core.entities.FlightDetails;
import com.lti.core.entities.FlightSchedule;
import com.lti.core.exceptions.HrExceptions;

public interface AdminService {

	public void addFlight(FlightSchedule flightSchedule) throws HrExceptions;
	public void deleteFlight(FlightDetails flightDetails) throws HrExceptions;
	public List<FlightDetails> getFlights() throws HrExceptions;
	public List<AdminDetails> isValid(AdminDetails adminDetails);
}
