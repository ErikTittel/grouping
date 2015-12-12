package de.et.trips;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.iterableWithSize;

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
    public void groupTripsByDriverAndVehicle() {
        List<Trip> trips = new ArrayList<>();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        Trip trip1 = new Trip("1", "John", "Truck01", "Detroit", LocalDateTime.parse("12.12.2015 08:20", df));
        Trip trip2 = new Trip("2", "John", "Truck01", "Atlanta", LocalDateTime.parse("13.12.2015 09:13", df));
        Trip trip3 = new Trip("3", "Lea", "Truck02", "Atlanta", LocalDateTime.parse("14.12.2015 10:18", df));
        Trip trip4 = new Trip("4", "Tim", "Truck03", "Atlanta", LocalDateTime.parse("15.12.2015 14:12", df));
        trips.add(trip1);
        trips.add(trip2);
        trips.add(trip3);
        trips.add(trip4);

        List<TripGroup> groups = service.groupTrips(trips);

        assertThat(groups, is(iterableWithSize(2)));
        TripGroup group = groups.get(0);
        assertThat(group.getTrips(), contains(trip1, trip2));
        assertThat(group.getGroupProperty().toString(), is("GroupProperty(John, Truck01)"));

        TripGroup group2 = groups.get(1);
        assertThat(group2.getTrips(), contains(trip3, trip4));
        assertThat(group2.getGroupProperty().toString(), is("GroupProperty(Atlanta)"));
    }

}