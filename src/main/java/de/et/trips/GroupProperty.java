package de.et.trips;

/**
 * @author Erik
 */
public class GroupProperty {

    private final String driver;
    private final String vehicle;

    public GroupProperty(String driver, String vehicle) {
        this.driver = driver;
        this.vehicle = vehicle;
    }

    public String getDriver() {
        return driver;
    }

    public String getVehicle() {
        return vehicle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GroupProperty)) return false;

        GroupProperty that = (GroupProperty) o;

        return driver.equals(that.driver) && vehicle.equals(that.vehicle);

    }

    @Override
    public int hashCode() {
        int result = driver.hashCode();
        result = 31 * result + vehicle.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "GroupProperty{" +
                 driver + ", " +
                vehicle + ", " +
                '}';
    }
}
