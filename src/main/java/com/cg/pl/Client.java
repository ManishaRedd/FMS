package com.cg.pl;
import java.math.*;
import java.util.List;
import java.util.Scanner;

import com.cg.fms.bean.Flight;
import com.cg.fms.exception.FlightException;
import com.cg.fms.service.FlightService;
import com.cg.fms.service.FlightServiceImpl;


public class Client {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		FlightService flightservice=new FlightServiceImpl();
		int choice=0;
		Flight flight=null;
		List<Flight> list=null;
		while(choice!=6)

		{
		System.out.println("1.Add flight");
		System.out.println("2.view flight");
		System.out.println("3.Delete flight");
		System.out.println("4.View list of flights");
		System.out.println("5.Exit");

		choice=sc.nextInt();
		sc.nextLine();

		switch(choice)
		{
		case 1:
		System.out.println("Enter carriername");
		String name=sc.nextLine();
		System.out.println("enter flight Model");
		String model=sc.nextLine();
		 System.out.println("Enter seat capacity");
		 int  seat=sc.nextInt();


		 flight=new Flight();
		 flight.setCarrierName(name);
		 flight.setFlightModel(model);
		 flight.setSeatCapacity(seat);
		 try
		 {
		int flightnum= flightservice.addFlight(flight);
		 System.out.println("Flight number="+flightnum);
		}
		 catch(FlightException e)
		 {
		 System.err.println(e.getMessage());
		 }
		break;
		case 2:
		System.out.println("Enter flightnumber");
		int flightNumber=sc.nextInt();
		try
		{
		flightservice.viewFlight(flightNumber);
		System.out.println("carrier name="+flight.getCarrierName()+ ", Flight model="+flight.getFlightModel()+" ,Seat Capacity="+flight.getSeatCapacity());

		}
		catch(FlightException e)
		{
		System.err.println(e.getMessage());
		}
		break;
		case 3:
		System.out.println("Enter flightnumber");
		 flightNumber=sc.nextInt();
		try
		{
		flightservice.deleteFlight(flightNumber);
		System.out.println("flight deleted");

		}
		catch(FlightException e)
		{
		System.err.println(e.getMessage());
		}
		break;
		
		case 4:
		try
		{
		list=flightservice.viewFlight();
		for(Flight fl: list)
		{
		flightNumber=fl.getFlightNumber();
		name=fl.getCarrierName();
		model=fl.getFlightModel();
		seat=fl.getSeatCapacity();
		System.out.println(flightNumber+" "+name+" "+model+" "+seat);
		}
		}
		catch(FlightException e) {
		System.err.println(e.getMessage());
		}
		}
		}

		}
		


	}
