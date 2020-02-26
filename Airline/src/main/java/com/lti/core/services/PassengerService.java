package com.lti.core.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.lti.core.entities.FlightDetails;
import com.lti.core.entities.Passenger;
import com.lti.core.entities.UserDetails;
import com.lti.core.exceptions.HrExceptions;

public interface PassengerService {

	public boolean addPassenger(Passenger passenger)  throws HrExceptions;
	public List<FlightDetails> getFlights(String source, String destination, LocalDate departureDate) throws HrExceptions;
	public List<FlightDetails> getFlightsAfterLogin(String source, String destination, LocalDate departureDate,String flightClass) throws HrExceptions;
	public List<UserDetails> isValid(UserDetails userDetails);
	public boolean register(UserDetails userDetails) throws HrExceptions;
	public boolean doPayment(int price, long accNo, int userId);
}
