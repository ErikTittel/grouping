package de.et.trips;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Erik
 */
public class TripGroup implements Comparable<TripGroup> {

    private List<Trip> trips;
    private final GroupProperty groupProperty;

    public TripGroup(GroupProperty groupProperty, List<Trip> trips) {
        this.groupProperty = groupProperty;
        this.trips = trips;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public GroupProperty getGroupProperty() {
        return groupProperty;
    }

    @Override
    public int compareTo(TripGroup o) {
        return trips.get(0).getId().compareTo(o.getTrips().get(0).getId());
    }
}
