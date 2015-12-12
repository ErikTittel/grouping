package de.et.trips;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Map<GroupProperty, TripGroup> tripGroups = new HashMap<>();
        for (Trip trip : trips) {
            addTripToGroups(trip, tripGroups);
        }
        return asSortedList(tripGroups.values());
    }

    private void addTripToGroups(Trip trip, Map<GroupProperty, TripGroup> tripGroups) {
        GroupProperty groupProperty = new GroupProperty(trip.getDriver(), trip.getVehicle());
        if (tripGroups.containsKey(groupProperty)) {
            tripGroups.get(groupProperty).addTrip(trip);
        } else {
            TripGroup group = new TripGroup(groupProperty, trip);
            tripGroups.put(groupProperty, group);
        }
    }

    private List<TripGroup> asSortedList(Collection<TripGroup> values) {
        List<TripGroup> groups = new ArrayList<>(values);
        Collections.sort(groups);
        return groups;
    }
}
