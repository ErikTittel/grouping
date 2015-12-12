package de.et.trips;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides services regarding trips.
 *
 * @author Erik
 */
public class TripService {

    /**
     * Groups a list of trips by certain properties. E. g. by driver and vehicle.
     */
    public List<TripGroup> groupTrips(List<Trip> trips) {
        ArrayList<TripGroup> tripGroups = new ArrayList<>();
        for (Trip trip : trips) {
            TripGroup group = new TripGroup(new GroupProperty(trip.getDriver(), trip.getVehicle()));
            group.addTrip(trip);
            tripGroups.add(group);
        }
        return tripGroups;
    }
}
