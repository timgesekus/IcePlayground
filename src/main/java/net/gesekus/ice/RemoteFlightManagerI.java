package net.gesekus.ice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Entities.Flight;
import Ice.Current;
import Managers._RemoteFlightManagerDisp;

public class RemoteFlightManagerI extends _RemoteFlightManagerDisp {
	private Map<Integer,Flight> flights = new HashMap<Integer,Flight>();
	@Override
	public Flight getFlight(int flightId, Current __current) {
		return flights.get(flightId);
	}

	@Override
	public void addFlight(Flight flight, Current __current) {
		flights.put(flight.id, flight);

	}

}
