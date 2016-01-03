package de.et.trips;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.iterableWithSize;

import org.junit.Test;

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
        Trip trip1 = new Trip("1", "John", "Truck01", "Detroit", "12.12.2015 08:20");
        Trip trip2 = new Trip("2", "John", "Truck01", "Atlanta", "13.12.2015 09:13");
        Trip trip3 = new Trip("3", "Lea", "Truck02", "Atlanta", "14.12.2015 10:18");
        Trip trip4 = new Trip("4", "Tim", "Truck03", "Atlanta", "15.12.2015 14:12");
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