package net.gesekus.ice;

import Entities.Flight;
import Managers.RemoteFlightManagerPrx;

public class Client {
	public static void main(String[] args) {
		int status = 0;
		Ice.Communicator ic = null;
		try {
			ic = Ice.Util.initialize(args);
			Ice.ObjectPrx base = ic
					.stringToProxy("RemoteFlightManager:default -p 10000");
			RemoteFlightManagerPrx remoteFlightManager = Managers.RemoteFlightManagerPrxHelper.checkedCast(base);
			if (remoteFlightManager == null)
				throw new Error("Invalid proxy");

			Flight flight = new Flight(10, 20);
			remoteFlightManager.addFlight(flight);
			Flight newFlight = remoteFlightManager.getFlight(10);
			System.out.println("Flight with id " + newFlight.icaoFlightPlanId);
		} catch (Ice.LocalException e) {
			e.printStackTrace();
			status = 1;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			status = 1;
		}
		if (ic != null) {
			// Clean up
			//
			try {
				ic.destroy();
			} catch (Exception e) {
				System.err.println(e.getMessage());
				status = 1;
			}
		}
		System.exit(status);
	}
}
