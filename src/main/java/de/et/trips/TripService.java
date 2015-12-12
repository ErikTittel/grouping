package de.et.trips;

import java.util.ArrayList;
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
        List<TripGroup> groups = new ArrayList<>();
        List<Trip> remainingTrips = addTripsToGroups(trips, groups, new GroupFilterDriverVehicle());
        addTripsToGroups(remainingTrips, groups, new GroupFilterLocation());
        Collections.sort(groups);
        return groups;
    }

    private List<Trip> addTripsToGroups(List<Trip> trips, List<TripGroup> groups, GroupFilter groupFilter) {
        List<Trip> remainingTrips = new ArrayList<>(trips);
        Map<GroupProperty, List<Trip>> tripsByProperty = new HashMap<>();
        for (Trip trip : trips) {
            GroupProperty groupProperty = groupFilter.readProperty(trip);
            if (tripsByProperty.containsKey(groupProperty)) {
                tripsByProperty.get(groupProperty).add(trip);
            } else {
                ArrayList<Trip> tripList = new ArrayList<>();
                tripList.add(trip);
                tripsByProperty.put(groupProperty, tripList);
            }
        }
        tripsByProperty.keySet().stream().filter(p -> tripsByProperty.get(p).size() > 1).forEach(p -> {
            List<Trip> tripsWithSameProperty = tripsByProperty.get(p);
            groups.add(new TripGroup(p, tripsWithSameProperty));
            remainingTrips.removeAll(tripsWithSameProperty);
        });

        return remainingTrips;
    }
}
