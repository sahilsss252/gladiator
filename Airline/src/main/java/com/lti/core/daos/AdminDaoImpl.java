package com.lti.core.daos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.core.entities.AdminDetails;
import com.lti.core.entities.FlightDetails;
import com.lti.core.entities.FlightScheduleDetails;
import com.lti.core.entities.UserDetails;
import com.lti.core.exceptions.HrExceptions;

@Repository
public class AdminDaoImpl implements AdminDao {

	@PersistenceContext
	private EntityManager manager;

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void addFlight(FlightDetails flightDetails) throws HrExceptions {
		// TODO Auto-generated method stub
		System.out.println("in dao Flight Details" + flightDetails);

		/*FlightDetails fd = (FlightDetails) manager.merge(flightDetails);
		System.out.println("======================> " + fd.getFlightId());*/
		
		/*for(FlightScheduleDetails fs : flightDetails.getFlightScheduleDetails()) {
			fs.setFlightDetails(flightDetails);
			//manager.merge(fs);
		}*/
		
		manager.persist(flightDetails);
		
		
		/*List<FlightScheduleDetails> scheduleDetails = flightDetails.getFlightScheduleDetails();
		for(FlightScheduleDetails scheduleDetail:scheduleDetails){
			scheduleDetail.set
		}*/
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void deleteFlight(FlightDetails flightDetails)
			throws HrExceptions {
		// TODO Auto-generated method stub
//		System.out.println("in dao");
//		System.out.println(Source +" "+depaturetime+" "+departuredate);
//		String q="delete from FlightDetails e  e.FlightScheduleDetails s where e.source=:s1 and e.destination=:d1 and s.departureDate=: date1  and s.departureTime=: d2 and e.carrier=:c";
//		Query qq= manager.createQuery(q);
//		qq.setParameter("s1", Source);
//		qq.setParameter("d1", destination);
//		qq.setParameter("date1", departuredate);
//		qq.setParameter("d2", depaturetime);
//		qq.setParameter("c", Carrier);
//		
//		qq.executeUpdate();
		
		
		
		manager.remove(flightDetails);
		System.out.println("done");
		
		
		
	}

	
		public List<FlightDetails> getFlights() throws HrExceptions {
			String query="from FlightDetails";
			Query q=manager.createQuery(query);
			//System.out.println(q.getSingleResult());
			List<FlightDetails> lst=q.getResultList();
			//List<FlightDetails> u=q.getResultList();
			
			return lst;
		}

		@Override
		public List<AdminDetails> isValid(AdminDetails adminDetails) {
			
			String q="select e from AdminDetails e where e.username=:u and e.password=:p";
			Query qq=manager.createQuery(q);
			qq.setParameter("u", adminDetails.getUsername());
			qq.setParameter("p", adminDetails.getPassword());
			
			List<AdminDetails> user1=qq.getResultList();
			List<AdminDetails> u=new ArrayList<>();
			if(user1.isEmpty())
				return u;
			else
			return user1;
		}
	}

