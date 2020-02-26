package com.lti.core.daos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.lti.core.entities.FlightDetails;
import com.lti.core.entities.PassengerDetails;
import com.lti.core.entities.UserDetails;
import com.lti.core.exceptions.HrExceptions;

public interface UserDetailsDao {

	public boolean userRegistration(UserDetails userDetails) throws HrExceptions;
	public List<FlightDetails> getFlights(String source,String destination,LocalDate departureDate) throws HrExceptions;
	public List<UserDetails> isValid(UserDetails userDetails);
	public List<FlightDetails> getFlightsafterLogin(String source,String destination,LocalDate departureDate,String flightClass) throws HrExceptions;
	public void addPassenger(PassengerDetails passengerDetails);
	public void updateSchedule(int newSeats1, int schedule, String flightc);
	
	public boolean doPayment(int price, long accNo, int userId);
}
