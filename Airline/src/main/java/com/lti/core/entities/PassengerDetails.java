package com.lti.core.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="PASSENGER_DETAILS")
@SequenceGenerator(name = "seqDetails", sequenceName = "PASSENGER_DETAILS_SEQUENCE", allocationSize = 1, initialValue = 1000)
public class PassengerDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqDetails")
	private int passengerId;
	private String passengerName;
	private String passengerAge;
	private String passengerGender;
	private String seatNo;
	private String flightClass;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="userId")
	private UserDetails userDetails;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="scheduleId")
	private FlightScheduleDetails flightscheduleDetails;

	public int getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getPassengerAge() {
		return passengerAge;
	}

	public void setPassengerAge(String passengerAge) {
		this.passengerAge = passengerAge;
	}

	public String getPassengerGender() {
		return passengerGender;
	}

	public void setPassengerGender(String passengerGender) {
		this.passengerGender = passengerGender;
	}

	public String getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}

	public String getFlightClass() {
		return flightClass;
	}

	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public FlightScheduleDetails getFlightScheduleDetails() {
		return flightscheduleDetails;
	}

	public void setFlightScheduleDetails(FlightScheduleDetails flightScheduleDetails) {
		this.flightscheduleDetails = flightScheduleDetails;
	}

	public PassengerDetails() {
		super();
	}
	
	
	
	
	
	
	
}
