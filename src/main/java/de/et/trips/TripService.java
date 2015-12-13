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

    private static final GroupFilter DRIVER_VEHICLE_FILTER = new GroupFilterDriverVehicle();
    private static final GroupFilter LOCATION_FILTER = new GroupFilterLocation();

    /**
     * Groups a list of trips by certain properties.
     * <p/>
     * Grouping happens in two steps.
     * <ol>
     *     <li> grouping by driver and vehicle</li>
     *     <li> grouping by location</li>
     * </ol>
     * A group consists of at least 2 trips.
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

        tripsByProperty.entrySet().stream()
                .filter(e -> moreThen1Element(e.getValue()))
                .forEach(e -> {
                    List<Trip> tripsWithSameProperty = e.getValue();
                    groups.add(new TripGroup(e.getKey(), tripsWithSameProperty));
                    remainingTrips.removeAll(tripsWithSameProperty);
                });
        return remainingTrips;
    }

    private boolean moreThen1Element(List<Trip> trips) {
        return trips.size() > 1;
    }
}
