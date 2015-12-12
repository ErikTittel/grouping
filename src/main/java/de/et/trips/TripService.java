package de.et.trips;

import static java.util.stream.Collectors.groupingBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Provides services regarding trips.
 *
 * @author Erik
 */
public class TripService {

    private static final GroupFilterDriverVehicle DRIVER_VEHICLE_FILTER = new GroupFilterDriverVehicle();
    private static final GroupFilterLocation LOCATION_FILTER = new GroupFilterLocation();

    /**
     * Groups a list of trips by certain properties. E. g. by driver and vehicle.
     */
    public List<TripGroup> groupTrips(List<Trip> trips) {
        List<TripGroup> groups = new ArrayList<>();
        List<Trip> remainingTrips = addTripsToGroups(trips, groups, DRIVER_VEHICLE_FILTER);
        addTripsToGroups(remainingTrips, groups, LOCATION_FILTER);
        Collections.sort(groups);
        return groups;
    }

    private List<Trip> addTripsToGroups(List<Trip> trips, List<TripGroup> groups, GroupFilter groupFilter) {
        List<Trip> remainingTrips = new ArrayList<>(trips);

        Map<GroupProperty, List<Trip>> tripsByProperty = trips.stream()
                .collect(groupingBy(groupFilter::readProperty));

        tripsByProperty.keySet().stream()
                .filter(p -> tripsByProperty.get(p).size() > 1)
                .forEach(p -> {
                    List<Trip> tripsWithSameProperty = tripsByProperty.get(p);
                    groups.add(new TripGroup(p, tripsWithSameProperty));
                    remainingTrips.removeAll(tripsWithSameProperty);
                });
        return remainingTrips;
    }
}
