package de.et.trips;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Erik
 */
public class Trip implements Comparable<Trip> {

    private final String id;
    private final String driver;
    private final String vehicle;
    private final String departureLocation;
    private final LocalDateTime departureTime;

    public Trip(String id, String driver, String vehicle, String departureLocation, String departureTimeAsText) {
        this.id = id;
        this.driver = driver;
        this.vehicle = vehicle;
        this.departureLocation = departureLocation;
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        this.departureTime = LocalDateTime.parse(departureTimeAsText, df);
    }

    public String getId() {
        return id;
    }

    public String getDriver() {
        return driver;
    }

    public String getVehicle() {
        return vehicle;
    }

    public String getDepartureLocation() {
        return departureLocation;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Trip other = (Trip) o;

        return id.equals(other.id)
                && driver.equals(other.driver)
                && vehicle.equals(other.vehicle)
                && departureLocation.equals(other.departureLocation)
                && departureTime.equals(other.departureTime);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + driver.hashCode();
        result = 31 * result + vehicle.hashCode();
        result = 31 * result + departureLocation.hashCode();
        result = 31 * result + departureTime.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Trip{" + id + ", " +
                driver + ", " +
                vehicle + ", " +
                departureLocation + ", " +
                departureTime +
                '}';
    }

    @Override
    public int compareTo(Trip o) {
        return id.compareTo(o.getId());
    }
}
