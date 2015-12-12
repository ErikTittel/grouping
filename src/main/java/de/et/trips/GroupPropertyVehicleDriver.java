package de.et.trips;

/**
 * @author Erik
 */
class GroupPropertyVehicleDriver extends GroupProperty {

    private final String driver;
    private final String vehicle;

    public GroupPropertyVehicleDriver(Trip trip) {
        driver = trip.getDriver();
        vehicle = trip.getVehicle();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GroupPropertyVehicleDriver)) return false;

        GroupPropertyVehicleDriver other = (GroupPropertyVehicleDriver) o;

        return driver.equals(other.driver) && vehicle.equals(other.vehicle);
    }

    @Override
    public int hashCode() {
        int result = driver.hashCode();
        result = 31 * result + vehicle.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "GroupProperty(" +
                driver + ", " +
                vehicle +
                ')';
    }
}
