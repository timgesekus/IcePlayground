#include "Flight.ice" 

module Managers {
    interface RemoteFlightManager {
    	Entities::Flight getFlight(int flightId);
    	void addFlight(Entities::Flight flight);
    };
}; 
