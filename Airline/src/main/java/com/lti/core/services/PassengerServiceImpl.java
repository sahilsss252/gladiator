package com.lti.core.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.core.daos.UserDetailsDao;
import com.lti.core.entities.FlightDetails;
import com.lti.core.entities.FlightScheduleDetails;
import com.lti.core.entities.Passenger;
import com.lti.core.entities.PassengerDetails;
import com.lti.core.entities.UserDetails;
import com.lti.core.exceptions.HrExceptions;

@Service
public class PassengerServiceImpl implements PassengerService {

	@Autowired
	private UserDetailsDao userDetailsDao;
	
	
	@Override
	public boolean addPassenger(Passenger passenger) throws HrExceptions {
		UserDetails userDetails=new  UserDetails();
		PassengerDetails passengerDetails =new PassengerDetails();
		FlightScheduleDetails flightScheduleDetails=new FlightScheduleDetails();
		flightScheduleDetails.setScheduleId(passenger.getScheduleId());
		userDetails.setUserId(passenger.getUserId());
		passengerDetails.setSeatNo(passenger.getSeatNo());
		passengerDetails.setPassengerName(passenger.getPassengername());
		passengerDetails.setPassengerGender(passenger.getPassengerGender());
		passengerDetails.setPassengerAge(passenger.getPassengerAge());
		passengerDetails.setFlightClass(passenger.getFlightClass());
		passengerDetails.setFlightScheduleDetails(flightScheduleDetails);
		passengerDetails.setUserDetails(userDetails);
		List<PassengerDetails> passengerDetails2=new ArrayList<>();
		passengerDetails2.add(passengerDetails);
		userDetails.setPassengerDetails(passengerDetails2);
		userDetailsDao.addPassenger(passengerDetails);
		int newSeats=passenger.getAvailableSeats();
		int newSeats1=newSeats-1;
		int sid=passenger.getScheduleId();
		String flightc=passenger.getFlightClass();
		userDetailsDao.updateSchedule(newSeats1, sid,flightc);
		return true;
		
	}


	@Override
	public List<FlightDetails> getFlights(String source, String destination, LocalDate departureDate) throws HrExceptions {
		// TODO Auto-generated method stub
		return userDetailsDao.getFlights(source,destination,departureDate);
	}


	@Override
	public List<UserDetails> isValid(UserDetails userDetails) {
		// TODO Auto-generated method stub
		List<UserDetails> user=userDetailsDao.isValid(userDetails);
		return user;
	}


	@Override
	public List<FlightDetails> getFlightsAfterLogin(String source, String destination, LocalDate departureDate,
			String flightClass) throws HrExceptions {
		// TODO Auto-generated method stub
		return userDetailsDao.getFlightsafterLogin(source, destination, departureDate, flightClass);
	}


	@Override
	public boolean register(UserDetails userDetails) throws HrExceptions {
		// TODO Auto-generated method stub
		return userDetailsDao.userRegistration(userDetails);
	}


	@Override
	public boolean doPayment(int price, long accNo, int userId) {
		// TODO Auto-generated method stub
		return userDetailsDao.doPayment(price, accNo, userId);
	}

	
	
	
}
