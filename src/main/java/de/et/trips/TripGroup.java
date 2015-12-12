package de.et.trips;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Erik
 */
public class TripGroup implements Comparable<TripGroup> {

    private List<Trip> trips = new ArrayList<>();
    private final GroupProperty groupProperty;

    public TripGroup(GroupProperty groupProperty, Trip firstTrip) {
        this.groupProperty = groupProperty;
        trips.add(firstTrip);
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void addTrip(Trip trip) {
        trips.add(trip);
        Collections.sort(trips);
    }

    public GroupProperty getGroupProperty() {
        return groupProperty;
    }

    @Override
    public int compareTo(TripGroup o) {
        return trips.get(0).getId().compareTo(o.getTrips().get(0).getId());
    }
}
