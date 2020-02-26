package com.lti.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.core.entities.AdminDetails;
import com.lti.core.entities.FlightDetails;
import com.lti.core.entities.FlightSchedule;
import com.lti.core.entities.UserDetails;
import com.lti.core.exceptions.HrExceptions;
import com.lti.core.services.AdminService;

@RestController
@CrossOrigin
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@PostMapping(value="/addFlight",consumes = "APPLICATION/JSON")
	public void addFlight(@RequestBody FlightSchedule flightSchedule) throws HrExceptions{
		
		System.out.println(flightSchedule);
		adminService.addFlight(flightSchedule);
	}
	
	@GetMapping(value="/viewFlight",produces = "APPLICATION/JSON")
	public @ResponseBody List<FlightDetails> ViewFlights() throws HrExceptions{
			return adminService.getFlights();
	}
	@PostMapping(value="/deleteFlight",consumes = "APPLICATION/JSON")
	public void deleteFlight(@RequestBody FlightDetails flightDetails) throws HrExceptions{
		
			adminService.deleteFlight(flightDetails);
	}
	
	@PostMapping(value="/adminlogin",consumes="Application/JSON")
	public List<AdminDetails> isLogin(@RequestBody AdminDetails adminDetails){
		
	
		List<AdminDetails> u = adminService.isValid(adminDetails);
		System.out.println(u);
		return u;
		
	}
}
