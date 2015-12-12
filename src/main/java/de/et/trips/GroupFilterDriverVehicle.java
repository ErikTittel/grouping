package de.et.trips;

/**
 * @author Erik
 */
public class GroupFilterDriverVehicle implements GroupFilter {

    @Override
    public GroupProperty readProperty(Trip trip) {
        return new GroupPropertyVehicleDriver(trip);
    }
}
