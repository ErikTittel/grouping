package de.et.trips;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Erik
 */
public class GroupPropertyTest {

    @Test
    public void twoTripWithSameVehicleDriverProperty() throws Exception {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        Trip trip1 = new Trip("1", "John", "Truck01", "Detroit", LocalDateTime.parse("12.12.2015 08:20", df));
        Trip trip2 = new Trip("2", "John", "Truck01", "Atlanta", LocalDateTime.parse("13.12.2015 09:13", df));

        GroupPropertyVehicleDriver property1 = new GroupPropertyVehicleDriver(trip1);
        GroupPropertyVehicleDriver property2 = new GroupPropertyVehicleDriver(trip2);

        assertThat(property1, is(equalTo((property2))));
    }

    @Test
    public void twoTripWithDifferentVehicleDriverProperty() throws Exception {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        Trip trip1 = new Trip("1", "John", "Truck01", "Detroit", LocalDateTime.parse("12.12.2015 08:20", df));
        Trip trip2 = new Trip("2", "John", "Truck02", "Atlanta", LocalDateTime.parse("13.12.2015 09:13", df));

        GroupPropertyVehicleDriver property1 = new GroupPropertyVehicleDriver(trip1);
        GroupPropertyVehicleDriver property2 = new GroupPropertyVehicleDriver(trip2);

        assertThat(property1, is(not(equalTo((property2)))));
    }

    @Test
    public void twoTripWithSameLocationProperty() throws Exception {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        Trip trip1 = new Trip("1", "John", "Truck01", "Detroit", LocalDateTime.parse("12.12.2015 08:20", df));
        Trip trip2 = new Trip("2", "Lea", "Truck02", "Detroit", LocalDateTime.parse("13.12.2015 09:13", df));

        GroupPropertyLocation property1 = new GroupPropertyLocation(trip1);
        GroupPropertyLocation property2 = new GroupPropertyLocation(trip2);

        assertThat(property1, is(equalTo((property2))));
    }

    @Test
    public void twoTripWithDifferentLocationProperty() throws Exception {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        Trip trip1 = new Trip("1", "John", "Truck01", "Detroit", LocalDateTime.parse("12.12.2015 08:20", df));
        Trip trip2 = new Trip("2", "John", "Truck01", "Atlanta", LocalDateTime.parse("13.12.2015 09:13", df));

        GroupPropertyLocation property1 = new GroupPropertyLocation(trip1);
        GroupPropertyLocation property2 = new GroupPropertyLocation(trip2);

        assertThat(property1, is(not(equalTo((property2)))));
    }
}