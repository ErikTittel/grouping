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
        addTripsToGroups(trips, tripGroups, new GroupFilterDriverVehicle());
        removeGroupsWithSize1(tripGroups);
        List<Trip> remainingTrips = tripsNotGrouped(trips, tripGroups);
        addTripsToGroups(remainingTrips, tripGroups, new GroupFilterLocation());
        return asSortedList(tripGroups.values());
    }

    private void addTripsToGroups(List<Trip> trips, Map<GroupProperty, TripGroup> tripGroups, GroupFilter
            groupFilter) {
        for (Trip trip : trips) {
            GroupProperty groupProperty = groupFilter.readProperty(trip);
            if (tripGroups.containsKey(groupProperty)) {
                tripGroups.get(groupProperty).addTrip(trip);
            } else {
                TripGroup group = new TripGroup(groupProperty, trip);
                tripGroups.put(groupProperty, group);
            }
        }
    }

    private void removeGroupsWithSize1(Map<GroupProperty, TripGroup> tripGroups) {
        List<GroupProperty> toDelete = new ArrayList<>();
        for (GroupProperty groupProperty : tripGroups.keySet()) {
            TripGroup group = tripGroups.get(groupProperty);
            if (group.getTrips().size() <= 1) {
                toDelete.add(groupProperty);
            }
        }
        for (GroupProperty groupProperty : toDelete) {
            tripGroups.remove(groupProperty);
        }
    }

    private List<Trip> tripsNotGrouped(List<Trip> trips, Map<GroupProperty, TripGroup> tripGroups) {
        List<Trip> groupedTrips = new ArrayList<>();
        for (TripGroup tripGroup : tripGroups.values()) {
            groupedTrips.addAll(tripGroup.getTrips());
        }
        List<Trip> remainingTrips = new ArrayList<>(trips);
        remainingTrips.removeAll(groupedTrips);
        return remainingTrips;
    }

    private List<TripGroup> asSortedList(Collection<TripGroup> values) {
        List<TripGroup> groups = new ArrayList<>(values);
        Collections.sort(groups);
        return groups;
    }
}
