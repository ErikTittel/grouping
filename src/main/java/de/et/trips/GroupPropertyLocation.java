package de.et.trips;

/**
 * @author Erik
 */
class GroupPropertyLocation extends GroupProperty {

    private final String location;

    public GroupPropertyLocation(Trip trip) {
        this.location = trip.getDepartureLocation();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GroupPropertyLocation)) return false;

        GroupPropertyLocation other = (GroupPropertyLocation) o;

        return location.equals(other.location);
    }

    @Override
    public int hashCode() {
        return location.hashCode();
    }

    @Override
    public String toString() {
        return "GroupProperty(" +
                location +
                ')';
    }
}
