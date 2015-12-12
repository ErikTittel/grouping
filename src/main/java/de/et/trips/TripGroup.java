package de.et.trips;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Erik
 */
public class TripGroup {

    private List<Trip> trips = new ArrayList<>();
    private final GroupProperty groupProperty;

    public TripGroup(GroupProperty groupProperty) {
        this.groupProperty = groupProperty;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void addTrip(Trip trip) {
        trips.add(trip);
    }

    public GroupProperty getGroupProperty() {
        return groupProperty;
    }
}
