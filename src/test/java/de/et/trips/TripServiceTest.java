package de.et.trips;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.iterableWithSize;
import static org.hamcrest.Matchers.nullValue;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Erik
 */
public class TripServiceTest {

    TripService service = new TripService();

    @Test
    public void testGroupTrips() {
        List<Trip> trips = new ArrayList<>();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        Trip trip = new Trip("1", "John", "Truck01", "Detroit", LocalDateTime.parse("12.12.2015 08:20", df));
        trips.add(trip);

        List<TripGroup> groups = service.groupTrips(trips);

        assertThat(groups, is(iterableWithSize(1)));
        TripGroup group = groups.get(0);
        assertThat(group.getTrips(), contains(trip));
        assertThat(group.getGroupProperty().getDriver(), is("John"));
        assertThat(group.getGroupProperty().getVehicle(), is("Truck01"));
    }
}