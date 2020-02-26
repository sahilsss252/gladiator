package com.lti.web;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.core.entities.FlightDetails;
import com.lti.core.entities.Passenger;
import com.lti.core.entities.UserDetails;
import com.lti.core.exceptions.HrExceptions;
import com.lti.core.services.PassengerService;



@RestController
@CrossOrigin
public class PassengerController {
	
	@Autowired
	private PassengerService passengerService;

	@PostMapping(value="/register",consumes = "APPLICATION/JSON")
	public void register(@RequestBody UserDetails userDetails) throws HrExceptions{
		
		
			boolean b=passengerService.register(userDetails);
		}
	


	
	@GetMapping(value="/getFlight/{source}/{destination}/{departureDate}",produces = "APPLICATION/JSON")
	public @ResponseBody List<FlightDetails> ViewFlights(
			@PathVariable("source") String source,
			@PathVariable("destination") String destination,
			@PathVariable("departureDate") String departureDate) throws HrExceptions{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse(departureDate, formatter);
		System.out.println(date);
		return passengerService.getFlights(source, destination, date);
	}
	
	@GetMapping(value="/getFlightAfterLogin/{source}/{destination}/{departureDate}/{flightClass}",produces = "APPLICATION/JSON")
	public @ResponseBody List<FlightDetails> ViewFlightsafterLogin(
			@PathVariable("source") String source,
			@PathVariable("destination") String destination,
			@PathVariable("departureDate") String departureDate,
			@PathVariable("flightClass") String flightClass) throws HrExceptions{
		
		System.out.println(source);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse(departureDate, formatter);
		List<FlightDetails> flightDetails= passengerService.getFlightsAfterLogin(source, destination, date, flightClass);
		for(FlightDetails flights: flightDetails){
			//System.out.println("Output from controller:" + flights);
		}
		return flightDetails;
	}
	
	
	
	@GetMapping(value="/doPayment/{price}/{accNo}/{userId}",produces = "APPLICATION/JSON")
	public @ResponseBody boolean doPayment(
			@PathVariable("price") int price,
			@PathVariable("accNo") long accNo,
			@PathVariable("userId") int userId) throws HrExceptions{
		
		
		
		boolean b=passengerService.doPayment(price,accNo,userId);
		return b;
	}
	
	@PostMapping(value="/login",consumes="Application/JSON")
	public @ResponseBody List<UserDetails> isLogin(@RequestBody UserDetails userDetails){
		
		System.out.println(userDetails);
		List<UserDetails>u=passengerService.isValid(userDetails);
		
		System.out.println(u);
		return u;
		
	}
	
	
	@PostMapping(value="/payment",consumes="Application/JSON")
	public @ResponseBody boolean isPaymentDone(@RequestBody UserDetails userDetails){
		
		System.out.println(userDetails);
		List<UserDetails>u=passengerService.isValid(userDetails);
		System.out.println(u);
		return (Boolean) null;
		
	}
	
	
	@PostMapping(value="/addPassenger",consumes="Application/json")
	public void addPassenger(@RequestBody Passenger passenger)throws HrExceptions{

			boolean b=passengerService.addPassenger(passenger);
			
	}
	
}
