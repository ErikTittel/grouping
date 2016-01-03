package de.et.trips;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import org.junit.Test;

/**
 * @author Erik
 */
public class GroupPropertyTest {

    @Test
    public void twoTripWithSameVehicleDriverProperty() throws Exception {
        Trip trip1 = new Trip("1", "John", "Truck01", "Detroit", "12.12.2015 08:20");
        Trip trip2 = new Trip("2", "John", "Truck01", "Atlanta", "13.12.2015 09:13");

        GroupPropertyVehicleDriver property1 = new GroupPropertyVehicleDriver(trip1);
        GroupPropertyVehicleDriver property2 = new GroupPropertyVehicleDriver(trip2);

        assertThat(property1, is(equalTo((property2))));
    }

    @Test
    public void twoTripWithDifferentVehicleDriverProperty() throws Exception {
        Trip trip1 = new Trip("1", "John", "Truck01", "Detroit", "12.12.2015 08:20");
        Trip trip2 = new Trip("2", "John", "Truck02", "Atlanta", "13.12.2015 09:13");

        GroupPropertyVehicleDriver property1 = new GroupPropertyVehicleDriver(trip1);
        GroupPropertyVehicleDriver property2 = new GroupPropertyVehicleDriver(trip2);

        assertThat(property1, is(not(equalTo((property2)))));
    }

    @Test
    public void twoTripWithSameLocationProperty() throws Exception {
        Trip trip1 = new Trip("1", "John", "Truck01", "Detroit", "12.12.2015 08:20");
        Trip trip2 = new Trip("2", "Lea", "Truck02", "Detroit", "13.12.2015 09:13");

        GroupPropertyLocation property1 = new GroupPropertyLocation(trip1);
        GroupPropertyLocation property2 = new GroupPropertyLocation(trip2);

        assertThat(property1, is(equalTo((property2))));
    }

    @Test
    public void twoTripWithDifferentLocationProperty() throws Exception {
        Trip trip1 = new Trip("1", "John", "Truck01", "Detroit", "12.12.2015 08:20");
        Trip trip2 = new Trip("2", "John", "Truck01", "Atlanta", "13.12.2015 09:13");

        GroupPropertyLocation property1 = new GroupPropertyLocation(trip1);
        GroupPropertyLocation property2 = new GroupPropertyLocation(trip2);

        assertThat(property1, is(not(equalTo((property2)))));
    }
}