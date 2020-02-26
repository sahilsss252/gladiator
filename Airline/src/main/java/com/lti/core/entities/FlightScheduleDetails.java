package com.lti.core.entities;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="FLIGHT_SCHEDULE_DETAILS")
@SequenceGenerator(name = "seqSchedule", sequenceName = "FLIGHT_SCHEDULE_SEQUENCE", allocationSize = 1, initialValue = 5000)
public class FlightScheduleDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqSchedule")
	private int scheduleId;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate departureDate;
	
	private LocalTime arrival;
	private LocalTime departure;
	private int economySeats;
	private int economyPrice;
	private int businessSeats;
	private int businessPrice;
	
	
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="flightId")//fk
	private FlightDetails flightDetails;
	
	
	private int duration;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "flightscheduleDetails", cascade = CascadeType.ALL)
	private List<PassengerDetails> passengerDetails;
	
	
	
	public List<PassengerDetails> getPassengerDetails() {
		return passengerDetails;
	}
	public void setPassengerDetails(List<PassengerDetails> passengerDetails) {
		this.passengerDetails = passengerDetails;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}
	public LocalDate getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}
	public LocalTime getArrival() {
		return arrival;
	}
	public void setArrival(LocalTime arrivalTime) {
		this.arrival = arrivalTime;
	}
	public LocalTime getDeparture() {
		return departure;
	}
	public void setDeparture(LocalTime departureTime) {
		this.departure = departureTime;
	}
	public int getEconomySeats() {
		return economySeats;
	}
	public void setEconomySeats(int economySeats) {
		this.economySeats = economySeats;
	}
	public int getEconomyPrice() {
		return economyPrice;
	}
	public void setEconomyPrice(int economyPrice) {
		this.economyPrice = economyPrice;
	}
	public int getBusinessSeats() {
		return businessSeats;
	}
	public void setBusinessSeats(int businessSeats) {
		this.businessSeats = businessSeats;
	}
	public int getBusinessPrice() {
		return businessPrice;
	}
	public void setBusinessPrice(int businessPrice) {
		this.businessPrice = businessPrice;
	}
	public FlightDetails getFlightDetails() {
		return flightDetails;
	}
	public void setFlightDetails(FlightDetails flightDetails) {
		this.flightDetails = flightDetails;
	}
	public FlightScheduleDetails() {
		super();
	}
	public FlightScheduleDetails(int scheduleId, LocalDate departureDate, LocalTime arrivalTime, LocalTime departureTime,
			int ecomonySeats, int economyPrice, int businessSeats, int businessPrice, FlightDetails flightDetails) {
		super();
		this.scheduleId = scheduleId;
		this.departureDate = departureDate;
		this.arrival = arrivalTime;
		this.departure = departureTime;
		this.economySeats = ecomonySeats;
		this.economyPrice = economyPrice;
		this.businessSeats = businessSeats;
		this.businessPrice = businessPrice;
		this.flightDetails = flightDetails;
	}
	@Override
	public String toString() {
		return "FlightScheduleDetails [scheduleId=" + scheduleId + ", departureDate=" + departureDate + ", arrival="
				+ arrival + ", departure=" + departure + ", economySeats=" + economySeats + ", economyPrice="
				+ economyPrice + ", businessSeats=" + businessSeats + ", businessPrice=" + businessPrice
				+ ", duration=" + duration + "]";
	}

}
