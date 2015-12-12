package de.et.trips;

/**
 * @author Erik
 */
public class GroupFilterLocation implements GroupFilter {

    @Override
    public GroupProperty readProperty(Trip trip) {
        return new GroupPropertyLocation(trip);
    }
}
