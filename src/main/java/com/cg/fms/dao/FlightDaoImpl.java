package com.cg.fms.dao;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.cg.fms.bean.Flight;
import com.cg.fms.exception.FlightException;

public class FlightDaoImpl implements FlightDao {


	private List<Flight> list;
	   
	public FlightDaoImpl() {
	super();
	list=new ArrayList<Flight>();
	}

	public int addFlight(Flight flight) throws FlightException {

	boolean flag = list.stream().anyMatch(p-> p.getFlightNumber()==flight.getFlightNumber());
	if(flag==true)
	{
	throw new FlightException("FlightNumber already exists");
	}
	else
	{
	list.add(flight);
	}
	return flight.getFlightNumber();
	}

	public Flight viewFlight(int flightNumber) throws FlightException {
		boolean flag = list.stream().anyMatch(p-> p.getFlightNumber()==flightNumber);
		if(!flag)
		{
		throw new FlightException("flight not found");

		}
		Flight flight1 =list.stream().filter(p-> p.getFlightNumber()==flightNumber).findFirst().get();
		return flight1;
		}
	public void deleteFlight(int flightNumber) throws FlightException {
		boolean flag =list.stream().anyMatch(p-> p.getFlightNumber()==flightNumber);
		if(!flag) {
			throw new FlightException("flight  not found");
		}
	Flight flight =list.stream().filter(p-> p.getFlightNumber()==flightNumber).findFirst().get();
    
	list.remove(flight);
	}
	
	public List<Flight> viewFlight() throws FlightException {

	List<Flight> flightlist=list.stream().collect(Collectors.toList());
    if(flightlist==null)
       {
	     throw new FlightException("List is empty");
       }
	return flightlist;
	}

	}
	

