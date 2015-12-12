package de.et.trips;

/**
 * @author Erik
 */
class GroupFilterDriverVehicle implements GroupFilter {

    @Override
    public GroupProperty readProperty(Trip trip) {
        return new GroupPropertyVehicleDriver(trip);
    }
}
